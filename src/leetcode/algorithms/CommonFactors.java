package leetcode.algorithms;

/**
 * Description: 2427. Number of Common Factors
 *
 * @author Baltan
 * @date 2023/2/10 09:25
 */
public class CommonFactors {
    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
        System.out.println(commonFactors(25, 30));
    }

    public static int commonFactors(int a, int b) {
        int result = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        /**
         * 辗转相除法计算a和b的最大公约数
         */
        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        /**
         * 最大公约数的因子就是a和b的公因子
         */
        for (int i = 1; i <= min; i++) {
            if (min % i == 0) {
                result++;
            }
        }
        return result;
    }
}
