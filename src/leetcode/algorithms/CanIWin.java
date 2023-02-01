package leetcode.algorithms;

/**
 * Description: 464. Can I Win
 *
 * @author Baltan
 * @date 2023/1/31 14:33
 */
public class CanIWin {
    public static void main(String[] args) {
        System.out.println(canIWin(10, 40));
        System.out.println(canIWin(10, 11));
        System.out.println(canIWin(10, 0));
        System.out.println(canIWin(10, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/can-i-win/solutions/685543/464-wo-neng-ying-ma-dai-bei-wang-lu-de-d-qu1t/"></a>
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        /**
         * 先手直接选择数字maxChoosableInteger即可获胜
         */
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        /**
         * 所有数字之和小于desiredTotal，没有人可以获胜，先手必败
         */
        if (sum < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger], 0);
    }

    /**
     * @param maxChoosableInteger
     * @param desiredTotal        预期的总和
     * @param dp                  dp[i]表示可选数字状态用i的二进制值表示时，先手的结果
     * @param state               可选数字的状态，例如1001，表示所有数字中1和4已被使用，100表示所有数字中3已被使用……
     * @return
     */
    public static boolean dfs(int maxChoosableInteger, int desiredTotal, Boolean[] dp, int state) {
        /**
         * 当可选数字的状态为state时，先手的结果已计算过，不需要重复计算
         */
        if (dp[state] != null) {
            return dp[state];
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            /**
             * 说明数字i已被使用过，跳过数字i
             */
            if (((state >> (i - 1)) & 1) == 1) {
                continue;
            }
            /**
             * 1、如果先手选择了数字i后使得已选数字之和不小于desiredTotal，则先手获胜
             * 2、先手选择了数字i后，可选数字的状态变为了state，预期的总和变为了desiredTotal-i，此时的后手变成了下一轮选择的先手，如果他不
             * 能获胜，则先手获胜
             */
            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, dp, state | (1 << (i - 1)))) {
                dp[state] = true;
                return true;
            }
        }
        dp[state] = false;
        return false;
    }
}
