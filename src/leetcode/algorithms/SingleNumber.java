package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 136. Single Number
 *
 * @author Baltan
 * @date 2017/12/29 20:10
 * @see SingleNumber2
 * @see SingleNumber1
 * @see SingleNumber3
 * @see SingleNumber4
 * @see leetcode.interview.SingleNumbers
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 4, 2, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 3, 4, 4, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 4, 2, 3}));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
