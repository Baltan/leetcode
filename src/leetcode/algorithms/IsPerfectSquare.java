package leetcode.algorithms;

/**
 * Description:Valid Perfect Square
 *
 * @author Baltan
 * @date 2018/1/6 19:59
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(2147483647));
    }

    public static boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        double doubleNum = num;
        for (int i = 1; i <= doubleNum / i; i++) {
            if (doubleNum / i == i) {
                return true;
            }
        }
        return false;
    }
}
