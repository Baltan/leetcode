package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1798. Maximum Number of Consecutive Values You Can Make
 *
 * @author Baltan
 * @date 2022/6/30 16:41
 * @see MinimumAddedCoins
 */
public class GetMaximumConsecutive {
    public static void main(String[] args) {
        System.out.println(getMaximumConsecutive(new int[]{1, 3}));
        System.out.println(getMaximumConsecutive(new int[]{1, 1, 1, 4}));
        System.out.println(getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/solution/python-5xing-dong-tai-gui-hua-si-lu-by-y-uxlg/"></a>
     *
     * @param coins
     * @return
     */
    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        /**
         * 需要构造出的整数
         */
        int x = 0;

        for (int coin : coins) {
            /**
             * 如果当前硬币的值coin大于x+1，则和x+1不能被构造出，否则在[0,x]的基础上加上硬币coin后，[0,x+coin]都能被构造出
             * 来
             */
            if (coin > x + 1) {
                break;
            } else {
                x += coin;
            }
        }
        return x + 1;
    }
}
