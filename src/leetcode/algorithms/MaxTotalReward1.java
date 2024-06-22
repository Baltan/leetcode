package leetcode.algorithms;

import java.math.BigInteger;

/**
 * Description: 3181. Maximum Total Reward Using Operations II
 *
 * @author baltan
 * @date 2024/6/21 11:14
 * @see MaxTotalReward
 */
public class MaxTotalReward1 {
    public static void main(String[] args) {
        System.out.println(maxTotalReward(new int[]{6, 13, 9, 19}));
        System.out.println(maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/solutions/2805413/bitset-you-hua-0-1-bei-bao-by-endlessche-m1xn/"></a>
     *
     * @param rewardValues
     * @return
     */
    public static int maxTotalReward(int[] rewardValues) {
        /**
         * isVisited[i]表示数组rewardValues中是否存在数字i
         */
        boolean[] isVisited = new boolean[50001];
        /**
         * 数组rewardValues中不同数字的个数
         */
        int count = 0;
        /**
         * 数组rewardValues中的最大值
         */
        int max = Integer.MIN_VALUE;

        for (int rewardValue : rewardValues) {
            if (!isVisited[rewardValue]) {
                count++;
            }
            isVisited[rewardValue] = true;
            max = Math.max(max, rewardValue);
        }
        /**
         * 最大总奖励总是包含数组rewardValues中的最大值max，否则一定可以用max替换已选数字中的最大值得到更大的总奖励值。而选择max之前，已选
         * 数字之和至多为max-1，所以理论上的最大总奖励不可能大于max-1+max。如果数组rewardValues中存在数字max-1，或者存在两个数字之和为
         * max-1，则直接选择它们和max即可
         */
        for (int i = 0; i < max / 2; i++) {
            if (isVisited[max - 1] || (isVisited[i] && isVisited[max - 1 - i])) {
                return max * 2 - 1;
            }
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
         * conditions的二进制值从低到高第i位为1表示可以从数组values中获得总奖励i。初始状态下没有选择任何数字，总奖励值为0，将conditions
         * 二进制值的第0位置为1，即初始化conditions为1
         */
        BigInteger conditions = BigInteger.ONE;

        for (int value : values) {
            conditions = conditions.or(conditions.subtract(conditions.shiftRight(value).shiftLeft(value)).shiftLeft(value));
        }
        return conditions.bitLength() - 1;
    }
}
