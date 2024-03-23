package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 992. Subarrays with K Different Integers
 *
 * @author Baltan
 * @date 2024/2/9 23:30
 */
public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{2, 1, 2, 1, 2}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2}, 1));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/subarrays-with-k-different-integers/solutions/598337/miao-dong-xi-lie-xiang-jie-shuang-zhi-zh-9k8w/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0;
        /**
         * kLimits[i]表示以元素nums[i]作为左端点，不同元素的个数为k的最大子数组的右端点索引
         */
        int[] kLimits = help(nums, k);

        if (k == 1) {
            /**
             * 如果子数组中只能有1个不同的元素，则对于以元素nums[i]作为左端点的子数组中，右端点可以在[nums[i],kLimits[i]]范围内
             */
            for (int i = 0; i < nums.length; i++) {
                result += kLimits[i] - i + 1;
            }
        } else {
            /**
             * kLimits1[i]表示以元素nums[i]作为左端点，不同元素的个数为k-1的最大子数组的右端点索引
             */
            int[] kLimits1 = help(nums, k - 1);

            for (int i = 0; i < nums.length; i++) {
                /**
                 * 因为子数组nums[i……kLimits1[i]]中不同的元素个数为k-1，nums[i……kLimits[i]]中不同的元素个数为k，则以元素nums[i]作
                 * 为左端点，不同元素的个数为k的最大子数组的右端点可以在(kLimits1[i],kLimits[i]范围内
                 */
                if (kLimits[i] != -1 && kLimits1[i] != -1) {
                    result += kLimits[i] - kLimits1[i];
                }
            }
        }
        return result;
    }

    /**
     * 计算以数组nums中的每个元素作为左端点，且不同元素的个数为k的最大子数组的右端点索引
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] help(int[] nums, int k) {
        int[] limits = new int[nums.length];
        int lo = 0;
        int hi = -1;
        /**
         * counts[i]表示子数组nums[lo……hi]中元素i的个数，根据题意，nums[i]∈[1,20000]
         */
        int[] counts = new int[20001];
        /**
         * 子数组nums[lo……hi]中不同元素的个数
         */
        int count = 0;
        int length = nums.length;
        /**
         * 初始化，假设以数组nums中的任意一个元素作为左端点，都不存在不同元素的个数为k的子数组
         */
        Arrays.fill(limits, -1);
        outer:
        while (lo < length) {
            while (true) {
                if (hi == length - 1) {
                    if (count == k) {
                        /**
                         * 子数组nums[lo……hi]中不同元素的个数为k个
                         */
                        limits[lo] = hi;
                        lo++;
                        continue outer;
                    } else {
                        /**
                         * 当前子数组中不同元素的个数小于k个，而子数组的右端点已经位于数组nums的最后一个元素，则后续右移左端点的得到所有
                         * 子数组中不同元素的个数都是小于k个，不需要继续计算
                         */
                        break outer;
                    }
                } else {
                    /**
                     * 如果子数组nums[lo……hi]中已经存在元素nums[hi+1]或子数组中不同元素的个数小于k个，则可以将元素nums[hi+1]继续加到
                     * 子数组中，可以保证不同元素的个数不大于k
                     */
                    if (count < k || counts[nums[hi + 1]] != 0) {
                        hi++;
                        /**
                         * 如果nums[hi]是第一次在子数组中出现，则子数组中不同元素的个数要加1
                         */
                        count += counts[nums[hi]] == 0 ? 1 : 0;
                        counts[nums[hi]]++;
                        /**
                         * 子数组nums[lo……hi]中不同元素的个数为k个
                         */
                        if (count == k) {
                            limits[lo] = hi;
                        }
                    } else {
                        /**
                         * 子数组nums[lo……hi]中不同元素的个数为k个
                         */
                        if (count == k) {
                            limits[lo] = hi;
                        }
                        /**
                         * 右移子数组的左端点，将左端点的数字移出子数组
                         */
                        counts[nums[lo]]--;
                        count -= counts[nums[lo]] == 0 ? 1 : 0;
                        lo++;
                        continue outer;
                    }
                }
            }

        }
        return limits;
    }
}
