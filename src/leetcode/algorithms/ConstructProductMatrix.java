package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2906. Construct Product Matrix
 *
 * @author baltan
 * @date 2023/10/19 15:47
 */
public class ConstructProductMatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        OutputUtils.print2DIntegerArray(constructProductMatrix(grid1));

        System.out.println("----------------------------------------");

        int[][] grid2 = {{12345}, {2}, {1}};
        OutputUtils.print2DIntegerArray(constructProductMatrix(grid2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/construct-product-matrix/solutions/2483137/zhou-sai-chang-kao-qian-hou-zhui-fen-jie-21hr/"></a>
     *
     * @param grid
     * @return
     */
    public static int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 假设将二维数组grid逐行相接展开后得到一个长度为rows*cols的一维数组arr
         */
        int total = rows * cols;
        /**
         * prefixRemainders[i+1]=(arr[0]*arr[1]*……*arr[i])%mod
         */
        int[] prefixRemainders = new int[total + 1];
        /**
         * suffixRemainders[i]=(arr[i]*arr[i+1]*……*arr[total-1])%mod
         */
        int[] suffixRemainders = new int[total + 1];
        int[][] result = new int[rows][cols];
        prefixRemainders[0] = 1;
        suffixRemainders[total] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                prefixRemainders[index + 1] = (int) (((long) grid[i][j] * prefixRemainders[index]) % mod);
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int index = i * cols + j;
                suffixRemainders[index] = (int) (((long) grid[i][j] * suffixRemainders[index + 1]) % mod);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                result[i][j] = (prefixRemainders[index] * suffixRemainders[index + 1]) % mod;
            }
        }
        return result;
    }
}
