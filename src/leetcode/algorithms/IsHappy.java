package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 202. Happy Number
 *
 * @author Baltan
 * @date 2018/1/4 15:59
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    /**
     * 求n每一位上的数字的平方和
     *
     * @param n
     * @return
     */
    public static int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n /= 10;
        }
        return sum;
    }
}
