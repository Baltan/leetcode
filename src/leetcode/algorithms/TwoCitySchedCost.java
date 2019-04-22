package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: Two City Scheduling
 *
 * @author Baltan
 * @date 2019-04-22 10:33
 */
public class TwoCitySchedCost {
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }

    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        int length = costs.length;
        int haflLength = length / 2;
        int cost = 0;

        for (int i = 0; i < haflLength; i++) {
            cost += costs[i][0];
        }

        for (int i = haflLength; i < length; i++) {
            cost += costs[i][1];
        }
        return cost;
    }
}
