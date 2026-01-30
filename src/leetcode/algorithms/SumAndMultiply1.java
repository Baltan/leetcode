package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 3756. Concatenate Non-Zero Digits and Multiply by Sum II
 *
 * @author baltan
 * @date 2026/1/26 11:22
 * @see SumAndMultiply
 */
public class SumAndMultiply1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sumAndMultiply("10203004", new int[][]{{0, 7}, {1, 3}, {4, 6}}));
        OutputUtils.print1DIntegerArray(sumAndMultiply("1000", new int[][]{{0, 3}, {1, 1}}));
        OutputUtils.print1DIntegerArray(sumAndMultiply("9876543210", new int[][]{{0, 9}}));
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int[] result = new int[queries.length];
        int mod = 1000000007;
        /**
         * prefixSums[i]表示字符串s的前i个字符表示的数字之和
         */
        int[] prefixSums = new int[s.length() + 1];
        /**
         * 依次保存字符串s去除所有字符'0'后剩余的字符
         */
        StringBuilder builder = new StringBuilder();
        /**
         * indexMapping[i]表示字符s[i]在字符串builder中的索引值，如果字符s[i]为'0'，则为s[i]之前最近一个非'0'字符在builder中的索引值
         */
        int[] indexMapping = new int[s.length()];
        /**
         * memo[i][j]表示i*(10^j)除以mod的余数。初始化memo[i][j]为-1时，表示memo[i][j]的值未知
         */
        long[][] memo = new long[10][s.length()];

        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            prefixSums[i + 1] = prefixSums[i] + digit;
            /**
             * 将字符串s中的非'0'字符追加到builder中
             */
            if (digit != 0) {
                builder.append(digit);
            }
            indexMapping[i] = builder.length() - 1;
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            /**
             * 子串s[start……end]中所有字符表示的数字之和
             */
            int sum = prefixSums[end + 1] - prefixSums[start];
            /**
             * 因为s[start]为字符'0'时，在builder中的索引值为s[start]之前最近一个非'0'字符在builder中的索引值indexMapping[start]，
             * 所以索引值要加1，排除该非'0'字符
             */
            int startMappedIndex = s.charAt(start) == '0' ? indexMapping[start] + 1 : indexMapping[start];
            int endMappedIndex = indexMapping[end] + 1;

            if (startMappedIndex == endMappedIndex) {
                /**
                 * 子串s[start……end]中没有非0数字，则形成的新整数x为0
                 */
                result[i] = 0;
            } else {
                /**
                 * 子串s[start……end]表示的新整数中每一个数位上的数字乘以10的幂次
                 */
                int exponent = 0;
                /**
                 * 从低位向高位遍历子串s[start……end]表示的新整数x
                 */
                for (int j = endMappedIndex - 1; j >= startMappedIndex; j--) {
                    int digit = builder.charAt(j) - '0';
                    /**
                     * 记忆化搜索计算digit*(10^exponent)除以mod的余数
                     */
                    if (memo[digit][exponent] == -1) {
                        dfs(memo, mod, digit, exponent);
                    }
                    result[i] = (int) (result[i] + memo[digit][exponent] * sum % mod) % mod;
                    exponent++;
                }
            }
        }
        return result;
    }

    /**
     * 记忆化搜索计算digit*(10^exponent)除以mod的余数，即memo[digit][exponent]
     *
     * @param memo
     * @param mod
     * @param digit
     * @param exponent
     */
    public static void dfs(long[][] memo, int mod, int digit, int exponent) {
        /**
         * 0或一位数字digit除以mod的余数即其本身
         */
        if (exponent == 0 || digit == 0) {
            memo[digit][exponent] = digit;
            return;
        }
        /**
         * 如果memo[digit][exponent-1]不为-1，说明已知memo[digit][exponent-1]的值，否则先递归计算memo[digit][exponent-1]的值
         */
        if (memo[digit][exponent - 1] == -1) {
            dfs(memo, mod, digit, exponent - 1);
        }
        memo[digit][exponent] = memo[digit][exponent - 1] * 10 % mod;
    }
}
