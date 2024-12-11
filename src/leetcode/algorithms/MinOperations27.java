package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3377. Digit Operations to Make Two Integers Equal
 *
 * @author Baltan
 * @date 2024/12/11 22:46
 */
public class MinOperations27 {
    public static void main(String[] args) {
        System.out.println(minOperations(1, 1));
        System.out.println(minOperations(10, 12));
        System.out.println(minOperations(4, 8));
        System.out.println(minOperations(6, 2));
    }

    public static int minOperations(int n, int m) {
        /**
         * 因为n在变换为m的整个过程中都不能为质数，所以如果一开始n或m为质数，则无法完成变换
         */
        if (isPrime(n) || isPrime(m)) {
            return -1;
        }

        if (n == m) {
            return n;
        }
        int result = Integer.MAX_VALUE;
        /**
         * costs[i]表示将n变换为i的最小代价
         */
        int[] costs = new int[10000];
        /**
         * inQueue[i]表示将n变换为i的情况当前是否还在队列中未计算，避免n的中间变量重复入队
         */
        boolean[] inQueue = new boolean[10000];
        /**
         * 将队列中的所有元素根据将n变换为该元素的最小代价升序排列
         */
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> costs[x]));
        Arrays.fill(costs, Integer.MAX_VALUE / 2);
        pq.offer(n);
        costs[n] = n;
        inQueue[n] = true;

        while (!pq.isEmpty()) {
            n = pq.poll();
            inQueue[n] = false;
            int temp = n;
            int weight = 1;
            /**
             * 完成变换，更新将n变换为m的最小代价
             */
            if (n == m) {
                result = Math.min(result, costs[n]);
                continue;
            }

            while (temp != 0) {
                /**
                 * n在该数位上的数字
                 */
                int digit = temp % 10;
                /**
                 * 将n在该数位上的数字增加1
                 */
                if (digit != 9) {
                    int nextN = n + weight;
                    /**
                     * n变换为nextN的代价比之前的情况更优
                     */
                    if (!isPrime(nextN) && costs[n] + nextN < costs[nextN]) {
                        costs[nextN] = costs[n] + nextN;
                        /**
                         * 如果将n变换为nextN的情况还在队列中未计算，不需要将nextN重复入队
                         */
                        if (!inQueue[nextN]) {
                            pq.offer(nextN);
                            inQueue[nextN] = true;
                        }
                    }
                }
                /**
                 * 将n在该数位上的数字减少1
                 */
                if (digit != 0) {
                    int nextN = n - weight;
                    /**
                     * n变换为nextN的代价比之前的情况更优
                     */
                    if (!isPrime(nextN) && costs[n] + nextN < costs[nextN]) {
                        costs[nextN] = costs[n] + nextN;
                        /**
                         * 如果将n变换为nextN的情况还在队列中未计算，不需要将nextN重复入队
                         */
                        if (!inQueue[nextN]) {
                            pq.offer(nextN);
                            inQueue[nextN] = true;
                        }
                    }
                }
                temp /= 10;
                weight *= 10;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        /**
         * 1不是质数
         */
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
