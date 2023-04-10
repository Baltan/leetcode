package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2616. Minimize the Maximum Difference of Pairs
 *
 * @author Baltan
 * @date 2023/4/9 21:58
 */
public class MinimizeMax {
    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{0, 5, 3, 4}, 0));
        System.out.println(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(minimizeMax(new int[]{4, 2, 1, 2}, 1));
    }

    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        int length = nums.length;
        Arrays.sort(nums);
        /**
         * 数对之差可能的最小值
         */
        int lo = 0;
        /**
         * 数对之差可能的最大值
         */
        int hi = nums[length - 1] - nums[0];
        /**
         * 二分查找至少大于等于p个数对之差的最小值
         */
        outer:
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            /**
             * 数对之差小于等于mid的数对个数
             */
            int pairs = 0;

            for (int i = 1; i < length; ) {
                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++;
                    i += 2;
                    /**
                     * 已经找到了p个数对之差小于等于mid的数对，不需要继续计算后面的数对，继续二分查找
                     */
                    if (pairs == p) {
                        hi = mid;
                        continue outer;
                    }
                } else {
                    i += 1;
                }
            }
            /**
             * 数对之差小于等于mid的数对个数小于p个
             */
            lo = mid + 1;
        }
        return lo;
    }
}
