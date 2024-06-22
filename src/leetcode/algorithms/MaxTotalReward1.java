package leetcode.algorithms;

import java.util.BitSet;

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

    public static int maxTotalReward(int[] rewardValues) {
        /**
         * isVisited[i]表示数组rewardValues中是否存在数字i
         */
        boolean[] isVisited = new boolean[50001];
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
         * 用一个二进制数表示数组values可能获得的各种总奖励值，如果能获得总奖励i，则bitSet[i]为true
         */
        BitSet bitSet = new BitSet(values[count - 1] * 2);
        /**
         * 初始状态下没有选择任何数字，总奖励值为0
         */
        bitSet.set(0);

        for (int value : values) {
            BitSet nextBitSet = new BitSet();
            nextBitSet.or(bitSet);
            int bitIndex;

            while ((bitIndex = bitSet.nextSetBit(0)) != -1 && bitIndex < value) {
                nextBitSet.set(bitIndex + value);
                bitSet.clear(bitIndex);
            }
            bitSet = nextBitSet;
        }
        return bitSet.length() - 1;
    }
}
