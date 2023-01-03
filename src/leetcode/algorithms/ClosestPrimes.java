package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2523. Closest Prime Numbers in Range
 *
 * @author Baltan
 * @date 2023/1/2 12:27
 */
public class ClosestPrimes {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(closestPrimes(10, 19));
        OutputUtils.print1DIntegerArray(closestPrimes(4, 6));
    }

    public static int[] closestPrimes(int left, int right) {
        /**
         * 唯一可能的一组相邻的质数
         */
        if (left <= 2 && right >= 3) {
            return new int[]{2, 3};
        }
        int[] result = {-1, -1};
        List<Integer> primes = new ArrayList<>();
        /**
         * 相邻两个质数的最小差值
         */
        int diff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                /**
                 * 除了[2,3]，其余相邻质数的最小差值为2，如果找到了两个质数之差为2，就不用再继续查找了
                 */
                if (!primes.isEmpty() && i - primes.get(primes.size() - 1) == 2) {
                    return new int[]{primes.get(primes.size() - 1), i};
                }
                primes.add(i);
            }
        }
        /**
         * 从已有质数中找到差最小的两个
         */
        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i) - primes.get(i - 1) < diff) {
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
                diff = result[1] - result[0];
            }
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
