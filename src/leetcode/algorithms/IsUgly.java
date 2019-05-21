package leetcode.algorithms;

/**
 * Description: 263. Ugly Number
 *
 * @author Baltan
 * @date 2018/1/6 19:43
 */
public class IsUgly {
    public static void main(String[] args) {
        System.out.println(isUgly(-1));
        System.out.println(isUgly(0));
        System.out.println(isUgly(1));
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2.0 == 0) {
            num /= 2.0;
        }
        while (num % 3.0 == 0) {
            num /= 3.0;
        }
        while (num % 5.0 == 0) {
            num /= 5.0;
        }
        return num == 1;
    }
}
