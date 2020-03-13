package leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 面试题 03.03. 堆盘子
 *
 * @author Baltan
 * @date 2020-03-13 14:32
 */
public class StackOfPlates {
    /**
     * 每个栈的容量
     */
    private int capacity;
    /**
     * 依次保存各个栈
     */
    private List<Stack<Integer>> stackList;

    public StackOfPlates(int cap) {
        this.capacity = cap;
        this.stackList = new ArrayList<>();
    }

    public void push(int val) {
        /**
         * 如果每个栈的容量不大于0，则总是无法加入元素
         */
        if (capacity <= 0) {
            return;
        }

        int size = stackList.size();
        /**
         * 如果当前还没有栈，或者最后一个栈已经满了，就要重新创建一个新栈，在新栈中加入元素，否则就在最后一个
         * 栈中加入元素
         */
        if (size == 0 || stackList.get(size - 1).size() == capacity) {
            Stack<Integer> otherStack = new Stack<>();
            otherStack.push(val);
            stackList.add(otherStack);
        } else {
            stackList.get(size - 1).push(val);
        }
    }

    public int pop() {
        /**
         * 如果没有栈，返回-1
         */
        if (stackList.isEmpty()) {
            return -1;
        }
        /**
         * 从最后一个栈中弹出栈顶的元素
         */
        int size = stackList.size();
        int value = stackList.get(size - 1).pop();
        /**
         * 如果此时最后一个栈中没有元素了，就将这个栈删除
         */
        if (stackList.get(size - 1).isEmpty()) {
            stackList.remove(size - 1);
        }
        return value;
    }

    public int popAt(int index) {
        /**
         * 如果没有栈或者在指定位置上没有栈，返回-1
         */
        if (stackList.isEmpty() || index >= stackList.size()) {
            return -1;
        }
        /**
         * 从指定位置的栈中弹出栈顶的元素
         */
        int value = stackList.get(index).pop();
        /**
         * 如果此时指定位置的栈中没有元素了，就将这个栈删除
         */
        if (stackList.get(index).isEmpty()) {
            stackList.remove(index);
        }
        return value;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates1 = new StackOfPlates(1);
        stackOfPlates1.push(1);
        stackOfPlates1.push(2);
        System.out.println(stackOfPlates1.popAt(1));
        System.out.println(stackOfPlates1.pop());
        System.out.println(stackOfPlates1.pop());

        System.out.println("--------------------");

        StackOfPlates stackOfPlates2 = new StackOfPlates(2);
        stackOfPlates2.push(1);
        stackOfPlates2.push(2);
        stackOfPlates2.push(3);
        System.out.println(stackOfPlates2.popAt(0));
        System.out.println(stackOfPlates2.popAt(0));
        System.out.println(stackOfPlates2.popAt(0));

        System.out.println("--------------------");

        StackOfPlates stackOfPlates3 = new StackOfPlates(0);
        stackOfPlates3.push(2);
        stackOfPlates3.push(8);
        stackOfPlates3.push(56);
        stackOfPlates3.push(1);
        stackOfPlates3.push(39);
        stackOfPlates3.push(40);
        System.out.println(stackOfPlates3.pop());
        System.out.println(stackOfPlates3.pop());
        System.out.println(stackOfPlates3.pop());
        System.out.println(stackOfPlates3.pop());
        System.out.println(stackOfPlates3.pop());
        System.out.println(stackOfPlates3.pop());
    }
}
