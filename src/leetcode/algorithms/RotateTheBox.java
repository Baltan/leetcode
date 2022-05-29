package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1861. Rotating the Box
 *
 * @author Baltan
 * @date 2022/5/29 12:49
 */
public class RotateTheBox {
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
            for (int j = cols - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    /**
                     * 当前石块向右移动最终停留的列
                     */
                    int finalCol = j;
                    /**
                     * 查找当前石块遇到障碍物或其他石块或盒子右边缘前的最右边的空位
                     */
                    while (finalCol + 1 < cols && box[i][finalCol + 1] == '.') {
                        finalCol++;
                    }
                    /**
                     * 当前石块最终移动到box[i][finalCol]位置，当前位置被空出
                     */
                    if (j != finalCol) {
                        box[i][finalCol] = '#';
                        box[i][j] = '.';
                    }
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
