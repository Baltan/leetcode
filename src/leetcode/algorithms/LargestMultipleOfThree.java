package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1363. Largest Multiple of Three
 *
 * @author Baltan
 * @date 2020-04-03 22:52
 */
public class LargestMultipleOfThree {
    public static void main(String[] args) {
        System.out.println(largestMultipleOfThree(new int[]{8, 1, 9}));
        System.out.println(largestMultipleOfThree(new int[]{8, 6, 7, 1, 0}));
        System.out.println(largestMultipleOfThree(new int[]{1}));
        System.out.println(largestMultipleOfThree(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(largestMultipleOfThree(new int[]{2, 2, 1, 1, 1}));
    }

    public static String largestMultipleOfThree(int[] digits) {
        StringBuilder builder = new StringBuilder();
        /**
         * queues[i]保存digits中所有除以3余数为i的值，并且队列中的值按降序排列
         */
        Queue<Integer>[] queues = new Queue[3];

        for (int i = 0; i < 3; i++) {
            queues[i] = new PriorityQueue<>((x, y) -> y - x);
        }

        for (int digit : digits) {
            if (digit == 0 || digit == 3 || digit == 6 || digit == 9) {
                queues[0].offer(digit);
            } else if (digit == 1 || digit == 4 || digit == 7) {
                queues[1].offer(digit);
            } else {
                queues[2].offer(digit);
            }
        }

        if (queues[1].isEmpty() && queues[2].isEmpty()) {
            /**
             * 如果三个队列中都没有元素，返回""
             */
            if (queues[0].isEmpty()) {
                return "";
                /**
                 * 如果只有queues[0]中有元素，并且只有0，说明digits中所有数字都为0，返回"0"
                 */
            } else if (queues[0].peek() == 0) {
                return "0";
            }
        }
        /**
         * 3的倍数字符串中除以3余0的数字的最大个数，显然digits中所有3的倍数都能出现在字符串中
         */
        int count0 = queues[0].size();
        /**
         * 3的倍数字符串中除以3余1的数字的最大个数
         */
        int count1 = queues[1].size();
        /**
         * 3的倍数字符串中除以3余2的数字的最大个数
         */
        int count2 = queues[2].size();
        /**
         * digits中所有不是3的倍数的数字的和除以3的余数
         */
        int remainder = (queues[1].size() + queues[2].size() * 2) % 3;
        /**
         * 当remainder不为0时，需要删除digits中的一些数字使得剩余数字的和为3的倍数才能保证拼接
         * 得到的字符串数字为3的倍数，并且删除的数字越少，最后拼接得到的3的倍数字符串值越大
         */
        if (remainder == 1) {
            /**
             * 当remainder为1时，先考虑删除digits中一个除以3余1的数，如果不行就删除两个除以3余
             * 2的数
             */
            if (!queues[1].isEmpty()) {
                count1--;
            } else {
                count2 -= 2;
            }
        } else if (remainder == 2) {
            /**
             * 当remainder为2时，先考虑删除digits中一个除以3余2的数，如果不行就删除两个除以3余
             * 1的数
             */
            if (!queues[2].isEmpty()) {
                count2--;
            } else {
                count1 -= 2;
            }
        }
        /**
         * 将三个队列当前头部最大的数字拼接到builder中组成一个3的倍数字符串
         */
        while (count0 > 0 || count1 > 0 || count2 > 0) {
            /**
             * 三个队列当前头部的最大值
             */
            int max = -1;
            /**
             * 头部最大值所在队列的索引
             */
            int queueIndex = -1;

            if (count0 > 0 && !queues[0].isEmpty() && queues[0].peek() > max) {
                max = queues[0].peek();
                queueIndex = 0;
            }

            if (count1 > 0 && !queues[1].isEmpty() && queues[1].peek() > max) {
                max = queues[1].peek();
                queueIndex = 1;
            }

            if (count2 > 0 && !queues[2].isEmpty() && queues[2].peek() > max) {
                max = queues[2].peek();
                queueIndex = 2;
            }
            /**
             * 将最大值拼接到builder中
             */
            builder.append(max);
            /**
             * 将最大值出队
             */
            queues[queueIndex].poll();

            if (queueIndex == 0) {
                count0--;
            } else if (queueIndex == 1) {
                count1--;
            } else {
                count2--;
            }
        }
        return builder.toString();
    }
}
