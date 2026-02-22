package leetcode.algorithms;

/**
 * Description: 3776. Minimum Moves to Balance Circular Array
 *
 * @author baltan
 * @date 2026/2/3 09:02
 */
public class MinMoves6 {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{5, 1, -4}));
        System.out.println(minMoves(new int[]{1, 2, -5, 2}));
        System.out.println(minMoves(new int[]{-3, 2}));
    }

    public static long minMoves(int[] balance) {
        long result = 0L;
        int length = balance.length;
        /**
         * 所有账户的总金额
         */
        long sum = 0L;
        /**
         * 初始余额为负数的账户的索引值
         */
        int negativeIndex = -1;

        for (int i = 0; i < length; i++) {
            sum += balance[i];

            if (balance[i] < 0) {
                negativeIndex = i;
            }
        }
        /**
         * 所有账户的总金额为负数，则不可能使所有账户的余额都非负
         */
        if (sum < 0) {
            return -1;
        }
        /**
         * 初始不存在余额为负数的账户，不需要移动余额
         */
        if (negativeIndex == -1) {
            return 0;
        }
        /**
         * 从距离balance[negativeIndex]最近的账户开始，由近到远将余额转移到balance[negativeIndex]账户中，直到它的余额非负
         */
        for (int i = 1; balance[negativeIndex] < 0; i++) {
            /**
             * 从左右两个距离相同的账户转移到账户balance[negativeIndex]的金额的总数
             */
            int count = Math.min(balance[(negativeIndex - i + length) % length] + balance[(negativeIndex + i) % length], -balance[negativeIndex]);
            result += (long) count * i;
            balance[negativeIndex] += count;
        }
        return result;
    }
}
