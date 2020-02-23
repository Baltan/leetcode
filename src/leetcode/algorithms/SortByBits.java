package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1356. Sort Integers by The Number of 1 Bits
 *
 * @author Baltan
 * @date 2020-02-23 13:50
 */
public class SortByBits {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        OutputUtils.print1DIntegerArray(sortByBits(arr1));

        int[] arr2 = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        OutputUtils.print1DIntegerArray(sortByBits(arr2));

        int[] arr3 = new int[]{10000, 10000};
        OutputUtils.print1DIntegerArray(sortByBits(arr3));

        int[] arr4 = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        OutputUtils.print1DIntegerArray(sortByBits(arr4));

        int[] arr5 = new int[]{10, 100, 1000, 10000};
        OutputUtils.print1DIntegerArray(sortByBits(arr5));

        int[] arr6 = new int[]{666};
        OutputUtils.print1DIntegerArray(sortByBits(arr6));
    }

    public static int[] sortByBits(int[] arr) {
        /**
         * 题目给出的数组arr中元素的最大值
         */
        int max = 10000;
        /**
         * bitCounts[i]为十进制数i的二进制表示中1的个数
         */
        int[] bitCounts = new int[max + 1];
        int index = 0;
        /**
         * 队列中的元素按照其二进制表示中1的个数升序排列，如果相等的话则按照元素大小升序排列
         */
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> bitCounts[x] == bitCounts[y] ? x - y :
                bitCounts[x] - bitCounts[y]);
        /**
         * @see CountBits1
         */
        for (int i = 1; i <= max; i++) {
            bitCounts[i] = bitCounts[i & (i - 1)] + 1;
        }

        for (int i : arr) {
            queue.offer(i);
        }
        /**
         * 将队列中的值按序放回数组
         */
        while (!queue.isEmpty()) {
            arr[index++] = queue.poll();
        }
        return arr;
    }
}
