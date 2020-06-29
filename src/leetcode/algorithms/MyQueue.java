package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 232. Implement Queue using Stacks
 *
 * @author Baltan
 * @date 2018/1/6 20:16
 * @see leetcode.interview.MyQueue
 * @see leetcode.interview.CQueue
 */
public class MyQueue {
    /**
     * 保存所有队列中的元素，栈顶总是最后加入队列的元素
     */
    private Stack<Integer> stack;
    /**
     * 将stack中所有元素逆序保存
     */
    private Stack<Integer> otherStack;

    public MyQueue() {
        stack = new Stack<>();
        otherStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     *
     * @param x
     */
    public void push(int x) {
        /**
         * 将otherStack中所有元素还原到stack中后在栈顶加入新元素
         */
        while (!otherStack.isEmpty()) {
            stack.push(otherStack.pop());
        }
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue.
     *
     * @return
     */
    public int pop() {
        /**
         * 将stack中所有元素逆序保存到otherStack中后弹出otherStack栈顶元素
         */
        while (!stack.isEmpty()) {
            otherStack.push(stack.pop());
        }
        return otherStack.pop();
    }

    /**
     * Get the front element.
     *
     * @return
     */
    public int peek() {
        /**
         * 将stack中所有元素逆序保存到otherStack中后返回otherStack栈顶元素
         */
        while (!stack.isEmpty()) {
            otherStack.push(stack.pop());
        }
        return otherStack.peek();
    }

    /**
     * Return whether the queue is empty.
     *
     * @return
     */
    public boolean empty() {
        /**
         * 当两个栈中都没有元素时，说明队列中也没有元素
         */
        return stack.isEmpty() && otherStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(3);
        obj.push(5);
        obj.push(7);
        obj.push(9);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}
