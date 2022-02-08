package leetcode.algorithms;

/**
 * Description: 1959. Minimum Total Space Wasted With K Resizing Operations
 *
 * @author Baltan
 * @date 2022/2/7 12:59
 */
public class MinSpaceWastedKResizing {
    public static void main(String[] args) {
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20}, 0));
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-total-space-wasted-with-k-resizing-operations/solution/java-yu-chu-li-dong-tai-gui-hua-jian-dan-js9e/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int minSpaceWastedKResizing(int[] nums, int k) {
        int length = nums.length;
        /**
         * dp[i][j]表示将nums[0]到nums[i]这部分元素调整j次时的最小总浪费空间，题目所求即为dp[length-1][k]，对于dp[i][j]，
         * 其最小值应为dp[0][j-1]+waste[1][i]、dp[1][j-1]+waste[2][i]、……、dp[i-1][j-1]+waste[i][i]中的最小值，其
         * 中waste[x][y]（x<=y）表示nums[x]到nums[y]这部分元素在没有调整次数的情况下的最小浪费空间，即
         * (y-x+1)*max(nums[x],nums[x+1],……,nums[y])-(nums[x]+nums[x+1]+……+nums[y])
         */
        int[][] dp = new int[length][k + 1];
        int[][] waste = new int[length][length];
        /**
         * 计算所有waste[x][y]的值，即(y-x+1)*max(nums[x],nums[x+1],……,nums[y])-(nums[x]+nums[x+1]+……+nums[y])，
         * 其中x<=y
         */
        for (int i = 0; i < length; i++) {
            /**
             * nums[i]到nums[j]这部分元素之和
             */
            int sum = 0;
            /**
             * nums[i]到nums[j]这部分元素的最大值
             */
            int max = Integer.MIN_VALUE;

            for (int j = i; j < length; j++) {
                sum += nums[j];
                max = Math.max(max, nums[j]);
                waste[i][j] = (j - i + 1) * max - sum;
            }
        }
        /**
         * nums[0]到nums[i]这部分元素之和
         */
        int sum = 0;
        /**
         * nums[0]到nums[i]这部分元素的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * 计算所有dp[i][0]的值，即(i+1)*max(nums[0],nums[1],……,nums[i])-(nums[0]+nums[1]+……+nums[i])
         */
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
            dp[i][0] = (i + 1) * max - sum;
        }
        /**
         * 计算nums[0]到nums[i]这部分元素调整j次时的最小总浪费空间，其中i>=j，因为如果可以调整的次数大于元素的数量，最小总浪费
         * 空间肯定为0
         */
        for (int j = 1; j <= k; j++) {
            for (int i = j; i < length; i++) {
                /**
                 * dp[0][j-1]+waste[1][i]、dp[1][j-1]+waste[2][i]、……、dp[i-1][j-1]+waste[i][i]中的最小值
                 */
                int min = Integer.MAX_VALUE;
                /**
                 * 计算dp[0][j-1]+waste[1][i]、dp[1][j-1]+waste[2][i]、……、dp[i-1][j-1]+waste[i][i]中的最小值
                 */
                for (int l = 0; l < i; l++) {
                    min = Math.min(min, dp[l][j - 1] + waste[l + 1][i]);
                }
                dp[i][j] = min;
            }
        }
        return dp[length - 1][k];
    }
}
