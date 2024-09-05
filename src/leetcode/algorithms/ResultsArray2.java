package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3275. K-th Nearest Obstacle Queries
 *
 * @author baltan
 * @date 2024/9/5 09:09
 */
public class ResultsArray2 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(resultsArray(new int[][]{{1, 2}, {3, 4}, {2, 3}, {-3, 0}}, 2));
        OutputUtils.print1DIntegerArray(resultsArray(new int[][]{{5, 5}, {4, 4}, {3, 3}}, 1));
    }

    public static int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        /**
         * 倒序保存距离原点最近的k个障碍物
         */
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < queries.length; i++) {
            maxHeap.offer(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
            /**
             * 将距离原点第k+1近的障碍物从大顶堆中移除
             */
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            result[i] = maxHeap.size() == k ? maxHeap.peek() : -1;
        }
        return result;
    }
}
