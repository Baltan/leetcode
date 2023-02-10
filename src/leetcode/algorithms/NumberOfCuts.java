package leetcode.algorithms;

/**
 * Description: 2481. Minimum Cuts to Divide a Circle
 *
 * @author Baltan
 * @date 2023/2/6 14:51
 */
public class NumberOfCuts {
    public static void main(String[] args) {
        System.out.println(numberOfCuts(4));
        System.out.println(numberOfCuts(3));
    }

    public static int numberOfCuts(int n) {
        /**
         * 如果将圆一等分，不需要切割
         */
        if (n == 1) {
            return 0;
        }
        /**
         * 如果将圆分成偶数份，进行n/2次第一种切割；如果将圆分成奇数份，进行n次第二种切割
         */
        return n % 2 == 0 ? n / 2 : n;
    }
}
