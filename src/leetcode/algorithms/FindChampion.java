package leetcode.algorithms;

/**
 * Description: 2923. Find Champion I
 *
 * @author Baltan
 * @date 2023/11/5 14:47
 * @see FindChampion1
 */
public class FindChampion {
    public static void main(String[] args) {
        System.out.println(findChampion(new int[][]{{1, 1}, {0, 1}}));
        System.out.println(findChampion(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(findChampion(new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 0, 0}}));
    }

    public static int findChampion(int[][] grid) {
        int length = grid.length;
        /**
         * losers[i]表示队伍i是否会失败
         */
        boolean[] losers = new boolean[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                /**
                 * 因为队伍i比队伍j强，所以队伍j会失败
                 */
                if (grid[i][j] == 1) {
                    losers[j] = true;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            /**
             * 没有失败过的队伍即为冠军
             */
            if (!losers[i]) {
                return i;
            }
        }
        return -1;
    }
}
