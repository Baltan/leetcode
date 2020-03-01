package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 225. Implement Stack using Queues
 *
 * @author Baltan
 * @date 2018/1/7 10:34
 */
public class MyStack {
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = queue.size();

        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int size = queue.size();

        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }

        int value = queue.poll();
        queue.offer(value);
        return value;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(3);
        obj.push(5);
        obj.push(7);
        obj.push(9);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
