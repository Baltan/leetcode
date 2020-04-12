package leetcode.algorithms;

import java.util.LinkedList;

/**
 * Description: 1404. Number of Steps to Reduce a Number in Binary Representation to One
 *
 * @author Baltan
 * @date 2020-04-12 12:34
 */
public class NumSteps {
    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
        System.out.println(numSteps("10"));
        System.out.println(numSteps("1"));
        System.out.println(numSteps("101110111101010110101010111101010101101010101001010101010101111010"));
    }

    public static int numSteps(String s) {
        int result = 0;
        /**
         * 双端队列保存字符串s中的每一个数字0或1
         */
        LinkedList<Integer> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            deque.offerLast(c - '0');
        }

        while (deque.size() > 1) {
            /**
             * 如果队列最后一个元素是0，说明s表示的十进制数是偶数，需要将其除以2，即将s右移一位，将队列最后
             * 一个元素移除即可
             */
            if (deque.peekLast() == 0) {
                deque.pollLast();
                result++;
            } else {
                /**
                 * 队列最后连续的1的个数
                 */
                int oneCount = 0;
                /**
                 * 当队列最后存在连续多个1时，需要将s表示的十进制数加1，即将最后一个0变为1，如果没有0的话，
                 * 就先加入一个1，然后再将最后连续的1都变为0。例如：
                 * 1111 -> 10000
                 * 1001111 -> 1010000
                 * 此时，进行了一次操作。但是操作之后队列最后的一串0又会被除以2的右移操作移除，所以此时可以
                 * 直接加上需要右移操作的次数，不再将最后的一串0加入队列
                 */
                while (!deque.isEmpty() && deque.peekLast() == 1) {
                    deque.pollLast();
                    oneCount++;
                }
                /**
                 * 如果队列最后连续的1前有0，就先将这个0出队，然后再加入一个1
                 */
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                deque.offerLast(1);
                /**
                 * 一次加1操作和oneCount次除以2的操作
                 */
                result += (oneCount + 1);
            }
        }
        return result;
    }
}
