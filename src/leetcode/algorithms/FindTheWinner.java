package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1823. Find the Winner of the Circular Game
 *
 * @author Baltan
 * @date 2022/6/19 15:06
 */
public class FindTheWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
        System.out.println(findTheWinner(500, 500));
    }

    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 将n个人依次入队
         */
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        /**
         * 每数k个人就将第k个人移出队伍，其余的依次从队首移到队尾，直到队伍中只剩最后一人为止
         */
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}
