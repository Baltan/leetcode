package leetcode.algorithms;

/**
 * Description: 935. Knight Dialer
 *
 * @author Baltan
 * @date 2019-07-30 09:56
 */
public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(4));
        System.out.println(knightDialer(5));
        System.out.println(knightDialer(6));
        System.out.println(knightDialer(7));
        System.out.println(knightDialer(8));
        System.out.println(knightDialer(9));
        System.out.println(knightDialer(10));
        System.out.println(knightDialer(5000));
    }

    public static int knightDialer(int N) {
        double result = 0;
        /**
         * arr每一个索引index代表的号码下一步可以跳到arr[index]数组中的号码上
         */
        int[][] arr = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        /**
         * dp[i+1][j]表示第i个数字为j的可能有dp[i+1][j]种情况
         */
        double[][] dp = new double[N + 1][10];
        /**
         * 如果只有一个号码，那么在每个号码上的可能性都只有1种
         */
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N - 1; i++) {
            /**
             * 如果走完第x步，在0-9上依次有k0-k9种类可能，那么对于第x+1步：
             * 如果第x+1步落在0上，那么第x步一定落在4或6上，所以第x+1步落在0上有(k4+k6)种可能，
             * 如果第x+1步落在1上，那么第x步一定落在6或8上，所以第x+1步落在1上有(k6+k8)种可能，
             * ……
             * 如果第x+1步落在9上，那么第x步一定落在2或4上，所以第x+1步落在0上有(k2+k4)种可能。
             *
             * 换句话说，
             * 如果第x步落在0上，那么第x+1步落在4或6上各有k0中可能，
             * 如果第x步落在1上，那么第x+1步落在6或8上各有k1中可能，
             * ……
             * 如果第x步落在9上，那么第x+1步落在2或4上各有k9中可能，
             */
            for (int j = 0; j < 10; j++) {
                for (int k : arr[j]) {
                    dp[i + 1][k] += dp[i][j];
                }
            }
            /**
             * 每一步走完后，对每个号码上的情况总数按题意取模，避免后续计算值超过double类型上限
             */
            for (int j = 0; j < 10; j++) {
                dp[i + 1][j] = dp[i + 1][j] % 1000000007;
            }
        }
        /**
         * 将第N个号码处为0-9的所有值相加即为所求
         */
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        return (int) (result % 1000000007);
    }
}
