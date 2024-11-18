package leetcode.algorithms;

/**
 * Description: 85. Maximal Rectangle
 *
 * @author Baltan
 * @date 2024/11/17 23:51
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '1'}}));
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(maximalRectangle(new char[][]{{'0'}}));
        System.out.println(maximalRectangle(new char[][]{{'1'}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximal-rectangle/solutions/535672/zui-da-ju-xing-by-leetcode-solution-bjlu/"></a>
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * help[i][j+1]表示从matrix[i][j]开始向左数，连续的1的个数
         */
        int[][] help = new int[rows][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                help[i][j + 1] = matrix[i][j] == '0' ? 0 : help[i][j] + 1;
            }
        }
        /**
         * 遍历计算以matrix[i][j]作为右下角的矩形的最大面积
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 矩形的最大宽度
                 */
                int width = cols;
                /**
                 * 从下往上枚举矩形的右上角matrix[k][j]，矩形的最大宽度width为max{help[k][j+1],help[k+1][j+1]},……,help[i][j+1]}
                 * 中的最大值，高度为i-k+1，从而得到矩形面积为width*(i-k+1)
                 */
                for (int k = i; k >= 0 && width > 0; k--) {
                    /**
                     * 从下往上遍历矩形上边界的过程中更新矩形的最大宽度
                     */
                    width = Math.min(width, help[k][j + 1]);
                    result = Math.max(result, width * (i - k + 1));
                }
            }
        }
        return result;
    }
}
