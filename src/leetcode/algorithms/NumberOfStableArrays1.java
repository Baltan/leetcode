package leetcode.algorithms;

/**
 * Description: 3130. Find All Possible Stable Binary Arrays II
 *
 * @author Baltan
 * @date 2024/5/2 14:38
 * @see NumberOfStableArrays
 */
public class NumberOfStableArrays1 {
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(20, 15, 75));
        System.out.println(numberOfStableArrays(2, 3, 4));
        System.out.println(numberOfStableArrays(2, 1, 2));
        System.out.println(numberOfStableArrays(1, 2, 2));
        System.out.println(numberOfStableArrays(1, 1, 2));
        System.out.println(numberOfStableArrays(1, 2, 1));
        System.out.println(numberOfStableArrays(3, 3, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-ii/solutions/2758868/dong-tai-gui-hua-cong-ji-yi-hua-sou-suo-37jdi/"></a>
     *
     * @param zero
     * @param one
     * @param limit
     * @return
     */
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;
        /**
         * dp[i][j][0]表示由i个0和j个1构成且最后一个元素为0的稳定数组的个数
         * dp[i][j][1]表示由i个0和j个1构成且最后一个元素为1的稳定数组的个数
         */
        long[][][] dp = new long[zero + 1][one + 1][2];
        /**
         * 如果稳定数组中只有元素1，则由[1,Math.min(limit,one)]个1构成的数组都是稳定数组
         */
        for (int i = 1; i <= limit && i <= one; i++) {
            dp[0][i][1] = 1;
        }
        /**
         * 如果稳定数组中只有元素0，则由[1,Math.min(limit,zero)]个0构成的数组都是稳定数组
         */
        for (int i = 1; i <= limit && i <= zero; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                /**
                 * 由i个0和j个1构成且最后一个元素为0的稳定数组可以通过两种情况得到：
                 * 1、由i-1个0和j个1构成且最后一个元素为1的稳定数组最后追加元素0（dp[i-1][j][1]）
                 * 2、由i-1个0和j个1构成且最后一个元素为0的稳定数组最后追加元素0（dp[i-1][j][0]），但是老数组的末尾如果有连续limit个0，
                 * 再追加元素0得到的就不是稳定数组了，需要将这些情况排除，即老数组的倒数第[0,limit)个元素为0，倒数第limit个元素为1的情况。
                 * 所以当老数组前面部分由i-1-limit个0和j个1构成且最后一个元素为1（dp[i-limit-1][j][1]）的情况都被排除
                 */
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] + mod -
                        (i - limit - 1 >= 0 ? dp[i - limit - 1][j][1] : 0)) % mod;
                /**
                 * 由i个0和j个1构成且最后一个元素为1的稳定数组可以通过两种情况得到：
                 * 1、由i个0和j-1个1构成且最后一个元素为0的稳定数组最后追加元素1（dp[i][j-1][0]）
                 * 2、由i个0和j-1个1构成且最后一个元素为1的稳定数组最后追加元素1（dp[i][j-1][1]），但是老数组的末尾如果有连续limit个1，
                 * 再追加元素1得到的就不是稳定数组了，需要将这些情况排除，即老数组的倒数第[0,limit)个元素为1，倒数第limit个元素为0的情况。
                 * 所以当老数组前面部分由i个0和j-limit-1个1构成且最后一个元素为0（dp[i][j-limit-1][0]）的情况都被排除
                 */
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1] + mod -
                        (j - limit - 1 >= 0 ? dp[i][j - limit - 1][0] : 0)) % mod;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % mod);
    }
}
