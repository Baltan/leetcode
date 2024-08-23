package leetcode.algorithms;

/**
 * Description: 3259. Maximum Energy Boost From Two Drinks
 *
 * @author baltan
 * @date 2024/8/21 13:52
 */
public class MaxEnergyBoost {
    public static void main(String[] args) {
        System.out.println(maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
        System.out.println(maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }

    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int length = energyDrinkA.length;
        /**
         * 当前如果选择饮料A可以获得的最大能量
         */
        long drinkA = 0;
        /**
         * 当前如果选择饮料B可以获得的最大能量
         */
        long drinkB = 0;

        for (int i = 0; i < length; i++) {
            long drinkA_ = Math.max(drinkA + energyDrinkA[i], drinkB);
            drinkB = Math.max(drinkB + energyDrinkB[i], drinkA);
            drinkA = drinkA_;
        }
        return Math.max(drinkA, drinkB);
    }
}
