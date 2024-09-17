package leetcode.algorithms;

/**
 * Description: 1531. String Compression II
 *
 * @author baltan
 * @date 2024/9/13 09:18
 */
public class GetLengthOfOptimalCompression {
    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println(getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println(getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/string-compression-ii/solutions/351308/javacan-kao-di-yi-de-dp-by-cdx3424/"></a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int getLengthOfOptimalCompression(String s, int k) {
        int length = s.length();
        /**
         * dp[i][j]表示字符串s长度为i的前缀子串中删除j个字符后，剩余部分行程长度编码的最小长度
         */
        int[][] dp = new int[length + 1][k + 1];

        for (int i = 1; i <= length; i++) {
            /**
             * 可以删除的字符数不多于i个，且不多于k个
             */
            for (int j = 0; j <= Math.min(k, i); j++) {
                dp[i][j] = i - j;
            }
        }

        for (int i = 1; i <= length; i++) {
            /**
             * 可以删除的字符数不多于i个，且不多于k个
             */
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j > 0) {
                    /**
                     * 如果删除字符s[i-1]，则s长度为i的前缀子串中删除j个字符，等同于s长度为i-1的前缀子串中删除j-1个字符
                     */
                    dp[i][j] = dp[i - 1][j - 1];
                }
                /**
                 * 如果保留字符s[i-1]，为了使得剩余部分行程长度编码的最小长度更小，总是希望令s[i-1]跟在同样的字符后面，从s[i-1]开始，向前
                 * 将不等于s[i-1]的字符逐一删除，直到不能继续删除字符为止，deleteCount表示这部分被删除字符的个数
                 */
                int deleteCount = 0;

                for (int l = i; l > 0; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) {
                        /**
                         * s[i-1]和s[l-1]之间不等于s[i-1]的字符都被删除后，剩余部分子串的最后有i-(l-1)-deleteCount个字符s[i-1]，这
                         * 些s[i-1]构成的子串的行程长度编码的长度为getCompressionLength(i-(l-1)-deleteCount)。除去以上删除的字符
                         * 外，还需从字符串s长度为l-1的前缀子串中删除j-deleteCount个字符
                         */
                        dp[i][j] = Math.min(dp[l - 1][j - deleteCount] + getCompressionLength(i - (l - 1) - deleteCount), dp[i][j]);
                    } else {
                        deleteCount++;
                        /**
                         * 删除字符的个数多余j个，不符合假设
                         */
                        if (deleteCount > j) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[length][k];
    }

    /**
     * 计算连续length个相同的字符构成的字符串的行程长度编码的长度
     *
     * @param length
     * @return
     */
    public static int getCompressionLength(int length) {
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return 1;
        } else if (length < 10) {
            return 2;
        } else if (length < 100) {
            return 3;
        } else {
            return 4;
        }
    }
}
