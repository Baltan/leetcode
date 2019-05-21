package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 232. Implement Queue using Stacks
 *
 * @author Baltan
 * @date 2018/1/6 20:16
 */
public class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue.
     *
     * @return
     */
    public int pop() {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int num = tempStack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return num;
    }

    /**
     * Get the front element.
     *
     * @return
     */
    public int peek() {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int num = tempStack.peek();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return num;
    }

    /**
     * Return whether the queue is empty.
     *
     * @return
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(3);
        obj.push(5);
        obj.push(7);
        obj.push(9);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
