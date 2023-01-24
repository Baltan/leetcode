package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2545. Sort the Students by Their Kth Score
 *
 * @author Baltan
 * @date 2023/1/23 21:47
 */
public class SortTheStudents {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(sortTheStudents(new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2));
        System.out.println("------------------------------------------------------");
        OutputUtils.print2DIntegerArray(sortTheStudents(new int[][]{{3, 4}, {5, 6}}, 0));
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        /**
         * 根据矩阵的第k列降序排列
         */
        Arrays.sort(score, (x, y) -> y[k] - x[k]);
        return score;
    }
}
