package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1901. Find a Peak Element II
 *
 * @author Baltan
 * @date 2022/4/23 22:40
 */
public class FindPeakGrid {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 4}, {3, 2}};
        OutputUtils.print1DIntegerArray(findPeakGrid(mat1));

        int[][] mat2 = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        OutputUtils.print1DIntegerArray(findPeakGrid(mat2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-a-peak-element-ii/solution/python3-er-fen-qie-pian-shi-jian-fu-za-d-gmd2/"></a>
     *
     * @param mat
     * @return
     */
    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int lo = 0;
        int hi = cols - 1;
        /**
         * 通过二分法在矩阵中查找极值
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            /**
             * 这一列中的最大值
             */
            int max = Integer.MIN_VALUE;
            /**
             * 这一列中最大值的行索引
             */
            int rowIndex = -1;
            /**
             * 查找这一列中的最大值
             */
            for (int i = 0; i < rows; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    rowIndex = i;
                }
            }
            /**
             * 如果最大值左边存在数字，并且左边的数字大于最大值，则在矩阵当前列的左半部分继续查找极值；如果最大值右边存在数字，
             * 并且右边的数字大于最大值，则在矩阵当前列的有半部分继续查找极值，否则当前最大值就是一个极值
             */
            if (mid != 0 && mat[rowIndex][mid - 1] > mat[rowIndex][mid]) {
                hi = mid - 1;
            } else if (mid != cols - 1 && mat[rowIndex][mid + 1] > mat[rowIndex][mid]) {
                lo = mid + 1;
            } else {
                return new int[]{rowIndex, mid};
            }
        }
        return null;
    }
}
