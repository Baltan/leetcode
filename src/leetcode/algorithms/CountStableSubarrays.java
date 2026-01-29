package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3728. Stable Subarrays With Equal Boundary and Interior Sum
 *
 * @author baltan
 * @date 2026/1/26 17:12
 */
public class CountStableSubarrays {
    public static void main(String[] args) {
        System.out.println(countStableSubarrays(new int[]{9, 3, 3, 3, 9}));
        System.out.println(countStableSubarrays(new int[]{1, 2, 3, 4, 5}));
        System.out.println(countStableSubarrays(new int[]{-4, 4, 0, 0, -8, -4}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/stable-subarrays-with-equal-boundary-and-interior-sum/solutions/3815641/qian-zhui-he-yu-ha-xi-biao-shi-zi-bian-x-d6vf/"></a>
     *
     * @param capacity
     * @return
     */
    public static long countStableSubarrays(int[] capacity) {
        long result = 0L;
        Map<Tuple, Integer> map = new HashMap<>();
        long[] prefixSums = new long[capacity.length + 1];
        prefixSums[1] = prefixSums[0] + capacity[0];
        map.merge(new Tuple(capacity[0], capacity[0] + prefixSums[1]), 1, Integer::sum);
        /**
         * 稳定子数组capacity[x……y]满足capacity[x]=capacity[y]=capacity[x+1]+capacity[x+2]+……+capacity[y-1]=prefixSums[y]-
         * prefixSums[x+1]，即capacity[x]=capacity[y]并且capacity[x]+prefixSums[x+1]=prefixSums[y]。题目相当于枚举每个右端点y，
         * 查找二元组(capacity[x],capacity[x]+prefixSums[x+1])的值等于(capacity[y],prefixSums[y])的左端点x的数量。因为稳定子数组
         * 的长度至少为3，所以右端点至少从capacity[2]开始
         */
        for (int y = 2; y < capacity.length; y++) {
            prefixSums[y] = prefixSums[y - 1] + capacity[y - 1];
            /**
             * 需要查找的二元组的值为(capacity[y],prefixSums[y])，即(capacity[y],prefixSum)
             */
            result += map.getOrDefault(new Tuple(capacity[y], prefixSums[y]), 0);
            /**
             * 将二元组(capacity[y-1],capacity[y-1]+prefixSums[y])加入map，作为下一轮循环可能的左端点
             */
            map.merge(new Tuple(capacity[y - 1], capacity[y - 1] + prefixSums[y]), 1, Integer::sum);
        }
        return result;
    }

    public record Tuple(int x, long y) {
    }
}
