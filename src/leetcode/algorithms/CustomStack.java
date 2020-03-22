package leetcode.algorithms;

/**
 * Description: 1381. Design a Stack With Increment Operation
 *
 * @author Baltan
 * @date 2020-03-22 00:51
 */
public class CustomStack {
    /**
     * 保存栈中元素的容器
     */
    private int[] container;
    /**
     * 栈中当前元素的数量
     */
    private int size;

    public CustomStack(int maxSize) {
        this.size = 0;
        this.container = new int[maxSize];
    }

    public void push(int x) {
        if (size < container.length) {
            container[size++] = x;
        }
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        int value = container[size - 1];
        size--;
        return value;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < size; i++) {
            container[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack1 = new CustomStack(3);
        customStack1.push(1);
        customStack1.push(2);
        System.out.println(customStack1.pop());
        customStack1.push(2);
        customStack1.push(3);
        customStack1.push(4);
        customStack1.increment(5, 100);
        customStack1.increment(2, 100);
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());
    }
}
