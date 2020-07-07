package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1503. Last Moment Before All Ants Fall Out of a Plank
 *
 * @author Baltan
 * @date 2020-07-05 23:18
 */
public class GetLastMoment {
    public static void main(String[] args) {
        int[] left1 = {4, 3};
        int[] right1 = {0, 1};
        System.out.println(getLastMoment(4, left1, right1));

        int[] left2 = {};
        int[] right2 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(getLastMoment(7, left2, right2));

        int[] left3 = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] right3 = {};
        System.out.println(getLastMoment(7, left3, right3));

        int[] left4 = {5};
        int[] right4 = {4};
        System.out.println(getLastMoment(9, left4, right4));

        int[] left5 = {6};
        int[] right5 = {0};
        System.out.println(getLastMoment(6, left5, right5));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/solution/ma-yi-you-mei-de-pa-pa-pa-pa-by-imcover/"></a>
     *
     * @param n
     * @param left
     * @param right
     * @return
     */
    public static int getLastMoment(int n, int[] left, int[] right) {
        int result = Integer.MIN_VALUE;
        /**
         * 把两只蚂蚁相遇后调头爬行，看做是互不影响继续向前爬行，则题目求的就是所有蚂蚁出发之后一直向前爬行，最后一只掉
         * 下木板的的蚂蚁花费的爬行时间
         */
        if (right.length != 0) {
            result = Math.max(result, n - Arrays.stream(right).min().getAsInt());
        }

        if (left.length != 0) {
            result = Math.max(result, Arrays.stream(left).max().getAsInt());
        }
        return result;
    }
}
