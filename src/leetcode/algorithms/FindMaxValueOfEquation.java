package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1499. Max Value of Equation
 *
 * @author Baltan
 * @date 2020-07-04 12:57
 */
public class FindMaxValueOfEquation {
    public static void main(String[] args) {
        int[][] points1 = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(findMaxValueOfEquation(points1, 1));

        int[][] points2 = {{0, 0}, {3, 0}, {9, 2}};
        System.out.println(findMaxValueOfEquation(points2, 3));

        int[][] points3 = {{-17, 5}, {-10, -8}, {-5, -13}, {-2, 7}, {8, -14}};
        System.out.println(findMaxValueOfEquation(points3, 4));

        int[][] points4 =
                {{-19, -12}, {-13, -18}, {-12, 18}, {-11, -8}, {-8, 2}, {-7, 12}, {-5, 16}, {-3, 9}, {1, -7},
                        {5, -4}, {6, -20}, {10, 4}, {16, 4}, {19, -9}, {20, 19}};
        System.out.println(findMaxValueOfEquation(points4, 6));
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        /**
         * 题目要求yi+yj+|xi-xj|的最大值，因为xi总是小于xj，所以也就是求yi+yj+xj-xi=xj+yj+(yi-xi)的最大值。逐一判断
         * 每个点，只要找到该点之前横坐标和该点相差不超过k的点中y-x值最大的点即可
         */
        int result = Integer.MIN_VALUE;
        int length = points.length;
        /**
         * deque保存每个点的索引值，并且每个点对应的y-x的值是递减的，即队首的点的y-x值最大
         */
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);

        for (int i = 1; i < length; i++) {
            /**
             * 队列前面的点都是points中最前面的点，可能和当前points[i]的横坐标相差超过k，需要将这部分点先出队
             */
            while (!deque.isEmpty() && points[i][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            /**
             * 如果队列中还有元素，则队首索引对应的点就是points[i]之前横坐标和points[i]相差不超过k的点中y-x值最大的点
             */
            if (!deque.isEmpty()) {
                int index = deque.peekFirst();
                result = Math.max(result, points[i][0] + points[i][1] + points[index][1] - points[index][0]);
            }
            /**
             * 计算points[i]的y-x的值，将deque队尾的点计算得到y-x值小于points[i]的点都出队，然后再将i入队，保证deque
             * 中每个点对应的y-x的值是递减的
             */
            while (!deque.isEmpty() &&
                    points[deque.peekLast()][1] - points[deque.peekLast()][0] < points[i][1] - points[i][0]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return result;
    }
}
