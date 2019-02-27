package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;

/**
 * Description:Reshape the Matrix
 *
 * @author Baltan
 * @date 2017/11/6 17:16
 */
public class MatrixReshape {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        int[][] newNums = matrixReshape(nums, 3, 6);
        OutputUtils.print2DIntegerArray(newNums);
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int initEleCols = nums[0].length;
        int rows = nums.length;
        int elementNums = rows * initEleCols;
        if (elementNums != r * c) {
            return nums;
        } else if (elementNums == r * c && elementNums % r != 0) {
            return nums;
        } else {
            ArrayList<Integer> numsList = new ArrayList();
            int[][] newNums = new int[r][c];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < initEleCols; j++) {
                    numsList.add(nums[i][j]);
                }
            }
            for (int i = 0; i < r; i++) {
                int[] newEle = new int[c];
                for (int j = 0; j < c; j++) {
                    newEle[j] = numsList.get(c * i + j);
                }
                newNums[i] = newEle;
            }
            return newNums;
        }
    }
}
