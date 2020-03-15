package leetcode.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 面试题 08.02. 迷路的机器人
 *
 * @author Baltan
 * @date 2020-03-15 17:18
 * @see leetcode.algorithms.UniquePaths
 * @see leetcode.algorithms.UniquePathsWithObstacles
 */
public class PathWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(pathWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{1}};
        System.out.println(pathWithObstacles(obstacleGrid2));

        int[][] obstacleGrid3 = {{0, 1}, {0, 0}};
        System.out.println(pathWithObstacles(obstacleGrid3));

        int[][] obstacleGrid4 = {{0, 1}, {1, 0}};
        System.out.println(pathWithObstacles(obstacleGrid4));
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        /**
         * 如果起点处或终点处有障碍物，则没有可行路径
         */
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return Arrays.asList();
        }

        List<List<Integer>> result = new LinkedList<>();
        /**
         * dp[i][j]表示走到第i行第j列的网格有几种路径
         */
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] != 1) {
                    /**
                     * 如果obstacleGrid[i-1][j]存在，并且obstacleGrid[i-1][j]没有障碍物，就尝试从
                     * obstacleGrid[i-1][j]向右移动一步走到obstacleGrid[i][j]
                     */
                    dp[i][j] += i - 1 >= 0 ? dp[i - 1][j] : 0;
                    /**
                     * 如果obstacleGrid[i][j-1]存在，并且obstacleGrid[i][j-1]没有障碍物，就尝试从
                     * obstacleGrid[i][j-1]向下移动一步走到obstacleGrid[i][j]
                     */
                    dp[i][j] += j - 1 >= 0 ? dp[i][j - 1] : 0;
                }
            }
        }

        int i = rows - 1;
        int j = cols - 1;
        /**
         * 从终点开始逆推一条路径
         */
        while (i != 0 || j != 0) {
            result.add(0, Arrays.asList(i, j));

            if (i - 1 >= 0 && dp[i - 1][j] > 0) {
                /**
                 * 如果obstacleGrid[i-1][j]存在，并且obstacleGrid[i-1][j]没有障碍物，就从
                 * obstacleGrid[i-1][j]走到obstacleGrid[i][j]
                 */
                i -= 1;
            } else if (j - 1 >= 0 && dp[i][j - 1] > 0) {
                /**
                 * 如果obstacleGrid[i][j-1]存在，并且obstacleGrid[i][j-1]没有障碍物，就从
                 * obstacleGrid[i][j-1]走到obstacleGrid[i][j]
                 */
                j -= 1;
            } else {
                /**
                 * 如果既不能从obstacleGrid[i-1][j]，也不能从obstacleGrid[i][j-1]走到
                 * obstacleGrid[i][j]，则没有可行路径
                 */
                return Arrays.asList();
            }
        }
        result.add(0, Arrays.asList(0, 0));
        return result;
    }
}
