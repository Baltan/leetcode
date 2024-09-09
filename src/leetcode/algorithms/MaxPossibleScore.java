package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3281. Maximize Score of Numbers in Ranges
 *
 * @author baltan
 * @date 2024/9/9 16:58
 */
public class MaxPossibleScore {
    public static void main(String[] args) {
        System.out.println(maxPossibleScore(new int[]{1000000000, 0}, 1000000000));
        System.out.println(maxPossibleScore(new int[]{6, 0, 3}, 2));
        System.out.println(maxPossibleScore(new int[]{2, 6, 13, 13}, 5));
    }

    public static int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        long lo = 0L;
        /**
         * 被选中的数字最小为start[0]，最大为start[start.length-1]+d，所以得分最大可能为start[start.length-1]+d-start[0]
         */
        long hi = start[start.length - 1] + d - start[0];
        /**
         * 二分计算可能的最大得分
         */
        outer:
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            /**
             * 贪心思想，令所有被选中数字中的最小值尽可能地小
             */
            long prev = start[0];

            for (int i = 1; i < start.length; i++) {
                /**
                 * 被选中的前一个数字为prev，则当前数字至少为prev+mid，但是prev+mid大于start[i]+d，说明得分只能小于mid
                 */
                if (prev + mid > start[i] + d) {
                    hi = mid - 1;
                    continue outer;
                }
                /**
                 * 贪心思想，令当前选择的数字尽可能地小，但是不能小于start[i]
                 */
                prev = Math.max(prev + mid, start[i]);
            }
            lo = mid;
        }
        return (int) lo;
    }
}
