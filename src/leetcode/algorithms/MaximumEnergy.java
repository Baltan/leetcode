package leetcode.algorithms;

/**
 * Description: 3147. Taking Maximum Energy From the Mystic Dungeon
 *
 * @author Baltan
 * @date 2024/5/18 06:28
 */
public class MaximumEnergy {
    public static void main(String[] args) {
        System.out.println(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
        System.out.println(maximumEnergy(new int[]{-2, -3, -1}, 2));
    }

    public static int maximumEnergy(int[] energy, int k) {
        int result = Integer.MIN_VALUE;
        /**
         * 遍历最后一个魔法师所有可能的位置，倒推可能的第一个魔法师，找到吸收能量的最大值即可
         */
        for (int i = energy.length - 1; i >= energy.length - k; i--) {
            int sum = 0;
            int j = i;

            while (j >= 0) {
                sum += energy[j];
                result = Math.max(result, sum);
                j -= k;
            }
        }
        return result;
    }
}
