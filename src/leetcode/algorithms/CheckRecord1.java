package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 552. Student Attendance Record II
 *
 * @author baltan
 * @date 2024/6/25 13:39
 */
public class CheckRecord1 {
    public static void main(String[] args) {
        System.out.println(checkRecord(3));
        System.out.println(checkRecord(2));
        System.out.println(checkRecord(1));
        System.out.println(checkRecord(10101));
        System.out.println(checkRecord(4));
        System.out.println(checkRecord(8));
        System.out.println(checkRecord(20));
        System.out.println(checkRecord(50));
        System.out.println(checkRecord(100));
        System.out.println(checkRecord(500));
    }

    public static int checkRecord(int n) {
        if (n == 1) {
            /**
             * A、L、P
             */
            return 3;
        }

        if (n == 2) {
            /**
             * PP、AP、PA、LP、PL、AL、LA、LL
             */
            return 8;
        }
        long result = 0L;
        int mod = 1000000007;
        /**
         * 在没有缺勤记录的情况下，dp[i][0]表示前i天中最后两天为"LL"的情况数，dp[i][1]表示前i天中最后两天为"LP"的情况数，dp[i][2]表示
         * 前i天中最后两天为"PL"的情况数，dp[i][3]表示前i天中最后两天为"PP"的情况数
         */
        long[][] dp = new long[n + 1][4];
        /**
         * sums[i]=dp[i][0]+dp[i][1]+dp[i][2]+dp[i][3]，即当总天数为i天时，在没有缺勤记录的情况下的总情况数
         */
        long[] sums = new long[n + 1];
        /**
         * 前两天中，可能为"LL"、"LP"、"PL"、"PP"
         */
        Arrays.fill(dp[2], 1L);
        /**
         * L、P
         */
        sums[1] = 2L;
        /**
         * LL、LP、PL、PP
         */
        sums[2] = 4L;

        for (int i = 3; i <= n; i++) {
            /**
             * 如果第i-1天和第i天为"LL"，则第i-2天和第i-1天可能为"PL"
             */
            dp[i][0] = dp[i - 1][2];
            /**
             * 如果第i-1天和第i天为"LP"，则第i-2天和第i-1天可能为"PL"、"LL"
             */
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            /**
             * 如果第i-1天和第i天为"PL"，则第i-2天和第i-1天可能为"LP"、"PP"
             */
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            /**
             * 如果第i-1天和第i天为"PP"，则第i-2天和第i-1天可能为"LP"、"PP"
             */
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            sums[i] = (dp[i][0] + dp[i][1] + dp[i][2] + dp[i][3]) % mod;
        }
        /**
         * 在没有缺勤记录的情况下，n天可能的情况数
         */
        for (int i = 0; i < 4; i++) {
            result = (result + dp[n][i]) % mod;
        }
        /**
         * 第一天缺勤，则后面n-1天的情况数为dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]=sums[n-1]
         */
        result = (result + sums[n - 1]) % mod;
        /**
         * 第二天缺勤，则第一天可以为"P"、"L"，后面n-2天的情况数为dp[n-2][0]+dp[n-2][1]+dp[n-2][2]+dp[n-2][3]=sums[n-2]
         */
        result = (result + 2 * sums[n - 2]) % mod;
        /**
         * 最后一天缺勤，则前面n-1天的情况数为dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]=sums[n-1]
         */
        result = (result + sums[n - 1]) % mod;
        /**
         * 倒数第二天缺勤，则最后一天可以为"P"、"L"，前面n-2天的情况数为dp[n-2][0]+dp[n-2][1]+dp[n-2][2]+dp[n-2][3]=sums[n-2]，但
         * 是当总天数为3天时，倒数第二天就是第二天，避免重复计算
         */
        if (n > 3) {
            result = (result + 2 * sums[n - 2]) % mod;
        }
        /**
         * 第[3,n-2]天缺勤的情况，则缺勤日前最少有2天，最多有n-3天，缺勤日前i天的情况数为dp[i][0]+dp[i][1]+dp[i][2]+dp[i][3]
         * =sums[i]，缺勤日后n-1-i天的情况数为dp[n-1-i][0]+dp[n-1-i][1]+dp[n-1-i][2]+dp[n-1-i][3]=sums[n-1-i]
         */
        for (int i = 2; i <= n - 3; i++) {
            result = (result + sums[i] * sums[n - 1 - i]) % mod;
        }
        return (int) result;
    }
}
