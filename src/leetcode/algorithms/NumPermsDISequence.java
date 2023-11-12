package leetcode.algorithms;

/**
 * Description: 903. Valid Permutations for DI Sequence
 *
 * @author Baltan
 * @date 2023/11/10 23:34
 */
public class NumPermsDISequence {
    public static void main(String[] args) {
        System.out.println(numPermsDISequence("DID"));
        System.out.println(numPermsDISequence("D"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/valid-permutations-for-di-sequence/solutions/669040/dong-tai-gui-hua-tong-su-yi-dong-de-zhua-4c92/"></a>
     *
     * @param s
     * @return
     */
    public static int numPermsDISequence(String s) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 将数字[0,max]构成一个长度为max+1的有序排列
         */
        int max = 0;
        /**
         * curr[i]表示将数字[0,max]构成一个长度为max+1的有序排列，最后一个数字为i时的排量数量
         */
        long[] curr = new long[max + 1];
        /**
         * 对于长度为1的有效排列，只有1种情况(0)
         */
        curr[max++] = 1;

        for (char c : s.toCharArray()) {
            /**
             * 已知[0,max)构成有效排列的情况，计算由[0,max]构成的有效排列
             */
            long[] next = new long[max + 1];

            if (c == 'D') {
                /**
                 * 因为有效排列中倒数第二个数字大于最后一个数字，所以最后一个数字可能为[0,max)
                 */
                for (int i = 0; i < max; i++) {
                    for (int j = i + 1; j <= max; j++) {
                        /**
                         * 假设当前长度为max+1的有效排列为X，除去X的最后一个数字，前缀长度为max的有效排列为Y。则X的倒数第二个数字，就是
                         * Y的最后一个数字。对于排列Y而言，假设最后一个数字Y[max-1]是j，在[0,j)中始终有一个更小的数字被拿走放到X[max]
                         * 位置，所以将排列Y按照数字在排列中的大小位置映射到一个由[0,max)构成的排列Z时，对应就是Z中数字j-1的情况
                         */
                        next[i] = (next[i] + curr[j - 1]) % mod;
                    }
                }
            } else {
                /**
                 * 因为有效排列中倒数第二个数字小于最后一个数字，所以最后一个数字可能为(0,max]
                 */
                for (int i = max; i > 0; i--) {
                    for (int j = i - 1; j >= 0; j--) {
                        /**
                         * 假设当前长度为max+1的有效排列为X，除去X的最后一个数字，前缀长度为max的有效排列为Y。则X的倒数第二个数字，就是
                         * Y的最后一个数字。对于排列Y而言，假设最后一个数字Y[max-1]是j，在(j,max)中始终有一个更大的数字被拿走放到
                         * X[max]位置，所以将排列Y按照数字在排列中的大小位置映射到一个由[0,max)构成的排列Z时，对应就是Z中数字j的情况
                         */
                        next[i] = (next[i] + curr[j]) % mod;
                    }
                }
            }
            max++;
            curr = next;
        }
        /**
         * 将有序排列中最后一个数字为[0,max]的所有排列数量相加
         */
        for (long count : curr) {
            result = (result + count) % mod;
        }
        return (int) result;
    }
}
