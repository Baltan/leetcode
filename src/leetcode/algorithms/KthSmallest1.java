package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 378. Kth Smallest Element in a Sorted Matrix
 *
 * @author Baltan
 * @date 2019-06-30 11:21
 */
public class KthSmallest1 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix1, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                queue.offer(matrix[i][j]);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }
}
