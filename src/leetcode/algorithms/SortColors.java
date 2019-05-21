package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 75. Sort Colors
 *
 * @author Baltan
 * @date 2018/9/26 14:41
 */
public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
        sortColors(new int[]{2, 0, 2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 2, 1, 0, 2, 1, 0, 0, 2, 1, 2});
        sortColors(new int[]{2, 0, 1});
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int temp;
        int cursor = 0;
        while (cursor <= end) {
            if (nums[cursor] == 0) {
                temp = nums[start];
                nums[start++] = 0;
                nums[cursor++] = temp;
            } else if (nums[cursor] == 2) {
                temp = nums[end];
                nums[end--] = 2;
                nums[cursor] = temp;
            } else {
                cursor++;
            }
        }
        OutputUtils.print1DIntegerArray(nums);
    }
}
