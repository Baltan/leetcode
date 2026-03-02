package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3809. Best Reachable Tower
 *
 * @author baltan
 * @date 2026/2/19 11:51
 */
public class BestTower {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(bestTower(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, new int[]{1, 1}, 2));
        OutputUtils.print1DIntegerArray(bestTower(new int[][]{{1, 3, 4}, {2, 2, 4}, {4, 4, 7}}, new int[]{0, 0}, 5));
        OutputUtils.print1DIntegerArray(bestTower(new int[][]{{5, 6, 8}, {0, 3, 5}}, new int[]{1, 2}, 1));
    }

    public static int[] bestTower(int[][] towers, int[] center, int radius) {
        /**
         * 已遍历过的最好可到达的塔
         */
        int[] reachableTower = null;

        for (int[] tower : towers) {
            if (Math.abs(tower[0] - center[0]) + Math.abs(tower[1] - center[1]) <= radius) {
                if (reachableTower == null || tower[2] > reachableTower[2] ||
                        (tower[2] == reachableTower[2] && (tower[0] < reachableTower[0] || (tower[0] == reachableTower[0] && tower[1] < reachableTower[1])))) {
                    reachableTower = tower;
                }
            }
        }
        return reachableTower == null ? new int[]{-1, -1} : new int[]{reachableTower[0], reachableTower[1]};
    }
}
