package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2352. Equal Row and Column Pairs
 *
 * @author Baltan
 * @date 2023/1/15 16:05
 */
public class EqualPairs {
    public static void main(String[] args) {
        int[][] grid1 = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(equalPairs(grid1));

        int[][] grid2 = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(equalPairs(grid2));
    }

    public static int equalPairs(int[][] grid) {
        int result = 0;
        /**
         * 每一行的数组转化成的字符串key -> 满足条件的行数
         */
        Map<String, Integer> map = new HashMap<>();
        int length = grid.length;

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        /**
         * 第i列
         */
        for (int i = 0; i < length; i++) {
            int[] col = new int[length];
            /**
             * 第i行
             */
            for (int j = 0; j < length; j++) {
                col[j] = grid[j][i];
            }
            /**
             * 每一列的数组转化成的字符串key
             */
            String key = Arrays.toString(col);
            result += map.getOrDefault(key, 0);
        }
        return result;
    }
}
