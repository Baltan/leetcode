package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1536. Minimum Swaps to Arrange a Binary Grid
 *
 * @author Baltan
 * @date 2020-08-08 22:54
 */
public class MinSwaps {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        System.out.println(minSwaps(grid1));

        int[][] grid2 = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}};
        System.out.println(minSwaps(grid2));

        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        System.out.println(minSwaps(grid3));

        int[][] grid4 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        System.out.println(minSwaps(grid4));

        int[][] grid5 = {{0, 0}, {0, 1}};
        System.out.println(minSwaps(grid5));
    }

    public static int minSwaps(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        /**
         * list[i]为初始状态下第i行尾部连续"0"的个数
         */
        List<Integer> list = new ArrayList<>(rows);

        for (int i = 0; i < rows; i++) {
            int[] row = grid[i];
            /**
             * 该行尾部连续"0"的个数
             */
            int count = 0;
            /**
             * 该行尾部连续"0"的个数进行计数
             */
            for (int j = rows - 1; j >= 0; j--) {
                if (row[j] == 0) {
                    count++;
                }
                /**
                 * 如果尾部出现了"1"或者已经遍历完了该行所有数字，记录下该行尾部连续"0"的个数
                 */
                if (row[j] == 1 || j == 0) {
                    list.add(count);
                    break;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            /**
             * 是否找到符合条件的行。对于第i行，尾部至少要有rows-1-i个连续的"0"
             */
            boolean flag = false;

            for (int j = i; j < rows; j++) {
                /**
                 * 从第i行开始向后查找，直到找到第一个尾部至少有rows-1-i个连续的"0"的行，将其上移到第i行的位置
                 */
                if (list.get(j) >= rows - 1 - i) {
                    result += (j - i);
                    list.remove(j);
                    list.add(i, rows - 1 - i);
                    flag = true;
                    break;
                }
            }
            /**
             * 如果没找到符合条件的行，则无法完成题目要求，直接返回-1
             */
            if (!flag) {
                return -1;
            }
        }
        return result;
    }
}
