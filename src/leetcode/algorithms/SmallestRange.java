package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 632. Smallest Range Covering Elements from K Lists
 *
 * @author Baltan
 * @date 2020-08-01 23:36
 */
public class SmallestRange {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(smallestRange(
                Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5,
                        18, 22, 30))));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/"></a>
     *
     * @param nums
     * @return
     */
    public static int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        /**
         * 维护size个整数数组对应的size个指针，pointers[i]指向nums[i]的第pointers[i]（0-based）个元素
         */
        int[] pointers = new int[size];
        /**
         * 当前size个指针指向的size个元素中的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * 保存size个整数数组的索引[0,size-1]，并按照当前指向的size个元素的值升序排列。即队首的索引对应的整数数
         * 组中的指针指向的元素是size个元素中的最小值
         */
        Queue<Integer> queue =
                new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(pointers[index])));
        /**
         * size个元素中的最小值（根据题意，元素的值最小为-100000）
         */
        int left = -100000;
        /**
         * size个元素中的最大值（根据题意，元素的值最大为100000）
         */
        int right = 100000;
        /**
         * 当前找到的最小区间的长度
         */
        int minInterval = right - left;

        for (int i = 0; i < size; i++) {
            queue.offer(i);
            /**
             * 找到size个元素中的最大值
             */
            max = Math.max(max, nums.get(i).get(0));
        }

        while (true) {
            /**
             * size个元素中的最小值所在整数数组的索引值
             */
            int minIndex = queue.poll();
            /**
             * 当前size个元素构成的区间长度
             */
            int currentInterval = max - nums.get(minIndex).get(pointers[minIndex]);

            if (currentInterval < minInterval) {
                minInterval = currentInterval;
                left = nums.get(minIndex).get(pointers[minIndex]);
                right = max;
            }
            pointers[minIndex]++;
            /**
             * 如果minIndex已经超出了该指针所在整数数组的范围，则后续最小区间[left,right]中不可能包含
             * nums[minIndex]中的元素了，不符合题意，退出循环
             */
            if (pointers[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            queue.offer(minIndex);
            /**
             * 更新size个元素中的最大值
             */
            max = Math.max(max, nums.get(minIndex).get(pointers[minIndex]));
        }
        return new int[]{left, right};
    }
}
