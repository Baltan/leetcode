package leetcode.algorithms;

/**
 * Description: 69. Sqrt(x)
 *
 * @author Baltan
 * @date 2018/7/27 11:19
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(14));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(24));
        System.out.println(mySqrt(36));
        System.out.println(mySqrt(575));
        System.out.println(mySqrt(3532));
        System.out.println(mySqrt(47658));
        System.out.println(mySqrt(25252262));
        System.out.println(mySqrt(364747584));
    }

    public static int mySqrt(int x) {
        long lo = 0;
        /**
         * 整型x的上限是2^31-1，所以所求答案不可能大于2^16
         */
        long hi = (int) Math.pow(2, 16);
        /**
         * 二分查找
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long pow = mid * mid;

            if (pow > x) {
                hi = mid - 1;
            } else if (pow < x) {
                if ((mid + 1) * (mid + 1) <= x) {
                    lo = mid + 1;
                } else {
                    return (int) mid;
                }
            } else {
                return (int) mid;
            }
        }
        return (int) lo;
    }
}
