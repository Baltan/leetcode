package leetcode.algorithms;

/**
 * Description: 279. Perfect Squares
 *
 * @author Baltan
 * @date 2019-06-14 11:16
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(1));
        System.out.println(numSquares(2));
        System.out.println(numSquares(3));
        System.out.println(numSquares(4));
        System.out.println(numSquares(5));
        System.out.println(numSquares(6));
        System.out.println(numSquares(7));
        System.out.println(numSquares(8));
        System.out.println(numSquares(9));
        System.out.println(numSquares(10));
        System.out.println(numSquares(11));
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(234));
        System.out.println(numSquares(4223));
        System.out.println(numSquares(96000));
        System.out.println(numSquares(423242));
    }

    public static int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                int result = Integer.MAX_VALUE;

                for (int j = sqrt; j >= 1; j--) {
                    result = Math.min(result, 1 + dp[i - j * j]);
                }
                dp[i] = result;
            }
        }
        return dp[n];
    }
}
