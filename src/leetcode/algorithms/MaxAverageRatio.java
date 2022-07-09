package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1792. Maximum Average Pass Ratio
 *
 * @author Baltan
 * @date 2022/7/4 09:40
 */
public class MaxAverageRatio {
    public static void main(String[] args) {
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.println(maxAverageRatio(classes1, extraStudents1));

        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents2 = 4;
        System.out.println(maxAverageRatio(classes2, extraStudents2));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double result = 0d;
        /**
         * 假设每个班级增加一个聪明的学生后，按照能够提升的通过率倒序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> {
            double diff = (1.0 * (y[0] + 1) / (y[1] + 1) - 1.0 * y[0] / y[1]) -
                    (1.0 * (x[0] + 1) / (x[1] + 1) - 1.0 * x[0] / x[1]);
            return diff > 0 ? 1 : -1;
        });

        for (int[] clazz : classes) {
            pq.offer(clazz);
        }
        /**
         * 每次都选择能够带来最大通过率提升的班级来增加一个聪明的学生
         */
        while (extraStudents-- > 0) {
            int[] clazz = pq.poll();
            clazz[0]++;
            clazz[1]++;
            pq.offer(clazz);
        }

        for (int[] clazz : pq) {
            result += 1.0 * clazz[0] / clazz[1];
        }
        return result / classes.length;
    }
}
