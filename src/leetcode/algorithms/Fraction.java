package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: LCP 2. 分式化简
 *
 * @author Baltan
 * @date 2019-09-27 09:39
 */
public class Fraction {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(fraction(new int[]{3, 2, 0, 2}));
        OutputUtils.print1DIntegerArray(fraction(new int[]{0, 0, 3}));
        OutputUtils.print1DIntegerArray(fraction(new int[]{0, 2147483647}));
    }

    public static int[] fraction(int[] cont) {
        int length = cont.length;
        int[] value = {0, 1};
        /**
         * 对于最后一个a到第二个a，即a1为止，由内向外逐层计算，1/(a+value)的值，并将结果赋值给value，
         * 最内层的a取倒数1/a，可以看做1/[a+(0/1)]，所以初始化value=[0,1]
         */
        for (int i = length - 1; i > 0; i--) {
            long denominator = 0L + value[0] + value[1] * cont[i];
            long numerator = 0L + value[1];
            value = reduction(numerator, denominator);
        }
        /**
         * 对于第一个a，即最外层的a0，只需要计算a0+value，不需要取倒数
         */
        return reduction(0L + value[0] + value[1] * cont[0], 0L + value[1]);
    }

    public static int[] reduction(long numerator, long denominator) {
        /**
         * 约分计算
         */
        if (numerator % denominator == 0) {
            return new int[]{(int) (numerator / denominator), 1};
        } else if (denominator % numerator == 0) {
            return new int[]{1, (int) (denominator / numerator)};
        } else {
            long max = Math.max(numerator, denominator);
            long min = Math.min(numerator, denominator);
            long diff = max - min;

            while (diff != min) {
                max = Math.max(diff, min);
                min = Math.min(diff, min);
                diff = max - min;
            }
            return new int[]{(int) (numerator / diff), (int) (denominator / min)};
        }
    }
}
