package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 2059. Minimum Operations to Convert Number
 *
 * @author Baltan
 * @date 2021/11/17 17:26
 */
public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 3}, 6, 4));
        System.out.println(minimumOperations(new int[]{2, 4, 12}, 2, 12));
        System.out.println(minimumOperations(new int[]{3, 5, 7}, 0, -4));
        System.out.println(minimumOperations(new int[]{2, 8, 16}, 0, 1));
        System.out.println(minimumOperations(new int[]{1}, 0, 3));
    }

    public static int minimumOperations(int[] nums, int start, int goal) {
        int result = 0;
        /**
         * 保存转换中的数字
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 保存转化过程中已经出现过的数字，避免重复处理（重复处理的数字所在的路径必然不在最小操作路径上）
         */
        Set<Integer> isVisited = new HashSet<>();
        queue.offer(start);
        isVisited.add(start);

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int x = queue.poll();

                for (int num : nums) {
                    int y = x;

                    if (y + num == goal) {
                        return result;
                    } else {
                        y += num;
                        /**
                         * 转换后得到的数字未被处理过，且在[1,1000]中，说明可以继续被转换，加入队列
                         */
                        if (0 <= y && 1000 >= y && !isVisited.contains(y)) {
                            queue.offer(y);
                            isVisited.add(y);
                        }
                    }

                    y = x;

                    if (y - num == goal) {
                        return result;
                    } else {
                        y -= num;
                        /**
                         * 转换后得到的数字未被处理过，且在[1,1000]中，说明可以继续被转换，加入队列
                         */
                        if (0 <= y && 1000 >= y && !isVisited.contains(y)) {
                            queue.offer(y);
                            isVisited.add(y);
                        }
                    }

                    y = x;

                    if ((y ^ num) == goal) {
                        return result;
                    } else {
                        y ^= num;
                        /**
                         * 转换后得到的数字未被处理过，且在[1,1000]中，说明可以继续被转换，加入队列
                         */
                        if (0 <= y && 1000 >= y && !isVisited.contains(y)) {
                            queue.offer(y);
                            isVisited.add(y);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
