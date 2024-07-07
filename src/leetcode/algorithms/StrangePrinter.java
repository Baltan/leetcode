package leetcode.algorithms;

/**
 * Description: 664. Strange Printer
 *
 * @author Baltan
 * @date 2024/6/30 14:25
 */
public class StrangePrinter {
    public static void main(String[] args) {
        System.out.println(strangePrinter("baacdddaaddaaaaccbd"));
        System.out.println(strangePrinter("baacdddaaddaaaaccbdd"));
        System.out.println(strangePrinter("baacdddaaddaaaaccbddb"));
        System.out.println(strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
        System.out.println(strangePrinter("tbgtgb"));
        System.out.println(strangePrinter("aaabbb"));
        System.out.println(strangePrinter("aba"));
    }

    public static int strangePrinter(String s) {
        /**
         * 连续的重复的字符对计算结果不会产生影响，所以只需保留一个字符即可
         */
        StringBuilder builder = new StringBuilder();
        char prev = ' ';

        for (char c : s.toCharArray()) {
            if (c != prev) {
                builder.append(c);
                prev = c;
            }
        }
        int length = builder.length();
        /**
         * dp[i][j]表示子串builder.substring(i,j)的最少打印次数
         */
        int[][] dp = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            dp[i][i + 1] = 1;
        }
        /**
         * 计算每个以builder[j]开头，长度为i的子串的最少打印次数
         */
        for (int i = 2; i <= length; i++) {
            for (int j = 0; i + j <= length; j++) {
                /**
                 * 最坏情况，子串builder.substring(j,i+j)中的所有字符互不相同，需要打印i次
                 */
                dp[j][i + j] = i;

                if (builder.charAt(j) == builder.charAt(i + j - 1)) {
                    /**
                     * 如果子串builder.substring(j,i+j)的首尾字符都为"*"，则可以先打印字符串"**……**"（共i个"*"），再打印前半部分的子
                     * 串builder.substring(j,i+j-1)得到
                     */
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][i + j - 1]);
                } else {
                    /**
                     * 分别打印子串builder.substring(j,k)和builder.substring(k,i+j)
                     */
                    for (int k = j + 1; k <= i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k][i + j]);
                    }
                }
            }
        }
        return dp[0][length];
    }
}