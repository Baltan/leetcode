package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2967. Minimum Cost to Maie Array Equalindromic
 *
 * @author Baltan
 * @date 2023/12/17 13:45
 * @see NearestPalindromic
 * @see NearestPalindromic1
 */
public class MinimumCost3 {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000}));
        System.out.println(minimumCost(new int[]{102, 103, 105, 106, 109}));
        System.out.println(minimumCost(new int[]{1}));
        System.out.println(minimumCost(new int[]{1, 2, 3, 4, 5}));
        System.out.println(minimumCost(new int[]{10, 12, 13, 14, 15}));
        System.out.println(minimumCost(new int[]{22, 33, 22, 33, 22}));
    }

    public static long minimumCost(int[] nums) {
        /**
         * 如果数组nums中只有一个数字，则将这个数字变为离自己最近的回文数字即可
         */
        if (nums.length == 1) {
            return Math.min(nums[0] - getMaxPalindromicNumberBetween(Integer.MIN_VALUE, nums[0]),
                    getMinPalindromicNumberBetween(nums[0], Integer.MAX_VALUE) - nums[0]);
        }
        long result = Long.MAX_VALUE;
        int n = nums.length;
        /**
         * 排序后的数组nums的前缀和
         */
        long[] prefixSums = new long[n + 1];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        /**
         * 小于数组nums中所有数字的最大的回文数字
         */
        int lowerLimit = getMaxPalindromicNumberBetween(0, nums[0]);
        /**
         * 大于数组nums中所有数字的最小的回文数字
         */
        int upperLimit = getMinPalindromicNumberBetween(nums[n - 1], Integer.MAX_VALUE);
        /**
         * 将数组中的数字都变为lowerLimit
         */
        if (lowerLimit != -1) {
            result = Math.min(result, prefixSums[n] - (long) n * lowerLimit);
        }
        /**
         * 将数组中的数字都变为upperLimit
         */
        if (upperLimit != -1) {
            result = Math.min(result, (long) n * upperLimit - prefixSums[n]);
        }
        /**
         * 假设排序后的数组nums为[x1,x2,x3,……,xn]，最终数组中的数字都变为回文数字y，则操作的总代价为|x1-y|+|x2-y|+|x3-y|+……+|xn-y|，
         * 即数组中的数字到y的距离之和，将数组nums分割为[x1,x2]、[x2,x3]、……、[x[n-1],xn]共n-1段，并且这n-1段依次编号为1、2、……、n-1。
         * 当y在第1段中，即y∈[x1,x2]时，
         * |x1-y|+|x2-y|+|x3-y|+……+|xn-y|
         * =(y-x1)+(x2-y)+(x3-y)+……+(xn-y)
         * =(x2+x3+……+xn)-x1+y-(n-1)*y
         * =prefixSums[n]-prefixSums[1]-prefixSums[1]+y-(n-1)y
         * =prefixSums[n]-2*prefixSums[1]+(2*1-n)y
         *
         * 将情况一般化后，可以得知，当y在第i段中，即y(xi,x[i+1])，其中，i∈[1,n-1]时，
         * |x1-y|+|x2-y|+|x3-y|+……+|xn-y|
         * =prefixSums[n]-prefixSums[i]-prefixSums[i]+i*y-(n-i)y
         * =prefixSums[n]-2*prefixSums[i]+(2*i-n)*y
         * 分为2*i小于等于n、2*i大于n两种情况讨论
         */
        for (int i = 1; i < n; i++) {
            if (2 * i <= n) {
                int max = getMaxPalindromicNumberBetween(nums[i - 1], nums[i]);

                if (max != -1) {
                    result = Math.min(result, prefixSums[n] - 2 * prefixSums[i] + (i * 2L - n) * max);
                }
            } else {
                int min = getMinPalindromicNumberBetween(nums[i - 1], nums[i]);

                if (min != -1) {
                    result = Math.min(result, prefixSums[n] - 2 * prefixSums[i] + (i * 2L - n) * min);
                }
            }
        }
        return result;
    }

    /**
     * 获取[lo,hi]之间最大的回文数字，如果不存在则返回-1
     *
     * @param lo
     * @param hi
     * @return
     */
    public static int getMaxPalindromicNumberBetween(int lo, int hi) {
        /**
         * 如果lo和hi都为一位数，则[lo,hi]范围内最大的回文数字就是hi
         */
        if (hi < 10) {
            return hi;
        }
        /**
         * 小于10的最大的回文数字为9
         */
        if (hi == 10) {
            return lo == 10 ? -1 : 9;
        }
        /**
         * hi的数位个数，例如：1234 -> 4，12345 -> 5
         */
        int bitLength = getBitLength(hi);

        if (bitLength % 2 == 0) {
            /**
             * hi的前半部分表示的数字，例如：1234 -> 12
             */
            int formerHalf = splitNum(hi, bitLength, 0, bitLength / 2 - 1);
            /**
             * hi的后半部分表示的数字，例如：1234 -> 34
             */
            int latterHalf = splitNum(hi, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * hi的前半部分翻转后表示的数字，例如：1234 -> 12 -> 21
             */
            int reversedFormerHalf = reverseNum(formerHalf);

            if (reversedFormerHalf <= latterHalf) {
                /**
                 * 为了获得尽可能大的回文数字，尽量保持hi的高位数字不动。如果用hi的前半部分翻转后表示的数字替换hi的后半部分表示的数字后，能
                 * 得到更小的数字max，则max为小于等于hi的最大的回文数字，例如：1234 -> 1221
                 */
                int max = hi - latterHalf + reversedFormerHalf;
                /**
                 * 如果max>=lo，则max是[lo,hi]范围内最大的回文数字；反之，[lo,hi]范围内的其余回文数字小于max，必然也小于lo
                 */
                return max >= lo ? max : -1;
            } else {
                /**
                 * hi的前半部分表示的数字的数位个数，例如：1234 -> 12，数位个数为2
                 */
                int formerHalfLength = bitLength / 2;
                /**
                 * hi的前半部分表示的数字减去1的差值的数位个数，例如：1234 -> 12 -> 11，数位个数为2
                 */
                int formerHalfLength1 = getBitLength(formerHalf - 1);

                if (formerHalfLength1 < formerHalfLength) {
                    /**
                     * 如果formerHalfLength1小于formerHalfLength，说明hi为100……00的形式，小于等于hi的最大的回文数字为99……99的形式，
                     * 例如：100000 -> 99999
                     */
                    int max = pow(bitLength - 1) - 1;
                    /**
                     * 如果max>=lo，则max是[lo,hi]范围内最大的回文数字；反之，[lo,hi]范围内的其余回文数字小于max，必然也小于lo
                     */
                    return max >= lo ? max : -1;
                } else {
                    /**
                     * 如果formerHalfLength1等于formerHalfLength，假设hi的前半部分表示的数字减去1的差值为formerHalf1，则用
                     * formerHalf1替换hi的前半部分，用formerHalf1翻转后表示的数字替换hi的后半部分后，得到的数字为小于等于hi的最大的回
                     * 文数字，例如：4321 -> 4224
                     */
                    int formerHalf1 = formerHalf - 1;
                    int max = formerHalf1 * pow(formerHalfLength1) + reverseNum(formerHalf1);
                    /**
                     * 如果max>=lo，则max是[lo,hi]范围内最大的回文数字；反之，[lo,hi]范围内的其余回文数字小于max，必然也小于lo
                     */
                    return max >= lo ? max : -1;
                }
            }
        } else {
            /**
             * hi的前半部分（不含最中间数位的数字）表示的数字，例如：12345 -> 12
             */
            int formerHalf = splitNum(hi, bitLength, 0, bitLength / 2 - 1);
            /**
             * hi的后半部分表示的数字，例如：12345 -> 45
             */
            int latterHalf = splitNum(hi, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * hi的前半部分（不含最中间数位的数字）翻转后表示的数字，例如：12345 -> 12 -> 21
             */
            int reversedFormerHalf = reverseNum(formerHalf);

            if (reversedFormerHalf <= latterHalf) {
                /**
                 * 为了获得尽可能大的回文数字，尽量保持hi的高位数字不动。如果用hi的前半部分（不含最中间数位的数字）翻转后表示的数字替换hi的
                 * 后半部分表示的数字后，能得到更小的数字max，则max为小于等于hi的最大的回文数字，例如：12345 -> 12321
                 */
                int max = hi - latterHalf + reversedFormerHalf;
                /**
                 * 如果max>=lo，则max是[lo,hi]范围内最大的回文数字；反之，[lo,hi]范围内的其余回文数字小于max，必然也小于lo
                 */
                return max >= lo ? max : -1;
            } else {
                /**
                 * 假设hi的前半部分（含最中间数位的数字）表示的数字减去1的差值为formerHalf1，则用formerHalf1替换hi的前半部分（含最中间
                 * 数位的数字），用formerHalf1截去个位数再翻转后表示的数字替换hi的后半部分后，得到的数字为小于等于hi的最大的回文数字，例
                 * 如：54321 -> 54245
                 */
                int formerHalf1 = hi / pow(bitLength / 2) - 1;
                int max = formerHalf1 * pow(bitLength / 2) + reverseNum(formerHalf1 / 10);
                /**
                 * 如果max>=lo，则max是[lo,hi]范围内最大的回文数字；反之，[lo,hi]范围内的其余回文数字小于max，必然也小于lo
                 */
                return max >= lo ? max : -1;
            }
        }
    }

    /**
     * 获取[lo,hi]之间最小的回文数字，如果不存在则返回-1
     *
     * @param lo
     * @param hi
     * @return
     */
    public static int getMinPalindromicNumberBetween(int lo, int hi) {
        /**
         * 如果lo和hi都为一位数，则[lo,hi]范围内最小的回文数字就是lo
         */
        if (lo < 10) {
            return lo;
        }
        /**
         * lo的数位个数，例如：1234 -> 4，12345 -> 5
         */
        int bitLength = getBitLength(lo);

        if (bitLength % 2 == 0) {
            /**
             * lo的前半部分表示的数字，例如：4321 -> 43
             */
            int formerHalf = splitNum(lo, bitLength, 0, bitLength / 2 - 1);
            /**
             * lo的后半部分表示的数字，例如：4321 -> 21
             */
            int latterHalf = splitNum(lo, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * lo的前半部分翻转后表示的数字，例如：4321 -> 43 -> 34
             */
            int reversedFormerHalf = reverseNum(formerHalf);

            if (reversedFormerHalf >= latterHalf) {
                /**
                 * 为了获得尽可能小的回文数字，尽量保持lo的高位数字不动。如果用lo的前半部分翻转后表示的数字替换lo的后半部分表示的数字后，能
                 * 得到更大的数字min，则min为大于等于lo的最小的回文数字，例如：4321 -> 4334
                 */
                int min = lo - latterHalf + reversedFormerHalf;
                /**
                 * 如果min<=hi，则min是[lo,hi]范围内最小的回文数字；反之，[lo,hi]范围内的其余回文数字大于min，必然也大于lo
                 */
                return min <= hi ? min : -1;
            } else {
                /**
                 * lo的前半部分表示的数字的数位个数，例如：4321 -> 43，数位个数为2
                 */
                int formerHalfLength = bitLength / 2;
                /**
                 * lo的前半部分表示的数字加上1的和值的数位个数，例如：4321 -> 43 -> 44，数位个数为2
                 */
                int formerHalfLength1 = getBitLength(formerHalf + 1);

                if (formerHalfLength1 > formerHalfLength) {
                    /**
                     * 如果formerHalfLength1大于formerHalfLength，说明lo为99……99的形式，大于等于lo的最小的回文数字为100……01的形式，
                     * 例如：99999 -> 100001
                     */
                    int min = pow(bitLength - 1) + 1;
                    /**
                     * 如果min<=hi，则min是[lo,hi]范围内最小的回文数字；反之，[lo,hi]范围内的其余回文数字大于min，必然也大于lo
                     */
                    return min <= hi ? min : -1;
                } else {
                    /**
                     * 如果formerHalfLength1等于formerHalfLength，假设lo的前半部分表示的数字加上1的和值为formerHalf1，则用
                     * formerHalf1替换lo的前半部分，用formerHalf1翻转后表示的数字替换lo的后半部分后，得到的数字为大于等于lo的最大的回
                     * 文数字，例如：1234 -> 1331
                     */
                    int formerHalf1 = formerHalf + 1;
                    int min = formerHalf1 * pow(formerHalfLength1) + reverseNum(formerHalf1);
                    /**
                     * 如果min<=hi，则min是[lo,hi]范围内最小的回文数字；反之，[lo,hi]范围内的其余回文数字大于min，必然也大于lo
                     */
                    return min <= hi ? min : -1;
                }
            }
        } else {
            /**
             * lo的前半部分（不含最中间数位的数字）表示的数字，例如：12345 -> 12
             */
            int formerHalf = splitNum(lo, bitLength, 0, bitLength / 2 - 1);
            /**
             * lo的后半部分表示的数字（不含最中间数位的数字），例如：12345 -> 45
             */
            int latterHalf = splitNum(lo, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * lo的前半部分（不含最中间数位的数字）翻转后表示的数字，例如：12345 -> 12 -> 21
             */
            int reversedFormerHalf = reverseNum(formerHalf);

            if (reversedFormerHalf >= latterHalf) {
                /**
                 * 为了获得尽可能大的回文数字，尽量保持hi的高位数字不动。如果用hi的前半部分（不含最中间数位的数字）翻转后表示的数字替换hi的
                 * 后半部分表示的数字后，能得到更小的数字max，则max为小于等于hi的最大的回文数字，例如：12345 -> 12321
                 */
                int min = lo - latterHalf + reversedFormerHalf;
                /**
                 * 如果min<=hi，则min是[lo,hi]范围内最小的回文数字；反之，[lo,hi]范围内的其余回文数字大于min，必然也大于lo
                 */
                return min <= hi ? min : -1;
            } else {
                /**
                 * 假设lo的前半部分（含最中间数位的数字）表示的数字加上1的和值为formerHalf1，则用formerHalf1替换hi的前半部分（含最中间
                 * 数位的数字），用formerHalf1截去个位数再翻转后表示的数字替换lo的后半部分后，得到的数字为大于等于lo的最小的回文数字，例
                 * 如：12345 -> 12421
                 */
                int formerHalf1 = lo / pow(bitLength / 2) + 1;
                int min = formerHalf1 * pow(bitLength / 2) + reverseNum(formerHalf1 / 10);
                /**
                 * 如果min<=hi，则min是[lo,hi]范围内最小的回文数字；反之，[lo,hi]范围内的其余回文数字大于min，必然也大于lo
                 */
                return min <= hi ? min : -1;
            }
        }
    }

    /**
     * 计算10的exponent次幂
     *
     * @param exponent
     * @return
     */
    public static int pow(int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return 10;
        }
        int help = pow(exponent / 2);
        return exponent % 2 == 0 ? help * help : help * help * 10;
    }

    /**
     * num翻转后表示的数字，例如：1234 -> 4321
     *
     * @param num
     * @return
     */
    public static int reverseNum(int num) {
        int reversedNum = 0;
        int bitLength = getBitLength(num);
        int weight = pow(bitLength - 1);

        while (num != 0) {
            reversedNum += num % 10 * weight;
            weight /= 10;
            num /= 10;
        }
        return reversedNum;
    }

    /**
     * num截取从高到低第[start,end]数位后表示的数字，例如：(12345,5,1,3) -> 234
     *
     * @param num
     * @param bitLength
     * @param start
     * @param end
     * @return
     */
    public static int splitNum(int num, int bitLength, int start, int end) {
        return (num % pow(bitLength - start) - num % pow(bitLength - end - 1)) / pow(bitLength - 1 - end);
    }

    /**
     * num的数位个数，例如：1234 -> 4
     *
     * @param num
     * @return
     */
    public static int getBitLength(int num) {
        int length = 0;

        while (num != 0) {
            length++;
            num /= 10;
        }
        return length;
    }
}
