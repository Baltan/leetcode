package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 641. Design Circular Deque
 *
 * @author Baltan
 * @date 2020-02-10 15:39
 */
public class MyCircularDeque {
    /**
     * 保存双端队列中的元素的容器
     */
    private List<Integer> container;
    /**
     * 双端队列中当前元素的数量
     */
    private int count;
    /**
     * 双端队列中元素的最大容量
     */
    private int maxCount;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.container = new ArrayList<>(k);
        this.count = 0;
        this.maxCount = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (count < maxCount) {
            container.add(0, value);
            count++;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (count < maxCount) {
            container.add(value);
            count++;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (count > 0) {
            container.remove(0);
            count--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count > 0) {
            container.remove(count - 1);
            count--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (count > 0) {
            return container.get(0);
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count > 0) {
            return container.get(count - 1);
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == maxCount;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque1 = new MyCircularDeque(3);
        System.out.println(circularDeque1.insertLast(1));
        System.out.println(circularDeque1.insertLast(2));
        System.out.println(circularDeque1.insertFront(3));
        System.out.println(circularDeque1.insertFront(4));
        System.out.println(circularDeque1.getRear());
        System.out.println(circularDeque1.isFull());
        System.out.println(circularDeque1.deleteLast());
        System.out.println(circularDeque1.insertFront(4));
        System.out.println(circularDeque1.getFront());
    }
}
