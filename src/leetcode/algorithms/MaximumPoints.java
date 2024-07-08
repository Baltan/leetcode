package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3207. Maximum Points After Enemy Battles
 *
 * @author Baltan
 * @date 2024/7/8 19:47
 */
public class MaximumPoints {
    public static void main(String[] args) {
        System.out.println(maximumPoints(new int[]{3, 2, 2}, 2));
        System.out.println(maximumPoints(new int[]{2}, 10));
        System.out.println(maximumPoints(new int[]{2, 3, 4}, 1));
    }

    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long result = 0;
        int lo = 0;
        int hi = enemyEnergies.length - 1;
        Arrays.sort(enemyEnergies);
        /**
         * 无法从任何敌人这里扣除能量并且得到1分，同时因为没有分数，也无法从任何敌人这里得到能量
         */
        if (currentEnergy < enemyEnergies[0]) {
            return result;
        }
        /**
         * 先得到1分，从而保证后续可以从未标记的敌人这里得到能量
         */
        currentEnergy -= enemyEnergies[0];
        result++;
        /**
         * 每次操作，总是扣除从能量值最小的敌人这里扣除能量并且得到1分，或者标记能量值最大的敌人并且得到对应能量
         */
        while (lo <= hi) {
            if (currentEnergy >= enemyEnergies[lo]) {
                /**
                 * 可以在当前敌人这里执行points次操作1
                 */
                int points = currentEnergy / enemyEnergies[lo];
                result += points;
                currentEnergy -= enemyEnergies[lo] * points;
            } else {
                currentEnergy += enemyEnergies[hi];
                /**
                 * 标记敌人，后续不可再操作这个敌人
                 */
                hi--;
            }
        }
        return result;
    }
}
