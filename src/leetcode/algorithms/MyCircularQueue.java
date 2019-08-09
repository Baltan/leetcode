package leetcode.algorithms;

/**
 * Description: 622. Design Circular Queue
 *
 * @author Baltan
 * @date 2019-08-09 09:14
 */
public class MyCircularQueue {
    private int[] array;
    private int count;
    private int head;
    private int tail;
    private int length;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        array = new int[k];
        /**
         * 环形队列中元素的个数
         */
        count = 0;
        /**
         * 队列中头部元素的索引位置
         */
        head = 0;
        /**
         * 队列中尾部元素的索引位置
         */
        tail = -1;
        /**
         * 队列的最大长度
         */
        length = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (count < length) {
            /**
             * 如果当前尾部索引位于数组最后了，需要在数组头部插入下一个元素，否则继续在数组下一个位置插入元素
             */
            if (tail < length - 1) {
                tail++;
            } else {
                tail = 0;
            }
            array[tail] = value;
            count++;
            return true;
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (count > 0) {
            /**
             * 如果当前头部索引位于数组最后了，删除该头部元素后，头部索引应当指向数组第0个位置，否则指向数组下一个位置
             */
            head = head + 1 == length ? 0 : head + 1;
            count--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (count > 0) {
            /**
             * 返回头部索引指向的元素
             */
            return array[head];
        }
        return -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (count > 0) {
            /**
             * 返回尾部索引指向的元素
             */
            return array[tail];
        }
        return -1;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == array.length;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue1 = new MyCircularQueue(3);
        System.out.println(circularQueue1.enQueue(1));
        System.out.println(circularQueue1.enQueue(2));
        System.out.println(circularQueue1.enQueue(3));
        System.out.println(circularQueue1.enQueue(4));
        System.out.println(circularQueue1.Rear());
        System.out.println(circularQueue1.isFull());
        System.out.println(circularQueue1.deQueue());
        System.out.println(circularQueue1.enQueue(4));
        System.out.println(circularQueue1.Rear());

        System.out.println("----------------------");

        MyCircularQueue circularQueue2 = new MyCircularQueue(8);
        System.out.println(circularQueue2.enQueue(3));
        System.out.println(circularQueue2.enQueue(9));
        System.out.println(circularQueue2.enQueue(5));
        System.out.println(circularQueue2.enQueue(0));
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.deQueue());
        System.out.println(circularQueue2.isEmpty());
        System.out.println(circularQueue2.isEmpty());
        System.out.println(circularQueue2.Rear());
        System.out.println(circularQueue2.Rear());
        System.out.println(circularQueue2.deQueue());

        System.out.println("----------------------");

        MyCircularQueue circularQueue3 = new MyCircularQueue(3);
        System.out.println(circularQueue3.enQueue(2));
        System.out.println(circularQueue3.Rear());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.deQueue());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.deQueue());
        System.out.println(circularQueue3.Front());
        System.out.println(circularQueue3.enQueue(4));
        System.out.println(circularQueue3.enQueue(2));
        System.out.println(circularQueue3.enQueue(2));
        System.out.println(circularQueue3.enQueue(3));
    }
}
