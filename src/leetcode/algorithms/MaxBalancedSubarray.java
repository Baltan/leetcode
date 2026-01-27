package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3755. Find Maximum Balanced XOR Subarray Length
 *
 * @author baltan
 * @date 2026/1/26 10:38
 */
public class MaxBalancedSubarray {
    public static void main(String[] args) {
        System.out.println(maxBalancedSubarray(new int[]{3, 1, 3, 2, 0}));
        System.out.println(maxBalancedSubarray(new int[]{3, 2, 8, 5, 4, 14, 9, 15}));
        System.out.println(maxBalancedSubarray(new int[]{0}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-maximum-balanced-xor-subarray-length/solutions/3839714/qian-zhui-he-ha-xi-biao-by-tsreaper-wefq/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxBalancedSubarray(int[] nums) {
        int result = 0;
        /**
         * 数组nums的前缀数组中所有元素按位异或的值
         */
        int prefixXor = 0;
        /**
         * 数组nums的前缀数组中奇数元素和偶数元素个数之差
         */
        int prefixCountDiff = 0;
        /**
         * 数组nums的前缀数组中所有元素按位异或的值 ->
         *      { 数组nums的前缀数组中奇数元素和偶数元素个数之差 -> 满足条件的最短前缀数组的最后一个元素的索引值 }
         */
        Map<Integer, Map<Integer, Integer>> xorMap = new HashMap<>();
        /**
         * 哨兵，前缀数组为空数组的情况
         */
        xorMap.computeIfAbsent(0, x -> new HashMap<>()).put(0, -1);
        /**
         * 如果子数组nums[x……y]是平衡异或子数组，即nums[x]^nums[x+1]^……^nums[y-1]^nums[y]=0，且nums[x……y]中奇数元素和偶数元素个数
         * 之差为0，则nums[0]^nums[1]^……^nums[x-1]^nums[x]=nums[0]^nums[1]^……^nums[y-1]^nums[y]，且nums[0……x]中奇数元素和偶数
         * 元素个数之差与nums[0……y]中奇数元素和偶数元素个数之差相等
         */
        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];
            prefixCountDiff += nums[i] % 2 == 0 ? -1 : 1;
            Map<Integer, Integer> prefixCountDiffMap = xorMap.computeIfAbsent(prefixXor, x -> new HashMap<>());

            if (prefixCountDiffMap.containsKey(prefixCountDiff)) {
                result = Math.max(result, i - prefixCountDiffMap.get(prefixCountDiff));
            } else {
                prefixCountDiffMap.put(prefixCountDiff, i);
            }
        }
        return result;
    }
}
