package leetcode.algorithms;

/**
 * Description: Broken Calculator
 *
 * @author Baltan
 * @date 2019-04-10 13:56
 */
public class BrokenCalc {
    public static void main(String[] args) {
        System.out.println(brokenCalc(2, 3));
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(56, 42324234));
    }

    public static int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }

        if ((Y & 1) == 0) {
            return brokenCalc(X, Y / 2) + 1;
        } else {
            return brokenCalc(X, Y + 1) + 1;
        }
    }
}
