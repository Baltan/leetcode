package leetcode.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 面试题62. 圆圈中最后剩下的数字
 *
 * @author Baltan
 * @date 2020-03-30 00:22
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
        System.out.println(lastRemaining(70866, 116922));
    }

    public static int lastRemaining(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < m; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
