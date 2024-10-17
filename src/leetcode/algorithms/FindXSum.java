package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Description: 3318. Find X-Sum of All K-Long Subarrays I
 *
 * @author Baltan
 * @date 2024/10/17 23:19
 */
public class FindXSum {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2));
        OutputUtils.print1DIntegerArray(findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2));
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        /**
         * counts[i]表示子数组中元素i的个数，根据题意nums[i]∈[1,50]
         */
        int[] counts = new int[51];
        Integer[] indexes = IntStream.rangeClosed(1, 50).boxed().toArray(Integer[]::new);

        for (int i = 0; i < k; i++) {
            counts[nums[i]]++;
        }
        /**
         * 将子数组中的所有元素优先按照出现的次数降序排列，如果出现次数相同，则按照元素值降序排列
         */
        Arrays.sort(indexes, (m, n) -> Objects.equals(counts[m], counts[n]) ? n - m : counts[n] - counts[m]);
        /**
         * 取出现次数最多的x个元素进行计算
         */
        for (int i = 0; i < x; i++) {
            result[0] += indexes[i] * counts[indexes[i]];
        }

        for (int i = k; i < nums.length; i++) {
            /**
             * 子数组中尾部加入元素nums[i]，并且移除前一个子数组的第一个元素nums[i-k]
             */
            counts[nums[i]]++;
            counts[nums[i - k]]--;
            /**
             * 将子数组中的所有元素优先按照出现的次数降序排列，如果出现次数相同，则按照元素值降序排列
             */
            Arrays.sort(indexes, (m, n) -> Objects.equals(counts[m], counts[n]) ? n - m : counts[n] - counts[m]);
            /**
             * 取出现次数最多的x个元素进行计算
             */
            for (int j = 0; j < x; j++) {
                result[i - k + 1] += indexes[j] * counts[indexes[j]];
            }
        }
        return result;
    }
}
