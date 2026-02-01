package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3756. Concatenate Non-Zero Digits and Multiply by Sum II
 *
 * @author baltan
 * @date 2026/1/26 11:22
 * @see SumAndMultiply
 */
public class SumAndMultiply1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sumAndMultiply("9876543210", new int[][]{{0, 9}}));
        OutputUtils.print1DIntegerArray(sumAndMultiply("10203004", new int[][]{{0, 7}, {1, 3}, {4, 6}}));
        OutputUtils.print1DIntegerArray(sumAndMultiply("1000", new int[][]{{0, 3}, {1, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/solutions/3839697/san-ge-qian-zhui-he-pythonjavacgo-by-end-6e1a/"></a>
     *
     * @param s
     * @param queries
     * @return
     */
    public static int[] sumAndMultiply(String s, int[][] queries) {
        int[] result = new int[queries.length];
        int mod = 1000000007;
        /**
         * prefixSums[i]表示字符串s的前i个字符表示的数字之和
         */
        int[] prefixSums = new int[s.length() + 1];
        /**
         * prefixNumModulus[i]表示字符串s的前i个字符表示的数字除去0后得到的不含零新整数x除以mod的余数
         */
        long[] prefixNumModulus = new long[s.length() + 1];
        /**
         * prefixNonZeroNumLengths[i]表示字符串s的前i个字符表示的数字除去0后得到的不含零新整数x的位数
         */
        int[] prefixNonZeroNumLengths = new int[s.length() + 1];
        /**
         * exponentModulus[i]表示10^i除以mod的余数
         */
        long[] exponentModulus = new long[s.length() + 1];
        exponentModulus[0] = 1L;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            prefixSums[i + 1] = prefixSums[i] + digit;
            prefixNumModulus[i + 1] = digit == 0 ? prefixNumModulus[i] : (prefixNumModulus[i] * 10 + digit) % mod;
            prefixNonZeroNumLengths[i + 1] = digit == 0 ? prefixNonZeroNumLengths[i] : prefixNonZeroNumLengths[i] + 1;
            exponentModulus[i + 1] = exponentModulus[i] * 10 % mod;
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            /**
             * 子串s[start……end]中所有字符表示的数字之和
             */
            int digitSum = prefixSums[end + 1] - prefixSums[start];
            /**
             * 子串s[0……end]除去0后得到的不含零新整数比s[0……start-1]除去0后得到的不含零新整数多lengthDiff个数位
             */
            int lengthDiff = prefixNonZeroNumLengths[end + 1] - prefixNonZeroNumLengths[start];
            /**
             * 子串s[start……end]除去0后得到的不含零新整数除以mod的余数
             */
            long nonZeroNumModule = (prefixNumModulus[end + 1] - prefixNumModulus[start] * exponentModulus[lengthDiff] % mod + mod) % mod;
            result[i] = (int) (nonZeroNumModule * digitSum % mod);
        }
        return result;
    }
}
