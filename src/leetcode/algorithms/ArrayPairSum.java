package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 561. Array Partition I
 * @author Baltan
 *
 * @date 2017/11/6 17:05
 */
public class ArrayPairSum {
    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i * 2];
        }
        return sum;
    }
}
