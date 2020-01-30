package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 120. Triangle
 *
 * @author Baltan
 * @date 2020-01-30 12:40
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle1 =
                Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle1));

        List<List<Integer>> triangle2 =
                Arrays.asList(Arrays.asList(2), Arrays.asList(3, 9), Arrays.asList(6, 10, 7),
                        Arrays.asList(4, 5, 8, 3), Arrays.asList(11, 4, 2, 9, 6));
        System.out.println(minimumTotal(triangle2));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        /**
         * dp[i]表示从当前这一行的第i（0-based）个数字走到底的最小路径和，某一行的数字可能不足size个
         * ，则后面的数字不作考虑
         */
        int[] dp = new int[size];
        List<Integer> lastLevel = triangle.get(size - 1);
        /**
         * 初始化最下面一行的最小路径和
         */
        for (int i = 0; i < size; i++) {
            dp[i] = lastLevel.get(i);
        }
        /**
         * 自倒数第二行开始向上依次计算最小路径和
         */
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> currentLevel = triangle.get(i);
            /**
             * 第i（0-based）行共有i+1个数字，分别计算从这i+1个数字出发的最小路径和
             */
            for (int j = 0; j <= i; j++) {
                /**
                 * 从第j个数字出发可以向左下方走到dp[j]，也可以向右下方走到dp[j+1]，取较小值
                 */
                dp[j] = Math.min(dp[j], dp[j + 1]) + currentLevel.get(j);
            }
        }
        return dp[0];
    }
}
