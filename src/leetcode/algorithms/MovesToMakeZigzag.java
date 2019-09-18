package leetcode.algorithms;

/**
 * Description: 1144. Decrease Elements To Make Array Zigzag
 *
 * @author Baltan
 * @date 2019-09-18 09:05
 */
public class MovesToMakeZigzag {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println(movesToMakeZigzag(nums1));

        int[] nums2 = {9, 6, 1, 6, 2};
        System.out.println(movesToMakeZigzag(nums2));

        int[] nums3 =
                {3, 3, 56, 2, 5, 7, 4, 2, 1, 45, 67, 6, 3, 43, 4, 54, 6, 2, 1, 4, 56, 6, 8, 4, 2, 1, 3, 231,
                        23, 8, 5, 7, 7, 4, 2};
        System.out.println(movesToMakeZigzag(nums3));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int evenIndexChange = 0;
        int oddIndexChange = 0;
        int length = nums.length;
        /**
         * 如果只减少偶数索引位置的数字的值
         */
        for (int i = 0; i < length; i += 2) {
            /**
             * 如果左右都有数字，如果左右数字都不大于当前数字，当前数字要减到比左右数字的较小值更小，如果只有一边
             * 数字不大于当前数字，当前数字减到比该数字小即可；
             * 如果只有一边有数字，且该数字不大于当前数字，当前数字减到比该数字小即可。
             */
            if (i - 1 >= 0 && i + 1 < length) {
                if (nums[i - 1] <= nums[i] && nums[i + 1] <= nums[i]) {
                    evenIndexChange += nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1;
                } else if (nums[i - 1] <= nums[i]) {
                    evenIndexChange += nums[i] - nums[i - 1] + 1;
                } else if (nums[i + 1] <= nums[i]) {
                    evenIndexChange += nums[i] - nums[i + 1] + 1;
                }
            } else if (i - 1 >= 0) {
                if (nums[i - 1] <= nums[i]) {
                    evenIndexChange += nums[i] - nums[i - 1] + 1;
                }
            } else if (i + 1 < length) {
                if (nums[i + 1] <= nums[i]) {
                    evenIndexChange += nums[i] - nums[i + 1] + 1;
                }
            }
        }
        /**
         * 如果只减少奇数索引位置的数字的值
         */
        for (int i = 1; i < length; i += 2) {
            /**
             * 如果左右都有数字，如果左右数字都不大于当前数字，当前数字要减到比左右数字的较小值更小，如果只有一边
             * 数字不大于当前数字，当前数字减到比该数字小即可；
             * 如果只有一边有数字，且该数字不大于当前数字，当前数字减到比该数字小即可。
             */
            if (i - 1 >= 0 && i + 1 < length) {
                if (nums[i - 1] <= nums[i] && nums[i + 1] <= nums[i]) {
                    oddIndexChange += nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1;
                } else if (nums[i - 1] <= nums[i]) {
                    oddIndexChange += nums[i] - nums[i - 1] + 1;
                } else if (nums[i + 1] <= nums[i]) {
                    oddIndexChange += nums[i] - nums[i + 1] + 1;
                }
            } else if (i - 1 >= 0) {
                if (nums[i - 1] <= nums[i]) {
                    oddIndexChange += nums[i] - nums[i - 1] + 1;
                }
            } else if (i + 1 < length) {
                if (nums[i + 1] <= nums[i]) {
                    oddIndexChange += nums[i] - nums[i + 1] + 1;
                }
            }
        }
        /**
         * 只减少偶数索引位置的数字的值和只减少奇数索引位置的数字的值两者取较小值
         */
        return Math.min(evenIndexChange, oddIndexChange);
    }
}
