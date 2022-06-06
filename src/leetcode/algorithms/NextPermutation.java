package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 31. Next Permutation
 *
 * @author Baltan
 * @date 2018/9/3 10:05
 * @see MaxCompatibilitySum
 * @see GetMinSwaps
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        OutputUtils.print1DIntegerArray(nums1);

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        OutputUtils.print1DIntegerArray(nums2);

        int[] nums3 = {2, 3, 1};
        nextPermutation(nums3);
        OutputUtils.print1DIntegerArray(nums3);

        int[] nums4 = {1, 1, 5};
        nextPermutation(nums4);
        OutputUtils.print1DIntegerArray(nums4);

        int[] nums5 = {1};
        nextPermutation(nums5);
        OutputUtils.print1DIntegerArray(nums5);

        int[] nums6 = {1, 2};
        nextPermutation(nums6);
        OutputUtils.print1DIntegerArray(nums6);

        int[] nums7 = {2, 1};
        nextPermutation(nums7);
        OutputUtils.print1DIntegerArray(nums7);

        int[] nums8 = {2, 4, 5, 3, 6, 3, 2, 1, 6};
        nextPermutation(nums8);
        OutputUtils.print1DIntegerArray(nums8);
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        /**
         * 找到索引最大的相邻两数顺序排列的一对数字
         */
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            /**
             * 冒泡排序将nums中索引index之后部分的数字按照升序排列
             */
            for (int i = nums.length - 2; i > index; i--) {
                for (int j = index + 1; j <= i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            /**
             * 找到nums中索引index之后部分的第一个大于nums[index]的数字nums[i]，交换两数
             */
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        } else {
            /**
             * 冒泡排序将nums中的所有数字按照升序排列
             */
            for (int i = nums.length - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }
}
