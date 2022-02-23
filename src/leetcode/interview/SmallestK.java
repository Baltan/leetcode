package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 面试题 17.14. 最小K个数
 *
 * @author Baltan
 * @date 2022/2/23 11:32
 */
public class SmallestK {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 2, 4, 6, 8};
        OutputUtils.print1DIntegerArray(smallestK(arr1, 4));

        int[] arr2 = {1, 2, 3};
        OutputUtils.print1DIntegerArray(smallestK(arr2, 0));
    }

    public static int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        int[] result = new int[k];
        int index = k - 1;
        /**
         * 容量为k的大顶堆，堆顶的元素始终为堆中所有元素的最大值
         */
        Queue<Integer> maxHeap = new PriorityQueue<>(k, (x, y) -> y - x);

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            result[index--] = maxHeap.poll();
        }
        return result;
    }
}
