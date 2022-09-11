package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1670. Design Front Middle Back Queue
 *
 * @author Baltan
 * @date 2022/9/6 09:12
 */
public class FrontMiddleBackQueue {
    private Deque<Integer> head;
    private Deque<Integer> tail;

    public FrontMiddleBackQueue() {
        head = new ArrayDeque<>();
        tail = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        head.offerFirst(val);
        keepBalance();
    }

    public void pushMiddle(int val) {
        if (head.size() < tail.size()) {
            head.offerLast(val);
        } else {
            tail.offerFirst(val);
        }
        keepBalance();
    }

    public void pushBack(int val) {
        tail.offerLast(val);
        keepBalance();
    }

    public int popFront() {
        if (head.isEmpty() && tail.isEmpty()) {
            return -1;
        }
        int val = head.isEmpty() ? tail.pollFirst() : head.pollFirst();
        keepBalance();
        return val;
    }

    public int popMiddle() {
        if (head.isEmpty() && tail.isEmpty()) {
            return -1;
        }
        /**
         * 如果head的长度和tail的长度相等，则中间的元素即为head最后一个元素；如果head的长度比tail的长度小1，则中间的元素即为
         * tail第一个元素
         */
        int val = head.size() == tail.size() ? head.pollLast() : tail.pollFirst();
        keepBalance();
        return val;
    }

    public int popBack() {
        if (tail.isEmpty()) {
            return -1;
        }
        int val = tail.pollLast();
        keepBalance();
        return val;
    }

    /**
     * 始终保持head的长度和tail的长度相等，或者head的长度比tail的长度小1
     */
    private void keepBalance() {
        while (head.size() > tail.size()) {
            tail.offerFirst(head.pollLast());
        }

        while (tail.size() - head.size() > 1) {
            head.offerLast(tail.pollFirst());
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue1 = new FrontMiddleBackQueue();
        frontMiddleBackQueue1.pushFront(1);
        frontMiddleBackQueue1.pushBack(2);
        frontMiddleBackQueue1.pushMiddle(3);
        frontMiddleBackQueue1.pushMiddle(4);
        System.out.println(frontMiddleBackQueue1.popFront());
        System.out.println(frontMiddleBackQueue1.popMiddle());
        System.out.println(frontMiddleBackQueue1.popMiddle());
        System.out.println(frontMiddleBackQueue1.popBack());
        System.out.println(frontMiddleBackQueue1.popFront());

        System.out.println("--------------------------");

        FrontMiddleBackQueue frontMiddleBackQueue2 = new FrontMiddleBackQueue();
        frontMiddleBackQueue2.pushMiddle(1);
        frontMiddleBackQueue2.pushMiddle(2);
        frontMiddleBackQueue2.pushMiddle(3);
        System.out.println(frontMiddleBackQueue2.popMiddle());
        System.out.println(frontMiddleBackQueue2.popMiddle());
        System.out.println(frontMiddleBackQueue2.popMiddle());
    }
}
