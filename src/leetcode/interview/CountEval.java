package leetcode.interview;

import java.util.Objects;

/**
 * Description: 面试题 08.14. 布尔运算
 *
 * @author Baltan
 * @date 2020-03-16 18:05
 */
public class CountEval {
    public static void main(String[] args) {
        System.out.println(countEval("1^0|0|1", 0));
        System.out.println(countEval("0&0&0&1^1|0", 1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/boolean-evaluation-lcci/solution/qu-jian-dp-by-lightcml/"></a>
     *
     * @param s
     * @param result
     * @return
     */
    public static int countEval(String s, int result) {
        if (s == null || Objects.equals(s, "")) {
            return 0;
        }
        /**
         * s中数字的总个数
         */
        int totalDigitCount = s.length() / 2 + 1;
        /**
         * 将s中的数字和运算符号分别从0开始分配索引，例如：
         * s="1^0|0|1"，则
         *
         *  char    1   ^   0   |   0   |   1
         * index    0   1   2   3   4   5   6
         *
         * digit    1   0   0   1
         * index    0   1   2   3
         *
         *  sign    ^   |   |
         * index    0   1   2
         *
         * dp[i][j][0]表示用索引在[i,j]的数字可以表示出false的方法数
         * dp[i][j][1]表示用索引在[i,j]的数字可以表示出true的方法数
         */
        int[][][] dp = new int[totalDigitCount][totalDigitCount][2];
        /**
         * 初始化一个数字可以表示出true和false的方法数，当前数字为1则可以表示出true，当前数字为0则可以表示
         * 出false
         */
        for (int i = 0; i < totalDigitCount; i++) {
            /**
             * 数字索引为i对应在字符串s中的索引为i*2
             */
            if (s.charAt(i * 2) == '1') {
                dp[i][i][1] = 1;
            } else {
                dp[i][i][0] = 1;
            }
        }

        /**
         * dc（digitCount）：当前用到的数字的个数
         * fdi（firstDigitIndex）：当前用到的dc个数字中第一个数字的索引位置
         * ldi（lastDigitIndex）：当前用到的dc个数字中最后一个数字的索引位置
         * si（signIndex）：分隔当前dc个数字的运算符号的索引位置
         */
        for (int dc = 2; dc <= totalDigitCount; dc++) {
            for (int fdi = 0; fdi <= totalDigitCount - dc; fdi++) {
                /**
                 * 当前用到的dc个数字中最后一个数字的索引位置
                 */
                int ldi = fdi + dc - 1;
                /**
                 * 观察可知数字索引为[i,j]之间的数字被符号索引为[i,j-1]之间的索引分隔
                 */
                for (int si = fdi; si < ldi; si++) {
                    /**
                     * 符号索引为si对应在字符串s中的索引为si*2+1
                     */
                    char sign = s.charAt(si * 2 + 1);

                    if (sign == '&') {
                        /**
                         * dp[fdi][ldi]表示false可以由三种情况得到：
                         * 1、dp[fdi][si]表示false，dp[si+1][ldi]表示false
                         * 2、dp[fdi][si]表示false，dp[si+1][ldi]表示true
                         * 3、dp[fdi][si]表示true，dp[si+1][ldi]表示false
                         */
                        dp[fdi][ldi][0] +=
                                (dp[fdi][si][0] * dp[si + 1][ldi][0] + dp[fdi][si][0] * dp[si + 1][ldi][1] +
                                        dp[fdi][si][1] * dp[si + 1][ldi][0]);
                        /**
                         * dp[fdi][ldi]表示true可以由一种情况得到：
                         * 1、dp[fdi][si]表示true，dp[si+1][ldi]表示true
                         */
                        dp[fdi][ldi][1] += dp[fdi][si][1] * dp[si + 1][ldi][1];
                    } else if (sign == '|') {
                        /**
                         * dp[fdi][ldi]表示false可以由一种情况得到：
                         * 1、dp[fdi][si]表示false，dp[si+1][ldi]表示false
                         */
                        dp[fdi][ldi][0] += dp[fdi][si][0] * dp[si + 1][ldi][0];
                        /**
                         * dp[fdi][ldi]表示true可以由三种情况得到：
                         * 1、dp[fdi][si]表示true，dp[si+1][ldi]表示true
                         * 2、dp[fdi][si]表示false，dp[si+1][ldi]表示true
                         * 3、dp[fdi][si]表示true，dp[si+1][ldi]表示false
                         */
                        dp[fdi][ldi][1] +=
                                (dp[fdi][si][1] * dp[si + 1][ldi][1] + dp[fdi][si][0] * dp[si + 1][ldi][1] +
                                        dp[fdi][si][1] * dp[si + 1][ldi][0]);
                    } else {
                        /**
                         * dp[fdi][ldi]表示false可以由两种情况得到：
                         * 1、dp[fdi][si]表示false，dp[si+1][ldi]表示false
                         * 2、dp[fdi][si]表示true，dp[si+1][ldi]表示true
                         */
                        dp[fdi][ldi][0] +=
                                (dp[fdi][si][0] * dp[si + 1][ldi][0] + dp[fdi][si][1] * dp[si + 1][ldi][1]);
                        /**
                         * dp[fdi][ldi]表示true可以由两种情况得到：
                         * 1、dp[fdi][si]表示false，dp[si+1][ldi]表示true
                         * 2、dp[fdi][si]表示true，dp[si+1][ldi]表示false
                         */
                        dp[fdi][ldi][1] +=
                                (dp[fdi][si][0] * dp[si + 1][ldi][1] + dp[fdi][si][1] * dp[si + 1][ldi][0]);
                    }
                }
            }
        }
        return dp[0][totalDigitCount - 1][result];
    }
}
