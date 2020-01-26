package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1329. Sort the Matrix Diagonally
 *
 * @author Baltan
 * @date 2020-01-26 13:09
 */
public class DiagonalSort {
    public static void main(String[] args) {
        int[][] mat1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        OutputUtils.print2DIntegerArray(diagonalSort(mat1));

        int[][] mat2 = {{1}};
        OutputUtils.print2DIntegerArray(diagonalSort(mat2));

        int[][] mat3 = {{5, 4, 3, 2, 1}};
        OutputUtils.print2DIntegerArray(diagonalSort(mat3));

        int[][] mat4 = {{5, 4}, {1, 3}, {6, 7}, {3, 2}};
        OutputUtils.print2DIntegerArray(diagonalSort(mat4));
    }

    public static int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * 从左向右逐一处理每一条对角线，对于最左边的rows条对角线而言，左数第i条对角线的起点为
         * mat[rows-i][0]，例如第1条对角线起点为mat[rows-1][0]，以此类推，第rows条对角线起
         * 点为mat[0][0]。对角线向右下方延伸，终点为对角线到达最右列或者最下行的长度的较小值
         */
        for (int i = rows - 1; i >= 0; i--) {
            /**
             * 对角线的长度为从起点开始向右下方延伸，到达最右列或者最下行的长度的较小值
             */
            int arrayLength = Math.min(cols, rows - i);
            int[] array = new int[arrayLength];
            int index = 0;
            /**
             * 对角线上当前元素在mat中的行索引
             */
            int rowIndex = i;
            /**
             * 对角线上当前元素在mat中的列索引
             */
            int colIndex = 0;
            /**
             * 将对角线上的所有元素加入到数组array中
             */
            while (index < arrayLength) {
                array[index] = mat[rowIndex][colIndex];
                rowIndex++;
                colIndex++;
                index++;
            }

            Arrays.sort(array);
            /**
             * 对角线起点在mat中的行索引
             */
            rowIndex = i;
            /**
             * 对角线起点在mat中的列索引
             */
            colIndex = 0;
            /**
             * 将排序后的对角线元素从对角线起点开始依次从左上向右下放回对应位置
             */
            for (int j = 0; j < arrayLength; j++) {
                mat[rowIndex][colIndex] = array[j];
                rowIndex++;
                colIndex++;
            }
        }
        /**
         * 从左向右逐一处理从第rows+1条开始的每一条对角线，对于所有对角线而言，左数第i条对角线
         * 的起点为mat[0][i]，例如第1条对角线起点为mat[0][1]，以此类推，最后一条对角线起点为
         * mat[0][cols-1]。对角线向右下方延伸，终点为对角线到达最右列或者最下行的长度的较小值
         */
        for (int i = 1; i < cols; i++) {
            /**
             * 对角线的长度为从起点开始向右下方延伸，到达最右列或者最下行的长度的较小值
             */
            int arrayLength = Math.min(rows, cols - i);
            int[] array = new int[arrayLength];
            int index = 0;
            /**
             * 对角线上当前元素在mat中的行索引
             */
            int rowIndex = 0;
            /**
             * 对角线起点在mat中的列索引
             */
            int colIndex = i;
            /**
             * 将对角线上的所有元素加入到数组array中
             */
            while (index < arrayLength) {
                array[index] = mat[rowIndex][colIndex];
                rowIndex++;
                colIndex++;
                index++;
            }

            Arrays.sort(array);
            /**
             * 对角线起点在mat中的行索引
             */
            rowIndex = 0;
            /**
             * 对角线起点在mat中的列索引
             */
            colIndex = i;
            /**
             * 将排序后的对角线元素从对角线起点开始依次从左上向右下放回对应位置
             */
            for (int j = 0; j < arrayLength; j++) {
                mat[rowIndex][colIndex] = array[j];
                rowIndex++;
                colIndex++;
            }
        }
        return mat;
    }
}
