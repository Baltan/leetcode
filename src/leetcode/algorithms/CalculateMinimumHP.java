package leetcode.algorithms;

/**
 * Description: 174. Dungeon Game
 *
 * @author Baltan
 * @date 2019-06-05 10:52
 */
public class CalculateMinimumHP {
    public static void main(String[] args) {
        int[][] dungeon1 = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon1));

        int[][] dungeon2 = {{-2, -30, 3}, {-5, -100, 1}, {-10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon2));

        int[][] dungeon3 = {{-2, -30, -13}, {-5, -100, -1}, {-10, -30, -5}};
        System.out.println(calculateMinimumHP(dungeon3));

        int[][] dungeon4 = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        System.out.println(calculateMinimumHP(dungeon4));

        int[][] dungeon5 = {{-5}};
        System.out.println(calculateMinimumHP(dungeon5));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        /**
         * 保存进入某个格子前至少需要带有的血量，minHPMatrix[0][0]即为进入左上角的格子前至少要有的血量
         */
        int[][] minHPMatrix = new int[rows][cols];
        /**
         * 如果最右下角这个格子血量x不为负，则进入这个格子的时候至少有1滴血即可，
         * 如果最右下角这个格子血量x为负，因为出格子时至少还要有1滴血，则进入这个格子的时候至少有1-x滴血即可
         */
        minHPMatrix[rows - 1][cols - 1] =
                dungeon[rows - 1][cols - 1] >= 0 ? 1 : 1 - dungeon[rows - 1][cols - 1];
        /**
         * 沿最下面这条边走（当处于最下面一排时，此时只能向右走），出某个格子后的血量即为进入其右边格子的最少要求的血量
         */
        for (int i = cols - 2; i >= 0; i--) {
            minHPMatrix[rows - 1][i] = Math.max(1, minHPMatrix[rows - 1][i + 1] - dungeon[rows - 1][i]);
        }
        /**
         * 沿最右边这条边走（当处于最右边一排时，此时只能向下走），出某个格子后的血量即为进入其下边格子的最少要求的血量
         */
        for (int i = rows - 2; i >= 0; i--) {
            minHPMatrix[i][cols - 1] = Math.max(1, minHPMatrix[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }
        /**
         * 其余格子，出某个格子后的血量即为进入其右边格子或其下面格子的最少要求的血量的较小值
         */
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int minHP = Math.min(minHPMatrix[i][j + 1], minHPMatrix[i + 1][j]);
                minHPMatrix[i][j] = Math.max(1, minHP - dungeon[i][j]);
            }
        }
        return minHPMatrix[0][0];
    }
}
