package leetcode.algorithms;

/**
 * Description: 2048. Next Greater Numerically Balanced Number
 *
 * @author Baltan
 * @date 2021/11/18 17:18
 */
public class NextBeautifulNumber {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
        System.out.println(nextBeautifulNumber(1000));
        System.out.println(nextBeautifulNumber(3000));
        System.out.println(nextBeautifulNumber(768758));
        System.out.println(nextBeautifulNumber(44325));
    }

    public static int nextBeautifulNumber(int n) {
        /**
         * 从n+1开始逐一尝试，直到找到第一个数值平衡数
         */
        for (int i = n + 1; ; i++) {
            if (isBeautifulNumber(i)) {
                return i;
            }
        }
    }

    /**
     * 判断n是否是数值平衡数
     *
     * @param n
     * @return
     */
    public static boolean isBeautifulNumber(int n) {
        /**
         * countArr[i]表示数字i在n中出现的次数
         */
        int[] countArr = new int[10];

        while (n > 0) {
            /**
             * n个位上的数字
             */
            int remainder = n % 10;
            countArr[remainder]++;
            n /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (countArr[i] != 0 && countArr[i] != i) {
                return false;
            }
        }
        return true;
    }
}
