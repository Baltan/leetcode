package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 823. Binary Trees With Factors
 *
 * @author Baltan
 * @date 2019-07-19 12:00
 */
public class NumFactoredBinaryTrees1 {
    public static void main(String[] args) {
//        int[] A1 = {2, 4};
//        System.out.println(numFactoredBinaryTrees(A1));
//
//        int[] A2 = {2, 4, 5, 10};
//        System.out.println(numFactoredBinaryTrees(A2));
//
//        int[] A3 = {2, 4, 8, 16};
//        System.out.println(numFactoredBinaryTrees(A3));
//
//        int[] A4 = {2, 3, 4, 6, 8, 12, 16, 24, 32};
//        System.out.println(numFactoredBinaryTrees(A4));

        int[] A5 =
                {46, 144, 5040, 4488, 544, 380, 4410, 34, 11, 5, 3063808, 5550, 34496, 12, 540, 28, 18, 13, 2,
                        1056, 32710656, 31, 91872, 23, 26, 240, 18720, 33, 49, 4, 38, 37, 1457, 3, 799,
                        557568, 32, 1400, 47, 10, 20774, 1296, 9, 21, 92928, 8704, 29, 2162, 22, 1883700,
                        49588, 1078, 36, 44, 352, 546, 19, 523370496, 476, 24, 6000, 42, 30, 8, 16262400,
                        61600, 41, 24150, 1968, 7056, 7, 35, 16, 87, 20, 2730, 11616, 10912, 690, 150, 25, 6,
                        14, 1689120, 43, 3128, 27, 197472, 45, 15, 585, 21645, 39, 40, 2205, 17, 48, 136};
        System.out.println(numFactoredBinaryTrees(A5));
    }

    public static int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i) {
            index.put(A[i], i);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long x : dp) {
            ans += x;
        }

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(A[i], dp[i]);
        }
        System.out.println(map);
        return (int) (ans % MOD);
    }
}
