package leetcode.algorithms;

/**
 * Description: 2466. Count Ways To Build Good Strings
 *
 * @author Baltan
 * @date 2022/11/22 09:34
 */
public class CountGoodStrings {
    public static void main(String[] args) {
        System.out.println(countGoodStrings(3, 3, 1, 1));
        System.out.println(countGoodStrings(2, 3, 1, 2));
        System.out.println(countGoodStrings(45000, 100000, 23, 37));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * dp[i]表示长度为i的不同好字符串的数量
         */
        long[] dp = new long[high + 1];
        dp[zero]++;
        dp[one]++;

        for (int i = 2; i <= high; i++) {
            /**
             * 在长度为i-zero的好字符串末尾添加zero个0
             */
            if (i - zero > 0) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            /**
             * 在长度为i-one的好字符串末尾添加one个1
             */
            if (i - one > 0) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }
        /**
         * 累计长度范围为[low,high]的不同好字符串的总数
         */
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }
        return (int) result;
    }
}
