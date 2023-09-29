package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Description: 2866. Beautiful Towers II
 *
 * @author baltan
 * @date 2023/9/28 15:46
 * @see MaximumSumOfHeights
 */
public class MaximumSumOfHeights1 {
    public static void main(String[] args) {
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 2, 4, 4)));
        System.out.println(maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/beautiful-towers-ii/solutions/2456562/qian-hou-zhui-fen-jie-dan-diao-zhan-pyth-1exe/"></a>
     *
     * @param maxHeights
     * @return
     */
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long result = 0L;
        int size = maxHeights.size();
        long[] prefixSums = new long[size];
        long[] suffixSums = new long[size];
        Deque<Integer> prefixIndexDeque = new ArrayDeque<>();
        Deque<Integer> suffixIndexDeque = new ArrayDeque<>();
        prefixSums[0] = maxHeights.get(0);
        suffixSums[size - 1] = maxHeights.get(size - 1);
        prefixIndexDeque.offerLast(0);
        suffixIndexDeque.offerLast(size - 1);

        for (int i = 1; i < size; i++) {
            if (maxHeights.get(i) >= maxHeights.get(prefixIndexDeque.peekLast())) {
                prefixIndexDeque.offerLast(i);
                prefixSums[i] = prefixSums[i - 1] + maxHeights.get(i);
            } else {
                while (!prefixIndexDeque.isEmpty() && maxHeights.get(prefixIndexDeque.peekLast()) > maxHeights.get(i)) {
                    prefixIndexDeque.pollLast();
                }

                if (prefixIndexDeque.isEmpty()) {
                    prefixSums[i] = (long) maxHeights.get(i) * (i + 1);
                } else {
                    prefixSums[i] = (long) maxHeights.get(i) * (i - prefixIndexDeque.peekLast()) + prefixSums[prefixIndexDeque.peekLast()];
                }
                prefixIndexDeque.offerLast(i);
            }
            int j = size - 1 - i;

            if (maxHeights.get(j) >= maxHeights.get(suffixIndexDeque.peekLast())) {
                suffixIndexDeque.offerLast(j);
                suffixSums[j] = suffixSums[j + 1] + maxHeights.get(j);
            } else {
                while (!suffixIndexDeque.isEmpty() && maxHeights.get(suffixIndexDeque.peekLast()) > maxHeights.get(j)) {
                    suffixIndexDeque.pollLast();
                }

                if (suffixIndexDeque.isEmpty()) {
                    suffixSums[j] = (long) maxHeights.get(j) * (size - j);
                } else {
                    suffixSums[j] = (long) maxHeights.get(j) * (suffixIndexDeque.peekLast() - j) + suffixSums[suffixIndexDeque.peekLast()];
                }
                suffixIndexDeque.offerLast(j);
            }
        }

        for (int i = 0; i < size; i++) {
            long sum = prefixSums[i] + suffixSums[i] - maxHeights.get(i);
            result = Math.max(result, sum);
        }
        return result;
    }
}
