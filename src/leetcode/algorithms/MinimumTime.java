package leetcode.algorithms;

/**
 * Description: 2167. Minimum Time to Remove All Cars Containing Illegal Goods
 *
 * @author Baltan
 * @date 2022/2/10 21:56
 */
public class MinimumTime {
    public static void main(String[] args) {
        System.out.println(minimumTime("1100101"));
        System.out.println(minimumTime("0010"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/solution/godpmei-ju-fen-ge-dian-plustu-cao-yi-xia-m8h4/"></a>
     *
     * @param s
     * @return
     */
    public static int minimumTime(String s) {
        int result = Integer.MAX_VALUE;
        char[] charArray = s.toCharArray();
        int length = s.length();
        /**
         * dp1[i]表示s[0]到s[i]这部分子串中有违禁货物的车厢全部移除需要的最少时间
         */
        int[] dp1 = new int[length];
        /**
         * dp1[i]表示s[i]到s[length-1]这部分子串中有违禁货物的车厢全部移除需要的最少时间
         */
        int[] dp2 = new int[length];
        /**
         * 如果s[0]车厢有违禁货物，将这个车厢从左移除的所需时间最少，为1单位时间
         */
        dp1[0] = charArray[0] == '1' ? 1 : 0;
        /**
         * 如果s[length-1]车厢有违禁货物，将这个车厢从右移除的所需时间最少，为1单位时间
         */
        dp2[length - 1] = charArray[length - 1] == '1' ? 1 : 0;

        for (int i = 1; i < length; i++) {
            /**
             * 如果s[i]车厢有违禁货物，或者不考虑左边的车厢是否都被移除而直接移除车厢，所需时间为dp1[i-1]+2；或者从左边开始将
             * 所有车厢都移除，所需时间为i+1，两者取较小值。如果s[i]车厢没有有违禁货物，则不需要操作，所需时间和dp1[i-1]相同
             */
            dp1[i] = charArray[i] == '1' ? Math.min(dp1[i - 1] + 2, i + 1) : dp1[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            /**
             * 如果s[i]车厢有违禁货物，或者不考虑右边的车厢是否都被移除而直接移除车厢，所需时间为dp2[i+1]+2；或者从右边开始将
             * 所有车厢都移除，所需时间为length-1，两者取较小值。如果s[i]车厢没有有违禁货物，则不需要操作，所需时间和dp2[i+1]
             * 相同
             */
            dp2[i] = charArray[i] == '1' ? Math.min(dp2[i + 1] + 2, length - i) : dp2[i + 1];
        }
        /**
         * 将所有车厢分成左右两段，逐一判断最小时间
         */
        for (int i = 0; i < length; i++) {
            /**
             * 将当前车厢分到左半段所需的最小时间，即左半段为s[0]到s[i]，右半段为s[i+1]到s[length-1]
             */
            result = Math.min(result, dp1[i] + (i == length - 1 ? 0 : dp2[i + 1]));
            /**
             * 将当前车厢分到右半段所需的最小时间，即左半段为s[0]到s[i-1]，右半段为s[i]到s[length-1]
             */
            result = Math.min(result, (i == 0 ? 0 : dp1[i - 1]) + dp2[i]);
        }
        return result;
    }
}
