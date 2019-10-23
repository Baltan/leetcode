package leetcode.algorithms;

/**
 * Description: 740. Delete and Earn
 *
 * @author Baltan
 * @date 2019-10-23 09:30
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(deleteAndEarn(new int[]{5}));
        System.out.println(deleteAndEarn(new int[]{}));
        System.out.println(deleteAndEarn(
                new int[]{2, 2, 3, 3, 3, 4, 4, 3, 4, 6, 5, 6, 4, 2, 1, 4, 6, 8, 7, 5, 3, 2, 3, 5, 7,
                        8, 8, 4, 3, 2}));
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /**
         * 数组中的最大值
         */
        int max = 0;
        /**
         * 数组中的最小值
         */
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] count = new int[max + 1];

        for (int num : nums) {
            count[num]++;
        }

        int[] dp = new int[max + 1];
        dp[min] = min * count[min];

        for (int i = min + 1; i <= max; i++) {
            /**
             * 到数字i为止，如果选择删除数字i，可以获得的最大点数为dp[i-2]+i*count[i]，如果不删除数字i，可以获得的
             * 最大点数为dp[i-1]，两者较大值就是可以获得的最大点数。
             */
            dp[i] = Math.max(dp[i - 2] + i * count[i], dp[i - 1]);
        }
        return dp[max];
    }
}
