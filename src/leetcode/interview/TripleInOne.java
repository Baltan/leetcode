package leetcode.interview;

/**
 * Description: 面试题 03.01. 三合一
 *
 * @author Baltan
 * @date 2020-03-12 18:08
 */
public class TripleInOne {
    private int[] array;
    private int count1;
    private int count2;
    private int count3;
    private int capacity;

    public TripleInOne(int stackSize) {
        this.array = new int[stackSize * 3];
        /**
         * 第一个栈中元素的个数
         */
        this.count1 = 0;
        /**
         * 第二个栈中元素的个数
         */
        this.count2 = 0;
        /**
         * 第三个栈中元素的个数
         */
        this.count3 = 0;
        /**
         * 每个栈的大小
         */
        this.capacity = stackSize;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0 && count1 < capacity) {
            array[count1] = value;
            count1++;
        } else if (stackNum == 1 && count2 < capacity) {
            array[capacity + count2] = value;
            count2++;
        } else if (stackNum == 2 && count3 < capacity) {
            array[capacity * 2 + count3] = value;
            count3++;
        }
    }

    public int pop(int stackNum) {
        if (stackNum == 0 && count1 > 0) {
            int value = array[count1 - 1];
            count1--;
            return value;
        } else if (stackNum == 1 && count2 > 0) {
            int value = array[capacity + count2 - 1];
            count2--;
            return value;
        } else if (stackNum == 2 && count3 > 0) {
            int value = array[capacity * 2 + count3 - 1];
            count3--;
            return value;
        }
        return -1;
    }

    public int peek(int stackNum) {
        if (stackNum == 0 && count1 > 0) {
            return array[count1 - 1];
        } else if (stackNum == 1 && count2 > 0) {
            return array[capacity + count2 - 1];
        } else if (stackNum == 2 && count3 > 0) {
            return array[capacity * 2 + count3 - 1];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) {
            return count1 == 0;
        } else if (stackNum == 1) {
            return count2 == 0;
        } else {
            return count3 == 0;
        }
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne1 = new TripleInOne(1);
        tripleInOne1.push(0, 1);
        tripleInOne1.push(0, 2);
        System.out.println(tripleInOne1.pop(0));
        System.out.println(tripleInOne1.pop(0));
        System.out.println(tripleInOne1.pop(0));
        System.out.println(tripleInOne1.isEmpty(0));

        System.out.println("---------------------");

        TripleInOne tripleInOne2 = new TripleInOne(2);
        tripleInOne2.push(0, 1);
        tripleInOne2.push(0, 2);
        tripleInOne2.push(0, 3);
        System.out.println(tripleInOne2.pop(0));
        System.out.println(tripleInOne2.pop(0));
        System.out.println(tripleInOne2.pop(0));
        System.out.println(tripleInOne2.peek(0));
    }
}
