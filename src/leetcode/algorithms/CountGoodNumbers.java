package leetcode.algorithms;

/**
 * Description: 1922. Count Good Numbers
 *
 * @author Baltan
 * @date 2022/3/2 20:19
 */
public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1L));
        System.out.println(countGoodNumbers(4L));
        System.out.println(countGoodNumbers(50L));
        System.out.println(countGoodNumbers(1000000000000000L));
    }

    public static int countGoodNumbers(long n) {
        int mod = 1000000007;
        /**
         * 字符串中一位数素数的个数
         */
        long primeCount = n / 2;
        /**
         * 字符串中一位数偶数的个数
         */
        long evenCount = n - primeCount;
        /**
         * 一位数的偶数共有5个（0、2、4、6、8），一位数的素数共有4个（2、3、5、7），所以一共的组合数为：
         * (5^evenCount)*(4^primeCount) ，所求即为：
         * [(5^evenCount)*(4^primeCount)]%mod
         * ={[(5^evenCount)%mod]*[(4^primeCount)%mod]}%mod
         */
        return (int) ((calculate(5, evenCount, mod) * calculate(4, primeCount, mod)) % mod);
    }

    /**
     * 计算(base^exponent)%mod的值
     *
     * @param base
     * @param exponent
     * @param mod
     * @return
     */
    public static long calculate(int base, long exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        long remainder = calculate(base, exponent / 2, mod);

        if (exponent % 2 == 0) {
            return (remainder * remainder) % mod;
        } else {
            return (((remainder * remainder) % mod) * base) % mod;
        }
    }
}
