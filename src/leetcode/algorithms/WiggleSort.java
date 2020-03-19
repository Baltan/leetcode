package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 324. Wiggle Sort II
 *
 * @author Baltan
 * @date 2019-06-21 10:20
 * @see leetcode.interview.WiggleSort
 * @see leetcode.interview.WiggleSort1
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
        if (nums == null) {
            return;
        }

        int length = nums.length;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
        }

        if ((length & 1) == 0) {
            int index = length - 2;

            while (!queue.isEmpty()) {
                int num = queue.poll();
                nums[index] = num;
                index -= 2;

                if (index < 0) {
                    index = length - 1;
                }
            }
        } else {
            int index = 0;

            while (!queue.isEmpty()) {
                int num = queue.poll();
                nums[index] = num;
                index += 2;

                if (index >= length) {
                    index = 1;
                }
            }
        }
    }
}
