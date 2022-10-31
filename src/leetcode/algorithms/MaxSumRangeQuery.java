package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1589. Maximum Sum Obtained of Any Permutation
 *
 * @author Baltan
 * @date 2022/10/16 12:23
 */
public class MaxSumRangeQuery {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[][] requests1 = {{1, 3}, {0, 1}};
        System.out.println(maxSumRangeQuery(nums1, requests1));

        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int[][] requests2 = {{0, 1}};
        System.out.println(maxSumRangeQuery(nums2, requests2));

        int[] nums3 = {1, 2, 3, 4, 5, 10};
        int[][] requests3 = {{0, 2}, {1, 3}, {1, 1}};
        System.out.println(maxSumRangeQuery(nums3, requests3));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-sum-obtained-of-any-permutation/solutions/426633/tan-xin-chai-fen-shu-zu-by-fisher12/"></a>
     *
     * @param nums
     * @param requests
     * @return
     */
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        long result = 0L;
        int mod = 1000000007;
        int length = nums.length;
        /**
         * counts[i]表示nums[i]在所有查询结果之和中被累加的次数
         */
        int[] counts = new int[length];
        /**
         * 为了求得数组counts，定义数组counts的差分数组diffs，则
         * 当i≠0时，diffs[0]=counts[0],
         * 当i=0时，diffs[i]=counts[i]-counts[i-1]。
         * 由差分数组[diffs[0],diffs[1],diffs[2],……,diffs[length]]可以反推出数组counts为
         * [diffs[0],diffs[1]+diffs[0],diffs[2]+diffs[1]+diffs[0],……,diffs[length-1]+diffs[length-2]+……+diffs[0]]。
         * 当对数组counts在[x,y]区间上的所有元素都加1时，可以在差分数组diffs上对diffs[x]加1，对diffs[y+1]减1（如果y==length-1就不需要
         * 减1操作了，或者可以将差分数组diffs的长度多定义1个单位）。
         */
        int[] diffs = new int[length + 1];
        Arrays.sort(nums);
        /**
         * 计算获得差分数组diffs
         */
        for (int[] request : requests) {
            diffs[request[0]]++;
            diffs[request[1] + 1]--;
        }
        /**
         * 计算获得数组counts
         */
        counts[0] = diffs[0];

        for (int i = 1; i < length; i++) {
            counts[i] = diffs[i] + counts[i - 1];
        }
        Arrays.sort(counts);
        /**
         * 在被累加最多次的位置放置数组nums中的最大值，以此类推，在被累加最少次的位置放置数组nums中的最小值
         */
        for (int i = 0; i < length; i++) {
            result = (result + 1L * nums[i] * counts[i]) % mod;
        }
        return (int) result;
    }
}
