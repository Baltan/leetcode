package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1380. Lucky Numbers in a Matrix
 *
 * @author Baltan
 * @date 2023/2/21 09:13
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
        System.out.println(luckyNumbers(new int[][]{{7, 8}, {1, 2}}));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int cols = matrix[0].length;

        outer:
        for (int[] row : matrix) {
            /**
             * 当前行最小值的列索引
             */
            int index = -1;
            /**
             * 当前行的最小值
             */
            int rowMin = Integer.MAX_VALUE;

            for (int i = 0; i < cols; i++) {
                if (row[i] < rowMin) {
                    rowMin = row[i];
                    index = i;
                }
            }
            /**
             * 判断rowMin是否是所在列的最大值
             */
            for (int[] row1 : matrix) {
                /**
                 * 说明rowMin不是所在列的最大值
                 */
                if (row1[index] > rowMin) {
                    continue outer;
                }
            }
            result.add(rowMin);
        }
        return result;
    }
}
