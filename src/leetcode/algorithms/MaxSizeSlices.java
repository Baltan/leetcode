package leetcode.algorithms;

/**
 * Description: 1388. Pizza With 3n Slices
 *
 * @author Baltan
 * @date 2024/10/3 17:58
 */
public class MaxSizeSlices {
    public static void main(String[] args) {
        System.out.println(maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(maxSizeSlices(new int[]{8, 9, 8, 6, 1, 1}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/pizza-with-3n-slices/solutions/2397821/shi-jian-ji-bai-100kong-jian-wen-ding-95-fvy4/"></a>
     *
     * @param slices
     * @return
     */
    public static int maxSizeSlices(int[] slices) {
        /**
         * 因为所有元素构成一个环形，所以首尾元素slices[0]和slices[slices.length-1]两者之中至多选择一个。当不选择slices[0]时，结果等同
         * 于从slices[1]到slices[slices.length-1]这slices.length-1个元素中选择slices.length/3个彼此不相邻的元素；当不选择
         * slices[slices.length-1]时，结果等同于从slices[0]到slices[slices.length-2]这slices.length-1个元素中选择
         * slices.length/3个彼此不相邻的元素，两种方案选择和较大的即可
         */
        return Math.max(help(slices, 0, slices.length - 2), help(slices, 1, slices.length - 1));
    }

    /**
     * 从slices[start]到slices[end]这end-start+1个元素中选择slices.length/3个彼此不相邻的元素，求被选中元素之和的最大值
     *
     * @param slices
     * @param start
     * @param end
     * @return
     */
    public static int help(int[] slices, int start, int end) {
        int length = slices.length;
        /**
         * dp[i][j]表示从slices[start]到slices[i-1]这i-start个元素中选择j个彼此不相邻的元素，被选中元素之和的最大值
         */
        int[][] dp = new int[length + 1][length / 3 + 1];

        for (int i = start; i <= end; i++) {
            dp[i + 1][1] = Math.max(dp[i][1], slices[i]);
        }
        /**
         * 选择i个元素
         */
        for (int i = 2; i <= length / 3; i++) {
            /**
             * 因为要选择i个彼此不相邻的元素，所以至少要存在2*i-1个元素，即需要从元素slices[start+2*i-2]开始计算
             */
            for (int j = start + 2 * i - 2; j <= end; j++) {
                /**
                 * 如果不选择slices[j]，则dp[j+1][i]和dp[j][i]相同；如果选择了slices[j]，则上一个被选择的至多为slices[j-2]，因此
                 * dp[j+1][i]就是dp[j-1][i-1]的基础上加上slices[j]，两种方案选择和较大的即可
                 */
                dp[j + 1][i] = Math.max(dp[j][i], dp[j - 1][i - 1] + slices[j]);
            }
        }
        return dp[end + 1][length / 3];
    }
}
