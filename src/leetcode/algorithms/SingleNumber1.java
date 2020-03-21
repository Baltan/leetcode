package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 260. Single Number III
 *
 * @author Baltan
 * @date 2018/8/13 09:59
 * @see SingleNumber3
 * @see SingleNumber
 * @see SingleNumber2
 * @see SingleNumber4
 */
public class SingleNumber1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 7}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 6}));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] array = new int[2];
        int length = nums.length;
        boolean flag = false;
        Arrays.sort(nums);
        if (nums[1] != nums[0]) {
            array[0] = nums[0];
            flag = !flag;
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1] && !flag) {
                array[0] = nums[i];
                flag = !flag;
            } else if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1] && flag) {
                array[1] = nums[i];
                flag = !flag;
            }
        }
        if (nums[length - 1] != nums[length - 2]) {
            array[1] = nums[length - 1];
        }
        return array;
    }
}
