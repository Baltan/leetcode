package leetcode.algorithms;

/**
 * Description: 564. Find the Closest Palindrome
 *
 * @author baltan
 * @date 2023/12/19 12:14
 * @see NearestPalindromic
 * @see MinimumCost3
 */
public class NearestPalindromic1 {
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("9"));
        System.out.println(nearestPalindromic("10"));
        System.out.println(nearestPalindromic("15"));
        System.out.println(nearestPalindromic("55"));
        System.out.println(nearestPalindromic("99"));
        System.out.println(nearestPalindromic("100"));
        System.out.println(nearestPalindromic("123"));
        System.out.println(nearestPalindromic("999"));
        System.out.println(nearestPalindromic("1000"));
        System.out.println(nearestPalindromic("1008"));
        System.out.println(nearestPalindromic("9999"));
        System.out.println(nearestPalindromic("686768"));
        System.out.println(nearestPalindromic("11011"));
    }

    public static String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        /**
         * 小于num的最大的回文数字
         */
        long max = getMaxPalindrome(num);
        /**
         * 大于num的最小的回文数字
         */
        long min = getMinPalindrome(num);
        return String.valueOf(num - max <= min - num ? max : min);
    }

    /**
     * 获取小于num的最大的回文数字
     *
     * @param num
     * @return
     */
    public static long getMaxPalindrome(long num) {
        if (num <= 10) {
            return num - 1;
        }
        /**
         * num的数位个数，例如：1234 -> 4，12345 -> 5
         */
        int bitLength = getBitLength(num);
        /**
         * 为了获得尽可能大的回文数字，尽量保持num的高位数字不动
         */
        if (bitLength % 2 == 0) {
            /**
             * num的前半部分表示的数字，例如：1234 -> 12
             */
            long formerHalf = splitNum(num, bitLength, 0, bitLength / 2 - 1);
            /**
             * num的后半部分表示的数字，例如：1234 -> 34
             */
            long latterHalf = splitNum(num, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * formerHalf翻转后表示的数字，例如：1234 -> 12 -> 21
             */
            long reversedFormerHalf = reverseNum(formerHalf);
            /**
             * num的前半部分表示的数字减去1的差值，例如：1000 -> 10 -> 9或4321 -> 432 -> 431
             */
            long formerHalf1 = formerHalf - 1;
            /**
             * formerHalf的数位个数，例如：1234 -> 12，数位个数为2
             */
            int formerHalfLength = getBitLength(formerHalf);
            /**
             * formerHalf1的数位个数，例如：1234 -> 12 -> 11，数位个数为2
             */
            int formerHalfLength1 = getBitLength(formerHalf1);

            if (reversedFormerHalf < latterHalf) {
                /**
                 * 用reversedFormerHalf替换latterHalf后，得到的数字为小于num的最大的回文数字，例如：1234 -> 1221
                 */
                return num - latterHalf + reversedFormerHalf;
            } else {
                if (formerHalfLength1 < formerHalfLength) {
                    /**
                     * 如果formerHalfLength1小于formerHalfLength，说明num为100……00或100……01的形式，小于num的最大的回文数字为
                     * 99……99的形式，例如：100000 -> 99999或100001 -> 99999
                     */
                    return pow(bitLength - 1) - 1;
                } else {
                    /**
                     * 如果formerHalf1为0，则num只可能为11，小于num的最大的回文数字为9。否则，用formerHalf1替换formerHalf，用
                     * formerHalf1翻转后表示的数字替换latterHalf，得到的数字为小于num的最大的回文数字，例如：4321 -> 4224
                     */
                    return formerHalf1 == 0 ? 9 : formerHalf1 * pow(formerHalfLength1) + reverseNum(formerHalf1);
                }
            }
        } else {
            /**
             * num的前半部分（不含最中间数位的数字）表示的数字，例如：12345 -> 12
             */
            long formerHalf = splitNum(num, bitLength, 0, bitLength / 2 - 1);
            /**
             * num的后半部分（不含最中间数位的数字）表示的数字，例如：12345 -> 45
             */
            long latterHalf = splitNum(num, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * formerHalf翻转后表示的数字，例如：12345 -> 12 -> 21
             */
            long reversedFormerHalf = reverseNum(formerHalf);
            /**
             * num的前半部分（含最中间数位的数字）表示的数字，例如：12345 -> 123或10001 -> 100
             */
            long formerHalf2 = num / pow(bitLength / 2);
            /**
             * num的前半部分（含最中间数位的数字）表示的数字减去1的差值，例如：101 -> 10 -> 9或10001 -> 100 -> 99
             */
            long formerHalf3 = formerHalf2 - 1;
            /**
             * formerHalf2的数位个数，例如：12345 -> 123，数位个数为3
             */
            int formerHalfLength2 = getBitLength(formerHalf2);
            /**
             * formerHalf3的数位个数，例如：54321 -> 543 -> 542，数位个数为3，10001 -> 100 -> 99，数位个数为2
             */
            int formerHalfLength3 = getBitLength(formerHalf3);

            if (reversedFormerHalf < latterHalf) {
                /**
                 * 用reversedFormerHalf替换latterHalf后，得到的数字为小于num的最大的回文数字，例如：12345 -> 12321
                 */
                return num - latterHalf + reversedFormerHalf;
            } else {
                if (formerHalfLength3 < formerHalfLength2) {
                    /**
                     * 如果formerHalfLength3小于formerHalfLength2，说明num为100……00或100……01的形式，小于num的最大的回文数字为
                     * 99……99的形式，例如：10000 -> 9999或10001 -> 9999
                     */
                    return pow(bitLength - 1) - 1;
                } else {
                    /**
                     * 如果formerHalf3是一位数，用formerHalf3替换formerHalf2，用formerHalf3翻转后表示的数字替换num的后半部分，得到
                     * 的数字为小于num的最大的回文数字，例如：100 -> 99。否则，用formerHalf3替换formerHalf2，用formerHalf3截去个位
                     * 数再翻转后表示的数字替换latterHalf，得到的数字为小于num的最大的回文数字，例如：54321 -> 54245
                     */
                    return formerHalfLength3 == 1 ? formerHalf3 * pow(formerHalfLength3) + reverseNum(formerHalf3) :
                            formerHalf3 * pow(bitLength / 2) + reverseNum(formerHalf3 / 10);
                }
            }
        }
    }

    /**
     * 获取大于num的最小的回文数字
     *
     * @param num
     * @return
     */
    public static long getMinPalindrome(long num) {
        if (num < 9) {
            return num + 1;
        }
        /**
         * num的数位个数，例如：1234 -> 4，12345 -> 5
         */
        int bitLength = getBitLength(num);
        /**
         * 为了获得尽可能大的回文数字，尽量保持num的高位数字不动
         */
        if (bitLength % 2 == 0) {
            /**
             * num的前半部分表示的数字，例如：4321 -> 43
             */
            long formerHalf = splitNum(num, bitLength, 0, bitLength / 2 - 1);
            /**
             * num的后半部分表示的数字，例如：4321 -> 21
             */
            long latterHalf = splitNum(num, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * formerHalf翻转后表示的数字，例如：4321 -> 43 -> 34
             */
            long reversedFormerHalf = reverseNum(formerHalf);
            /**
             * num的前半部分表示的数字加上1的和值，例如：1000 -> 10 -> 11或98 -> 9 -> 10
             */
            long formerHalf1 = formerHalf + 1;
            /**
             * formerHalf的数位个数，例如：4321 -> 43，数位个数为2
             */
            int formerHalfLength = getBitLength(formerHalf);
            /**
             * formerHalf1的数位个数，例如：4321 -> 43 -> 44，数位个数为2
             */
            int formerHalfLength1 = getBitLength(formerHalf1);

            if (reversedFormerHalf > latterHalf) {
                /**
                 * 用reversedFormerHalf替换latterHalf后，得到的数字为大于num的最小的回文数字，例如：4321 -> 4334
                 */
                return num - latterHalf + reversedFormerHalf;
            } else {
                if (formerHalfLength1 > formerHalfLength) {
                    /**
                     * 如果formerHalfLength1大于formerHalfLength，说明num为99……99的形式，大于num的最小的回文数字为100……01的形式，
                     * 例如：99999 -> 100001
                     */
                    return pow(bitLength) + 1;
                } else {
                    /**
                     * 用formerHalf1替换num的前半部分，用formerHalf1翻转后表示的数字替换latterHalf，得到的数字为大于num的最小的回文
                     * 数字，例如：1234 -> 1331
                     */
                    return formerHalf1 * pow(formerHalfLength1) + reverseNum(formerHalf1);
                }
            }
        } else {
            /**
             * num的前半部分（不含最中间数位的数字）表示的数字，例如：12345 -> 12
             */
            long formerHalf = splitNum(num, bitLength, 0, bitLength / 2 - 1);
            /**
             * num的后半部分表示的数字（不含最中间数位的数字），例如：12345 -> 45
             */
            long latterHalf = splitNum(num, bitLength, (bitLength + 1) / 2, bitLength - 1);
            /**
             * formerHalf翻转后表示的数字，例如：12345 -> 12 -> 21
             */
            long reversedFormerHalf = reverseNum(formerHalf);
            /**
             * num的前半部分（含最中间数位的数字）表示的数字，例如：12345 -> 123或10001 -> 100
             */
            long formerHalf2 = num / pow(bitLength / 2);
            /**
             * num的前半部分（含最中间数位的数字）表示的数字加上1的和值，例如：101 -> 10 -> 11或10001 -> 100 -> 101
             */
            long formerHalf3 = formerHalf2 + 1;

            if (reversedFormerHalf > latterHalf) {
                /**
                 * 用reversedFormerHalf替换latterHalf后，得到的数字为大于num的最小的回文数字，例如：12345 -> 12321
                 */
                return num - latterHalf + reversedFormerHalf;
            } else {
                /**
                 * 用formerHalf3替换formerHalf2，用formerHalf3截去个位数再翻转后表示的数字替换latterHalf，得到的数字为大于num的最小
                 * 的回文数字，例如：12345 -> 12421
                 */
                return formerHalf3 * pow(bitLength / 2) + reverseNum(formerHalf3 / 10);
            }
        }
    }

    /**
     * 计算10的exponent次幂
     *
     * @param exponent
     * @return
     */
    public static long pow(int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return 10;
        }
        long help = pow(exponent / 2);
        return exponent % 2 == 0 ? help * help : help * help * 10;
    }

    /**
     * num翻转后表示的数字，例如：1234 -> 4321
     *
     * @param num
     * @return
     */
    public static long reverseNum(long num) {
        long reversedNum = 0;
        int bitLength = getBitLength(num);
        long weight = pow(bitLength - 1);

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
    public static long splitNum(long num, int bitLength, int start, int end) {
        return (num % pow(bitLength - start) - num % pow(bitLength - end - 1)) / pow(bitLength - 1 - end);
    }

    /**
     * num的数位个数，例如：1234 -> 4
     *
     * @param num
     * @return
     */
    public static int getBitLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;

        while (num != 0) {
            length++;
            num /= 10;
        }
        return length;
    }
}
