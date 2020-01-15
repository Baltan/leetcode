package leetcode.algorithms;

/**
 * Description: 878. Nth Magical Number
 *
 * @author Baltan
 * @date 2020-01-14 11:35
 * @see NthUglyNumber2
 */
public class NthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1, 2, 3));
        System.out.println(nthMagicalNumber(4, 2, 3));
        System.out.println(nthMagicalNumber(5, 2, 4));
        System.out.println(nthMagicalNumber(3, 6, 4));
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
        System.out.println(nthMagicalNumber(1000000000, 40000, 39999));
    }

    public static int nthMagicalNumber(int N, int A, int B) {
        int mod = 1000000007;
        /**
         * A和B的最小公倍数
         */
        int lcm = leastCommonMultiple(A, B);
        /**
         * [1,lcm]中A的倍数的个数
         */
        int aMultipleCountBetween1AndLcm = lcm / A;
        /**
         * [1,lcm]中B的倍数的个数
         */
        int bMultipleCountBetween1AndLcm = lcm / B;
        /**
         * [1,lcm]中可以被A或B整除的整数（神奇数字）的个数，从1开始，每隔lcm个数看做一组，每一组中有
         * multipleCountBetween1AndLcm个神奇数字
         */
        int multipleCountBetween1AndLcm = aMultipleCountBetween1AndLcm + bMultipleCountBetween1AndLcm - 1;
        /**
         * 到第N个神奇数字位置，包含了groups组
         */
        int groups = N / multipleCountBetween1AndLcm;
        long lo = 1L * groups * lcm;
        long hi = lo + lcm;
        /**
         * 二分查找第N个神奇数字，神奇数字在[groups*lcm,(groups+1)*lcm-1)之间
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            /**
             * [1,mid]中A的倍数的个数
             */
            long aMultipleCountBetween1AndMid = mid / A;
            /**
             * [1,mid]中A的倍数的个数
             */
            long bMultipleCountBetween1AndMid = mid / B;
            /**
             * [1,mid]中lcm的倍数的个数
             */
            long abMultipleCountBetween1AndMid = mid / lcm;
            /**
             * [1,mid]中神奇数字的个数，即可以被A或B整除的整数的个数
             */
            long multipleCountBetween1AndMid = aMultipleCountBetween1AndMid + bMultipleCountBetween1AndMid -
                    abMultipleCountBetween1AndMid;
            /**
             * 如果[1,mid]中神奇数字的个数不足N个，则第N个神奇数字在[mid+1,hi]中；如果[1,mid]中
             * 神奇数字的个数大于或等于N个，则第N个神奇数字在[lo,mid]中。我们要找到一个数x，[1,x]
             * 中神奇数字的个数为N个，[1,x-1]中神奇数字的个数为N-1个，则x即为所求的第N个神奇数字
             */
            if (multipleCountBetween1AndMid < N) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) (hi % mod);
    }

    /**
     * 计算A和B的最小公倍数
     *
     * @param A
     * @param B
     * @return
     */
    public static int leastCommonMultiple(int A, int B) {
        /**
         * A和B的最大公因数
         */
        int gcd = greatestCommonDivisor(A, B);
        /**
         * A和B的最小公倍数为(A/gcd)*(B/gcd)*gcd
         */
        return A * B / gcd;
    }

    /**
     * 辗转相除法计算A和B的最大公因数
     *
     * @param A
     * @param B
     * @return
     */
    public static int greatestCommonDivisor(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
