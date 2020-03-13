package leetcode.interview;

import java.util.Stack;

/**
 * Description: 面试题 03.05. 栈排序
 *
 * @author Baltan
 * @date 2020-03-13 15:22
 */
public class SortedStack {
    /**
     * 保存加入栈中的所有元素
     */
    private Stack<Integer> stack;
    /**
     * 临时栈，当要加入stack的元素大于stack栈顶的元素的时候，就将stack栈顶那些小于该元素的值都先存入
     * otherStack中
     */
    private Stack<Integer> otherStack;

    public SortedStack() {
        this.stack = new Stack<>();
        this.otherStack = new Stack<>();
    }

    public void push(int val) {
        /**
         * 将stack栈顶小于val的元素都先移到otherStack中
         */
        while (!stack.isEmpty() && stack.peek() < val) {
            otherStack.push(stack.pop());
        }
        /**
         * 将otherStack栈顶不小于val的元素都放回stack中
         */
        while (!otherStack.isEmpty() && otherStack.peek() >= val) {
            stack.push(otherStack.pop());
        }
        stack.push(val);
    }

    public void pop() {
        /**
         * 将otherStack中所有元素都放回stack中
         */
        while (!otherStack.isEmpty()) {
            stack.push(otherStack.pop());
        }

        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int peek() {
        /**
         * 将otherStack中所有元素都放回stack中
         */
        while (!otherStack.isEmpty()) {
            stack.push(otherStack.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        /**
         * 当stack和otherStack中都没有元素时，说明排序栈中也没有元素
         */
        return stack.isEmpty() && otherStack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack sortedStack1 = new SortedStack();
        sortedStack1.push(1);
        sortedStack1.push(2);
        System.out.println(sortedStack1.peek());
        sortedStack1.pop();
        sortedStack1.pop();

        System.out.println("--------------------");

        SortedStack sortedStack2 = new SortedStack();
        sortedStack2.pop();
        sortedStack2.pop();
        sortedStack2.push(1);
        sortedStack2.pop();
        System.out.println(sortedStack2.isEmpty());
    }
}
