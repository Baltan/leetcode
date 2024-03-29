package leetcode.algorithms;

/**
 * Description: 486. Predict the Winner
 *
 * @author Baltan
 * @date 2019-09-26 09:05
 * @see PredictTheWinner
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIII
 * @see StoneGameIX
 * @see StoneGameVI
 * @see StoneGameVII
 */
public class PredictTheWinner1 {
    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1}));
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(
                new int[]{1, 5, 233, 7, 43, 23, 5, 7, 34, 21, 86, 231, 5, 2, 67, 32, 7, 13, 65, 87}));
    }

    public static boolean predictTheWinner(int[] nums) {
        /**
         * 参考：
         * <a href="https://leetcode-cn.com/problems/predict-the-winner/solution/san-chong-dpsi-lu-jie-jue-duo-si-lu-by-a-fei-8/"></a>
         *
         * dp[i][j]表示对于数组的第i个元素到第j个元素（包含）这段数字"先手获得的最大和"和"后手获得的总和"的差值，
         * 例如初始数组nums为[1, 5, 233, 7]：
         * 1、dp[i][i]的值等于nums[i]，因为先手拿走唯一的数字后，后手没有数字可拿获得的总和只能为0，得到dp：
         * [1,0,0  ,0]
         * [0,5,0  ,0]
         * [0,0,233,0]
         * [0,0,0  ,7]
         * 2、对于dp[i][j]的值先手有两种取法，先取nums[i]，可以得到结果差值为nums[i]-dp[i+1][j]；先取nums[j]，
         * 可以得到结果的差值为nums[j]-dp[i][j-1]，两个结果取较大值，遍历更新dp：
         * [1,0,0  ,0]     [1,4,0  ,0  ]     [1,4,229,0   ]     [1,4,229,222 ]
         * [0,5,0  ,0]     [0,5,228,0  ]     [0,5,228,-221]     [0,5,228,-221]
         * [0,0,233,0]     [0,0,233,226]     [0,0,233,226 ]     [0,0,233,226 ]
         * [0,0,0  ,7]     [0,0,0  ,7  ]     [0,0,0  ,7   ]     [0,0,0  ,7   ]
         * 3、判断dp右上角的值dp[0][length-1]是否不小于0即可
         */
        int length = nums.length;
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }

        for (int j = 1; j < length; j++) {
            int i = 0;
            int diff = j - i;

            while (i + diff < length) {
                dp[i][i + diff] =
                        Math.max(nums[i] - dp[i + 1][i + diff], nums[i + diff] - dp[i][i + diff - 1]);
                i++;
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
