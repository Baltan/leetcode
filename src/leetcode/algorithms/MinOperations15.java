package leetcode.algorithms;

/**
 * Description: 2870. Minimum Number of Operations to Make Array Empty
 *
 * @author baltan
 * @date 2023/10/2 22:55
 */
public class MinOperations15 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));
        System.out.println(minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println(minOperations(new int[]{2, 1, 2, 2, 3, 3}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        /**
         * 数组nums中出现次数最多的数字出现的频数
         */
        int most = 0;
        /**
         * counts[i]表示数组nums中数字i出现的频数，根据题意，num∈[1,1000000]
         */
        int[] counts = new int[1000001];

        for (int num : nums) {
            counts[num]++;
            most = Math.max(most, counts[num]);
        }
        /**
         * dp[i]表示出现i次的数字完全被删除最少需要的操作次数
         */
        int[] dp = new int[most + 1];

        for (int i = 2; i <= most; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
                continue;
            }
            /**
             * 只能通过两次操作1被删除
             */
            if (i == 4) {
                dp[i] = 2;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            dp[i] = Math.min(dp[i], 1 + dp[i - 2]);
            dp[i] = Math.min(dp[i], 1 + dp[i - 3]);
        }

        for (int count : counts) {
            if (count == 0) {
                continue;
            }
            /**
             * 只出现1次的数字没法通过操作1和操作2被删除
             */
            if (count == 1) {
                return -1;
            }
            result += dp[count];
        }
        return result;
    }
}
