package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 2336. Smallest Number in Infinite Set
 *
 * @author Baltan
 * @date 2023/1/17 16:58
 */
public class SmallestInfiniteSet {
    /**
     * 保存所有通过addBack()加入到无限集中的数字，并且按照升序排列
     */
    private TreeSet<Integer> addNums;
    /**
     * 除去addNums中的数字外，无限集中剩余所有数字的最小值，即原始无限集中数字的最小值
     */
    private int min;

    public SmallestInfiniteSet() {
        addNums = new TreeSet<>();
        min = 1;
    }

    public int popSmallest() {
        if (addNums.isEmpty() || min < addNums.first()) {
            /**
             * 最小值在原始无限集的数字中
             */
            int result = min;
            min++;
            return result;
        } else {
            /**
             * 最小值在通过addBack()加入到无限集的数字中
             */
            return addNums.pollFirst();
        }
    }

    public void addBack(int num) {
        /**
         * 无限集中已存在数字num，不加入
         */
        if (num >= min || addNums.contains(num)) {
            return;
        }
        addNums.add(num);
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet1 = new SmallestInfiniteSet();
        smallestInfiniteSet1.addBack(2);
        System.out.println(smallestInfiniteSet1.popSmallest());
        System.out.println(smallestInfiniteSet1.popSmallest());
        System.out.println(smallestInfiniteSet1.popSmallest());
        smallestInfiniteSet1.addBack(1);
        System.out.println(smallestInfiniteSet1.popSmallest());
        System.out.println(smallestInfiniteSet1.popSmallest());
        System.out.println(smallestInfiniteSet1.popSmallest());
    }
}
