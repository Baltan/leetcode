package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1337. The K Weakest Rows in a Matrix
 *
 * @author Baltan
 * @date 2020-03-03 09:41
 */
public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        OutputUtils.print1DIntegerArray(kWeakestRows(mat1, 2));

        int[][] mat2 = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        OutputUtils.print1DIntegerArray(kWeakestRows(mat2, 3));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        /**
         * 队列中每个元素为[某一行的1的总数,该行的索引]，队列按照每一行1的总数递增排序，总数
         * 相等的情况下按照索引递增排序
         */
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            int count = 0;
            int col = 0;
            /**
             * 统计该行1的总数
             */
            while (col < cols && mat[i][col] == 1) {
                count++;
                col++;
            }
            queue.offer(new int[]{count, i});
        }
        /**
         * 依次取出队列中的前k个元素
         */
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[1];
        }
        return result;
    }
}
