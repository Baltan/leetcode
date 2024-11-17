package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1735. Count Ways to Make Array With Product
 *
 * @author Baltan
 * @date 2024/11/17 19:03
 */
public class WaysToFillArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(waysToFillArray(new int[][]{{2, 6}, {5, 1}, {73, 660}}));
        OutputUtils.print1DIntegerArray(waysToFillArray(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }

    public static int[] waysToFillArray(int[][] queries) {
        int[] result = new int[queries.length];
        int mod = 1000000007;
        /**
         * 计算[1,10000]范围内的所有质数。对于查询query，根据题意，k∈[1,10000]，所以对k分解质因素后，最大的质数不超过10000
         */
        List<Integer> primes = getPrimes();
        /**
         * 计算不同情况的组合数。对于查询query，根据题意，n∈[1,10000]，所以至多从10000个数中选择若干个数令它们不包括某个质因数x。又因为
         * k∈[1,10000]，而2^14=16384>10000，所以将k分解质因素后，某个质因数出现的次数至多为13次。即如果n属于[13,10000]，最终分解得到的
         * n个数中，至多只有13个数包含该质因数
         */
        long[][] combinations = getCombinations();

        for (int i = 0; i < queries.length; i++) {
            /**
             * 查询queries[i]的总方案数，假设k分解质因数后为k=(x1^e1)*(x2^e2)*……*(xa^ea)，则将每个质数的幂代表的数字分解到n个数中，最
             * 后将所有质数各自分解到n个数中的方案数相乘即可
             */
            long ways = 1;
            int n = queries[i][0];
            int k = queries[i][1];

            for (int prime : primes) {
                /**
                 * k分解质因数后包含质数prime的个数
                 */
                int exponent = 0;

                while (k % prime == 0) {
                    exponent++;
                    k /= prime;
                }

                if (exponent == 0) {
                    continue;
                }
                /**
                 * 将exponent个质数分解到n个数中的方案数
                 */
                long plan = 0L;
                /**
                 * 假设n个数中有j个数包含质因数prime，则j∈[1,Math.min(exponent,n)]
                 */
                for (int j = 1; j <= Math.min(exponent, n); j++) {
                    /**
                     * 从n个数中选择j个数包含质因数prime的方案数为combinations[n][j]。对于这j个数，它们每个可以包含若干个质因数prime，
                     * 可以用插空法，在exponent个质数prime中插入j-1个隔板，将其分解为j个数，方案数为combinations[exponent-1][j-1]，
                     * 所以总方案数为combinations[n][j]*combinations[exponent-1][j-1]
                     */
                    plan += combinations[n][j] * combinations[exponent - 1][j - 1] % mod;
                }
                ways = ways * plan % mod;
            }
            result[i] = (int) ways;
        }
        return result;
    }

    /**
     * 计算[1,10000]范围内的所有质数
     *
     * @return
     */
    public static List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        outer:
        for (int i = 3; i <= 10000; i++) {
            for (int prime : primes) {
                if (i % prime == 0) {
                    continue outer;
                }
            }
            primes.add(i);
        }
        return primes;
    }

    /**
     * 计算不同情况的组合数
     *
     * @return
     */
    public static long[][] getCombinations() {
        int mod = 1000000007;
        /**
         * combinations[i][j]表示从i个中取j个的组合数，即C(i,j)
         */
        long[][] combinations = new long[10001][14];

        for (int i = 0; i <= 10000; i++) {
            combinations[i][0] = 1;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 13; j++) {
                combinations[i][j] = (combinations[i - 1][j] + combinations[i - 1][j - 1]) % mod;
            }
        }
        return combinations;
    }
}
