package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 3556. Sum of Largest Prime Substrings
 *
 * @author Baltan
 * @date 2025/6/7 13:54
 */
public class SumOfLargestPrimes {
    public static void main(String[] args) {
        System.out.println(sumOfLargestPrimes("5"));
        System.out.println(sumOfLargestPrimes("12234"));
        System.out.println(sumOfLargestPrimes("111"));
    }

    public static long sumOfLargestPrimes(String s) {
        long result = 0L;
        long num = Long.parseLong(s);
        /**
         * 升序保存字符串s中的质数子串
         */
        TreeSet<Long> primes = new TreeSet<>();

        while (num > 0) {
            long remainder = num % 10;

            if (remainder == 2 && !primes.contains(2L)) {
                primes.add(2L);
            } else if (remainder % 2 == 1L) {
                long divisor = 10;
                /**
                 * 当num*10>=divisor时，继续循环得到的所有余数都是num本身了。例如num=97，divisor=1000
                 */
                while (num * 10 >= divisor) {
                    if (!primes.contains(remainder) && isPrime(remainder)) {
                        primes.add(remainder);
                    }
                    divisor *= 10;
                    remainder = num % divisor;
                }
            }
            /**
             * 截去数字num的个位数
             */
            num /= 10;
        }
        /**
         * 对集合primes中至多3个最大的质数求和
         */
        for (int i = 0; i < 3 && !primes.isEmpty(); i++) {
            result += primes.pollLast();
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(long num) {
        if (num == 1L) {
            return false;
        }

        for (int i = 2; (long) i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
