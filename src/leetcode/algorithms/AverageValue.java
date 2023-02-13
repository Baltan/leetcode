package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2455. Average Value of Even Numbers That Are Divisible by Three
 *
 * @author Baltan
 * @date 2023/2/8 09:34
 */
public class AverageValue {
    public static void main(String[] args) {
        System.out.println(averageValue(new int[]{1, 3, 6, 10, 12, 15}));
        System.out.println(averageValue(new int[]{1, 2, 4, 7, 10}));
    }

    public static int averageValue(int[] nums) {
        /**
         * 可被3整除的偶数也就是可被6整除
         */
        return (int) Arrays.stream(nums).filter(x -> x % 6 == 0).average().orElse(0);
    }
}
