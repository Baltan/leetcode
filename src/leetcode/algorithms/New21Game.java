package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 837. New 21 Game
 *
 * @author Baltan
 * @date 2019-10-29 08:45
 */
public class New21Game {
    public static void main(String[] args) {
        System.out.println(new21Game(10, 1, 10));
        System.out.println(new21Game(6, 1, 10));
        System.out.println(new21Game(21, 17, 10));
        System.out.println(new21Game(0, 0, 1));
        System.out.println(new21Game(421, 400, 47));
    }

    public static double new21Game(int N, int K, int W) {
        /**
         * 参考：
         * <a href="https://leetcode-cn.com/problems/new-21-game/solution/di-tui-gong-shi-yi-ji-xiang-xi-jie-ti-si-lu-by-wan/"></a>
         */
        if (K == 0) {
            return 1.0;
        }

        double result = 0;
        double[] dp = new double[N + 1];
        dp[1] = 1.0;
        double p = 1.0 / W;

        for (int i = 1; i <= N; i++) {
            int prevMin = Math.max(0, i - W);
            int prevMax = Math.min(i - 1, K - 1);
            /**
             * 得到i的概率只与得到[prevMin,prevMax]的概率有关
             */
            for (int j = prevMin; j <= prevMax; j++) {
                dp[i] += dp[j] * p;
            }
        }

        for (int i = K; i <= N; i++) {
            result += dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }
}
