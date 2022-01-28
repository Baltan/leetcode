package leetcode.algorithms;

/**
 * Description: 1969. Minimum Non-Zero Product of the Array Elements
 *
 * @author Baltan
 * @date 2022/1/28 14:03
 */
public class MinNonZeroProduct {
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(1));
        System.out.println(minNonZeroProduct(2));
        System.out.println(minNonZeroProduct(3));
        System.out.println(minNonZeroProduct(9));
        System.out.println(minNonZeroProduct(10));
        System.out.println(minNonZeroProduct(11));
        System.out.println(minNonZeroProduct(58));
        System.out.println(minNonZeroProduct(59));
        System.out.println(minNonZeroProduct(60));
    }

    /**
     * 因为每进行一次位交换后，两数和数不变的，所以不论怎么操作，数组nums中所有元素的和不变。为了使得nums中所有元素的乘积最小，但
     * 是最后的乘积不能为0，只需要令最后nums中有尽可能多的1即可，因为对于和为sum的两个数：1*(sum-1)<=2*(sum-2)<=……另一方面，
     * 一开始数组nums中的最大值2^p-1最后仍会保留（因为该数字的二进制表示每一位都为1，如果它的某一位1与另一个数的0进行了位交换，
     * 只会使得两数的乘积更大），所以最终nums中的数字为[1,1,……,1,2^p-2,2^p-2,……,2^p-2,2^p-1]，其中1的个数和2^p-1的个数相
     * 同，所求即为((2^p-2)^groups)*(2^p-1)对1000000007取余的结果
     *
     * @param p
     * @return
     */
    public static int minNonZeroProduct(int p) {
        int mod = 1000000007;
        /**
         * 因为最终nums中2^p-1肯定会保留，先把这个数字的乘积计算进result中
         */
        long result = ((1L << p) - 1) % mod;
        /**
         * 除2^p-1外最终nums中的最大值，也就是若干个2^p-2的值
         */
        long max = ((1L << p) - 2) % mod;
        /**
         * 最终nums中1和2^p-2的个数
         */
        long groups = ((1L << p) - 1) / 2;
        /**
         * 计算((2^p-2)^groups)*(2^p-1)对1000000007取余的结果
         */
        return (int) ((result * pow(max, groups, mod)) % mod);
    }

    /**
     * 计算(base^exponent)%mod
     *
     * @param base
     * @param exponent
     * @param mod
     * @return
     */
    public static long pow(long base, long exponent, int mod) {
        if (exponent == 0) {
            return 1L;
        }

        if (exponent == 1) {
            return base;
        }
        /**
         * 通过base^exponent=(base^(exponent/2))^2进行快速计算
         */
        long value = pow(base, exponent / 2, mod);

        if (exponent % 2 == 0) {
            return (value * value) % mod;
        } else {
            return (((value * value) % mod) * base) % mod;
        }
    }
}
