package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1738. Find Kth Largest XOR Coordinate Value
 *
 * @author Baltan
 * @date 2022/7/31 13:32
 */
public class KthLargestValue {
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        /**
         * prefixXORsPerRow[i][j+1]表示matrix[i][0]^matrix[i][1]^……^matrix[i][j]
         */
        int[][] prefixXORsPerRow = new int[m][n + 1];
        /**
         * prefixXORs[i][j+1]表示(matrix[0][0]^matrix[0][1]^……^matrix[0][j])^
         * (matrix[1][0]^matrix[1][1]^……^matrix[1][j])^……^(matrix[i][0]^matrix[i][1]^……^matrix[i][j])
         */
        int[][] prefixXORs = new int[m][n + 1];
        /**
         * 小顶堆，始终只保留prefixXORs中最大的k个数（除队列中的数不足k个以外）
         */
        Queue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixXORsPerRow[i][j + 1] = prefixXORsPerRow[i][j] ^ matrix[i][j];

                if (i > 0) {
                    prefixXORs[i][j + 1] = prefixXORs[i - 1][j + 1] ^ prefixXORsPerRow[i][j + 1];
                } else {
                    prefixXORs[i][j + 1] = prefixXORsPerRow[i][j + 1];
                }
                pq.offer(prefixXORs[i][j + 1]);
                /**
                 * 删除队列中多余的数字，因为第k大的数字一定不在这些数字中
                 */
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
