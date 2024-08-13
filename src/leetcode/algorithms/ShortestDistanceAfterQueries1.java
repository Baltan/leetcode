package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3244. Shortest Distance After Road Addition Queries II
 *
 * @author baltan
 * @date 2024/8/12 09:42
 * @see ShortestDistanceAfterQueries
 */
public class ShortestDistanceAfterQueries1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(12, new int[][]{{4, 7}, {8, 10}, {0, 7}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{2, 4}, {0, 2}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{1, 3}, {3, 5}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/solutions/2868558/qu-jian-bing-cha-ji-pythonjavacgo-by-end-a9k7/"></a>
     *
     * @param n
     * @param queries
     * @return
     */
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        /**
         * next[i]表示节点i一步可以到达右边最近的节点，初始时，next[i]都为i+1。当节点i被其余最短路跳过时，令next[i]为0
         */
        int[] next = new int[n - 1];
        /**
         * 剩余边数
         */
        int count = n - 1;

        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            /**
             * 标记路径跳过的节点(from,to)，由于(from,next[from])可能已被之前查询的路径标记过，所以可以只标记[next[from],to)
             */
            if (next[from] > 0 && next[from] < to) {
                for (int j = next[from]; j < to; ) {
                    int temp = next[j];
                    next[j] = 0;
                    j = temp;
                    count--;
                }
                next[from] = to;
            }
            result[i] = count;
        }
        return result;
    }
}
