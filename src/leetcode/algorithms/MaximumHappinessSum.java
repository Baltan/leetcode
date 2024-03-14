package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3075. Maximize Happiness of Selected Children
 *
 * @author Baltan
 * @date 2024/3/14 22:52
 */
public class MaximumHappinessSum {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
        System.out.println(maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        long result = 0L;
        /**
         * 未被选中的孩子每人需要被减少的幸福值
         */
        int decrement = 0;
        int index = happiness.length - 1;
        Arrays.sort(happiness);
        /**
         * 贪心思想，总是从未被选中的孩子中选择剩余幸福值最大的那个，直到余下的孩子幸福值都为0或者选完k个孩子
         */
        while (k > 0 && happiness[index] - decrement > 0) {
            result += happiness[index] - decrement;
            /**
             * 剩下的孩子幸福值都要再被减1
             */
            decrement++;
            index--;
            k--;
        }
        return result;
    }
}
