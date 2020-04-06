package leetcode.interview;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 面试题 16.21. 交换和
 *
 * @author Baltan
 * @date 2020-04-06 22:22
 */
public class FindSwapValues {
    public static void main(String[] args) {
        int[] array11 = {4, 1, 2, 1, 1, 2};
        int[] array12 = {3, 6, 3, 3};
        OutputUtils.print1DIntegerArray(findSwapValues(array11, array12));

        int[] array21 = {1, 2, 3};
        int[] array22 = {4, 5, 6};
        OutputUtils.print1DIntegerArray(findSwapValues(array21, array22));
    }

    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        /**
         * 如果两个数组各自所有元素之和的差值为奇数，则无满足条件的数值
         */
        if (((sum1 - sum2) & 1) == 1) {
            return new int[]{};
        }
        /**
         * 保存array2中的所有元素的集合
         */
        Set<Integer> set2 = new HashSet<>();

        for (int value : array2) {
            set2.add(value);
        }
        /**
         * 对array1中的每个元素都尝试和array2中的某个元素交换
         */
        for (int value : array1) {
            /**
             * ∵ sum1-value+expected = sum2+value-expected
             * ∴ expected=(sum2-sum1+2*value)/2
             */
            int expected = (sum2 - sum1 + 2 * value) / 2;

            if (set2.contains(expected)) {
                return new int[]{value, expected};
            }
        }
        return new int[]{};
    }
}
