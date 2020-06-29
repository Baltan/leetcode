package leetcode.interview;

import java.util.Stack;

/**
 * Description: 剑指 Offer 09. 用两个栈实现队列
 *
 * @author Baltan
 * @date 2020-06-30 07:34
 * @see MyQueue
 * @see leetcode.algorithms.MyQueue
 */
public class CQueue {
    /**
     * 保存所有队列中的元素，栈顶总是最后加入队列的元素
     */
    private Stack<Integer> stack;
    /**
     * 将stack中所有元素逆序保存
     */
    private Stack<Integer> otherStack;

    public CQueue() {
        stack = new Stack<>();
        otherStack = new Stack<>();
    }

    public void appendTail(int value) {
        /**
         * 栈顶总是最后加入队列的元素
         */
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty() && otherStack.isEmpty()) {
            return -1;
        }

        if (!otherStack.isEmpty()) {
            return otherStack.pop();
        } else {
            /**
             * 将stack中所有元素逆序保存到otherStack中，此时最先加入stack中的元素位于otherStack栈顶，弹出otherStack
             * 栈顶元素即可
             */
            while (!stack.isEmpty()) {
                otherStack.push(stack.pop());
            }
            return otherStack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue queue1 = new CQueue();
        queue1.appendTail(3);
        System.out.println(queue1.deleteHead());
        System.out.println(queue1.deleteHead());

        System.out.println("---------------------");

        CQueue queue2 = new CQueue();
        System.out.println(queue2.deleteHead());
        queue2.appendTail(5);
        queue2.appendTail(2);
        System.out.println(queue2.deleteHead());
        System.out.println(queue2.deleteHead());
    }
}
