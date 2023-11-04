package leetcode.algorithms;

/**
 * Description: 2919. Minimum Increment Operations to Make Array Beautiful
 *
 * @author Baltan
 * @date 2023/11/4 13:49
 */
public class MinIncrementOperations {
    public static void main(String[] args) {
        System.out.println(minIncrementOperations(new int[]{0, 0, 0, 1000000000}, 999999999));
        System.out.println(minIncrementOperations(new int[]{3, 7, 9, 6, 0}, 7));
        System.out.println(minIncrementOperations(new int[]{4, 3, 0}, 2));
        System.out.println(minIncrementOperations(new int[]{0, 5, 5}, 8));
        System.out.println(minIncrementOperations(new int[]{2, 3, 0, 0, 2}, 4));
        System.out.println(minIncrementOperations(new int[]{0, 1, 3, 3}, 5));
        System.out.println(minIncrementOperations(new int[]{1, 1, 2}, 1));
    }

    public static long minIncrementOperations(int[] nums, int k) {
        long result = Long.MAX_VALUE;
        long max = Long.MAX_VALUE;
        int length = nums.length;
        /**
         * dp[i]表示令数组nums的前缀子数组成为美丽数组，并且最后三个数字的状态为i时，需要的最少操作次数，当无法达到状态i时，dp[i]=max。
         * 对于状态i的二进制值：
         * 0b001表示prefixes[-3]<k，prefixes[-2]<k，prefixes[-1]>=k；
         * 0b010表示prefixes[-3]<k，prefixes[-2]>=k，prefixes[-1]<k；
         * 0b011表示prefixes[-3]<k，prefixes[-2]>=k，prefixes[-1]>=k；
         * 0b100表示prefixes[-3]>=k，prefixes[-2]<k，prefixes[-1]<k；
         * 0b101表示prefixes[-3]>=k，prefixes[-2]<k，prefixes[-1]>=k；
         * 0b110表示prefixes[-3]>=k，prefixes[-2]>=k，prefixes[-1]<k；
         * 0b111表示prefixes[-3]>=k，prefixes[-2]>=k，prefixes[-1]>=k。
         */
        long[] dp = new long[8];
        dp[0b001] = nums[0] < k && nums[1] < k ? Math.max(0L, k - nums[2]) : max;
        dp[0b010] = nums[0] < k && nums[2] < k ? Math.max(0L, k - nums[1]) : max;
        dp[0b011] = nums[0] < k ? Math.max(0L, k - nums[1]) + Math.max(0L, k - nums[2]) : max;
        dp[0b100] = nums[1] < k && nums[2] < k ? Math.max(0L, k - nums[0]) : max;
        dp[0b101] = nums[1] < k ? Math.max(0L, k - nums[0]) + Math.max(0L, k - nums[2]) : max;
        dp[0b110] = nums[2] < k ? Math.max(0L, k - nums[0]) + Math.max(0L, k - nums[1]) : max;
        dp[0b111] = Math.max(0L, k - nums[0]) + Math.max(0L, k - nums[1]) + Math.max(0L, k - nums[2]);

        for (int i = 3; i < length; i++) {
            long[] temp = new long[8];
            /**
             * 状态0b001只可能由上一个前缀子数组的状态0b100得到，只需令nums[i]>=k
             */
            temp[0b001] = dp[0b100] != max ? dp[0b100] + Math.max(0L, k - nums[i]) : max;
            /**
             * 状态0b010可能由上一个前缀子数组的状态0b001和0b101得到，只需令nums[i]<k
             */
            temp[0b010] = dp[0b001] != max && nums[i] < k ? dp[0b001] : max;
            temp[0b010] = Math.min(temp[0b010], dp[0b101] != max && nums[i] < k ? dp[0b101] : max);
            /**
             * 状态0b011可能由上一个前缀子数组的状态0b011和0b111得到，只需令nums[i]>=k
             */
            temp[0b011] = dp[0b001] != max ? dp[0b001] + Math.max(0L, k - nums[i]) : max;
            temp[0b011] = Math.min(temp[0b011], dp[0b101] != max ? dp[0b101] + Math.max(0L, k - nums[i]) : max);
            /**
             * 状态0b100可能由上一个前缀子数组的状态0b010和0b110得到，只需令nums[i]<k
             */
            temp[0b100] = dp[0b010] != max && nums[i] < k ? dp[0b010] : max;
            temp[0b100] = Math.min(temp[0b100], dp[0b110] != max ? dp[0b110] : max);
            /**
             * 状态0b101可能由上一个前缀子数组的状态0b010和0b110得到，只需令nums[i]>=k
             */
            temp[0b101] = dp[0b010] != max ? dp[0b010] + Math.max(0L, k - nums[i]) : max;
            temp[0b101] = Math.min(temp[0b101], dp[0b110] != max ? dp[0b110] + Math.max(0L, k - nums[i]) : max);
            /**
             * 状态0b110可能由上一个前缀子数组的状态0b011和0b111得到，只需令nums[i]<k
             */
            temp[0b110] = dp[0b011] != max && nums[i] < k ? dp[0b011] : max;
            temp[0b110] = Math.min(temp[0b110], dp[0b111] != max && nums[i] < k ? dp[0b111] : max);
            /**
             * 状态0b111可能由上一个前缀子数组的状态0b011和0b111得到，只需令nums[i]>=k
             */
            temp[0b111] = dp[0b011] != max ? dp[0b011] + Math.max(0L, k - nums[i]) : max;
            temp[0b111] = Math.min(temp[0b111], dp[0b111] != max ? dp[0b111] + Math.max(0L, k - nums[i]) : max);
            dp = temp;
        }
        /**
         * 从令数组nums成为美丽数组，并且最后三个数字的状态为i的7种情况中选择操作次数最少的一种
         */
        for (int i = 0b001; i <= 0b111; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;
    }
}
