package leetcode.algorithms;

/**
 * Description: 2140. Solving Questions With Brainpower
 *
 * @author Baltan
 * @date 2022/1/16 20:36
 */
public class MostPoints {
    public static void main(String[] args) {
        int[][] questions1 = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(mostPoints(questions1));

        int[][] questions2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(mostPoints(questions2));
    }

    public static long mostPoints(int[][] questions) {
        int length = questions.length;
        /**
         * dp[i]表示从第i题开始到最后一题为止可以获得的最高分
         */
        long[] dp = new long[length];
        dp[length - 1] = questions[length - 1][0];

        for (int i = length - 2; i >= 0; i--) {
            /**
             * 如果第i题不回答，则第i题开始到最后一题为止可以获得的最高分和第i+1题开始到最后一题为止可以获得的最高分相同；如果第
             * i题回答，这题可以获得questions[i][0]分，同时要跳过questions[i][1]题，即接下去至少从第i+1+questions[i][1]
             * 题开始可以继续作答（如果存在第i+1+questions[i][1]题的话），此时可以获得的最高分为questions[i][0]加上第i+1+
             * questions[i][1]题开始到最后一题为止可以获得的最高分
             */
            dp[i] = Math.max(dp[i + 1],
                    questions[i][0] + (i + 1 + questions[i][1] < length ? dp[i + 1 + questions[i][1]] : 0));
        }
        return dp[0];
    }
}
