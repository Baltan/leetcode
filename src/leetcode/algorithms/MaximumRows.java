package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2397. Maximum Rows Covered by Columns
 *
 * @author Baltan
 * @date 2022/12/25 13:43
 */
public class MaximumRows {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        System.out.println(maximumRows(matrix1, 2));

        int[][] matrix2 = {{1}, {0}};
        System.out.println(maximumRows(matrix2, 1));

        int[][] matrix3 = {{1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 1}};
        System.out.println(maximumRows(matrix3, 5));
    }

    public static int maximumRows(int[][] matrix, int numSelect) {
        int result = 0;
        /**
         * 将最右边的numSelect列覆盖，此时表示的二进制掩码值为0b11……11（共numSelect个1）
         */
        int minMask = 0;
        /**
         * 将最左边的numSelect列覆盖，此时表示的二进制掩码值为0b11……1100……00（共numSelect个1）
         */
        int maxMask = 0;
        /**
         * 从低位到高位每一位的权重
         */
        int minWeight = 1;
        /**
         * 从高位到低位每一位的权重
         */
        int maxWeight = (int) Math.pow(2, matrix[0].length - 1);
        /**
         * 将matrix的每一行看做一个二进制数，nums保存每一行计算得到的值
         */
        List<Integer> nums = new ArrayList<>(matrix.length);

        for (int[] row : matrix) {
            int value = 0;
            /**
             * 从低位到高位每一位的权重
             */
            int weight = 1;
            /**
             * 计算row行得到的值
             */
            for (int i = row.length - 1; i >= 0; i--) {
                value += row[i] * weight;
                weight <<= 1;
            }
            nums.add(value);
        }
        /**
         * 计算掩码的最大值和最小值
         */
        for (int i = 0; i < numSelect; i++) {
            minMask += minWeight;
            minWeight <<= 1;
            maxMask += maxWeight;
            maxWeight >>= 1;
        }

        for (int mask = minMask; mask <= maxMask; mask++) {
            /**
             * 掩码mask的二进制值中1的位数不为numSelect
             */
            if (numSelect != Integer.bitCount(mask)) {
                continue;
            }
            int count = 0;

            for (int num : nums) {
                /**
                 * 如果某一行中的每个1都被选中的列覆盖了，则该行代表的数字num和mask按位或的值应当也为mask
                 */
                if ((num | mask) == mask) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
