package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 164. Maximum Gap
 *
 * @author Baltan
 * @date 2020-11-26 23:28
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(maximumGap(new int[]{10}));
        System.out.println(maximumGap(new int[]{100, 3, 2, 1}));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int result = 0;
        int length = nums.length;
        radixSort(nums);

        for (int i = 1; i < length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return result;
    }

    /**
     * 基数排序
     *
     * <pre>
     * 准备10个队列，序号分别为0-9。
     * 先根据数组中所有数字的个位将数字放到对应的队列中，个位是几，就放到几号队列中。
     * 所有数字都放入队列中后，将所有队列中的数字按照队列的序号依次取出。
     * 再根据数组中所有数字的十位将数字放到对应的队列中，十位是几，就放到几号队列中。
     * 所有数字都放入队列中后，将所有队列中的数字按照队列的序号依次取出。
     * 再根据数组中所有数字的百位将数字放到对应的队列中，百位是几，就放到几号队列中。
     * 所有数字都放入队列中后，将所有队列中的数字按照队列的序号依次取出。
     * ……
     *
     * 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64
     *
     * 队列序号  0   1   2   3   4   5   6   7   8   9
     *                 12  13  34  65  76  97  38  49
     *                         64          27  78  49
     *
     * 12, 13, 34, 64, 65, 76, 97, 27, 38, 78, 49, 49
     *
     * 队列序号  0   1   2   3   4   5   6   7   8   9
     *             12  27  34  49      64  76      97
     *             13      38  49      65  78
     *
     * 12, 13, 27, 34, 38, 49, 49, 64, 65, 76, 78, 97
     * </pre>
     */
    public static void radixSort(int[] nums) {
        /**
         * 数组nums中的最大值
         */
        int max = nums[0];
        int length = nums.length;
        /**
         * queues[i]保存某一位上值为i的数字
         */
        Queue<Integer>[] queues = new Queue[10];
        /**
         * 查找数组中的最大值
         */
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
        }
        /**
         * 最大值max的数字个数
         */
        int maxLength = 0;

        while (max > 0) {
            max /= 10;
            maxLength++;
        }
        /**
         * 初始化10个队列
         */
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<>();
        }
        /**
         * 从最低位向最高位依次处理
         */
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                /**
                 * value从低位向高位数第i（0-based）个数字的值
                 */
                int value = (int) (num % Math.pow(10, i + 1) / Math.pow(10, i));
                queues[value].offer(num);
            }

            int index = 0;
            /**
             * 将10个队列中的值逐一出队重新存入数组nums中
             */
            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = queues[j];

                while (!queue.isEmpty()) {
                    nums[index] = queue.poll();
                    index++;
                }
            }
        }
    }
}
