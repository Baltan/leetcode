package leetcode.algorithms;

/**
 * Description: 3512. Minimum Operations to Make Array Sum Divisible by K
 *
 * @author baltan
 * @date 2025/4/25 16:58
 */
public class MinOperations28 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 9, 7}, 5));
        System.out.println(minOperations(new int[]{4, 1, 3}, 4));
        System.out.println(minOperations(new int[]{3, 2}, 6));
    }

    public static int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        /**
         * sum除以k的余数
         */
        return sum - sum / k * k;
    }
}
