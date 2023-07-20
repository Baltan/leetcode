package leetcode.algorithms;

/**
 * Description: 2778. Sum of Squares of Special Elements
 *
 * @author Baltan
 * @date 2023/7/16 18:12
 */
public class SumOfSquares {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{1, 2, 3, 4}));
        System.out.println(sumOfSquares(new int[]{2, 7, 1, 19, 18, 3}));
    }

    public static int sumOfSquares(int[] nums) {
        int result = 0;
        int length = nums.length;

        for (int i = 1; i <= length; i++) {
            if (length % i == 0) {
                result += nums[i - 1] * nums[i - 1];
            }
        }
        return result;
    }
}
