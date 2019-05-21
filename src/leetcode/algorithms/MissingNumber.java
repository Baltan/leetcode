package leetcode.algorithms;

/**
 * Description: 268. Missing Number
 * @author Baltan
 *
 * @date 2017/11/7 19:41
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int sumN = 0;
        int sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumNums += nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            sumN += i;
        }
        return sumN - sumNums;
    }
}
