package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Description: 2747. Count Zero Request Servers
 *
 * @author Baltan
 * @date 2023/6/28 23:08
 */
public class CountServers1 {
    public static void main(String[] args) {
        int[][] logs1 = {{1, 3}, {2, 6}, {1, 5}};
        int[] queries1 = {10, 11};
        OutputUtils.print1DIntegerArray(countServers(3, logs1, 5, queries1));

        int[][] logs2 = {{2, 4}, {2, 1}, {1, 2}, {3, 1}};
        int[] queries2 = {3, 4};
        OutputUtils.print1DIntegerArray(countServers(3, logs2, 2, queries2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-zero-request-servers/solutions/2320098/chi-xian-hua-dong-chuang-kou-pythonjavac-b573/"></a>
     *
     * @param n
     * @param logs
     * @param x
     * @param queries
     * @return
     */
    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] result = new int[queries.length];
        /**
         * 将所有服务器请求按照请求时间升序排列
         */
        Arrays.sort(logs, Comparator.comparingInt(log -> log[1]));
        /**
         * 将所有查询的索引按照对应的查询时间升序排列
         */
        Integer[] indexes = IntStream.range(0, queries.length)
                .boxed()
                .sorted(Comparator.comparingInt(index -> queries[index]))
                .toArray(Integer[]::new);
        /**
         * counts[i]表示在某个时间区间[time-x,time]范围内服务器i收到的请求数
         */
        int[] counts = new int[n + 1];
        /**
         * 时间区间起始值
         */
        int lo = 0;
        /**
         * 时间区间终止值
         */
        int hi = 0;
        /**
         * 某个时间区间[time-x,time]范围内未收到请求的服务器数量
         */
        int count = n;

        for (int index : indexes) {
            /**
             * 累加所有请求时间不大于queries[index]的情况
             */
            while (hi < logs.length && logs[hi][1] <= queries[index]) {
                /**
                 * 服务器logs[hi][0]本来在时间区间内收到请求数为0，现在在queries[index]时刻收到了一个请求，所以要将时间区间范围内未收到
                 * 请求的服务器数量减1
                 */
                if (counts[logs[hi][0]]++ == 0) {
                    count--;
                }
                hi++;
            }
            /**
             * 排除所有请求时间小于queries[index]-x的情况
             */
            while (lo < logs.length && logs[lo][1] < queries[index] - x) {
                /**
                 * 服务器logs[lo][0]本来在时间区间之前收到请求数为1，现在logs[lo][1]时刻的请求不计算在时间区间范围内了，因此时间区间内
                 * 未收到请求的服务器数量加1
                 */
                if (counts[logs[lo][0]]-- == 1) {
                    count++;
                }
                lo++;
            }
            result[index] = count;
        }
        return result;
    }
}
