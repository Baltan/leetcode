package leetcode.algorithms;

/**
 * Description: 2746. Decremental String Concatenation
 *
 * @author Baltan
 * @date 2023/6/27 23:19
 */
public class MinimizeConcatenatedLength {
    public static void main(String[] args) {
        System.out.println(minimizeConcatenatedLength(new String[]{"ab", "cab", "aa"}));
        System.out.println(minimizeConcatenatedLength(new String[]{"aa", "ab", "bc"}));
        System.out.println(minimizeConcatenatedLength(new String[]{"ab", "b"}));
        System.out.println(minimizeConcatenatedLength(new String[]{"aaa", "c", "aba"}));
    }

    public static int minimizeConcatenatedLength(String[] words) {
        int result = Integer.MAX_VALUE;
        int length = words.length;
        /**
         * dp[i][j][k]表示将words[k]拼接后可以得到的首字母为i+'a'，尾字母为j+'a'的字符串的最小长度
         */
        int[][][] dp = new int[26][26][length];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < length; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        /**
         * 第一个字符串words[0]的情况
         */
        dp[words[0].charAt(0) - 'a'][words[0].charAt(words[0].length() - 1) - 'a'][0] = words[0].length();

        for (int i = 1; i < length; i++) {
            int head = words[i].charAt(0) - 'a';
            int tail = words[i].charAt(words[i].length() - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    /**
                     * 如果words[i-1]拼接后存在首字母为j+'a'，尾字母为k+'a'的字符串，则可以将words[i]拼接到其头部或尾部，得到一个首字
                     * 母为head+'a'，尾字母为k+'a'的新字符串或首字母为j+'a'，尾字母为tail的新字符串
                     */
                    if (dp[j][k][i - 1] != Integer.MAX_VALUE) {
                        dp[j][tail][i] = Math.min(dp[j][tail][i], dp[j][k][i - 1] + words[i].length() - (head == k ? 1 : 0));
                        dp[head][k][i] = Math.min(dp[head][k][i], dp[j][k][i - 1] + words[i].length() - (tail == j ? 1 : 0));
                    }
                }
            }
        }
        /**
         * 数组words中所有字符串都完成拼接后，找到长度最小的字符串
         */
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i][j][length - 1] > 0) {
                    result = Math.min(result, dp[i][j][length - 1]);
                }
            }
        }
        return result;
    }
}
