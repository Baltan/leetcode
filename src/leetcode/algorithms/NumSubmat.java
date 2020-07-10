package leetcode.algorithms;

/**
 * Description: 1504. Count Submatrices With All Ones
 *
 * @author Baltan
 * @date 2020-07-08 20:51
 */
public class NumSubmat {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(numSubmat(mat1));

        int[][] mat2 = {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(numSubmat(mat2));

        int[][] mat3 = {{1, 1, 1, 1, 1, 1}};
        System.out.println(numSubmat(mat3));

        int[][] mat4 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        System.out.println(numSubmat(mat4));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-submatrices-with-all-ones/solution/5454-tong-ji-quan-1-zi-ju-xing-by-lin-miao-miao/"></a>
     *
     * @param mat
     * @return
     */
    public static int numSubmat(int[][] mat) {
        int result = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * help[i][j]表示第i行第j列（0-based）左侧的格子到当前格子有连续多少个1
         */
        int[][] help = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            help[i][0] = mat[i][0] == 1 ? 1 : 0;

            for (int j = 1; j < cols; j++) {
                help[i][j] = mat[i][j] == 1 ? help[i][j - 1] + 1 : 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 以第i行第j列（0-based）个格子作为矩形右下角的格子构成的矩形的最大宽度
                 */
                int min = help[i][j];
                /**
                 * k为矩形的顶边索引，最大为i，最小为0
                 */
                for (int k = i; k >= 0; k--) {
                    /**
                     * 矩形的最大宽度为多少，就包含几个相同高度的矩形
                     */
                    min = Math.min(min, help[k][j]);
                    result += min;
                }
            }
        }
        return result;
    }
}
