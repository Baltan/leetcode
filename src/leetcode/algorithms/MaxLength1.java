package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3411. Maximum Subarray With Equal Products
 *
 * @author Baltan
 * @date 2025/1/14 23:27
 */
public class MaxLength1 {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{2, 6}));
        System.out.println(maxLength(new int[]{1, 2, 1, 2, 1, 1, 1}));
        System.out.println(maxLength(new int[]{2, 3, 4, 5, 6}));
        System.out.println(maxLength(new int[]{1, 2, 3, 1, 4, 5, 1}));
    }

    public static int maxLength(int[] nums) {
        /**
         * 当数组nums中只有两个数时，假设这两个数为x和y，它们的最大公约数为m，最小公倍数为(x/m)*(y/m)*m=x*y/m。此时最大公约数和最小公倍数
         * 乘积恒等于x和y的乘积，所以长度为2的数组一定是乘积等价数组
         */
        if (nums.length == 2) {
            return 2;
        }
        int result = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * counts[i]表示子数组中数字i的个数
         */
        int[] counts = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            /**
             * 子数组中所有数字的最大公约数
             */
            int gcd = nums[i];
            /**
             * 子数组中所有数字的最小公倍数
             */
            int lcm = nums[i];
            Arrays.fill(counts, 0);
            counts[nums[i]]++;

            for (int j = i + 1; j < nums.length; j++) {
                /**
                 * 如果数字nums[j]此前已在子数组中出现过，则不会改变子数组中所有数字的最大公约数和最小公倍数
                 */
                if (counts[nums[j]] == 0) {
                    int newGcd = gcd(gcd, nums[j]);
                    lcm = lcm(lcm, nums[j]);
                    gcd = newGcd;
                }
                counts[nums[j]]++;

                if (isEqual(counts, lcm, gcd)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    /**
     * 判断counts表示的子数组中的所有元素的乘积是否等于它们的最大公约数和最小公倍数的乘积
     *
     * @param counts
     * @param lcm
     * @param gcd
     * @return
     */
    public static boolean isEqual(int[] counts, int lcm, int gcd) {
        int product = lcm * gcd;

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                if (product % i != 0) {
                    return false;
                }
                product /= i;
            }
        }
        return true;
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

    /**
     * 求x和y的最小公倍数
     *
     * @param x
     * @param y
     * @return
     */
    public static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }
}
