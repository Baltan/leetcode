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
        /**
         * prefixSums[i]表示以索引值为i的塔作为美丽塔的最高点时，索引值为[0,i]的所有塔的高度和
         */
        long[] prefixSums = new long[size];
        /**
         * suffixSums[i]表示以索引值为i的塔作为美丽塔的最高点时，索引值为[i,size)的所有塔的高度和
         */
        long[] suffixSums = new long[size];
        /**
         * 单调栈保存每座塔的索引，保持栈顶到栈底的索引对应的塔高是非递增的
         */
        Deque<Integer> prefixIndexDeque = new ArrayDeque<>();
        /**
         * 单调栈保存每座塔的索引，保持栈顶到栈底的索引对应的塔高是非递减的
         */
        Deque<Integer> suffixIndexDeque = new ArrayDeque<>();
        prefixSums[0] = maxHeights.get(0);
        suffixSums[size - 1] = maxHeights.get(size - 1);
        prefixIndexDeque.offerLast(0);
        suffixIndexDeque.offerLast(size - 1);

        for (int i = 1; i < size; i++) {
            if (maxHeights.get(i) >= maxHeights.get(prefixIndexDeque.peekLast())) {
                /**
                 * 以索引值为i-1的塔作为美丽塔的最高点时，可以直接连上索引值为i的塔
                 */
                prefixIndexDeque.offerLast(i);
                prefixSums[i] = prefixSums[i - 1] + maxHeights.get(i);
            } else {
                /**
                 * 将索引值为i的塔左边高度大于它的塔都出栈，如果希望以索引值为i的塔作为美丽塔的最高点，这部分出栈的塔的高度最多只能为
                 * maxHeights[i]
                 */
                while (!prefixIndexDeque.isEmpty() && maxHeights.get(prefixIndexDeque.peekLast()) > maxHeights.get(i)) {
                    prefixIndexDeque.pollLast();
                }

                if (prefixIndexDeque.isEmpty()) {
                    /**
                     * 索引值为i的塔左边的塔高度都大于maxHeights[i]，此时需要将所有塔的高度都改为maxHeights[i]
                     */
                    prefixSums[i] = (long) maxHeights.get(i) * (i + 1);
                } else {
                    /**
                     * 将索引值为i的塔左边的高度大于它的塔高度都改为maxHeights[i]，剩余的塔高度和为prefixSums[x]（其中x=
                     * prefixIndexDeque.peekLast()）
                     */
                    prefixSums[i] = (long) maxHeights.get(i) * (i - prefixIndexDeque.peekLast()) + prefixSums[prefixIndexDeque.peekLast()];
                }
                prefixIndexDeque.offerLast(i);
            }
            int j = size - 1 - i;

            if (maxHeights.get(j) >= maxHeights.get(suffixIndexDeque.peekLast())) {
                /**
                 * 以索引值为j+1的塔作为美丽塔的最高点时，可以直接连上索引值为j的塔
                 */
                suffixIndexDeque.offerLast(j);
                suffixSums[j] = suffixSums[j + 1] + maxHeights.get(j);
            } else {
                /**
                 * 将索引值为j的塔右边高度大于它的塔都出栈，如果希望以索引值为j的塔作为美丽塔的最高点，这部分出栈的塔的高度最多只能为
                 * maxHeights[j]
                 */
                while (!suffixIndexDeque.isEmpty() && maxHeights.get(suffixIndexDeque.peekLast()) > maxHeights.get(j)) {
                    suffixIndexDeque.pollLast();
                }

                if (suffixIndexDeque.isEmpty()) {
                    /**
                     * 索引值为j的塔右边的塔高度都大于maxHeights[j]，此时需要将所有塔的高度都改为maxHeights[j]
                     */
                    suffixSums[j] = (long) maxHeights.get(j) * (size - j);
                } else {
                    /**
                     * 将索引值为j的塔右边的高度大于它的塔高度都改为maxHeights[j]，剩余的塔高度和为suffixSums[x]（其中x=
                     * suffixIndexDeque.peekLast()）
                     */
                    suffixSums[j] = (long) maxHeights.get(j) * (suffixIndexDeque.peekLast() - j) + suffixSums[suffixIndexDeque.peekLast()];
                }
                suffixIndexDeque.offerLast(j);
            }
        }
        /**
         * 计算以索引值为i的塔作为美丽塔的最高点时，所有塔的高度和，取最大值
         */
        for (int i = 0; i < size; i++) {
            /**
             * 索引值为i的塔高度被重复计算一次，需要扣除
             */
            long sum = prefixSums[i] + suffixSums[i] - maxHeights.get(i);
            result = Math.max(result, sum);
        }
        return result;
    }
}
