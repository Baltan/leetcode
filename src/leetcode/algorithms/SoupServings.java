package leetcode.algorithms;

/**
 * Description: 808. Soup Servings
 *
 * @author Baltan
 * @date 2020-02-18 12:46
 */
public class SoupServings {
    public static void main(String[] args) {
        System.out.println(soupServings(50));
        System.out.println(soupServings(0));
        System.out.println(soupServings(660295675));
    }

    public static double soupServings(int N) {
        if (N == 0) {
            return 0.5;
        }

        int count = (int) Math.ceil(N * 1.0 / 25);
        double[][] dp = new double[count + 1][count + 1];
        dp[count][count] = 1.0;
        double aFirst = 0;
        double abSameTime = 0;

        for (int i = count; i > 0; i--) {
            for (int j = count; j > 0; j--) {
                if (i + 4 <= count) {
                    dp[i][j] += dp[i + 4][j] / 4;
                }

                if (i + 3 <= count && j + 1 <= count) {
                    dp[i][j] += dp[i + 3][j + 1] / 4;
                }

                if (i + 2 <= count && j + 2 <= count) {
                    dp[i][j] += dp[i + 2][j + 2] / 4;
                }

                if (i + 1 <= count && j + 3 <= count) {
                    dp[i][j] += dp[i + 1][j + 3] / 4;
                }

                if (i <= 4) {
                    aFirst += dp[i][j] / 4;
                }

                if (i <= 3 && j > 1) {
                    aFirst += dp[i][j] / 4;
                }

                if (i <= 2 && j > 2) {
                    aFirst += dp[i][j] / 4;
                }

                if (i <= 1 && j > 3) {
                    aFirst += dp[i][j] / 4;
                }

                if (i <= 3 && j <= 1) {
                    abSameTime += dp[i][j] / 4;
                }

                if (i <= 2 && j <= 2) {
                    abSameTime += dp[i][j] / 4;
                }

                if (i <= 1 && j <= 3) {
                    abSameTime += dp[i][j] / 4;
                }
            }
        }
        return aFirst + abSameTime / 2;
    }
}
