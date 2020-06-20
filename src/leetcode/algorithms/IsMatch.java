package leetcode.algorithms;

/**
 * Description: 44. Wildcard Matching
 *
 * @author Baltan
 * @date 2020-01-21 13:03
 * @see IsMatch1
 */
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch(
                "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/wildcard-matching/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-4/"></a>
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
         * 对于字符串""，当字符模式p长度不为零时，字符模式为若干个"*"（"*"、"**"、"***"……）才能匹配
         */
        for (int i = 1; i <= pLength; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                /**
                 * 1、当字符模式p的第j个字符为"?"时，这个"?"可以匹配字符串s的第"i"个字符，则字符模
                 * 式p的前j个字符是否匹配字符串s的前i个字符，取决于字符模式p的前j-1个字符是否匹配字
                 * 符串s的前i-1个字符（dp[i][j]=dp[i-1][j-1]）
                 * 2、当字符模式p的第j个字符为"*"时，如果这个"*"匹配""，则字符模式p的前j个字符是否
                 * 匹配字符串s的前i个字符，取决于字符模式p的前j-1个字符是否匹配字符串s的前i个字符
                 * （dp[i][j]=dp[i][j-1]）；如果这个"*"匹配非""的任意字符串，则字符模式p的前j个字
                 * 符是否匹配字符串s的前i个字符，取决于字符模式p的前j个字符是否匹配字符串s的前i-1个
                 * 字符（dp[i][j]=dp[i-1][j]）。两种情况任意一种匹配上，字符模式p的前j个字符就能
                 * 匹配字符串s的前i个字符
                 * 3、当字符模式p的第j个字符为a-z时，如果字符串s的第i个字符和字符模式p的第j个字符一
                 * 样，则字符模式p的前j个字符是否匹配字符串s的前i个字符，取决于字符模式p的前j-1个字
                 * 符是否匹配字符串s的前i-1个字符（dp[i][j]=dp[i-1][j-1]）；否则一定无法匹配
                 */
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
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
