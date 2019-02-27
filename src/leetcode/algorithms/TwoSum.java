package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description:Two Sum
 * @author Baltan
 *
 * @date 2017/11/7 11:29
 */

public class TwoSum {

    public static void main(String[] args) {
    }

    public int[] twoSum(int[] nums, int target) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int index1 = 0;
        int index2 = copyNums.length - 1;
        while (copyNums[index1] + copyNums[index2] != target) {
            if (copyNums[index1] + copyNums[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        int num1 = copyNums[index1];
        int num2 = copyNums[index2];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                firstIndex = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == num2) {
                secondIndex = i;
                break;
            }
        }
        int[] resultIndex = {firstIndex, secondIndex};
        return resultIndex;
    }
}
