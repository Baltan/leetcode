package leetcode.algorithms;

/**
 * Description: 1979. Find Greatest Common Divisor of Array
 *
 * @author Baltan
 * @date 2022/1/21 17:06
 */
public class FindGCD {
    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{2, 5, 6, 9, 10}));
        System.out.println(findGCD(new int[]{7, 5, 6, 8, 3}));
        System.out.println(findGCD(new int[]{3, 3}));
    }

    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(min, max);
    }

    /**
     * 求min和max的最大公约数
     *
     * @param min
     * @param max
     * @return
     */
    public static int gcd(int min, int max) {
        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
