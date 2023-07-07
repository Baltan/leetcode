package leetcode.algorithms;

/**
 * Description: 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 * @author Baltan
 * @date 2023/4/19 09:27
 */
public class MinimumDistance {
    public static void main(String[] args) {
        System.out.println(minimumDistance("CAKE"));
        System.out.println(minimumDistance("HAPPY"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-distance-to-type-a-word-using-two-fingers/solutions/2085814/java-1320-er-zhi-shu-ru-de-de-zui-xiao-j-ktl0/"></a>
     *
     * @param word
     * @return
     */
    public static int minimumDistance(String word) {
        int result = Integer.MAX_VALUE;
        char[] charArray = word.toCharArray();
        int length = charArray.length;
        int count = 26;
        /**
         * X-Y平面共有6列
         */
        int cols = 6;
        /**
         * distances[i][j]表示字母i+'A'和字母i+'B'在X-Y平面上的距离
         */
        int[][] distances = new int[count][count];
        /**
         * dp[i][j][k]表示输入第i个字符后左手在字母j上，右手在字母k上的最小移动总距离
         */
        int[][][] dp = new int[length][count][count];
        /**
         * 字符串word第一个字母在字母表中的索引值
         */
        int index = charArray[0] - 'A';
        /**
         * 计算X-Y平面上字母两两之间的距离
         */
        for (int i = 0; i < count; i++) {
            /**
             * 字母i+'A'的行索引
             */
            int ix = i / cols;
            /**
             * 字母i+'A'的列索引
             */
            int iy = i % cols;

            for (int j = 0; j < count; j++) {
                /**
                 * 字母j+'A'的行索引
                 */
                int jx = j / cols;
                /**
                 * 字母j+'A'的列索引
                 */
                int jy = j % cols;
                int distance = Math.abs(ix - jx) + Math.abs(iy - jy);
                distances[i][j] = distance;
            }
        }
        /**
         * 初始化所有情况的最小移动总距离为一个极大值
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        /**
         * 计算初始时左右手的位置，为了使得最小移动总距离尽可能小，左右手至少一个在字母word[0]上
         */
        for (int i = 0; i < count; i++) {
            /**
             * 左手在字母word[0]上
             */
            dp[0][index][i] = 0;
            /**
             * 右手在字母word[0]上
             */
            dp[0][i][index] = 0;
        }
        /**
         * 逐个输入字符串word后续的字母，计算每个字母输入后的最小移动总距离
         */
        for (int i = 1; i < length; i++) {
            /**
             * 当前要输入的字母在字母表中的索引值
             */
            index = charArray[i] - 'A';

            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    /**
                     * 只有之前存在某个最优方案的状态为dp[i-1][j][k]时，才能从该状态变化为状态dp[i][index][k]或dp[i][j][index]
                     */
                    if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
                        /**
                         * 移动左手到当前字母上完成输入
                         */
                        dp[i][index][k] = Math.min(dp[i][index][k], dp[i - 1][j][k] + distances[j][index]);
                        /**
                         * 移动右手到当前字母上完成输入
                         */
                        dp[i][j][index] = Math.min(dp[i][j][index], dp[i - 1][j][k] + distances[k][index]);
                    }
                }
            }
        }
        /**
         * 字符串word最后一个字母在字母表中的索引值
         */
        index = charArray[length - 1] - 'A';
        /**
         * 为了使得最小移动总距离尽可能小，左右手至少一个在最后一个字母上
         */
        for (int i = 0; i < count; i++) {
            result = Math.min(result, dp[length - 1][index][i]);
            result = Math.min(result, dp[length - 1][i][index]);
        }
        return result;
    }
}
