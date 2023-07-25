package leetcode.algorithms;

/**
 * Description: 2786. Visit Array Positions to Maximize Score
 *
 * @author Baltan
 * @date 2023/7/24 22:57
 */
public class MaxScore4 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{9, 58, 17, 54, 91, 90, 32, 6, 13, 67, 24, 80, 8, 56, 29, 66, 85, 38, 45, 13, 20, 73, 16, 98, 28, 56, 23, 2, 47, 85, 11, 97, 72, 2, 28, 52, 33}, 90));
        System.out.println(maxScore(new int[]{8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79}, 74));
        System.out.println(maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
        System.out.println(maxScore(new int[]{2, 4, 6, 8}, 3));
    }

    public static long maxScore(int[] nums, int x) {
        int length = nums.length;
        /**
         * 偶数位置的最大得分，如果不存在跳到偶数位置的情况，标记最大得分为Long.MIN_VALUE
         */
        long maxEvenScore = nums[0] % 2 == 0 ? nums[0] : Long.MIN_VALUE;
        /**
         * 奇数位置的最大得分，如果不存在跳到奇数位置的情况，标记最大得分为Long.MIN_VALUE
         */
        long maxOddScore = nums[0] % 2 != 0 ? nums[0] : Long.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            if (nums[i] % 2 == 0) {
                /**
                 * 从之前偶数位置的最大得分处跳到nums[i]，如果之前不存在偶数位置，则标记从偶数位置跳到nums[i]的最大得分为Long.MIN_VALUE
                 */
                long fromEvenScore = maxEvenScore == Long.MIN_VALUE ? Long.MIN_VALUE : maxEvenScore + nums[i];
                /**
                 * 从之前奇数位置的最大得分处跳到nums[i]，因为和nums[i]奇偶性不同，所以减去x。如果之前不存在奇数位置，则标记从奇数位置跳
                 * 到nums[i]的最大得分为Long.MIN_VALUE
                 */
                long fromOddScore = maxOddScore == Long.MIN_VALUE ? Long.MIN_VALUE : maxOddScore + nums[i] - x;
                /**
                 * 因为当前值nums[i]为偶数，所以可以更新偶数位置的最大得分
                 */
                maxEvenScore = Math.max(maxEvenScore, Math.max(fromEvenScore, fromOddScore));
            } else {
                /**
                 * 从之前偶数位置的最大得分处跳到nums[i]，因为和nums[i]奇偶性不同，所以减去x。如果之前不存在偶数位置，则标记从偶数位置跳
                 * 到nums[i]的最大得分为Long.MIN_VALUE
                 */
                long fromEvenScore = maxEvenScore == Long.MIN_VALUE ? Long.MIN_VALUE : maxEvenScore + nums[i] - x;
                /**
                 * 从之前奇数位置的最大得分处跳到nums[i]，如果之前不存在奇数位置，则标记从奇数位置跳到nums[i]的最大得分为Long.MIN_VALUE
                 */
                long fromOddScore = maxOddScore == Long.MIN_VALUE ? Long.MIN_VALUE : maxOddScore + nums[i];
                /**
                 * 因为当前值nums[i]为奇数，所以可以更新奇数位置的最大得分
                 */
                maxOddScore = Math.max(maxOddScore, Math.max(fromEvenScore, fromOddScore));
            }
        }
        return Math.max(maxEvenScore, maxOddScore);
    }
}
