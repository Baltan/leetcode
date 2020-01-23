package leetcode.algorithms;

/**
 * Description: 718. Maximum Length of Repeated Subarray
 *
 * @author Baltan
 * @date 2020-01-22 12:38
 */
public class FindLength {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 2, 1};
        int[] B1 = {3, 2, 1, 4, 7};
        System.out.println(findLength(A1, B1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode/"></a>
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int result = 0;
        int aLength = A.length;
        int bLength = B.length;
        /**
         * dp[i][j]表示A.subarray(i)和B.subarray(j)这两个子数组的最长公共前缀， 最长重复子数组就是
         * 所有公共前缀中最长的那一组
         */
        int[][] dp = new int[aLength + 1][bLength + 1];

        for (int i = aLength - 1; i >= 0; i--) {
            for (int j = bLength - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
