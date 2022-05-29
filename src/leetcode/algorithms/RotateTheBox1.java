package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1861. Rotating the Box
 *
 * @author Baltan
 * @date 2022/5/29 12:49
 * @see RotateTheBox
 */
public class RotateTheBox1 {
    public static void main(String[] args) {
        char[][] box1 = {{'#', '.', '#'}};
        OutputUtils.print2DCharacterArray(rotateTheBox(box1));
        System.out.println("-----------------------------");

        char[][] box2 = {{'#', '.', '*', '.'},
                {'#', '#', '*', '.'}};
        OutputUtils.print2DCharacterArray(rotateTheBox(box2));
        System.out.println("-----------------------------");

        char[][] box3 = {{'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}};
        OutputUtils.print2DCharacterArray(rotateTheBox(box3));
    }

    public static char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] result = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            /**
             * 石块可以移动到的最右侧的空位，-1表示右侧没有空位
             */
            int emptyCol = -1;

            for (int j = cols - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    /**
                     * 如果当前石块右侧有空位，则当前石块移动到最右侧的空位，当前位置变成空位，此时最右侧的空位为
                     * box[i][emptyCol-1]
                     */
                    if (emptyCol != -1) {
                        box[i][emptyCol] = '#';
                        box[i][j] = '.';
                        emptyCol--;
                    }
                } else if (box[i][j] == '*') {
                    /**
                     * 遇到障碍物时，障碍物右侧的所有空位都无法到达
                     */
                    emptyCol = -1;
                } else {
                    /**
                     * 如果右侧还有空位，则最右侧的空位仍为box[i][emptyCol-1]，否则为box[i][j]
                     */
                    emptyCol = emptyCol == -1 ? j : emptyCol;
                }
            }
        }
        /**
         * 盒子旋转90°得到最终状态
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = box[i][j];
            }
        }
        return result;
    }
}
