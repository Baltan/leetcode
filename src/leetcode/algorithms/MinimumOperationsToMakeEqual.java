package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 2998. Minimum Number of Operations to Make X and Y Equal
 *
 * @author baltan
 * @date 2024/1/8 12:58
 */
public class MinimumOperationsToMakeEqual {
    public static void main(String[] args) {
        System.out.println(minimumOperationsToMakeEqual(1, 20));
        System.out.println(minimumOperationsToMakeEqual(26, 1));
        System.out.println(minimumOperationsToMakeEqual(54, 2));
        System.out.println(minimumOperationsToMakeEqual(25, 30));
    }

    public static int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) {
            return 0;
        }
        int result = 0;
        /**
         * 保存已得到过的数字
         */
        Set<Integer> isVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        isVisited.add(x);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            /**
             * 对当前队列中已有的数字分别尝试四种操作，直到得到y为止
             */
            for (int i = 0; i < size; i++) {
                x = queue.poll();

                if (x % 11 == 0) {
                    int num1 = x / 11;

                    if (num1 == y) {
                        return result;
                    }

                    if (!isVisited.contains(num1)) {
                        queue.offer(num1);
                        isVisited.add(num1);
                    }
                }

                if (x % 5 == 0) {
                    int num2 = x / 5;

                    if (num2 == y) {
                        return result;
                    }

                    if (!isVisited.contains(num2)) {
                        queue.offer(num2);
                        isVisited.add(num2);
                    }
                }
                int num3 = x - 1;

                if (num3 == y) {
                    return result;
                }

                if (!isVisited.contains(num3)) {
                    queue.offer(num3);
                    isVisited.add(num3);
                }
                int num4 = x + 1;

                if (num4 == y) {
                    return result;
                }

                if (!isVisited.contains(num4)) {
                    queue.offer(num4);
                    isVisited.add(num4);
                }
            }
        }
        return result;
    }
}
