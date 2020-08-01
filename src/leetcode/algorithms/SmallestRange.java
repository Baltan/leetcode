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

    public static int[] smallestRange(List<List<Integer>> nums) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int minInterval = right - left;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        Queue<Integer> queue =
                new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(next[index])));

        for (int i = 0; i < size; i++) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        while (true) {
            int minIndex = queue.poll();
            int currentInterval = max - nums.get(minIndex).get(next[minIndex]);

            if (currentInterval < minInterval) {
                minInterval = currentInterval;
                left = nums.get(minIndex).get(next[minIndex]);
                right = max;
            }
            next[minIndex]++;

            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            queue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{left, right};
    }
}
