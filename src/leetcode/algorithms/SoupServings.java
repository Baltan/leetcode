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
        /**
         * 因为每次分汤都是25ml的倍数，所以将每25ml看做1份，初始时，A、B各有count份，不足25ml的
         * 也看做1份
         */
        int count = (int) Math.ceil(N * 1.0 / 25);
        /**
         * 参考：<a href="https://leetcode-cn.com/problems/soup-servings/solution/fen-tang-by-leetcode/"></a>
         * 当count很大时，A会有很大的概率比B先分配完，当count>=500时，所求概率已经大于0.999999了
         */
        if (count >= 500) {
            return 1.0;
        }
        /**
         * dp[i][j]表示A还剩i份，B还剩j份的情况出现的概率
         */
        double[][] dp = new double[count + 1][count + 1];
        /**
         * 初始时A、B各有count份，所以概率为100%
         */
        dp[count][count] = 1.0;
        /**
         * A先分完的概率
         */
        double aFirst = 0;
        /**
         * A、B同时分完的概率
         */
        double abSameTime = 0;
        /**
         * 只计算到A、B都至少剩1份为止
         */
        for (int i = count; i > 0; i--) {
            for (int j = count; j > 0; j--) {
                /**
                 * A还剩i份，B还剩j份的情况可能由A还剩i+4份，B还剩j份的情况通过操作1实现
                 */
                if (i + 4 <= count) {
                    dp[i][j] += dp[i + 4][j] / 4;
                }
                /**
                 * A还剩i份，B还剩j份的情况可能由A还剩i+3份，B还剩j+1份的情况通过操作2实现
                 */
                if (i + 3 <= count && j + 1 <= count) {
                    dp[i][j] += dp[i + 3][j + 1] / 4;
                }
                /**
                 * A还剩i份，B还剩j份的情况可能由A还剩i+2份，B还剩j+2份的情况通过操作3实现
                 */
                if (i + 2 <= count && j + 2 <= count) {
                    dp[i][j] += dp[i + 2][j + 2] / 4;
                }
                /**
                 * A还剩i份，B还剩j份的情况可能由A还剩i+1份，B还剩j+3份的情况通过操作4实现
                 */
                if (i + 1 <= count && j + 3 <= count) {
                    dp[i][j] += dp[i + 1][j + 3] / 4;
                }
                /**
                 * 如果此时A不多于4份，操作1会导致A先分完
                 */
                if (i <= 4) {
                    aFirst += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于3份并且B多余1份，操作2会导致A先分完
                 */
                if (i <= 3 && j > 1) {
                    aFirst += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于2份并且B多余2份，操作3会导致A先分完
                 */
                if (i <= 2 && j > 2) {
                    aFirst += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于1份并且B多余3份，操作4会导致A先分完
                 */
                if (i <= 1 && j > 3) {
                    aFirst += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于3份并且B不多余1份，操作2会导致A、B同时分完
                 */
                if (i <= 3 && j <= 1) {
                    abSameTime += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于2份并且B不多余2份，操作3会导致A、B同时分完
                 */
                if (i <= 2 && j <= 2) {
                    abSameTime += dp[i][j] / 4;
                }
                /**
                 * 如果此时A不多于1份并且B不多余3份，操作4会导致A、B同时分完
                 */
                if (i <= 1 && j <= 3) {
                    abSameTime += dp[i][j] / 4;
                }
            }
        }
        return aFirst + abSameTime / 2;
    }
}
