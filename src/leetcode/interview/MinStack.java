package leetcode.interview;

import java.util.Stack;

/**
 * Description: 面试题 03.02. 栈的最小值
 *
 * @author Baltan
 * @date 2018/1/8 15:40
 * @see leetcode.algorithms.MinStack
 */
public class MinStack {
    /**
     * 保存加入栈中的所有元素
     */
    private Stack<Integer> stack;
    /**
     * 单调栈，栈顶的元素总是栈中最小的
     */
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Push element x onto stack.
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
        int removeNum = stack.pop();

        if (removeNum == minStack.peek()) {
            minStack.pop();
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
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.top());
        System.out.println(minStack1.getMin());

        System.out.println("----------------------");

        MinStack minStack2 = new MinStack();
        minStack2.push(2147483646);
        minStack2.push(2147483646);
        minStack2.push(2147483647);
        System.out.println(minStack2.top());
        minStack2.pop();
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
        minStack2.pop();
        minStack2.push(2147483647);
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());
        minStack2.push(-2147483648);
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
    }
}
