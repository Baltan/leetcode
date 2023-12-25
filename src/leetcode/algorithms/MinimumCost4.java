package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2976. Minimum Cost to Convert String I
 *
 * @author baltan
 * @date 2023/12/25 10:35
 */
public class MinimumCost4 {
    public static void main(String[] args) {
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost("abcd", "acbe", original1, changed1, cost1));

        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(minimumCost("aaaa", "bbbb", original2, changed2, cost2));

        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(minimumCost("abcd", "abce", original3, changed3, cost3));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long result = 0L;
        /**
         * minCosts[i][j]表示从字符i变为字符j的最小代价
         */
        int[][] minCosts = new int[26][26];

        for (int i = 0; i < 26; i++) {
            /**
             * 假设字符i无法变为字符j
             */
            Arrays.fill(minCosts[i], Integer.MAX_VALUE);
            minCosts[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            minCosts[original[i] - 'a'][changed[i] - 'a'] = Math.min(minCosts[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        /**
         * Floyd算法更新字符j变为字符k的最小代价，判断将字符j先变为字符i，再将字符i变为字符k，是否可以减小字符j变为字符k的最小代价
         */
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (minCosts[j][i] != Integer.MAX_VALUE && minCosts[i][k] != Integer.MAX_VALUE) {
                        minCosts[j][k] = Math.min(minCosts[j][k], minCosts[j][i] + minCosts[i][k]);
                    }
                }
            }
        }

        for (int i = 0; i < source.length(); i++) {
            int minCost = minCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            /**
             * 如果字符source[i]无法变为字符target[i]，直接返回-1
             */
            if (minCost == Integer.MAX_VALUE) {
                return -1L;
            }
            result += minCost;
        }
        return result;
    }
}
