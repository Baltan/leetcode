package leetcode.algorithms;

/**
 * Description: 2369. Check if There is a Valid Partition For The Array
 *
 * @author Baltan
 * @date 2023/1/11 15:53
 */
public class ValidPartition {
    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{4, 4, 4, 5, 6}));
        System.out.println(validPartition(new int[]{1, 1, 1, 2}));
        System.out.println(validPartition(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/solutions/1728735/by-endlesscheng-8y73/"></a>
     *
     * @param nums
     * @return
     */
    public static boolean validPartition(int[] nums) {
        int length = nums.length;
        /**
         * dp[i+1]表示子数组[nums[0],nums[1],……,nums[i]]是否存在有效划分
         */
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 0; i < length; i++) {
            /**
             * 子数组[nums[0],nums[1],……,nums[i-2]]存在有效划分，子数组[nums[i-1],nums[i]]恰由2个相等元素组成
             */
            boolean condition1 = i - 1 >= 0 && dp[i - 1] && nums[i] == nums[i - 1];
            /**
             * 子数组[nums[0],nums[1],……,nums[i-3]]存在有效划分，子数组[nums[i-2],nums[i-1],nums[i]]恰由3个相等元素组成或者恰由3个
             * 连续递增元素组成
             */
            boolean condition2 = i - 2 >= 0 && dp[i - 2] && ((nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) || (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2));

            if (condition1 || condition2) {
                dp[i + 1] = true;
            }
        }
        return dp[length];
    }
}
