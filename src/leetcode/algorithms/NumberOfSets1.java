package leetcode.algorithms;

/**
 * Description: 1621. Number of Sets of K Non-Overlapping Line Segments
 *
 * @author Baltan
 * @date 2022/10/2 15:31
 * @see NumberOfSets
 * @see NumberOfSets2
 */
public class NumberOfSets1 {
    public static void main(String[] args) {
        System.out.println(numberOfSets(4, 2));
        System.out.println(numberOfSets(3, 1));
        System.out.println(numberOfSets(30, 7));
        System.out.println(numberOfSets(33, 20));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/solution/mou-da-lao-de-yi-xing-dai-ma-by-darktiantian/"></a>
     * <a href="https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/solution/dong-tai-gui-hua-shu-xue-fa-si-lu-fen-xi-sagz/"></a>
     *
     * @param n
     * @param k
     * @return
     */
    public static int numberOfSets(int n, int k) {
        int mod = 1000000007;
        int totalPoints = n + k - 1;
        int chosenPoints = 2 * k;
        /**
         * 从totalPoints个点中选择chosenPoints个点，一共的选择数为：
         * [totalPoints*(totalPoints-1)*……*(totalPoints-chosenPoints+1)]/[1*2*……*chosenPoints]
         * 为防止溢出，用杨辉三角计算最终的值，例如：
         * 1
         * 1   1
         * 1   2   1
         * 1   3   3   1
         * 1   4   6   4   1
         * ……
         * 则所求值即为第totalPoints（0-based）行的第chosenPoints（0-based）个数，其中第i行有i+1个数
         */
        long[] help = new long[chosenPoints + 1];
        /**
         * 第0行的第0个数，即为杨辉三角最顶上的数
         */
        help[0] = 1;

        for (int row = 1; row <= totalPoints; row++) {
            /**
             * 从第row行的最后一个数向前计算，每一行至多需要计算到第row个数，其中第totalPoints行只需要计算到第chosenPoints
             * 个数即可
             */
            for (int col = Math.min(chosenPoints, row); col >= 1; col--) {
                help[col] = help[col] + help[col - 1];

                if (help[col] > mod) {
                    help[col] %= mod;
                }
            }
        }
        return (int) help[chosenPoints];
    }
}
