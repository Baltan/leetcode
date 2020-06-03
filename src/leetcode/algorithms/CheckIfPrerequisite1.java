package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1462. Course Schedule IV
 *
 * @author Baltan
 * @date 2020-06-03 21:06
 * @see CheckIfPrerequisite
 * @see FindTheCity
 */
public class CheckIfPrerequisite1 {
    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(checkIfPrerequisite(2, prerequisites1, queries1));

        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        System.out.println(checkIfPrerequisite(2, prerequisites2, queries2));

        int[][] prerequisites3 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = {{1, 0}, {1, 2}};
        System.out.println(checkIfPrerequisite(3, prerequisites3, queries3));

        int[][] prerequisites4 = {{1, 0}, {2, 0}};
        int[][] queries4 = {{0, 1}, {2, 0}};
        System.out.println(checkIfPrerequisite(3, prerequisites4, queries4));

        int[][] prerequisites5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries5 = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        System.out.println(checkIfPrerequisite(5, prerequisites5, queries5));
    }

    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>(queries.length);
        /**
         * dp[i][j]表示从i课程开始修起，直到修完j课程，至少需要修的课程数-1，即图上i点到j点经过的最少边数
         */
        int[][] dp = new int[n][n];
        /**
         * 题意约束的n的最大值
         */
        int maxN = 100;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    /**
                     * 因为最多只有100门课，即有向图上最多只有100个点，则最多只需要经过99条边
                     */
                    dp[i][j] = maxN;
                    dp[j][i] = maxN;
                }
            }
        }
        /**
         * 更新直接相连的两个点的距离
         */
        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[0];
            int course = prerequisite[1];
            dp[preCourse][course] = 1;
        }
        /**
         * <em>Floyd算法核心代码</em>：
         * 更新j到k之间的最小距离，逐一判断从j先到i，再到k的距离是否比j直接到k的距离小，如果是的话就更新距离
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            /**
             * 如果x到y经过的边数小于maxN，即说明x可以通过若干条有向边到达y，即x是y的先修课程
             */
            result.add(dp[x][y] < maxN);
        }
        return result;
    }
}
