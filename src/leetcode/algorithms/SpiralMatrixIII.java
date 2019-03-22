package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Spiral Matrix III
 *
 * @author Baltan
 * @date 2019-03-22 09:37
 */
public class SpiralMatrixIII {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(spiralMatrixIII(1, 4, 0, 0));
        OutputUtils.print2DIntegerArray(spiralMatrixIII(5, 6, 1, 4));
        OutputUtils.print2DIntegerArray(spiralMatrixIII(3, 3, 2, 0));
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        int index = 0;
        result[index++] = new int[]{r0, c0};

        boolean[][] book = new boolean[R][C];
        /**
         * 0-right,1-down,2-left,3-up
         */
        int direction = 0;
        book[r0][c0] = true;

        while (index < R * C) {
            if (direction == 0) {
                c0++;
                if (c0 < C && r0 < R && r0 >= 0 && !book[r0][c0]) {
                    result[index++] = new int[]{r0, c0};
                    book[r0][c0] = true;
                    if ((r0 + 1 < R && !book[r0 + 1][c0]) || (r0 + 1 == R)) {
                        direction = (direction + 1) & 3;
                    }
                } else if (c0 == C) {
                    direction = (direction + 1) & 3;
                } else if (r0 == -1 && !book[0][c0]) {
                    direction = (direction + 1) & 3;
                }
            } else if (direction == 1) {
                r0++;
                if (r0 < R && c0 < C && c0 >= 0 && !book[r0][c0]) {
                    result[index++] = new int[]{r0, c0};
                    book[r0][c0] = true;
                    if ((c0 - 1 >= 0 && !book[r0][c0 - 1]) || (c0 - 1 == -1)) {
                        direction = (direction + 1) & 3;
                    }
                } else if (r0 == R) {
                    direction = (direction + 1) & 3;
                } else if (c0 == C && !book[r0][C - 1]) {
                    direction = (direction + 1) & 3;
                }
            } else if (direction == 2) {
                c0--;
                if (c0 >= 0 && r0 < R && r0 >= 0 && !book[r0][c0]) {
                    result[index++] = new int[]{r0, c0};
                    book[r0][c0] = true;
                    if ((r0 - 1 >= 0 && !book[r0 - 1][c0]) || (r0 - 1 == -1)) {
                        direction = (direction + 1) & 3;
                    }
                } else if (c0 == -1) {
                    direction = (direction + 1) & 3;
                } else if (r0 == R && !book[R - 1][c0]) {
                    direction = (direction + 1) & 3;
                }
            } else {
                r0--;
                if (r0 >= 0 && c0 < C && c0 >= 0 && !book[r0][c0]) {
                    result[index++] = new int[]{r0, c0};
                    book[r0][c0] = true;
                    if ((c0 + 1 < C && !book[r0][c0 + 1]) || (c0 + 1 == C)) {
                        direction = (direction + 1) & 3;
                    }
                } else if (r0 == -1) {
                    direction = (direction + 1) & 3;
                } else if (c0 == -1 && !book[r0][0]) {
                    direction = (direction + 1) & 3;
                }
            }
        }
        return result;
    }
}
