package leetcode.algorithms;

/**
 * Description: 650. 2 Keys Keyboard
 *
 * @author Baltan
 * @date 2019-10-24 09:47
 */
public class MinSteps {
    public static void main(String[] args) {
        System.out.println(minSteps(1));
        System.out.println(minSteps(2));
        System.out.println(minSteps(3));
        System.out.println(minSteps(4));
        System.out.println(minSteps(5));
        System.out.println(minSteps(6));
        System.out.println(minSteps(7));
        System.out.println(minSteps(8));
        System.out.println(minSteps(9));
        System.out.println(minSteps(10));
        System.out.println(minSteps(25));
        System.out.println(minSteps(50));
        System.out.println(minSteps(97));
        System.out.println(minSteps(100));
        System.out.println(minSteps(499));
        System.out.println(minSteps(500));
        System.out.println(minSteps(1000));
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            /**
             * 如果i是j的倍数，那么i可以通过dp[j]，复制1次，再粘贴j/i-1次获得，即dp[j]+i/j
             */
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
