package leetcode.algorithms;

/**
 * Description: 3153. Sum of Digit Differences of All Pairs
 *
 * @author Baltan
 * @date 2024/5/19 19:51
 */
public class SumDigitDifferences {
    public static void main(String[] args) {
        System.out.println(sumDigitDifferences(new int[]{13, 23, 12}));
        System.out.println(sumDigitDifferences(new int[]{10, 10, 10, 10}));
    }

    public static long sumDigitDifferences(int[] nums) {
        long result = 0L;
        /**
         * counts[i][j]表示数组nums中的所有数中，由低到高第i位上为j的数字个数。根据题意，nums[i]∈[1,1000000000)，所以最多是九位数
         */
        int[][] counts = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < nums.length; j++) {
                /**
                 * 数字nums[j]由低到高第i位上为digit
                 */
                int digit = nums[j] % 10;
                /**
                 * 累计此前所有数字中由低到高第i位上不为digit的情况
                 */
                for (int k = 0; k < 10; k++) {
                    if (k != digit) {
                        result += counts[i][k];
                    }
                }
                counts[i][digit]++;
                nums[j] /= 10;
            }
        }
        return result;
    }
}
