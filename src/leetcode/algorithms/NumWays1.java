package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: LCP 07. 传递信息
 *
 * @author Baltan
 * @date 2020-06-17 21:21
 */
public class NumWays1 {
    public static void main(String[] args) {
        int[][] relation1 = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(numWays(5, relation1, 3));

        int[][] relation2 = {{0, 2}, {2, 1}};
        System.out.println(numWays(3, relation2, 2));

        int[][] relation3 = {{0, 1}, {0, 2}, {2, 1}, {1, 2}, {1, 0}, {2, 0}};
        System.out.println(numWays(3, relation3, 5));
    }

    public static int numWays(int n, int[][] relation, int k) {
        /**
         * dp[i][j]表示经过i轮传递可以传递到编号j的小朋友的传递方案数
         */
        int[][] dp = new int[k + 1][n];
        /**
         * 初始时从编号为0的小朋友开始传递
         */
        dp[0][0] = 1;
        /**
         * array[i]为编号为i的小朋友下一轮可以传递的所有小朋友的编号的集合
         */
        List<Integer>[] array = new List[n];

        for (int i = 0; i < n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int[] pair : relation) {
            array[pair[0]].add(pair[1]);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 当dp[i][j]不为0时，说明经过i轮传递可以到达编号为j的小朋友
                 */
                if (dp[i][j] != 0) {
                    /**
                     * 通过j可以计算传递i+1轮可以到达某个小朋友的方案数
                     */
                    for (int next : array[j]) {
                        dp[i + 1][next] += dp[i][j];
                    }
                }
            }
        }
        return dp[k][n - 1];
    }
}
