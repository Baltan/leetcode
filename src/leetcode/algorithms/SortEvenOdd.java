package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2164. Sort Even and Odd Indices Independently
 *
 * @author Baltan
 * @date 2022/2/10 14:00
 */
public class SortEvenOdd {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sortEvenOdd(new int[]{4, 1, 2, 3}));
        OutputUtils.print1DIntegerArray(sortEvenOdd(new int[]{2, 1}));
    }

    public static int[] sortEvenOdd(int[] nums) {
        /**
         * 数组nums中偶数索引上的数字，按照升序排列
         */
        Queue<Integer> evenQueue = new PriorityQueue<>();
        /**
         * 数组nums中奇数索引上的数字，按照降序排列
         */
        Queue<Integer> oddQueue = new PriorityQueue<>(Collections.reverseOrder());
        /**
         * 是否是数组nums中偶数索引上的数字
         */
        boolean isEven = true;

        for (int num : nums) {
            if (isEven) {
                evenQueue.offer(num);
            } else {
                oddQueue.offer(num);
            }
            isEven = !isEven;
        }

        int index = 0;
        /**
         * 将排序后的偶数索引上的数字重新放在各个偶数索引位置
         */
        while (!evenQueue.isEmpty()) {
            nums[index] = evenQueue.poll();
            index += 2;
        }

        index = 1;
        /**
         * 将排序后的奇数索引上的数字重新放在各个奇数索引位置
         */
        while (!oddQueue.isEmpty()) {
            nums[index] = oddQueue.poll();
            index += 2;
        }
        return nums;
    }
}
