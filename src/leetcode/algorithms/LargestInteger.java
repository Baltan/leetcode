package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2231. Largest Number After Digit Swaps by Parity
 *
 * @author Baltan
 * @date 2022/4/16 13:45
 */
public class LargestInteger {
    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(65875));
    }

    public static int largestInteger(int num) {
        if (num < 10) {
            return num;
        }

        int result = 0;
        /**
         * 从小到大保存num中各数位上的奇数数字
         */
        Queue<Integer> oddPq = new PriorityQueue<>();
        /**
         * 从小到大保存num中各数位上的偶数数字
         */
        Queue<Integer> evenPq = new PriorityQueue<>();
        int value = num;
        int base = 1;
        /**
         * 计算出num中各数位上的奇数数字和偶数数字
         */
        while (value != 0) {
            int remainder = value % 10;

            if (remainder % 2 == 0) {
                evenPq.offer(remainder);
            } else {
                oddPq.offer(remainder);
            }
            value /= 10;
        }
        /**
         * 从低位到高位依次累加num中的奇数数字和偶数数字（从小到大）
         */
        while (num != 0) {
            int remainder = num % 10;

            if (remainder % 2 == 0) {
                result += evenPq.poll() * base;
            } else {
                result += oddPq.poll() * base;
            }
            base *= 10;
            num /= 10;
        }
        return result;
    }
}
