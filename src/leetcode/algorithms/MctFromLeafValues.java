package leetcode.algorithms;

/**
 * Description: 1130. Minimum Cost Tree From Leaf Values
 *
 * @author Baltan
 * @date 2022/11/5 19:06
 */
public class MctFromLeafValues {
    public static void main(String[] args) {
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4}));
        System.out.println(mctFromLeafValues(new int[]{4, 11}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/solution/dan-diao-zhan-and-dong-tai-gui-hua-by-20-z0te/"></a>
     * 题目的实际含义就是将数组arr中相邻的数两两合并，计算他们的乘积之和，两数合并后会剩下两数中的较大值，计算将前面得到的所有乘积之和相加可能得
     * 到的最小值。
     *
     * @param arr
     * @return
     */
    public static int mctFromLeafValues(int[] arr) {
        int length = arr.length;
        /**
         * maxValues[i][j]表示arr[i]到arr[j]这部分元素中的最大值（包括arr[i]和arr[j]）
         */
        int[][] maxValues = new int[length][length];
        /**
         * dp[i][j]表示arr[i]到arr[j]这部分元素生成符合条件的二叉树后，每个非叶节点的值的最小可能总和（包括arr[i]和arr[j]），则状态转移方
         * 程为dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+maxVal[i][k]*maxVal[k+1][j])
         */
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            maxValues[i][i] = arr[i];

            for (int j = i + 1; j < length; j++) {
                maxValues[i][j] = Math.max(maxValues[i][j - 1], arr[j]);
            }
        }
        /**
         * 数组的长度范围为[2,length]
         */
        for (int interval = 2; interval <= length; interval++) {
            for (int i = 0; i < length; i++) {
                int j = i + interval - 1;

                if (j == length) {
                    break;
                }
                dp[i][j] = Integer.MAX_VALUE;
                /**
                 * 枚举arr[i]和arr[j]中的所有分界点arr[k]（包括arr[i]，不包括arr[j]）
                 */
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxValues[i][k] * maxValues[k + 1][j]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
