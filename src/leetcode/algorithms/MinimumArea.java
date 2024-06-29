package leetcode.algorithms;

/**
 * Description: 3195. Find the Minimum Area to Cover All Ones I
 *
 * @author baltan
 * @date 2024/6/27 16:26
 */
public class MinimumArea {
    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
        System.out.println(minimumArea(new int[][]{{1, 0}, {0, 0}}));
    }

    public static int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 矩阵grid中最上面的1的位置
         */
        int topmost = Integer.MIN_VALUE;
        /**
         * 矩阵grid中最下面的1的位置
         */
        int bottommost = Integer.MAX_VALUE;
        /**
         * 矩阵grid中最左边的1的位置
         */
        int leftmost = Integer.MAX_VALUE;
        /**
         * 矩阵grid中最右边的1的位置
         */
        int rightmost = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    topmost = Math.max(topmost, i);
                    bottommost = Math.min(bottommost, i);
                    leftmost = Math.min(leftmost, j);
                    rightmost = Math.max(rightmost, j);
                }
            }
        }
        return (topmost - bottommost + 1) * (rightmost - leftmost + 1);
    }
}
