package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description: 2463. Minimum Total Distance Traveled
 *
 * @author Baltan
 * @date 2025/2/4 19:02
 */
public class MinimumTotalDistance {
    public static void main(String[] args) {
        System.out.println(minimumTotalDistance(Arrays.asList(9, 11, 99, 101), new int[][]{{10, 1}, {7, 1}, {14, 1}, {100, 1}, {96, 1}, {103, 1}}));
        System.out.println(minimumTotalDistance(Arrays.asList(0, 4, 6), new int[][]{{2, 2}, {6, 2}}));
        System.out.println(minimumTotalDistance(Arrays.asList(1, -1), new int[][]{{-2, 1}, {2, 1}}));
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        /**
         * limit[i]表示最左边i个工厂一共最多可以修理机器人的个数
         */
        long[] limits = new long[factory.length + 1];
        /**
         * distancePrefixSums[i][j]表示最左边j个机器人都到factory[i]的总距离，所求即为dp[factory.length][robot.size()]
         */
        long[][] distancePrefixSums = new long[factory.length][robot.size() + 1];
        /**
         * dp[i][j]表示最左边j个机器人到最左边i个工厂维修移动的最小总距离
         */
        long[][] dp = new long[factory.length + 1][robot.size() + 1];
        /**
         * 将所有机器人和工厂分别按照坐标升序排列
         */
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < factory.length; i++) {
            for (int j = 0; j < robot.size(); j++) {
                distancePrefixSums[i][j + 1] = distancePrefixSums[i][j] + Math.abs(robot.get(j) - factory[i][0]);
                dp[i + 1][j + 1] = Long.MAX_VALUE;
            }
            limits[i + 1] = limits[i] + factory[i][1];
        }
        /**
         * 计算最左边j个机器人到最左边i个工厂维修移动的最小总距离dp[i][j]
         */
        for (int i = 1; i <= factory.length; i++) {
            for (int j = 1; j <= Math.min(robot.size(), limits[i]); j++) {
                /**
                 * 假设最左边k个机器人到最左边i-1个工厂维修，接下去j-k个机器人到工厂factory[i-1]维修，这种情况下机器人移动的最小总距离为
                 * dp[i-1][k]+(distancePrefixSums[i-1][j]-distancePrefixSums[i-1][k])。因为工厂factory[i-1]最多可以修理
                 * factory[i-1][1]个机器人，所以最左边i-1个工厂至少要修理Math.max(0,j-factory[i-1][1])个机器人，最多可以修理
                 * Math.min(j,limits[i-1])个机器人，这些情况中取总距离的最小值即可
                 */
                for (int k = Math.max(0, j - factory[i - 1][1]); k <= Math.min(j, limits[i - 1]); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + distancePrefixSums[i - 1][j] - distancePrefixSums[i - 1][k]);
                }
            }
        }
        return dp[factory.length][robot.size()];
    }
}
