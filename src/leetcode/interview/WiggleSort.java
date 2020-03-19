package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 面试题 10.11. 峰与谷
 *
 * @author Baltan
 * @date 2020-03-19 15:01
 * @see WiggleSort1
 * @see leetcode.algorithms.WiggleSort
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums1);
        OutputUtils.print1DIntegerArray(nums1);

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums2);
        OutputUtils.print1DIntegerArray(nums2);

        int[] nums3 = {9, 6, 8, 7, 3, 5, 1, 2, 4};
        wiggleSort(nums3);
        OutputUtils.print1DIntegerArray(nums3);

        int[] nums4 = {2, 1};
        wiggleSort(nums4);
        OutputUtils.print1DIntegerArray(nums4);

        int[] nums5 = {2};
        wiggleSort(nums5);
        OutputUtils.print1DIntegerArray(nums5);

        int[] nums6 = {};
        wiggleSort(nums6);
        OutputUtils.print1DIntegerArray(nums6);

        int[] nums7 = {4, 5, 5, 6};
        wiggleSort(nums7);
        OutputUtils.print1DIntegerArray(nums7);
    }

    public static void wiggleSort(int[] nums) {
        /**
         * 将nums中所有数字升序排列
         */
        Queue<Integer> queue = new PriorityQueue<>();
        int length = nums.length;
        int index;

        for (int num : nums) {
            queue.offer(num);
        }

        if ((length & 1) == 0) {
            index = 1;
            /**
             * 从索引1开始每隔一个数字填入queue中最小的数字，即队列头部的数字
             */
            while (index < length) {
                nums[index] = queue.poll();
                index += 2;
            }

            index = 0;
            /**
             * 从索引0开始每隔一个数字填入queue中最小的数字，即队列头部的数字
             */
            while (index < length) {
                nums[index] = queue.poll();
                index += 2;
            }
        } else {
            index = 0;
            /**
             * 从索引0开始每隔一个数字填入queue中最小的数字，即队列头部的数字
             */
            while (index < length) {
                nums[index] = queue.poll();
                index += 2;
            }

            index = 1;
            /**
             * 从索引1开始每隔一个数字填入queue中最小的数字，即队列头部的数字
             */
            while (index < length) {
                nums[index] = queue.poll();
                index += 2;
            }
        }
    }
}
