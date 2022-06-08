package leetcode.interview;

/**
 * Description: 面试题 16.09. 运算
 *
 * @author Baltan
 * @date 2022/6/8 10:00
 * 参考：
 * <a href="https://leetcode.cn/problems/operations-lcci/solution/mian-shi-ti-1609-yun-suan-zhi-yong-liao-jia-fa-yu-/"></a>
 */
public class Operations {
    private int length;
    private int negativeOne;
    private long[] positives;
    private long[] negatives;

    public Operations() {
        /**
         * 因为Integer类型为32位，所以长度取32即可
         */
        length = 32;
        /**
         * positives[0]、positives[1]、positives[2]……依次为1、2、4……
         */
        positives = new long[length];
        /**
         * negatives[0]、negatives[1]、negatives[2]……依次为-1、-2、-4……
         */
        negatives = new long[length];
        /**
         * negativeOne为-1，所有的-1运算都采用+negativeOne的形式
         */
        negativeOne = Integer.MIN_VALUE + Integer.MAX_VALUE;
        positives[0] = 1;
        negatives[0] = negativeOne;

        for (int i = 1; i < length; i++) {
            positives[i] = positives[i + negativeOne] + positives[i + negativeOne];
            negatives[i] = negatives[i + negativeOne] + negatives[i + negativeOne];
        }
    }

    public int minus(int a, int b) {
        if (b == 0) {
            return a;
        }
        /**
         * 按照绝对值从大到小，将b拆分成若干个2的次幂的和，例如：100=64+32+4，-200=(-128)+(-64)+(-8)
         */
        if (b > 0) {
            for (int i = length + negativeOne; i >= 0; i += negativeOne) {
                if (positives[i] <= b) {
                    /**
                     * a减去positives[i]
                     */
                    a += negatives[i];
                    /**
                     * b减去positives[i]
                     */
                    b += negatives[i];
                }
            }
        } else {
            for (int i = length + negativeOne; i >= 0; i += negativeOne) {
                if (negatives[i] >= b) {
                    /**
                     * a减去negatives[i]
                     */
                    a += positives[i];
                    /**
                     * b减去negatives[i]
                     */
                    b += positives[i];
                }
            }
        }
        return a;
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1) {
            return b;
        }

        if (b == 1) {
            return a;
        }

        int result = 0;
        long[] help = new long[length];

        if (a < 0 && b < 0) {
            a = minus(0, a);
            b = minus(0, b);
        }

        if (a > 0) {
            /**
             * help[0]、help[1]、help[2]……依次为b、2b、4b……
             */
            help[0] = b;

            for (int i = 1; i < length; i++) {
                help[i] = help[i + negativeOne] + help[i + negativeOne];
            }
            /**
             * 按照绝对值从大到小，将a拆分成若干个2的次幂的和，例如：100=64+32+4，结果乘积即为64b+32b+4b
             */
            for (int i = length + negativeOne; i >= 0; i += negativeOne) {
                if (positives[i] <= a) {
                    /**
                     * 结果乘积加上positives[i]*b
                     */
                    result += help[i];
                    /**
                     * a减去positives[i]
                     */
                    a += negatives[i];
                }
            }
        } else {
            /**
             * help[0]、help[1]、help[2]……依次为a、2a、4a……
             */
            help[0] = a;

            for (int i = 1; i < length; i++) {
                help[i] = help[i + negativeOne] + help[i + negativeOne];
            }
            /**
             * 按照绝对值从大到小，将b拆分成若干个2的次幂的和，例如：100=64+32+4，结果乘积即为64a+32a+4a
             */
            for (int i = length + negativeOne; i >= 0; i += negativeOne) {
                if (positives[i] <= b) {
                    /**
                     * 结果乘积加上positives[i]*a
                     */
                    result += help[i];
                    /**
                     * b减去positives[i]
                     */
                    b += negatives[i];
                }
            }
        }
        return result;
    }

    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }

        if (b == 1) {
            return a;
        }

        if (b == -1) {
            return minus(0, a);
        }

        int result = 0;
        boolean isPositive = (a < 0 && b < 0) || (a > 0 && b > 0);
        /**
         * 为避免出现a或b为-2147483648取反后变成2147483648后溢出，转换为长整形
         */
        long aa = a;
        long bb = b;

        if (aa < 0) {
            aa = minus(0, a);
        }

        if (bb < 0) {
            bb = minus(0, b);
        }

        if (aa < bb) {
            return 0;
        }
        /**
         * positiveHelp[0]、positiveHelp[1]、positiveHelp[2]……依次为bb、2bb、4bb……
         */
        long[] positiveHelp = new long[length];
        /**
         * negativeHelp[0]、negativeHelp[1]、negativeHelp[2]……依次为-bb、-2bb、-4bb……
         */
        long[] negativeHelp = new long[length];
        positiveHelp[0] = bb;
        negativeHelp[0] = minus(0, (int) bb);

        for (int i = 1; i < length; i++) {
            positiveHelp[i] = positiveHelp[i + negativeOne] + positiveHelp[i + negativeOne];
            negativeHelp[i] = negativeHelp[i + negativeOne] + negativeHelp[i + negativeOne];
        }
        /**
         * 按照绝对值从大到小，将aa拆分成若干个2的次幂乘以bb的和，例如：aa=100，bb=7，则aa=56+28+14+2，结果乘积即为8+4+2
         */
        for (int i = length + negativeOne; i >= 0; i += negativeOne) {
            if (positiveHelp[i] <= aa) {
                /**
                 * 结果商加上positives[i]
                 */
                result += positives[i];
                /**
                 * aa减去positiveHelp[i]
                 */
                aa += negativeHelp[i];
            }
        }
        return isPositive ? result : minus(0, result);
    }

    public static void main(String[] args) {
        Operations operations = new Operations();
        System.out.println(operations.minus(1, 2));
        System.out.println(operations.minus(1000000, 4000));
        System.out.println(operations.minus(1000000, -465000));
        System.out.println(operations.multiply(3, 4));
        System.out.println(operations.multiply(-345, 56));
        System.out.println(operations.multiply(-345, -56));
        System.out.println(operations.divide(5, -2));
        System.out.println(operations.minus(0, -2147483647));
        System.out.println(operations.minus(-1, 2147483647));
        System.out.println(operations.multiply(-1, -2147483647));
        System.out.println(operations.multiply(-100, 21474836));
        System.out.println(operations.divide(2147483647, -1));
        System.out.println(operations.divide(-2147483648, 1));
        System.out.println(operations.divide(-13969484, -5));
    }
}
