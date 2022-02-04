package leetcode.algorithms;

/**
 * Description: 1958. Check if Move is Legal
 *
 * @author Baltan
 * @date 2022/2/4 11:30
 */
public class CheckMove {
    public static void main(String[] args) {
        char[][] board1 = {{'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'}, {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'}};
        System.out.println(checkMove(board1, 4, 3, 'B'));

        char[][] board2 = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'B', '.', '.', 'W', '.', '.', '.'},
                {'.', '.', 'W', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', 'B', 'W', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'W', '.'}, {'.', '.', '.', '.', '.', '.', '.', 'B'}};
        System.out.println(checkMove(board2, 4, 4, 'W'));
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        /**
         * 依据题意，board的边长为8
         */
        final int LENGTH = 8;
        /**
         * 上、右上、右、右下、下、左下、左、左上8个移动方向
         */
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        /**
         * 好线段中间格子的颜色
         */
        char midColor = color == 'W' ? 'B' : 'W';

        for (int[] direction : directions) {
            /**
             * 以(rMove,cMove)为端点，在direction方向上延伸的好线段的第一个中间格子坐标为(currX,currY)
             */
            int currX = rMove + direction[0];
            int currY = cMove + direction[1];
            /**
             * 是否存在中间格子
             */
            boolean hasMid = false;

            while (currX >= 0 && currX < LENGTH && currY >= 0 && currY < LENGTH) {
                /**
                 * 如果当前格子和中间格子颜色相同，继续在direction方向上延伸查找
                 */
                if (board[currX][currY] == midColor) {
                    hasMid = true;
                    currX += direction[0];
                    currY += direction[1];
                    /**
                     * 如果当前格子和端点格子颜色相同，判断线段是否存在中间格子，存在则说明已找到一条好线段；否则direction方
                     * 向上的延伸不是好线段
                     */
                } else if (board[currX][currY] == color) {
                    if (hasMid) {
                        return true;
                    } else {
                        break;
                    }
                    /**
                     * 如果当前格子是一个空格，则direction方向上的延伸不是好线段
                     */
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
