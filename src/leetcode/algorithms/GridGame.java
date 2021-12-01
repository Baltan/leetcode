package leetcode.algorithms;

/**
 * Description: 2017. Grid Game
 *
 * @author Baltan
 * @date 2021/12/1 10:40
 */
public class GridGame {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(gridGame(grid1));

        int[][] grid2 = {{3, 3, 1}, {8, 5, 2}};
        System.out.println(gridGame(grid2));

        int[][] grid3 = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        System.out.println(gridGame(grid3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/grid-game/solution/javaqian-zhui-he-by-merickbao-2-nq78/"></a>
     *
     * @param grid
     * @return
     */
    public static long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;
        int cols = grid[0].length;
        /**
         * 记录两排数组的前缀和
         */
        long[][] prefixSums = new long[2][cols + 1];

        for (int i = 1; i <= cols; i++) {
            prefixSums[0][i] = prefixSums[0][i - 1] + grid[0][i - 1];
            prefixSums[1][i] = prefixSums[1][i - 1] + grid[1][i - 1];
        }
        /**
         * 第二个机器人可以得到的点数，只能是第一排右边剩余的格子中的点数或者第二排左边剩余格子中的点数，对于第二个机器人来说，
         * 要在两种情况中选择较大值，对第一个机器人来说，要获得这些较大值当中的最小值
         */
        for (int i = 1; i <= cols; i++) {
            result = Math.min(result, Math.max(prefixSums[1][i - 1], prefixSums[0][cols] - prefixSums[0][i]));
        }
        return result;
    }
}
