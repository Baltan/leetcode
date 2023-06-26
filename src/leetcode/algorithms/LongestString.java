package leetcode.algorithms;

/**
 * Description: 2745. Construct the Longest New String
 *
 * @author Baltan
 * @date 2023/6/25 23:27
 */
public class LongestString {
    public static void main(String[] args) {
        System.out.println(longestString(10, 27, 43));
        System.out.println(longestString(2, 5, 1));
        System.out.println(longestString(3, 2, 2));
    }

    public static int longestString(int x, int y, int z) {
        int result = 0;
        int total = x + y + z;
        /**
         * dp[i][j][k][0]表示由i个字符串"AA"、j个字符串"BB"、k个字符串"AB"拼接在一起，且以"AA"结尾的新字符串个数
         * dp[i][j][k][1]表示由i个字符串"AA"、j个字符串"BB"、k个字符串"AB"拼接在一起，且以"BB"结尾的新字符串个数
         * dp[i][j][k][2]表示由i个字符串"AA"、j个字符串"BB"、k个字符串"AB"拼接在一起，且以"AB"结尾的新字符串个数
         */
        boolean[][][][] dp = new boolean[x + 1][y + 1][z + 1][3];
        /**
         * 新字符串"AA"
         */
        dp[1][0][0][0] = true;
        /**
         * 新字符串"BB"
         */
        dp[0][1][0][1] = true;
        /**
         * 新字符串"AB"
         */
        dp[0][0][1][2] = true;
        /**
         * count表示新字符串中字符串"AA"、"BB"、"AB"的总个数
         */
        for (int count = 2; count <= total; count++) {
            /**
             * i表示新字符串中字符串"AA"的个数
             */
            for (int i = 0; i <= x; i++) {
                /**
                 * j表示新字符串中字符串"BB"的个数
                 */
                for (int j = 0; j <= y; j++) {
                    /**
                     * k表示新字符串中字符串"AB"的个数，且k∈[0,z]
                     */
                    int k = count - i - j;

                    if (k >= 0 && k <= z) {
                        if (i > 0) {
                            dp[i][j][k][0] = dp[i - 1][j][k][1] | dp[i - 1][j][k][2];

                            if (dp[i][j][k][0]) {
                                result = Math.max(result, count << 1);
                            }
                        }

                        if (j > 0) {
                            dp[i][j][k][1] = dp[i][j - 1][k][0];

                            if (dp[i][j][k][1]) {
                                result = Math.max(result, count << 1);
                            }
                        }

                        if (k > 0) {
                            dp[i][j][k][2] = dp[i][j][k - 1][1] | dp[i][j][k - 1][2];

                            if (dp[i][j][k][2]) {
                                result = Math.max(result, count << 1);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
