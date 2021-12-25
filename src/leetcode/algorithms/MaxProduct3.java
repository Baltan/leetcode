package leetcode.algorithms;

/**
 * Description: 2002. Maximum Product of the Length of Two Palindromic Subsequences
 *
 * @author Baltan
 * @date 2021/12/25 18:39
 */
public class MaxProduct3 {
    public static void main(String[] args) {
        System.out.println(maxProduct("leetcodecom"));
        System.out.println(maxProduct("bb"));
        System.out.println(maxProduct("accbcaxxcxx"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/solution/wei-rao-li-lun-geng-xin-yi-chong-nao-hui-9i5l/"></a>
     *
     * @param s
     * @return
     */
    public static int maxProduct(String s) {
        int result = Integer.MIN_VALUE;
        int length = s.length();
        /**
         * 将s分成两个子序列，为了使两个子序列中的回文子序列都尽可能长，两个子序列本身应尽可能长，所以将s中的所有字符都加入两个
         * 子序列中，用一个二进制数num表示s的每一个字符是否被选到第一个子序列中，则(1<<length)-1-num可以表示第二个子序列中含
         * 有s中的哪些字符。第一个子序列最小可能为1，即只选中了s最右边的字符，最大可能为(1<<length)-2即除了s最右边的字符，其
         * 余字符都选中，但是因为两个字符具有对称性，所以只需考虑一半的情况，即num的最大值为(1<<(length-1))-1
         */
        int min = 1;
        int max = (1 << (length - 1)) - 1;
        int sum = (1 << length) - 1;

        for (int i = min; i <= max; i++) {
            /**
             * 查找两个子序列中的最大回文子序列的长度
             */
            String x = getString(s, i);
            String y = getString(s, sum - i);
            result = Math.max(result, longestPalindromeSubseq(x) * longestPalindromeSubseq(y));
        }
        return result;
    }

    /**
     * 对于value的二进制表示，如果从右向左数第x位为1，则字符串s从右向左数的第x个字符被加入子串中
     *
     * @param s
     * @param value
     * @return
     */
    public static String getString(String s, int value) {
        StringBuilder builder = new StringBuilder();
        int index = s.length() - 1;
        /**
         * 从右向左判断value的二进制表示的每一位是否为1
         */
        while (value > 0) {
            if ((value & 1) == 1) {
                builder.insert(0, s.charAt(index));
            }
            /**
             * 将高位移动到低位
             */
            value >>= 1;
            index--;
        }
        return builder.toString();
    }

    /**
     * 查找字符串s中最长回文子序列的长度
     *
     * @param s
     * @return
     * @see LongestPalindromeSubseq
     */
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 1;
        int length = s.length();
        int[][] dp = new int[length][length];
        /**
         * dp[i][j]表示以s.chatAt(i)作为第一个字符，以s.charAt(j)作为最后一个字符的子串中的
         * 最长回文子序列。当i=j时，显然该子串本身即为长度为1的回文序列，所以初始化dp[0][0]、
         * dp[1][1]、……、dp[length-1][length-1]为1
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        /**
         * 当i≠j时，如果s.chatAt(i)和s.charAt(j)相等，则dp[i][j]=dp[i+1][j-1]+2，如果
         * s.chatAt(i)和s.charAt(j)不相等，则dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
         * 例如：s="cbbd"
         * <pre>
         * 1  0  0  0    1  1  0  0    1  1  2  0    1  1  2  2
         * 0  1  0  0 => 0  1  2  0 => 0  1  2  2 => 0  1  2  2
         * 0  0  1  0    0  0  1  1    0  0  1  1    0  0  1  1
         * 0  0  0  1    0  0  0  1    0  0  0  1    0  0  0  1
         * </pre>
         */
        for (int i = 1; i < length; i++) {
            int row = 0;
            int col = i;

            while (row < length && col < length) {
                char c1 = s.charAt(row);
                char c2 = s.charAt(col);

                if (c1 == c2) {
                    dp[row][col] = dp[row + 1][col - 1] + 2;
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
                }
                result = Math.max(result, dp[row][col]);
                row++;
                col++;
            }
        }
        return result;
    }
}
