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
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> tempQueue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int num = 0;
        while (!queue.isEmpty()) {
            num = queue.poll();
            if (!queue.isEmpty()) {
                tempQueue.add(num);
            }
        }
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
        return num;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int num = 0;
        while (!queue.isEmpty()) {
            num = queue.poll();
            tempQueue.add(num);
        }
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
        return num;
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
