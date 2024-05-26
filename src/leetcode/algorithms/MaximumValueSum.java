package leetcode.algorithms;

/**
 * Description: 3068. Find the Maximum Sum of Node Values
 *
 * @author Baltan
 * @date 2024/5/26 13:29
 */
public class MaximumValueSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int k1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}};
        System.out.println(maximumValueSum(nums1, k1, edges1));

        int[] nums2 = {2, 3};
        int k2 = 7;
        int[][] edges2 = {{0, 1}};
        System.out.println(maximumValueSum(nums2, k2, edges2));

        int[] nums3 = {7, 7, 7, 7, 7, 7};
        int k3 = 3;
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}};
        System.out.println(maximumValueSum(nums3, k3, edges3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-the-maximum-sum-of-node-values/solutions/2664309/liang-chong-fang-fa-shu-xing-dp-xian-xin-lh6b/"></a>
     *
     * @param nums
     * @param k
     * @param edges
     * @return
     */
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int length = nums.length;
        /**
         * 无向树中任意两个节点组成的路径，如果对这些节点上相邻的两点一一进行异或k运算，则最终只有首尾两个节点各自异或k，中间的其余节点因为各
         * 自异或k两次，最终没有变化。并且每次选择一条路径进行上述操作后，都会有0个或2个节点和初始时相比，发生了异或k的变化。所以题目等同于在
         * 数组nums中选择偶数个数字，将这些选中数字进行异或k运算，其余数字不变，最终使得所有数字之和最大
         *
         * dp[i][0]表示在数组nums的前i个数中，对偶数个数字进行异或k运算后，这i个数字之和的最大值
         * dp[i][1]表示在数组nums的前i个数中，对奇数个数字进行异或k运算后，这i个数字之和的最大值
         * 题目所求即为dp[length][0]
         */
        long[][] dp = new long[length + 1][2];
        /**
         * 初始化状态：数组nums中一个数字都不选（也是选择了偶数个数字的一种情况），则元素之和为0
         */
        dp[0][0] = 0;
        /**
         * 初始化状态：不存在一个数字都不选并且是对奇数个数字进行异或k运算的情况，初始化为一个极小值
         */
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <= length; i++) {
            /**
             * 如果不对当前数字nums[i-1]进行异或k运算，则dp[i][0]=dp[i-1][0]+nums[i-1]或者dp[i][1]=dp[i-1][1]+nums[i-1]；如果对
             * 当前数字nums[i-1]进行异或k运算，则dp[i][0]=dp[i-1][1]+(nums[i-1]^k)或者dp[i][1]=dp[i-1][0]+(nums[i-1]^k)。
             * dp[i][0]和dp[i][1]都要在各自的两种情况中选择和较大的情况
             */
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][1] + (nums[i - 1] ^ k));
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i - 1], dp[i - 1][0] + (nums[i - 1] ^ k));
        }
        return dp[length][0];
    }
}
