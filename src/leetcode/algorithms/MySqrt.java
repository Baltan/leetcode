package leetcode.algorithms;

/**
 * Description: Sqrt(x)
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
    }

    public static int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (x + res * res) / (2 * res);
        }
        return (int) res;
    }
}
