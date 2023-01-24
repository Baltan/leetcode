package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2300. Successful Pairs of Spells and Potions
 *
 * @author Baltan
 * @date 2023/1/20 18:04
 */
public class SuccessfulPairs {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7));
        OutputUtils.print1DIntegerArray(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        /**
         * 最大的药水能量强度
         */
        int maxPotion = potions[potions.length - 1];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            /**
             * 最大能量强度的药水都不能和当前咒语完成配对，其他药水就不用计算了
             */
            if (1L * spell * maxPotion < success) {
                result[i] = 0;
                continue;
            }
            int lo = 0;
            int hi = potions.length - 1;
            /**
             * 二分查找能和当前咒语完成配对的能量强度最小的药水的索引位置
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                long product = 1L * spell * potions[mid];

                if (product < success) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            result[i] = potions.length - lo;
        }
        return result;
    }
}
