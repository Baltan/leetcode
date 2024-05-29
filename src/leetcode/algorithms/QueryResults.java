package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3160. Find the Number of Distinct Colors Among the Balls
 *
 * @author Baltan
 * @date 2024/5/29 22:17
 */
public class QueryResults {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(queryResults(1, new int[][]{{0, 1}, {0, 4}, {0, 4}, {0, 1}, {1, 2}}));
        OutputUtils.print1DIntegerArray(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}}));
        OutputUtils.print1DIntegerArray(queryResults(4, new int[][]{{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}}));
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        /**
         * 球的编号 -> 球的颜色
         */
        Map<Integer, Integer> ballMap = new HashMap<>((int) (queries.length/ 0.75 + 1));
        /**
         * 颜色i -> 本轮涂色后颜色为i的球的个数
         */
        Map<Integer, Integer> colorMap = new HashMap<>((int) (queries.length / 0.75 + 1));

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballMap.containsKey(ball)) {
                /**
                 * 本轮涂色前球的颜色
                 */
                int oldColor = ballMap.get(ball);
                /**
                 * 如果本轮涂色和球之前的颜色不同，则会发生变化
                 */
                if (color != oldColor) {
                    int oldColorCount = colorMap.get(oldColor);
                    ballMap.put(ball, color);
                    colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
                    /**
                     * 更新颜色为oldColor的球的个数
                     */
                    if (oldColorCount == 1) {
                        colorMap.remove(oldColor);
                    } else {
                        colorMap.put(oldColor, oldColorCount - 1);
                    }
                }
            } else {
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            }
            result[i] = colorMap.size();
        }
        return result;
    }
}
