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
                /**
                 * x^2n
                 * =(x^n)*(x^n)
                 *
                 * n>0
                 */
                int m = n / 2;
                double value = myPow(x, m);
                return value * value;
            } else {
                /**
                 * x^(2n+1)
                 * =(x^n)*(x^n)*x
                 *
                 * n>0
                 */
                int m = n / 2;
                double value = myPow(x, m);
                return value * value * x;
            }
        } else {
            /**
             * x^2n
             * =1/(x^2m)
             * =1/[(x^m)*(x^m)]
             *
             * n<0且m=-n
             */
            if (n % 2 == 0) {
                int m = -(n / 2);
                double value = myPow(x, m);
                return 1 / (value * value);
            } else {
                /**
                 * x^(2n-1)
                 * =1/[x^(2m+1)]
                 * =1/[(x^m)*(x^m)*x]
                 *
                 * n<0且m=-n
                 */
                int m = -(n / 2);
                double value = myPow(x, m);
                return 1 / (value * value * x);
            }
        }
    }
}
