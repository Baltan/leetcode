package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2318. Number of Distinct Roll Sequences
 *
 * @author Baltan
 * @date 2024/1/30 23:37
 */
public class DistinctSequences {
    public static void main(String[] args) {
        System.out.println(distinctSequences(4));
        System.out.println(distinctSequences(2));
        System.out.println(distinctSequences(1000));
    }

    public static int distinctSequences(int n) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 保存所有可能的三元组，即连续三个数字构成的三位数
         */
        List<Integer> triplets = new ArrayList<>();

        if (n == 1) {
            return 6;
        }

        if (n == 2) {
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 6; j++) {
                    if (!cannotAdjacent(i, j)) {
                        result++;
                    }
                }
            }
            return (int) result;
        }
        /**
         * 计算所有可能的三元组ijk
         */
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (cannotAdjacent(i, j)) {
                    continue;
                }

                for (int k = 1; k <= 6; k++) {
                    if (cannotAdjacent(j, k) || i == k) {
                        continue;
                    }
                    triplets.add(i * 100 + j * 10 + k);
                }
            }
        }
        int size = triplets.size();
        /**
         * help[i][j]表示两个三元组能否首尾相接构成一个四元组，根据题意，三位数xyz只能和三位数yz?首尾相连
         */
        boolean[][] help = new boolean[size][size];
        /**
         * dp[i][j]表示前i个数字构成的序列中，以三位数triplets[j]结尾的组合数，所求即为dp[n][0]+dp[n][1]+……+dp[n][size-1]
         */
        long[][] dp = new long[n + 1][size + 1];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int triplet1 = triplets.get(i);
                int triplet2 = triplets.get(j);
                /**
                 * 只有triplet1的后两位和triplet2的前两位相同才行
                 */
                help[i][j] = triplet1 % 100 == triplet2 / 10;
            }
        }

        for (int i = 0; i < size; i++) {
            dp[3][i] = 1L;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (help[j][k]) {
                        /**
                         * 前i个数字构成的序列中，以三位数triplets[k]结尾的组合数，可以由前i-1个数字构成的序列中，以三位数triplets[j]
                         * 结尾的组合数累加得到
                         */
                        dp[i][k] = (dp[i][k] + dp[i - 1][j]) % mod;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            result = (result + dp[n][i]) % mod;
        }
        return (int) result;
    }

    /**
     * 判断x和y能否在相邻位置出现
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean cannotAdjacent(int x, int y) {
        /**
         * 相邻数字不能相等，且互质
         */
        return x == y || (x % 2 == 0 && y % 2 == 0) || (x == 3 && y == 6) || (x == 6 && y == 3);
    }
}
