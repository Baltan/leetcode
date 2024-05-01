package leetcode.algorithms;

import java.math.BigInteger;

/**
 * Description: 3129. Find All Possible Stable Binary Arrays I
 *
 * @author Baltan
 * @date 2024/4/29 22:16
 */
public class NumberOfStableArrays {
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(20, 15, 75));
        System.out.println(numberOfStableArrays(2, 3, 4));
        System.out.println(numberOfStableArrays(2, 1, 2));
        System.out.println(numberOfStableArrays(1, 2, 2));
        System.out.println(numberOfStableArrays(1, 1, 2));
        System.out.println(numberOfStableArrays(1, 2, 1));
        System.out.println(numberOfStableArrays(3, 3, 2));
    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;

        if (zero + one <= limit) {
            /**
             * 如果数组中元素的总个数都不足limit+1个，则不论元素怎么排列都是稳定数组
             */
            return combination(mod, zero, one);
        }
        long result = 0L;
        /**
         * dp0[i][j][k]表示由i个0和j个1构成的稳定数组，最后一个元素为0，最后一个1为数组的倒数第k（0-based）个元素时的情况数
         * dp1[i][j][k]表示由i个0和j个1构成的稳定数组，最后一个元素为1，最后一个0为数组的倒数第k（0-based）个元素时的情况数
         */
        long[][][] dp0 = new long[zero + 1][one + 1][limit + 1];
        long[][][] dp1 = new long[zero + 1][one + 1][limit + 1];

        for (int i = 1; i <= limit; i++) {
            if (i > zero || limit + 1 - i > one) {
                continue;
            }

            for (int k = 1; k <= limit; k++) {
                /**
                 * 由i个0和limit+1-i个1构成的稳定数组，最后一个元素为0，最后一个1为数组的倒数第k（0-based）个元素时的情况数（即
                 * arr[limit-k]为1，且剩余的limit-i个1在arr[0]-arr[limit-k-1]中）
                 */
                if (limit - i <= limit - k) {
                    /**
                     * 由i个0和limit+1-i个1构成的稳定数组，最后一个元素为0，最后一个1为数组的倒数第k（0-based）个元素时的情况数（即
                     * arr[limit-k]为1，且剩余的limit-i个1在arr[0]-arr[limit-k-1]中）
                     */
                    dp0[i][limit + 1 - i][k] = combination(mod, i - k, limit - i);
                }

                if (i - 1 <= limit - k) {
                    /**
                     * 由i个0和limit+1-i个1构成的稳定数组，最后一个元素为1，最后一个0为数组的倒数第k（0-based）个元素时的情况数（即
                     * arr[limit-k]为0，且剩余的i-1个0在arr[0]-arr[limit-k-1]中）
                     */
                    dp1[i][limit + 1 - i][k] = combination(mod, i - 1, limit - k - (i - 1));
                }
            }
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                /**
                 * 元素总个数不足limit+2个的情况都已计算过
                 */
                if (i + j <= limit + 1) {
                    continue;
                }

                for (int k = 1; k <= limit; k++) {
                    /**
                     * 如果数组由i个0和j个1构成，最后一个元素为0，最后一个1为数组的倒数第1（0-based）个元素，则只可能通过由i-1个0和j个1，
                     * 最后一个元素为1的稳定数组的最后追加0得到，即dp1[i-1][j][k]
                     */
                    dp0[i][j][1] = (dp0[i][j][1] + dp1[i - 1][j][k]) % mod;
                    /**
                     * 如果数组由i个0和j个1构成，最后一个元素为1，最后一个0为数组的倒数第1（0-based）个元素，则只可能通过由i个0和j-1个1，
                     * 最后一个元素为0的稳定数组的最后追加1得到，即dp0[i][j-1][k]
                     */
                    dp1[i][j][1] = (dp1[i][j][1] + dp0[i][j - 1][k]) % mod;
                }

                for (int k = 2; k <= limit; k++) {
                    /**
                     * 如果数组由i个0和j个1构成，最后一个元素为0，最后一个1为数组的倒数第k（0-based）个元素，则只可能通过由i-1个0和j个1，
                     * 最后一个元素为0，最后一个1为数组的倒数第k-1（0-based）个元素的稳定数组的最后追加0得到
                     */
                    dp0[i][j][k] = (dp0[i][j][k] + dp0[i - 1][j][k - 1]) % mod;
                    /**
                     * 如果数组由i个0和j个1构成，最后一个元素为1，最后一个0为数组的倒数第k（0-based）个元素，则只可能通过由i个0和j-1个1，
                     * 最后一个元素为1，最后一个0为数组的倒数第k-1（0-based）个元素的稳定数组的最后追加1得到
                     */
                    dp1[i][j][k] = (dp1[i][j][k] + dp1[i][j - 1][k - 1]) % mod;
                }
            }
        }

        for (int k = 1; k <= limit; k++) {
            /**
             * 累计所有由i个0和j个1构成，最后一个元素为0，最后一个1为数组的倒数第k（0-based）个元素的稳定数组的个数
             */
            result = (result + dp0[zero][one][k]) % mod;
            /**
             * 累计所有由i个0和j个1构成，最后一个元素为1，最后一个0为数组的倒数第k（0-based）个元素的稳定数组的个数
             */
            result = (result + dp1[zero][one][k]) % mod;
        }
        return (int) result;
    }

    /**
     * 计算从zero+one个中随机算则zero个的排列数C(zero+one,zero)对mod取余的值
     *
     * @param mod
     * @param zero
     * @param one
     * @return
     */
    public static int combination(int mod, int zero, int one) {
        BigInteger result = BigInteger.ONE;
        BigInteger total = BigInteger.valueOf(zero + one);
        int min = Math.min(zero, one);
        /**
         * C(x,y)=(x*(x-1)*(x-2)*……*(x-y+1))/(1*2*3*……*y)
         */
        for (int i = 1; i <= min; i++) {
            BigInteger bi = BigInteger.valueOf(i);
            result = result.multiply(total.add(BigInteger.ONE).subtract(bi)).divide(bi);
        }
        return result.mod(BigInteger.valueOf(mod)).intValue();
    }
}
