package leetcode.algorithms;

/**
 * Description: 3128. Right Triangles
 *
 * @author Baltan
 * @date 2024/4/28 22:30
 */
public class NumberOfRightTriangles {
    public static void main(String[] args) {
        System.out.println(numberOfRightTriangles(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}}));
        System.out.println(numberOfRightTriangles(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        System.out.println(numberOfRightTriangles(new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}}));
    }

    public static long numberOfRightTriangles(int[][] grid) {
        long result = 0L;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * rowCounts[i]表示第i行值为1的单元格的个数
         */
        int[] rowCounts = new int[rows];
        /**
         * rowCounts[i]表示第i列值为1的单元格的个数
         */
        int[] colCounts = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCounts[i]++;
                    colCounts[j]++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    /**
                     * 以单元格grid[i][j]作为直角三角形的直角顶点，可以在同一行任意选择其余rowCounts[i]-1个点中的一个，在同一列任意选
                     * 择其余colCounts[j]-1个点中的一个，两两组合构成(rowCounts[i]-1)*(colCounts[j]-1)个不同的直角三角形
                     */
                    result += (long) (rowCounts[i] - 1) * (colCounts[j] - 1);
                }
            }
        }
        return result;
    }
}
