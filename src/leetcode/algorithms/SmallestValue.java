package leetcode.algorithms;

/**
 * Description: 2507. Smallest Value After Replacing With Sum of Prime Factors
 *
 * @author Baltan
 * @date 2022/12/19 11:03
 */
public class SmallestValue {
    public static void main(String[] args) {
        System.out.println(smallestValue(15));
        System.out.println(smallestValue(3));
    }

    public static int smallestValue(int n) {
        int m = help(n);

        while (m < n) {
            n = m;
            m = help(n);
        }
        return m;
    }

    /**
     * 计算数字n的所有质因数的和
     *
     * @param n
     * @return
     */
    public static int help(int n) {
        int result = 0;
        int factor = 2;
        /**
         * 从最小的质数2开始尝试对n做质因数分解
         */
        while (factor * factor <= n) {
            if (n % factor == 0) {
                result += factor;
                n /= factor;
            } else {
                factor++;
            }
        }
        return result + n;
    }
}
