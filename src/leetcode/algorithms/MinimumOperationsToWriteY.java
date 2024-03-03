package leetcode.algorithms;

/**
 * Description: 3071. Minimum Operations to Write the Letter Y on a Grid
 *
 * @author Baltan
 * @date 2024/3/3 19:34
 */
public class MinimumOperationsToWriteY {
    public static void main(String[] args) {
        System.out.println(minimumOperationsToWriteY(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 0}}));
        System.out.println(minimumOperationsToWriteY(new int[][]{{0, 1, 0, 1, 0}, {2, 1, 0, 1, 2}, {2, 2, 2, 0, 1}, {2, 2, 2, 2, 2}, {2, 1, 2, 2, 2}}));
    }

    public static int minimumOperationsToWriteY(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int half = grid.length / 2;
        /**
         * 属于字母Y的单元格的个数
         */
        int yCount = half * 3 + 1;
        /**
         * 不属于字母Y的单元格的个数
         */
        int otherCount = grid.length * grid.length - yCount;
        /**
         * yCounts[i]表示属于字母Y的单元格中数字i出现的次数
         */
        int[] yCounts = new int[3];
        /**
         * otherCounts[i]表示不属于字母Y的单元格中数字i出现的次数
         */
        int[] otherCounts = new int[3];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i <= half && (i == j || i + j + 1 == grid.length)) {
                    /**
                     * 主对角线和副对角线上属于字母Y的单元格
                     */
                    yCounts[grid[i][j]]++;
                } else if (i > half && j == half) {
                    /**
                     * 中心竖直线上属于字母Y的单元格
                     */
                    yCounts[grid[i][j]]++;
                } else {
                    /**
                     * 不属于字母Y的单元格
                     */
                    otherCounts[grid[i][j]]++;
                }
            }
        }
        /**
         * 分别计算最终属于字母Y的单元格都为数字i，不属于字母Y的单元格都为数字j时的操作次数
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    result = Math.min(result, (yCount - yCounts[i]) + (otherCount - otherCounts[j]));
                }
            }
        }
        return result;
    }
}
