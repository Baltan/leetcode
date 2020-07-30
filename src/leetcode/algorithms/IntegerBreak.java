package leetcode.algorithms;

/**
 * Description: 343. Integer Break
 *
 * @author Baltan
 * @date 2019-03-31 09:32
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(7));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(9));
        System.out.println(integerBreak(10));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/"></a>
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int quotient = n / 3;
        int remainder = n % 3;

        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            /**
             * 将余数1和一个3合并成4，4 拆分成2*2>1*3
             */
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
