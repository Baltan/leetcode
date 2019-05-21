package leetcode.algorithms;

/**
 * Description: 50. Pow(x, n)
 *
 * @author Baltan
 * @date 2018/9/18 11:28
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n > 0) {
            if (n % 2 == 0) {
                int m = n / 2;
                double value = myPow(x, m);
                return value * value;
            } else {
                int m = n / 2;
                double value = myPow(x, m);
                return value * value * x;
            }
        } else {
            if (n % 2 == 0) {
                int m = -(n / 2);
                double value = myPow(x, m);
                return 1 / (value * value);
            } else {
                int m = -(n / 2);
                double value = myPow(x, m);
                return 1 / (value * value * x);
            }
        }
    }
}
