package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: Friend Circles
 *
 * @author Baltan
 * @date 2019-05-10 09:44
 */
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] M1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(M1));

        int[][] M2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(findCircleNum(M2));
    }

    public static int findCircleNum(int[][] M) {
        int result = 0;
        int number = M.length;
        boolean[] book = new boolean[number];
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < number; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            int value = list.pollFirst();
            queue.offer(value);
            result++;
            book[value] = true;

            while (!queue.isEmpty()) {
                int studentNo = queue.poll();
                for (int i = 0; i < number; i++) {
                    if (!book[i] && M[studentNo][i] == 1 && studentNo != i) {
                        list.remove(new Integer(i));
                        queue.offer(i);
                        book[i] = true;
                    }
                }
            }
        }
        return result;
    }
}
