package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2578. Split With Minimum Sum
 *
 * @author Baltan
 * @date 2023/3/5 17:26
 */
public class SplitNum {
    public static void main(String[] args) {
        System.out.println(splitNum(4325));
        System.out.println(splitNum(687));
    }

    public static int splitNum(int num) {
        int result = 0;
        /**
         * 某个数字在num1或num2中的权重
         */
        int weight = 1;
        /**
         * 某个权重已分配的数字，因为是拆分到num1和num2两个数字中，所以至多可以分配两次
         */
        int count = 0;
        /**
         * 将num所有数位上的数字按照倒序排列
         */
        Queue<Integer> digits = new PriorityQueue<>(Collections.reverseOrder());

        while (num != 0) {
            digits.offer(num % 10);
            num /= 10;
        }
        /**
         * 越大的数字分配越小的权重
         */
        while (!digits.isEmpty()) {
            int digit = digits.poll();
            result += digit * weight;

            if (count == 0) {
                /**
                 * 当前权重weight之前还没分配过数字，还能分配一次
                 */
                count++;
            } else {
                /**
                 * 当前权重weight之前已分配过一次，接下去需要分配的数字权重为weight*10
                 */
                count = 0;
                weight *= 10;
            }
        }
        return result;
    }
}
