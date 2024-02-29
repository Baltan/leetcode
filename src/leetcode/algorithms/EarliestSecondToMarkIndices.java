package leetcode.algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: 3048. Earliest Second to Mark Indices I
 *
 * @author baltan
 * @date 2024/2/28 10:34
 */
public class EarliestSecondToMarkIndices {
    public static void main(String[] args) {
        System.out.println(earliestSecondToMarkIndices(new int[]{1, 1, 0}, new int[]{2, 2, 1, 3, 2, 3, 2, 3, 1, 2}));
        System.out.println(earliestSecondToMarkIndices(new int[]{2, 2, 0}, new int[]{2, 2, 2, 2, 3, 2, 2, 1}));
        System.out.println(earliestSecondToMarkIndices(new int[]{1, 3}, new int[]{1, 1, 1, 2, 1, 1, 1}));
        System.out.println(earliestSecondToMarkIndices(new int[]{0, 1}, new int[]{2, 2, 2}));
    }

    public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int result = Integer.MAX_VALUE;
        int lo = 0;
        int hi = changeIndices.length;
        /**
         * decrement[i]表示nums[i]被执行减1操作的次数
         */
        int[] decrement = new int[nums.length];
        /**
         * mark[i]表示nums[i]是否被标记下标
         */
        boolean[] mark = new boolean[nums.length];
        /**
         * 通过逆序操作的思路，二分判断mid秒内，能否将数组nums中所有下标都标记，即对mid内的所有操作逆序执行，先标记下标，再对已标记下标的元
         * 素进行减1操作
         */
        outer:
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            /**
             * 保存数组nums中需要被执行减1操作的元素的索引
             */
            Deque<Integer> marked = new LinkedList<>();
            Arrays.fill(decrement, 0);
            Arrays.fill(mark, false);

            for (int i = mid - 1; i >= 0; i--) {
                /**
                 * 当前可以对数组nums中索引为changeIndex的元素标记下标
                 */
                int changeIndex = changeIndices[i] - 1;

                if (!mark[changeIndex]) {
                    mark[changeIndex] = true;
                    /**
                     * 元素nums[changeIndex]被标记下标后，后续还需要进行nums[changeIndex]次减1操作
                     */
                    if (nums[changeIndex] > 0) {
                        marked.offerLast(changeIndex);
                    }
                } else if (!marked.isEmpty()) {
                    /**
                     * 对数组nums中的元素nums[recentIndex]进行减1操作，直到不需要再进行操作后，从队列中删除
                     */
                    int recentIndex = marked.peekFirst();
                    decrement[recentIndex]++;

                    if (decrement[recentIndex] == nums[recentIndex]) {
                        marked.pollFirst();
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                /**
                 * 如果数组nums中存在某个元素没有变成0或者未被标记下标，则说明数组nums未被全部标记下标，需要更多次秒数执行操作
                 */
                if (!mark[i] || decrement[i] < nums[i]) {
                    lo = mid + 1;
                    continue outer;
                }
            }
            /**
             * 在mid秒内，可以将数组nums中所有下标都标记
             */
            result = Math.min(result, mid);
            hi = mid - 1;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
