package leetcode.algorithms;

/**
 * Description: 201. Bitwise AND of Numbers Range
 *
 * @author Baltan
 * @date 2019-12-28 00:17
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
        System.out.println(rangeBitwiseAnd(0, 2147483647));
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(rangeBitwiseAnd(2147483647, 2147483647));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int result = m;
        /**
         * 如果m=Integer.MAX_VALUE，则n也为Integer.MAX_VALUE，直接返回Integer.MAX_VALUE
         */
        if (result == Integer.MAX_VALUE) {
            return result;
        }

        for (int i = m + 1; i <= n; i++) {
            result &= i;
            /**
             * 如果当前循环过的这些数字按位与的结果为0，则退出循环，因为0与后面的任何数字按位与的结果
             * 仍旧为0；如果当前循环到i为Integer.MAX_VALUE，则退出循环，因为i++之后，i会变为
             * -2147483648，会继续进入循环，直到结果变为0才退出循环。
             */
            if (result == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }
        return result;
    }
}
