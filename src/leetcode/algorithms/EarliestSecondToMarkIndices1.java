package leetcode.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3049. Earliest Second to Mark Indices II
 *
 * @author baltan
 * @date 2024/3/1 08:59
 * @see EarliestSecondToMarkIndices
 */
public class EarliestSecondToMarkIndices1 {
    public static void main(String[] args) {
        System.out.println(earliestSecondToMarkIndices(new int[]{9, 15, 15, 10, 8, 0, 12, 19, 18, 0, 2, 11, 13, 10, 17, 1, 2, 17, 9, 12, 5, 18, 11, 14, 13, 4, 18, 6, 13, 16, 6, 14, 11, 13, 5, 11, 5, 17, 10, 4, 9, 12, 7, 2, 2, 16, 15, 16, 5, 4, 0, 10, 14, 3, 17, 7, 8, 15, 6, 13, 3, 4, 8, 15, 9, 13, 18, 14, 2, 9, 10, 11, 1, 18, 13, 16, 6, 8, 12, 12, 12, 5, 14, 19, 8, 11, 6, 8, 19, 4, 14, 2, 8, 2, 9, 9, 7, 8, 4, 9, 9, 14, 12, 10, 4, 5, 18, 11, 5, 3, 15, 9, 8, 9, 8, 8, 13, 7, 17, 12, 11, 3, 6, 12, 5, 8, 1, 4, 8, 5, 5, 17, 12, 17, 19, 8, 14, 18, 19, 19}, new int[]{67, 61, 70, 57, 10, 30, 82, 97, 107, 6, 100, 10, 72, 72, 27, 12, 126, 3, 120, 123, 48, 109, 115, 137, 89, 4, 43, 7, 95, 134, 8, 22, 55, 89, 90, 76, 118, 31, 32, 97, 36, 3, 118, 119, 87, 17, 3, 72, 19, 122, 54, 67, 91, 29, 75, 51, 44, 118, 57, 138, 111, 76, 31, 25, 36, 120, 112, 13, 22, 15, 121, 69, 18, 99, 48, 104, 115, 50, 35, 133, 43, 100, 71, 5, 140, 18, 67, 43, 135, 123, 53, 117, 70, 95, 2, 105, 75, 125, 130, 108, 140, 110, 37, 17, 68, 96, 120, 54, 17, 26, 47, 59, 137, 129, 76, 137, 6, 2, 51, 12, 137, 103, 129, 66, 58, 2, 43, 4, 126, 32, 111, 125, 1, 19, 1, 69, 114, 132, 122, 130, 29, 40, 61, 26, 41, 136, 34, 58, 9, 84, 70, 5, 59, 58, 83, 128, 71, 125, 3, 56, 28, 125, 41, 28, 4, 53, 108, 117, 57, 102, 119, 97, 13, 39, 122, 53, 46, 27, 123, 54, 111, 52, 71, 41, 121, 25, 28, 51, 21, 30, 118, 48, 26, 30, 75, 29, 83, 43, 18, 11, 4, 136, 107, 28, 34, 101, 81, 79, 127, 63, 4, 109, 126, 86, 9, 118, 110, 48, 40, 130, 89, 17, 49, 115, 47, 124, 3, 1, 38, 32, 23, 53, 27, 129, 80, 72, 89, 32, 22, 88, 106, 26, 68, 91, 123, 77, 80, 93, 136, 119, 94, 85, 136, 3, 59, 54, 138, 73, 54, 47, 105, 76, 99, 131, 76, 50, 75, 37, 82, 96, 136, 47, 133, 63, 10, 116, 139, 89, 80, 7, 68, 33, 91, 75, 47, 21, 128, 56, 93, 53, 102, 57, 128, 60, 60, 75, 122, 134, 111, 63, 101, 106, 121, 94, 29, 2, 69, 39, 91, 20, 57, 30, 52, 7, 104, 111, 27, 103, 26, 132, 15, 140, 48, 14, 59, 119, 88, 52, 124, 71, 114, 85, 48, 107, 50, 88, 108, 130, 127, 70, 9, 43, 99, 72, 62, 74, 42, 100, 36, 80, 91, 50, 79, 11, 63, 9, 129, 23, 61, 125, 93, 46, 81, 140, 12, 2, 88, 132, 131, 86, 61, 11, 140, 32, 82, 61, 105, 136, 21, 13, 87, 123, 62, 37, 133, 137, 45, 134, 19, 117, 118, 111, 35, 70, 122, 46, 71, 69, 49, 61, 14, 110, 83, 26, 1, 24, 98, 105, 31, 130, 129, 117, 113, 51, 13, 105, 59, 70, 98, 77, 58, 87, 59, 92, 16, 40, 10, 98, 109, 58, 30, 134, 27, 112, 19, 27, 136, 117, 4, 26, 118, 132, 15, 90, 54, 27, 55, 112, 96, 24, 60, 14, 111, 118, 117, 138, 18, 126, 96, 138, 44, 125, 3, 82, 97, 34, 121, 104, 10, 136, 1, 139, 139, 15, 89, 53, 54, 3, 36, 21, 26, 96, 46, 8, 73, 23, 6, 102, 8, 101, 99, 63, 97, 102, 5, 65, 135, 137, 28, 16, 132, 29, 14, 130, 55, 102, 42, 108, 116, 90, 129, 14, 45, 34, 21, 129, 56, 38, 91, 76, 10, 49, 10, 107, 22, 14, 31, 16, 10, 71, 43, 1, 111, 57, 3, 25, 30, 56, 133, 6, 5, 133, 31, 61, 26, 51, 50, 94, 101, 140, 41, 110, 48, 50, 88, 70, 64, 131, 97, 85, 61, 140, 98, 43, 68, 100, 67, 97, 27, 71, 114, 32, 63, 4, 92, 101, 55, 1, 66, 27, 140, 106, 136, 60, 15, 96, 1, 90, 86, 109, 47, 18, 108, 4, 60, 47, 115, 138, 4, 13, 69, 117, 44, 3, 121, 8, 115, 47, 8, 40, 73, 20, 5, 80, 91, 32, 35, 103, 121, 132, 71, 39, 9, 51, 54, 80, 97, 40, 90, 100, 53, 18, 89, 96, 32, 81, 115, 7, 139, 135, 58, 71}));
        System.out.println(earliestSecondToMarkIndices(new int[]{1, 1}, new int[]{1, 2, 1, 2}));
        System.out.println(earliestSecondToMarkIndices(new int[]{2, 2}, new int[]{1, 2, 1, 1, 2, 2, 2}));
        System.out.println(earliestSecondToMarkIndices(new int[]{0}, new int[]{1}));
        System.out.println(earliestSecondToMarkIndices(new int[]{5, 1, 3, 2, 2, 5}, new int[]{3, 2, 2, 3, 1, 1, 3, 4, 2, 3, 4, 2, 5, 6, 5, 3, 6, 5, 3}));
        System.out.println(earliestSecondToMarkIndices(new int[]{3, 2, 3}, new int[]{1, 3, 2, 2, 2, 2, 3}));
        System.out.println(earliestSecondToMarkIndices(new int[]{0, 0, 1, 2}, new int[]{1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(earliestSecondToMarkIndices(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/earliest-second-to-mark-indices-ii/solutions/2653053/er-fen-da-an-fan-hui-tan-xin-pythonjavac-997n/"></a>
     *
     * @param nums
     * @param changeIndices
     * @return
     */
    public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        /**
         * 如果只有一次操作机会，当且仅当数组nums为[0]时，可以标记数组nums中的所有下标
         */
        if (changeIndices.length == 1) {
            return nums.length == 1 && nums[0] == 0 ? 1 : -1;
        }
        int result = Integer.MAX_VALUE;
        int lo = 1;
        int hi = changeIndices.length;
        /**
         * 标记数组nums中的所有下标需要的最大用时，即对每个非零元素都只执行减1操作，最后再执行标记操作
         */
        long max = 0L;
        /**
         * firstIndex[i]表示数组changeIndices中第一次出现nums中的下标i+1的索引
         */
        int[] firstIndex = new int[nums.length];
        Arrays.fill(firstIndex, -1);

        for (int i = changeIndices.length - 1; i >= 0; i--) {
            /**
             * 更新数组changeIndices中第一次出现nums中的下标changeIndices[i]的索引为i
             */
            firstIndex[changeIndices[i] - 1] = i;
        }

        for (int num : nums) {
            /**
             * 对元素num执行num次减1操作，最后再执行一次标记操作
             */
            max += (num + 1);
        }
        /**
         * 二分计算标记数组nums中的所有下标的最小用时
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            /**
             * 升序保存数组nums中被执行过设置成0操作的元素
             */
            Queue<Integer> pq = new PriorityQueue<>();
            /**
             * 可用的操作次数
             */
            int count = 0;
            /**
             * 还需要执行的操作次数
             */
            long total = max;

            for (int i = mid - 1; i >= 0; i--) {
                /**
                 * 如果需要，本次操作可以将nums[numIndex]设置成0
                 */
                int numIndex = changeIndices[i] - 1;

                if (nums[numIndex] <= 1 || i != firstIndex[numIndex]) {
                    /**
                     * 当前changeIndices[i]执行操作类型根据之前的操作暂定，将changeIndices[i]执行操作累计到后续可用的操作次数中
                     */
                    count++;
                } else if (count == 0) {
                    if (!pq.isEmpty() && pq.peek() < nums[numIndex]) {
                        /**
                         * 之前已被执行一次设置成0操作和标记下标操作的堆顶元素后续被修改为执行pq.poll()次减1操作和一次标记下标操作
                         */
                        total += pq.poll() + 1;
                        count += 2;
                        /**
                         * 当前操作将元素nums[numIndex]变成0，再使用一次操作将其标记下标，并加入到优先队列中
                         */
                        count--;
                        total -= nums[numIndex] + 1;
                        pq.offer(nums[numIndex]);
                    } else {
                        /**
                         * 当前changeIndices[i]执行操作类型根据之前的操作暂定，将changeIndices[i]执行操作累计到后续可用的操作次数中
                         */
                        count++;
                    }
                } else {
                    /**
                     * 当前操作将元素nums[numIndex]变成0，再使用一次操作将其标记下标
                     */
                    count--;
                    /**
                     * 元素nums[numIndex]已被标记，后续不需要再执行nums[numIndex]次减1操作和一次标记下标操作，并加入到优先队列中
                     */
                    total -= nums[numIndex] + 1;
                    pq.offer(nums[numIndex]);
                }
            }
            /**
             * 如果可用操作次数不小于还需要执行的操作次数，则说明可以在mid秒内标记数组nums中的所有下标
             */
            if (count >= total) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
