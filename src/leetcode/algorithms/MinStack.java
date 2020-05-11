package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 155. Min Stack
 *
 * @author Baltan
 * @date 2018/1/8 15:40
 * @see leetcode.interview.MinStack
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
        /**
         * 只有在单调栈minStack中没有元素或者当前元素不大于单调栈栈顶元素时，才将该元素存入单调栈中，因为当
         * 栈stack中还有更大的元素时，检索栈中的最小元素永远得到的是当前单调栈栈顶的元素，直到该元素也出栈
         */
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
        int removeNum = stack.pop();
        /**
         * 如果栈stack出栈的元素就是单调栈minStack栈顶的元素，则单调栈栈顶元素出栈
         */
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
