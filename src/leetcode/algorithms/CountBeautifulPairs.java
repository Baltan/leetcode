package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2748. Number of Beautiful Pairs
 *
 * @author Baltan
 * @date 2023/7/1 16:27
 */
public class CountBeautifulPairs {
    public static void main(String[] args) {
        System.out.println(countBeautifulPairs(new int[]{756, 1324, 2419, 495, 106, 111, 1649, 1474, 2001, 1633, 273, 1804, 2102, 1782, 705, 1529, 1761, 1613, 111, 186, 412}));
        System.out.println(countBeautifulPairs(new int[]{2, 5, 1, 4}));
        System.out.println(countBeautifulPairs(new int[]{11, 21, 12}));
    }

    public static int countBeautifulPairs(int[] nums) {
        int result = 0;
        int length = nums.length;
        /**
         * digits[i]表示数字nums[i]的个位数字
         */
        int[] digits = Arrays.stream(nums).map(x -> x % 10).toArray();

        for (int i = 0; i < length; i++) {
            /**
             * 计算得到nums[i]的最高位数字
             */
            while (nums[i] >= 10) {
                nums[i] /= 10;
            }

            for (int j = i + 1; j < length; j++) {
                if (gcd(nums[i], digits[j]) == 1) {
                    result++;
                }
            }
        }
        return result;
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
