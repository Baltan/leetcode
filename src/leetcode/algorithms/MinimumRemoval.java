package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2171. Removing Minimum Number of Magic Beans
 *
 * @author Baltan
 * @date 2022/2/14 21:37
 */
public class MinimumRemoval {
    public static void main(String[] args) {
        System.out.println(minimumRemoval(new int[]{4, 1, 6, 5}));
        System.out.println(minimumRemoval(new int[]{2, 10, 3, 2}));
    }

    public static long minimumRemoval(int[] beans) {
        /**
         * 最多可以剩下的豆子数
         */
        long maxLeft = Long.MIN_VALUE;
        /**
         * 豆子总数
         */
        long total = 0L;
        /**
         * 之前已经判断过的每个袋子中可能剩下的豆子数，避免重复判断
         */
        int before = 0;
        Arrays.sort(beans);

        for (int i = 0; i < beans.length; i++) {
            total += beans[i];

            if (beans[i] == before) {
                continue;
            }
            /**
             * 如果最后每个袋子中的豆子数为beans[i]，则只有当前袋子以及之后的所有袋子最后被留下，留下的豆子总数为
             * beans[i]*(beans.length-i)
             */
            maxLeft = Math.max(maxLeft, 1L * beans[i] * (beans.length - i));
            before = beans[i];
        }
        return total - maxLeft;
    }
}
