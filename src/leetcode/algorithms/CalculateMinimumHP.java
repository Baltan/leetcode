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

        int[][] minHPMatrix = new int[rows][cols];

        minHPMatrix[rows - 1][cols - 1] =
                dungeon[rows - 1][cols - 1] >= 0 ? 1 : 1 - dungeon[rows - 1][cols - 1];

        for (int i = cols - 2; i >= 0; i--) {
            minHPMatrix[rows - 1][i] = Math.max(1, minHPMatrix[rows - 1][i + 1] - dungeon[rows - 1][i]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            minHPMatrix[i][cols - 1] = Math.max(1, minHPMatrix[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int minHP = Math.min(minHPMatrix[i][j + 1], minHPMatrix[i + 1][j]);
                minHPMatrix[i][j] = Math.max(1, minHP - dungeon[i][j]);
            }
        }
        return minHPMatrix[0][0];
    }
}
