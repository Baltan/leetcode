package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1238. Circular Permutation in Binary Representation
 *
 * @author Baltan
 * @date 2020-02-21 17:32
 * @see GrayCode
 * @see CircularPermutation1
 */
public class CircularPermutation {
    public static void main(String[] args) {
        System.out.println(circularPermutation(2, 3));
        System.out.println(circularPermutation(3, 2));
    }

    public static List<Integer> circularPermutation(int n, int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        /**
         * 在二进制数字头部加1换算成十进制加的数字，n=k时，相当于十进制加2**(k-1)
         */
        int head = 1;
        /**
         * 当n=1时，格雷码序列为[0]
         * 当n=k（k>1）时，假设n=k-1时的格雷码序列为Seq(k-1)，将Seq(k-1)的每一个数字头部加一个0得到
         * 序列Seq(k)，再将Seq(k-1)倒序的每一个数字头部加一个1追加在Seq(k)后面即可，例如
         * n  Seq
         * 0   0
         * 1   0     1
         * 2   00    01    11    10
         * 3   000   001   011   010   110   111   101   100
         * 4   0000  0001  0011  0010  0110  0111  0101  0100  1100  1101  1111  1110  1010  1011  1001  1000
         */
        for (int i = 0; i < n; i++) {
            Deque<Integer> otherDeque = new ArrayDeque<>();

            while (!deque.isEmpty()) {
                int value = deque.pollLast();
                otherDeque.addFirst(value);
                otherDeque.addLast(head + value);
            }
            /**
             * 下一轮循环头部加1换算成十进制加的数字要翻倍
             */
            head <<= 1;
            deque = otherDeque;
        }
        /**
         * 将队列deque头部的数字逐一移动尾部，直到头部的数字为start为止
         */
        while (deque.getFirst() != start) {
            deque.addLast(deque.pollFirst());
        }
        return new LinkedList<>(deque);
    }
}
