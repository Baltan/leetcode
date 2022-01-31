package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1672. Richest Customer Wealth
 *
 * @author Baltan
 * @date 2022/1/31 13:33
 */
public class MaximumWealth {
    public static void main(String[] args) {
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts1));

        int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(maximumWealth(accounts2));

        int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(maximumWealth(accounts3));
    }

    public static int maximumWealth(int[][] accounts) {
        int result = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            /**
             * 当前用户所有银行中的存款总额
             */
            int sum = Arrays.stream(account).sum();
            result = Math.max(result, sum);
        }
        return result;
    }
}
