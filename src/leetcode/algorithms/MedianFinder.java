package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 295. Find Median from Data Stream
 *
 * @author Baltan
 * @date 2019-08-07 11:01
 * @see leetcode.interview.MedianFinder
 */
public class MedianFinder {
    private List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int index = list.size() - 1;
            /**
             * 从list最后一个数字开始判断，如果该数字大于要插入的数字，就将该数字向后挪一个位置，
             * 一直向前处理，直到某个数字不大于要插入的数字位置
             */
            while (index >= 0 && list.get(index) > num) {
                if (index == list.size() - 1) {
                    list.add(list.get(index));
                } else {
                    list.set(index + 1, list.get(index));
                }
                index--;
            }
            /**
             * 将要插入的数字放到上面最后结束的那个数字的后面一个位置，这样list中的数字还是升序排列的
             */
            if (index + 1 < list.size()) {
                list.set(index + 1, num);
            } else {
                list.add(num);
            }
        }
    }

    public double findMedian() {
        int size = list.size();

        if ((size & 1) == 1) {
            return list.get(size / 2);
        } else {
            return (list.get(size / 2 - 1) + list.get(size / 2)) * 1.0 / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder1 = new MedianFinder();
        finder1.addNum(1);
        finder1.addNum(2);
        System.out.println(finder1.findMedian());
        finder1.addNum(3);
        System.out.println(finder1.findMedian());
        finder1.addNum(4);
        System.out.println(finder1.findMedian());
        finder1.addNum(2);
        System.out.println(finder1.findMedian());
        finder1.addNum(5);
        System.out.println(finder1.findMedian());
        finder1.addNum(5);
        System.out.println(finder1.findMedian());
        finder1.addNum(1);
        System.out.println(finder1.findMedian());

        System.out.println("------------------");

        MedianFinder finder2 = new MedianFinder();
        finder2.addNum(-1);
        System.out.println(finder2.findMedian());
        finder2.addNum(-2);
        System.out.println(finder2.findMedian());
        finder2.addNum(-3);
        System.out.println(finder2.findMedian());
        finder2.addNum(-4);
        System.out.println(finder2.findMedian());
        finder2.addNum(-5);
        System.out.println(finder2.findMedian());
    }
}
