package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 2280. Minimum Lines to Represent a Line Chart
 *
 * @author Baltan
 * @date 2023/1/22 15:54
 */
public class MinimumLines {
    public static void main(String[] args) {
        System.out.println(minimumLines(new int[][]{{72, 98}, {62, 27}, {32, 7}, {71, 4}, {25, 19}, {91, 30}, {52, 73}, {10, 9}, {99, 71}, {47, 22}, {19, 30}, {80, 63}, {18, 15}, {48, 17}, {77, 16}, {46, 27}, {66, 87}, {55, 84}, {65, 38}, {30, 9}, {50, 42}, {100, 60}, {75, 73}, {98, 53}, {22, 80}, {41, 61}, {37, 47}, {95, 8}, {51, 81}, {78, 79}, {57, 95}}));
        System.out.println(minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
        System.out.println(minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
    }

    public static int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        /**
         * 按照日期升序排列
         */
        Arrays.sort(stockPrices, Comparator.comparingInt(x -> x[0]));
        int result = 1;
        /**
         * 最早两天股价连线的斜率为yDiff/xDiff
         */
        int xDiff = stockPrices[1][0] - stockPrices[0][0];
        int yDiff = stockPrices[1][1] - stockPrices[0][1];
        /**
         * 计算每个相邻两天股价连线的斜率currYDiff/currXDiff，和较前的一段连线的斜率yDiff/xDiff作比较，如果斜率相等说明在同一条直线上
         */
        for (int i = 2; i < stockPrices.length; i++) {
            int currXDiff = stockPrices[i][0] - stockPrices[i - 1][0];
            int currYDiff = stockPrices[i][1] - stockPrices[i - 1][1];
            /**
             * 将currYDiff/currXDiff和yDiff/xDiff的等值比较转换为xDiff*currYDiff和yDiff*currXDiff的等值比较，避免浮点运算，同时用
             * 长整形计算，避免整型溢出
             */
            if (1L * xDiff * currYDiff != 1L * yDiff * currXDiff) {
                result++;
                xDiff = currXDiff;
                yDiff = currYDiff;
            }
        }
        return result;
    }
}
