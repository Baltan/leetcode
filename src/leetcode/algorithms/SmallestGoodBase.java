package leetcode.algorithms;

/**
 * Description: 483. Smallest Good Base
 *
 * @author Baltan
 * @date 2020-01-14 13:21
 */
public class SmallestGoodBase {
    public static void main(String[] args) {
        System.out.println(smallestGoodBase("2251799813685247"));
        System.out.println(smallestGoodBase("13"));
        System.out.println(smallestGoodBase("4681"));
        System.out.println(smallestGoodBase("1000000000000000000"));
        System.out.println(smallestGoodBase("999999999999999999"));
        System.out.println(smallestGoodBase("99999999999999999"));
        System.out.println(smallestGoodBase("9999999999999999"));
        System.out.println(smallestGoodBase("999999999999999"));
        System.out.println(smallestGoodBase("99999999999999"));
        System.out.println(smallestGoodBase("9999999999999"));
        System.out.println(smallestGoodBase("999999999999"));
        System.out.println(smallestGoodBase("99999999999"));
        System.out.println(smallestGoodBase("9999999999"));
        System.out.println(smallestGoodBase("999999999"));
        System.out.println(smallestGoodBase("99999999"));
        System.out.println(smallestGoodBase("9999999"));
        System.out.println(smallestGoodBase("999999"));
        System.out.println(smallestGoodBase("99999"));
        System.out.println(smallestGoodBase("9999"));
        System.out.println(smallestGoodBase("999"));
        System.out.println(smallestGoodBase("99"));
        System.out.println(smallestGoodBase("9"));
    }

    public static String smallestGoodBase(String n) {
        long N = Long.valueOf(n);
        /**
         * 因为n∈[3,10^18]，所以n的好进制表示的长度最短为2，最长为63，因为10^18<Long.MAX_VALUE
         */
        int shortest = 2;
        int longest = 63;
        /**
         * 假设N可以表示成k进制下的111……111（一共i个1），即N=1+k+k^2+k^3+……^+k^(i-1)。因为要求
         * 最小好进制，则好进制表示的值应该尽可能长，所以从最长的可能向最短的可能依次尝试
         */
        for (int i = longest; i >= shortest; i--) {
            long minBase = 2;
            /**
             * 因为N=1+k+k^2+k^3+……^+k^(i-1)>k^(i-1)，所以k<N^[1/(i-1)]，即好进制k最大可能为
             * Math.floor(N^[1/(i-1)])
             */
            long maxBase = (long) Math.pow(N, 1.0 / (i - 1));
            /**
             * 二分查找是否存在好进制k，使得k进制表示的111……111（一共i个1）等于十进制表示的N
             */
            while (minBase <= maxBase) {
                long midBase = (minBase + maxBase) / 2;
                long sum = getSum(i, midBase);

                if (sum == N) {
                    return String.valueOf(midBase);
                } else if (sum < N) {
                    minBase = midBase + 1;
                } else {
                    maxBase = midBase - 1;
                }
            }
        }
        /**
         * 对于[3,10^18]中的任意一个十进制值N，总能表示为(N-1)进制的11，所以(N-1)进制一定是
         * 一个好进制。当然在上面的循环中最短已经尝试到了11，所以方法总是在上面循环的二分查找中
         * 返回
         */
        return String.valueOf(N - 1);
    }

    /**
     * 计算base进制数111……111（共length个1）的十进制表示的值
     *
     * @param length
     * @param base
     * @return
     */
    public static long getSum(int length, long base) {
        long sum = 1L;
        long prev = 1;

        for (int j = 1; j < length; j++) {
            prev *= base;
            sum += prev;
        }
        return sum;
    }
}
