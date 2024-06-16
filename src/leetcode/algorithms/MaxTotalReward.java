package leetcode.algorithms;

/**
 * Description: 3180. Maximum Total Reward Using Operations I
 *
 * @author Baltan
 * @date 2024/6/16 14:14
 */
public class MaxTotalReward {
    public static void main(String[] args) {
        System.out.println(maxTotalReward(new int[]{6, 13, 9, 19}));
        System.out.println(maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    public static int maxTotalReward(int[] rewardValues) {
        int result = Integer.MIN_VALUE;
        /**
         * isVisited[i]表示数组rewardValues中是否存在数字i
         */
        boolean[] isVisited = new boolean[2001];
        /**
         * 数组rewardValues中不同数字的个数
         */
        int count = 0;

        for (int rewardValue : rewardValues) {
            if (!isVisited[rewardValue]) {
                count++;
            }
            isVisited[rewardValue] = true;
        }
        /**
         * 升序保存数组rewardValues中的不同数字，因为每次选择一个数字必须保证它大于已选数字之和，所以不可能选择到同样的数字
         */
        int[] values = new int[count];
        int index = 0;

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i]) {
                values[index] = i;
                index++;
            }
        }
        /**
         * dp[i][j]表示判断过数字rewardValues[i]是否选择之后，能否使得已选数字之和为j
         */
        boolean[][] dp = new boolean[count][values[count - 1] * 2];
        /**
         * 初始化不选rewardValues[0]
         */
        dp[0][0] = true;
        /**
         * 初始化选择rewardValues[0]
         */
        dp[0][values[0]] = true;

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i - 1][j]) {
                    /**
                     * 不选values[i]
                     */
                    dp[i][j] = true;
                    /**
                     * 只有在此前已选数字之和j小于values[i]的情况下，才有可能选择values[i]
                     */
                    if (values[i] > j) {
                        dp[i][j + values[i]] = true;
                    }
                }
            }
        }
        /**
         * 判断过所有数字之后，选择已选数字之和的最大值即可
         */
        for (int i = dp[count - 1].length - 1; i >= 0; i--) {
            if (dp[count - 1][i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
