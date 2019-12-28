package leetcode.algorithms;

/**
 * Description: 201. Bitwise AND of Numbers Range
 *
 * @author Baltan
 * @date 2019-12-28 00:17
 */
public class RangeBitwiseAnd1 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
        System.out.println(rangeBitwiseAnd(0, 2147483647));
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(rangeBitwiseAnd(2147483647, 2147483647));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--41/"></a>
     *
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        int removeCount = 0;
        /**
         * 如果m和n不相等，则[m,n]这些数二进制表示的最低位一定有0和1，则这些数与运算的最低位一定为0。
         * 如果m和n不相等，每次循环，将m和n同时右移一位消除最低位，并且将右移的次数记录下来，直到m和
         * n相等为止。此时，右移的次数即为[m,n]这些数与运算结果低位0的个数，最后将m（或者n）左移这么
         * 多位即可
         */
        while (m != n) {
            m >>= 1;
            n >>= 1;
            removeCount++;
        }
        return m << removeCount;
    }
}
