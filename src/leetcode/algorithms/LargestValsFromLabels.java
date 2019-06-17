package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1090. Largest Values From Labels
 *
 * @author Baltan
 * @date 2019-06-17 09:58
 */
public class LargestValsFromLabels {
    public static void main(String[] args) {
        int[] values1 = {5, 4, 3, 2, 1};
        int[] labels1 = {1, 1, 2, 2, 3};
        int num_wanted1 = 3;
        int use_limit1 = 1;
        System.out.println(largestValsFromLabels(values1, labels1, num_wanted1, use_limit1));

        int[] values2 = {5, 4, 3, 2, 1};
        int[] labels2 = {1, 3, 3, 3, 2};
        int num_wanted2 = 3;
        int use_limit2 = 2;
        System.out.println(largestValsFromLabels(values2, labels2, num_wanted2, use_limit2));

        int[] values3 = {9, 8, 8, 7, 6};
        int[] labels3 = {0, 0, 0, 1, 1};
        int num_wanted3 = 3;
        int use_limit3 = 1;
        System.out.println(largestValsFromLabels(values3, labels3, num_wanted3, use_limit3));

        int[] values4 = {9, 8, 8, 7, 6};
        int[] labels4 = {0, 0, 0, 1, 1};
        int num_wanted4 = 3;
        int use_limit4 = 2;
        System.out.println(largestValsFromLabels(values4, labels4, num_wanted4, use_limit4));
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int result = 0;
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        int length = values.length;
        Map<Integer, Integer> useNum = new HashMap<>();

        for (int i = 0; i < length; i++) {
            queue.offer(new int[]{values[i], labels[i]});
        }

        while (num_wanted > 0 && !queue.isEmpty()) {
            int[] arr = queue.poll();
            int value = arr[0];
            int label = arr[1];

            if (!useNum.containsKey(label) || useNum.get(label) < use_limit) {
                result += value;
                useNum.put(label, useNum.getOrDefault(label, 0) + 1);
                num_wanted--;
            }
        }
        return result;
    }
}
