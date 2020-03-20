package leetcode.interview;

/**
 * Description: 面试题 16.05. 阶乘尾数
 *
 * @author Baltan
 * @date 2018/1/6 20:30
 * @see leetcode.algorithms.TrailingZeroes
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        int zeroNum = 0;
        /**
         * 尾随零的个数只和n分解素因数后，因子中2的个数和5的个数有关，显然2的个数肯定多余5的个数，所以只需
         * 考虑5的个数即可
         */
        while (n >= 5) {
            zeroNum += (n / 5);
            n /= 5;
        }
        return zeroNum;
    }
}
