package leetcode.algorithms;

/**
 * Description: 486. Predict the Winner
 *
 * @author Baltan
 * @date 2019-09-26 09:05
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIII
 * @see StoneGameIX
 * @see StoneGameVII
 */
public class PredictTheWinner {
    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1}));
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(
                new int[]{1, 5, 233, 7, 43, 23, 5, 7, 34, 21, 86, 231, 5, 2, 67, 32, 7, 13, 65, 87}));
    }

    public static boolean predictTheWinner(int[] nums) {
        int sum1 = max(nums);
        int length = nums.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return sum1 >= sum - sum1;
    }

    public static int max(int[] nums) {
        /**
         * 计算对于每一个数组，先手可以获得的最大和，如果数组只有一项，先手拿走这一项即可；如果数组有多项，
         * 先手可以先拿走第一项或最后一项，对于剩下的数组，后手成为了先手，剩下的数组总和减去后手可以获得
         * 的最大和即为剩下数组先手可以获得的总和，加上先手先拿的初始数组第一项或最后一项，两种情况取较大
         * 值即为游戏先手玩家1可以取得的最大和
         */
        if (nums.length == 1) {
            return nums[0];
        } else {
            int length = nums.length;
            int[] subArray1 = new int[length - 1];
            int[] subArray2 = new int[length - 1];
            int sum = 0;

            sum += nums[0];
            subArray1[0] = nums[0];

            for (int i = 1; i < length - 1; i++) {
                sum += nums[i];
                subArray1[i] = nums[i];
                subArray2[i - 1] = nums[i];
            }

            sum += nums[length - 1];
            subArray2[length - 2] = nums[length - 1];
            return Math.max(nums[0] + sum - max(subArray2), nums[length - 1] + sum - max(subArray1));
        }
    }
}
