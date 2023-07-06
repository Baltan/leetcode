package leetcode.algorithms;

import java.util.TreeMap;

/**
 * Description: 2762. Continuous Subarrays
 *
 * @author Baltan
 * @date 2023/7/5 22:52
 */
public class ContinuousSubarrays {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
        System.out.println(continuousSubarrays(new int[]{1, 2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/continuous-subarrays/solutions/2327219/shuang-zhi-zhen-ping-heng-shu-ha-xi-biao-4frl/"></a>
     *
     * @param nums
     * @return
     */
    public static long continuousSubarrays(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * 滑动窗口左边数字的索引位置
         */
        int lo = 0;
        /**
         * i -> 滑动窗口中数字i的个数
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int hi = 0; hi < length; hi++) {
            map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);
            /**
             * 当滑动窗口中的最大值和最小值之差大于2时，将左指针不断右移，直到当前窗口中的最大值和最小值之差不大于2
             */
            while (map.lastKey() - map.firstKey() > 2) {
                int leftmost = nums[lo];
                /**
                 * 滑动窗口中的数字leftmost减少一个
                 */
                map.put(leftmost, map.getOrDefault(leftmost, 0) - 1);
                /**
                 * 如果滑动窗口中没有数字leftmost了，需要将这个key删除
                 */
                if (map.get(leftmost) == 0) {
                    map.remove(leftmost);
                }
                lo++;
            }
            /**
             * 以nums[hi]作为右端点，以nums[lo]、nums[lo+1]、……、nums[hi]作为左端点的子数组都能构成不间断子数组
             */
            result += hi - lo + 1;
        }
        return result;
    }
}
