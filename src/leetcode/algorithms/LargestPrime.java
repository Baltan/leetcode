package leetcode.algorithms;

/**
 * Description: 3770. Largest Prime from Consecutive Prime Sum
 *
 * @author baltan
 * @date 2026/1/29 16:09
 */
public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(largestPrime(393961));
        System.out.println(largestPrime(398771));
        System.out.println(largestPrime(1));
        System.out.println(largestPrime(20));
        System.out.println(largestPrime(2));
    }

    public static int largestPrime(int n) {
        if (n < 2) {
            return 0;
        }
        int result = 0;
        /**
         * 从2开始的所有质数之和
         */
        int sum = 0;
        /**
         * isPrime[i]表示i是否是质数
         */
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            isPrime[i] = isPrime(i);
        }

        for (int i = 2; sum < n; i++) {
            if (isPrime[i]) {
                sum += i;
            }

            if (sum <= n && isPrime[sum]) {
                result = sum;
            }
        }
        return result;
    }

    /**
     * 判断n是不是质数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
