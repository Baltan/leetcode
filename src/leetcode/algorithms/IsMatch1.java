package leetcode.algorithms;

/**
 * Description: 10. Regular Expression Matching
 *
 * @author Baltan
 * @date 2020-06-20 13:58
 * @see IsMatch
 */
public class IsMatch1 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aaa", ".*"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/"></a>
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        /**
         * dp[i][j]表示字符模式p的前j个字符是否匹配字符串s的前i个字符，判断字符模式p是否匹配字符串s，
         * 即求dp[sLength][pLength]
         */
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        /**
         * 字符模式""匹配字符串""，所以dp[0][0]为true
         */
        dp[0][0] = true;
        /**
         * 判断s为""时的匹配情况
         */
        for (int i = 1; i <= pLength; i++) {
            /**
             * 如果p的第i个字符为*，则p的第i-1个和第i个字符"_*"看做"_0",可以匹配""，则此时dp[0][i]取决于
             * dp[0][i-2]，即p的前i-2个字符能否匹配""
             */
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        /**
         * 1、当字符模式p的第j个字符为"."时，这个"."可以匹配字符串s的第"i"个字符，则字符模式p的前j个字符是否
         * 匹配字符串s的前i个字符，取决于字符模式p的前j-1个字符是否匹配字符串s的前i-1个字符
         * （dp[i][j]=dp[i-1][j-1]）
         * 2、当字符模式p的第j个字符为"*"时，
         *  1)、如果p的第j-1个字符既不为"."，也和s的第i个字符不相等，即p的第j-1个和第j个字符"_*"无法匹配s
         *  的第i个字符，则可以将"_*"看做"_0"，此时dp[i][j]取决于dp[i][j-2]，即p的前j-2个字符能否匹配s的
         *  前i个字符
         *  2)、如果p的第j个字符为"."或者和s的第i个字符相等，则p的第j-1个和第j个字符"_*"，可以看做"_0"，
         *  匹配0个字符，此时dp[i][j]取决于dp[i][j-2]；可以看做"_1"，匹配s的第i个字符，此时dp[i][j]取决于
         *  dp[i-1][j-2]；可以看做"_+"，匹配s的第i个字符开始向前的多个字符，此时dp[i][j]取决于dp[i-1][j]
         * 3、当字符模式p的第j个字符为a-z时，如果字符串s的第i个字符和字符模式p的第j个字符相等，则字符模式p的
         * 前j个字符是否匹配字符串s的前i个字符，取决于字符模式p的前j-1个字符是否匹配字符串s的前i-1个字符
         * （dp[i][j]=dp[i-1][j-1]）
         */
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j - 2] || dp[i][j - 2] || dp[i - 1][j];
                    }
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }
}
