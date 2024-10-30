package leetcode.algorithms;

/**
 * Description: 3334. Find the Maximum Factor Score of Array
 *
 * @author Baltan
 * @date 2024/10/27 17:26
 */
public class MaxScore9 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{2, 4, 8, 16}));
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxScore(new int[]{3}));
    }

    public static long maxScore(int[] nums) {
        if (nums.length == 1) {
            return (long) nums[0] * nums[0];
        }
        long result = 0;
        /**
         * 计算删除数字nums[i]后剩余数字的最大公约数和最小公倍数，其中i为nums.length时，不会删除任何数字
         */
        for (int i = 0; i <= nums.length; i++) {
            /**
             * 最大公约数
             */
            long gcd = i == 0 ? nums[1] : nums[0];
            /**
             * 最小公倍数
             */
            long lcm = i == 0 ? nums[1] : nums[0];

            for (int j = 0; j < nums.length; j++) {
                /**
                 * 跳过被删除的数字
                 */
                if (j == i) {
                    continue;
                }
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
            }
            result = Math.max(result, gcd * lcm);
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
    public static long gcd(long x, long y) {
        long min = Math.min(x, y);
        long max = Math.max(x, y);

        while (max % min != 0) {
            long remainder = max % min;
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
    public static long lcm(long x, long y) {
        long gcd = gcd(x, y);
        return x * y / gcd;
    }
}
