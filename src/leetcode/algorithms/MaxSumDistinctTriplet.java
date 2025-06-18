package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3572. Maximize Y‑Sum by Picking a Triplet of Distinct X‑Values
 *
 * @author baltan
 * @date 2025/6/18 08:59
 */
public class MaxSumDistinctTriplet {
    public static void main(String[] args) {
        System.out.println(maxSumDistinctTriplet(new int[]{1, 2, 1, 3, 2}, new int[]{5, 3, 4, 6, 2}));
        System.out.println(maxSumDistinctTriplet(new int[]{1, 2, 1, 2}, new int[]{4, 5, 6, 7}));
    }

    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        int[] max = new int[1000001];

        for (int i = 0; i < x.length; i++) {
            max[x[i]] = Math.max(max[x[i]], y[i]);
        }
        max = Arrays.stream(max)
                .filter(i -> i > 0)
                .sorted()
                .toArray();
        return max.length < 3 ? -1 : max[max.length - 3] + max[max.length - 2] + max[max.length - 1];
    }
}
