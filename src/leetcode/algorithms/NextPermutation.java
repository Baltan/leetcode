package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Next Permutation
 *
 * @author Baltan
 * @date 2018/9/3 10:05
 */
public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{2, 3, 1});
        nextPermutation(new int[]{1, 1, 5});
        nextPermutation(new int[]{1});
        nextPermutation(new int[]{1, 2});
        nextPermutation(new int[]{2, 1});
        nextPermutation(new int[]{2, 4, 5, 3, 6, 3, 2, 1, 6});
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = nums.length - 2; i >= index + 1; i--) {
                for (int j = index + 1; j <= i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        } else {
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
        OutputUtils.print1DIntegerArray(nums);
    }
}
