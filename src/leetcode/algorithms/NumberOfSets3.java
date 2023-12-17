package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2959. Number of Possible Sets of Closing Branches
 *
 * @author Baltan
 * @date 2023/12/16 21:40
 */
public class NumberOfSets3 {
    public static void main(String[] args) {
        System.out.println(numberOfSets(3, 5, new int[][]{{0, 1, 2}, {1, 2, 10}, {0, 2, 10}}));
        System.out.println(numberOfSets(3, 5, new int[][]{{0, 1, 20}, {0, 1, 10}, {1, 2, 2}, {0, 2, 2}}));
        System.out.println(numberOfSets(1, 10, new int[][]{}));
    }

    public static int numberOfSets(int n, int maxDistance, int[][] roads) {
        int result = 0;
        /**
         * isClosed[i]表示分部i是否被关闭
         */
        boolean[] isClosed = new boolean[n];
        /**
         * path[i][j]表示分部i到分部j的最小距离
         */
        int[][] path = new int[n][n];
        /**
         * 初始化假设每个分部都是独立的
         */
        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
            path[i][i] = 0;
        }
        /**
         * 计算每个分部到其他分部的最小距离
         */
        for (int[] road : roads) {
            path[road[0]][road[1]] = Math.min(path[road[0]][road[1]], road[2]);
            path[road[1]][road[0]] = Math.min(path[road[1]][road[0]], road[2]);
        }
        /**
         * 依次判断每一种关闭分部的方案，status由低到高第i位如果为0，表示第i个分部被关闭
         */
        outer:
        for (int status = (1 << n) - 1; status >= 0; status--) {
            /**
             * dp[i][j]表示当前方案下，从分部i到分部j的最小距离
             */
            int[][] dp = new int[n][n];
            /**
             * 将二维数组path深拷贝到dp
             */
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = path[i][j];
                }
            }
            /**
             * 判断当前方案下，每个分部是否被关闭
             */
            for (int i = 0; i < n; i++) {
                isClosed[i] = (status & (1 << i)) == 0;
                /**
                 * 如果当前分部i被关闭，则与它相连的所有道路都不可通行
                 */
                if (isClosed[i]) {
                    for (int j = 0; j < n; j++) {
                        dp[i][j] = Integer.MAX_VALUE;
                        dp[j][i] = Integer.MAX_VALUE;
                    }
                }
            }
            /**
             * <em>Floyd算法核心代码</em>：
             * 更新分部i到分部j之间的最小距离，逐一判断从分部i途径分部k再到分部j的距离是否比分部i直接到分部j的距离小，如果是的话就更新距离
             */
            for (int k = 0; k < n; k++) {
                /**
                 * 分部k被关闭，无法用来中转
                 */
                if (isClosed[k]) {
                    continue;
                }

                for (int i = 0; i < n; i++) {
                    /**
                     * 分部i被关闭，不需要考虑从此处出发的情况
                     */
                    if (isClosed[i]) {
                        continue;
                    }

                    for (int j = 0; j < n; j++) {
                        /**
                         * 分部j被关闭，不需要考虑到达次数的情况
                         */
                        if (isClosed[j]) {
                            continue;
                        }
                        /**
                         * 判断从分部i途径分部k再到分部j的距离是否比分部i直接到分部j的距离小
                         */
                        if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                        }
                    }
                }
            }
            /**
             * 依次判断每个分部到其他分部的最小距离是否都不大于maxDistance
             */
            for (int i = 0; i < n; i++) {
                /**
                 * 分部i被关闭，不需要考虑从此处出发的情况
                 */
                if (isClosed[i]) {
                    continue;
                }

                for (int j = i; j < n; j++) {
                    /**
                     * 分部i到分部j的距离大于maxDistance，当前关闭分部的方案不可行
                     */
                    if (!isClosed[j] && dp[i][j] > maxDistance) {
                        continue outer;
                    }
                }
            }
            result++;
        }
        return result;
    }
}
