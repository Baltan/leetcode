package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2682. Find the Losers of the Circular Game
 *
 * @author Baltan
 * @date 2023/5/17 09:14
 */
public class CircularGameLosers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(circularGameLosers(2, 1));
        OutputUtils.print1DIntegerArray(circularGameLosers(5, 2));
        OutputUtils.print1DIntegerArray(circularGameLosers(4, 4));
    }

    public static int[] circularGameLosers(int n, int k) {
        /**
         * isVisited[i]表示第i+1个朋友是否接到过球
         */
        boolean[] isVisited = new boolean[n];
        /**
         * 已接到过球的人数
         */
        int count = 0;
        /**
         * 轮数
         */
        int round = 1;
        /**
         * 当前将要接球的朋友的索引
         */
        int player = 0;

        while (!isVisited[player]) {
            isVisited[player] = true;
            count++;
            /**
             * 下一个将要接球的朋友的索引
             */
            player = (player + round++ * k) % n;
        }
        int[] result = new int[n - count];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                result[index++] = i + 1;
            }
        }
        return result;
    }
}
