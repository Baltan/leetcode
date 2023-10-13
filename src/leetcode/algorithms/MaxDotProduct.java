package leetcode.algorithms;

/**
 * Description: 1458. Max Dot Product of Two Subsequences
 *
 * @author Baltan
 * @date 2023/10/12 23:07
 */
public class MaxDotProduct {
    public static void main(String[] args) {
        System.out.println(maxDotProduct(new int[]{-3, -8, 3, -10, 1, 3, 9}, new int[]{9, 2, 3, 7, -9, 1, -8, 5, -1, -1}));
        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/max-dot-product-of-two-subsequences/solutions/519006/liang-ge-zi-xu-lie-de-zui-da-dian-ji-by-jwqux/"></a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        /**
         * dp[i][j]表示数组nums1的前i+1个数构成的前缀子数组和数组nums2的前j+1个数构成的前缀子数组的最大点积
         */
        int[][] dp = new int[length1][length2];
        dp[0][0] = nums1[0] * nums2[0];
        /**
         * 计算nums1[0]和数组nums2的前缀子数组的最大点积
         */
        for (int i = 1; i < length2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }
        /**
         * 计算数组nums1的前缀子数组和nums2[0]的最大点积
         */
        for (int i = 1; i < length1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }
        /**
         * 计算数组nums1的前i+1个数构成的前缀子数组和数组nums2的前j+1个数构成的前缀子数组的最大点积
         */
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                /**
                 * nums1[i]和nums2[j]都不在最大点积的非空子序列中
                 */
                dp[i][j] = dp[i - 1][j - 1];
                /**
                 * nums1[i]不在最大点积的非空子序列中，nums2[j]在最大点积的非空子序列中
                 */
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                /**
                 * nums1[i]在最大点积的非空子序列中，nums2[j]不在最大点积的非空子序列中
                 */
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                /**
                 * nums1[i]和nums2[j]都在最大点积的非空子序列中，因为只需保证两个子序列非空即可，所以nums1[i]和nums2[j]之前可以包含其
                 * 他数字，也可以不包含其他数字
                 */
                dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
            }
        }
        return dp[length1 - 1][length2 - 1];
    }
}
