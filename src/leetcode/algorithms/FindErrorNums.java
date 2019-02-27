package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description:Set Mismatch
 *
 * @author Baltan
 * @date 2018/1/5 16:18
 */
public class FindErrorNums {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findErrorNums(new int[]{1, 2, 2, 4}));
        OutputUtils.print1DIntegerArray(findErrorNums(new int[]{2, 2, 3}));
        OutputUtils.print1DIntegerArray(findErrorNums(new int[]{2, 3, 3}));
        OutputUtils.print1DIntegerArray(findErrorNums(new int[]{1, 2, 2}));
        OutputUtils.print1DIntegerArray(findErrorNums(new int[]{1, 1, 2}));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] returnArray = new int[2];
        boolean[] booleanArray = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (booleanArray[nums[i]] == false) {
                booleanArray[nums[i]] = true;
            } else {
                returnArray[0] = nums[i];
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (booleanArray[i] == false) {
                returnArray[1] = i;
                break;
            }
        }
        return returnArray;
    }
}
