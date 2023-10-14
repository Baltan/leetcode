package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1799. Maximize Score After N Operations
 *
 * @author Baltan
 * @date 2023/10/14 13:58
 */
public class MaxScore5 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2}));
        System.out.println(maxScore(new int[]{3, 4, 6, 8}));
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximize-score-after-n-operations/solutions/2028835/by-lcbin-8uxm/"></a>
     *
     * @param nums
     * @return
     */
    public static int maxScore(int[] nums) {
        int length = nums.length;
        /**
         * 二进制值中从低到高第i位和第j位为1的值 -> nums[i]和nums[j]的最大公约数
         */
        Map<Integer, Integer> maskGcd = new TreeMap<>();
        /**
         * 假设i的二进制值从低到高第x1、x2、x3、……xk为1，dp[i]表示对nums[x1]、nums[x2]、nums[x3]、……、nums[xk]这几个数字进行操作后
         * 能得到的最大分数和，所求即为dp[2^length-1]
         */
        int[] dp = new int[1 << length];
        dp[0] = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                /**
                 * 令二进制值中从低到高第i位和第j位为1，计算nums[i]和nums[j]的最大公约数
                 */
                maskGcd.put((1 << i) + (1 << j), gcd(nums[i], nums[j]));
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int bits = Integer.bitCount(i);
            /**
             * 因为每次操作都是选择两个数字，所以操作结束后状态的二进制值中一定有偶数个1
             */
            if ((bits & 1) == 1) {
                continue;
            }
            /**
             * 遍历最后一次操作为mask的二进制值表示的两个数的情况
             */
            for (Map.Entry<Integer, Integer> entry : maskGcd.entrySet()) {
                int mask = entry.getKey();

                if (mask > i) {
                    break;
                }
                /**
                 * 操作后，mask的二进制中为1的数位在状态i的二进制值中也必须为1
                 */
                if ((mask & i) == mask) {
                    /**
                     * 当前操作的两个数字可以得到的分数为entry.getValue()*bits/2，前面操作可以得到的最大分数和为dp[i-mask]
                     */
                    dp[i] = Math.max(dp[i], dp[i - mask] + entry.getValue() * bits / 2);
                }
            }
        }
        return dp[(1 << length) - 1];
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
