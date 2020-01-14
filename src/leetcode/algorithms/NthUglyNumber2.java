package leetcode.algorithms;

/**
 * Description: 1201. Ugly Number III
 *
 * @author Baltan
 * @date 2019-12-25 18:32
 * @see NthMagicalNumber
 */
public class NthUglyNumber2 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(3, 2, 3, 5));
        System.out.println(nthUglyNumber(4, 2, 3, 4));
        System.out.println(nthUglyNumber(5, 2, 11, 13));
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
        System.out.println(nthUglyNumber(500, 97, 97, 97));
        System.out.println(nthUglyNumber(30, 435, 5332, 5453));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/ugly-number-iii/solution/java-er-fen-cha-zhao-by-gaaakki/"></a>
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int nthUglyNumber(int n, int a, int b, int c) {
        long lo = Math.min(a, Math.min(b, c));
        long hi = 2_000_000_000;
        /**
         * a和b的最小公倍数
         */
        long lcmAB = leastCommonMultiple(a, b);
        /**
         * a和c的最小公倍数
         */
        long lcmAC = leastCommonMultiple(a, c);
        /**
         * b和c的最小公倍数
         */
        long lcmBC = leastCommonMultiple(b, c);
        /**
         * a和b和c的最小公倍数
         */
        long lcmABC = leastCommonMultiple(lcmAB, c);
        /**
         * 二分查找满足条件的丑数
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            /**
             * [1,mid]中a的倍数的个数
             */
            long aMultipleCount = mid / a;
            /**
             * [1,mid]中b的倍数的个数
             */
            long bMultipleCount = mid / b;
            /**
             * [1,mid]中c的倍数的个数
             */
            long cMultipleCount = mid / c;
            /**
             * [1,mid]中lcmAB的倍数的个数
             */
            long abMultipleCount = mid / lcmAB;
            /**
             * [1,mid]中lcmAC的倍数的个数
             */
            long acMultipleCount = mid / lcmAC;
            /**
             * [1,mid]中lcmBC的倍数的个数
             */
            long bcMultipleCount = mid / lcmBC;
            /**
             * [1,mid]中lcmABC的倍数的个数
             */
            long abcMultipleCount = mid / lcmABC;
            /**
             * [1,mid]中丑数的个数，即可以被a或b或c整除的整数的个数
             */
            long uglyNumberCount =
                    aMultipleCount + bMultipleCount + cMultipleCount - abMultipleCount - acMultipleCount -
                            bcMultipleCount + abcMultipleCount;
            /**
             * 如果[1,mid]中丑数的个数不足n个，则第n个丑数在[mid+1,hi]中；如果[1,mid]中丑数的个数
             * 大于或等于n个，则第n个丑数在[lo,mid]中。我们要找到一个数x，[1,x]中丑数的个数为n个，
             * [1,x-1]中丑数的个数为n-1个，则x即为所求的第n个丑数
             */
            if (uglyNumberCount < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) hi;
    }

    /**
     * 计算m和n的最小公倍数
     *
     * @param m
     * @param n
     * @return
     */
    public static long leastCommonMultiple(long m, long n) {
        /**
         * m和n的最大公因数
         */
        long gcd = greatestCommonDivisor(m, n);
        /**
         * m和n的最小公倍数为(m/gcd)*(n/gcd)*gcd
         */
        return m * n / gcd;
    }

    /**
     * 辗转相除法计算m和n的最大公因数
     *
     * @param m
     * @param n
     * @return
     */
    public static long greatestCommonDivisor(long m, long n) {
        long min = Math.min(m, n);
        long max = Math.max(m, n);

        while (max % min != 0) {
            long remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
