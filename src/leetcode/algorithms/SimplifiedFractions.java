package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1447. Simplified Fractions
 *
 * @author Baltan
 * @date 2020-05-18 09:13
 */
public class SimplifiedFractions {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(2));
        System.out.println(simplifiedFractions(3));
        System.out.println(simplifiedFractions(4));
        System.out.println(simplifiedFractions(1));
        System.out.println(simplifiedFractions(100));
    }

    public static List<String> simplifiedFractions(int n) {
        List<String> result = new LinkedList<>();
        /**
         * 所有分子为1的真分数
         */
        for (int i = 2; i <= n; i++) {
            result.add("1/" + i);
        }
        /**
         * 循环计算分子为numerator的最简真分数
         */
        for (int numerator = 2; numerator < n; numerator++) {
            /**
             * 保存分子为numerator时，分数值在(0,1/2)之间的最简真分数的所有分母值
             */
            List<Integer> denominators = new LinkedList<>();
            int k = 0;
            /**
             * 查找分母值在[numerator+1,numerator*2)之间的，即分数值在(0,1/2)之间的最简真分数，将符合条件的分母
             * 值加入denominators中
             */
            for (int denominator = numerator + 1; denominator < numerator * 2; denominator++) {
                if (isCoprime(numerator, denominator)) {
                    denominators.add(denominator);
                }
            }

            outer:
            while (true) {
                /**
                 * 如果a/b是最简分数，则a/b+ka（k∈N）也为最简分数，即a/b、a/b+a、a/b+2a、a/b+3a……都是最简分数，
                 * 所有b+ka<n的最简分数都是符合条件的
                 */
                for (int denominator : denominators) {
                    if (denominator + k * numerator > n) {
                        break outer;
                    }
                    result.add(numerator + "/" + (denominator + k * numerator));
                }
                k++;
            }
        }
        return result;
    }

    /**
     * 判断两数是否是互质的
     *
     * @param i
     * @param j
     * @return
     */
    public static boolean isCoprime(int i, int j) {
        int max = Math.max(i, j);
        int min = Math.min(i, j);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min == 1;
    }
}
