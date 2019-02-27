package leetcode.algorithms;

import java.util.Stack;

/**
 * Description:Min Stack
 *
 * @author Baltan
 * @date 2018/1/8 15:40
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public MinStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    /**
     * Push element x onto stack.
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (tempStack.isEmpty()) {
            tempStack.push(x);
        } else {
            if (x <= tempStack.peek()) {
                tempStack.push(x);
            }
        }
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
        int removeNum = stack.pop();
        if (removeNum == tempStack.peek()) {
            tempStack.pop();
        }
    }

    /**
     * Get the top element.
     *
     * @return
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Retrieve the minimum element in the stack.
     *
     * @return
     */
    public int getMin() {
        return tempStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        System.out.println("*****************************************");
        MinStack minStack1 = new MinStack();
        minStack1.push(2147483646);
        minStack1.push(2147483646);
        minStack1.push(2147483647);
        System.out.println(minStack1.top());
        minStack1.pop();
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.getMin());
        minStack1.pop();
        minStack1.push(2147483647);
        System.out.println(minStack1.top());
        System.out.println(minStack1.getMin());
        minStack1.push(-2147483648);
        System.out.println(minStack1.top());
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.getMin());
    }
}
