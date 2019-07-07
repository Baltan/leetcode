package leetcode.algorithms;

/**
 * Description: 397. Integer Replacement
 *
 * @author Baltan
 * @date 2019-07-07 12:32
 */
public class IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(1));
        System.out.println(integerReplacement(2));
        System.out.println(integerReplacement(3));
        System.out.println(integerReplacement(4));
        System.out.println(integerReplacement(5));
        System.out.println(integerReplacement(6));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(9));
        System.out.println(integerReplacement(10));
        System.out.println(integerReplacement(11));
        System.out.println(integerReplacement(12));
        System.out.println(integerReplacement(2147483647));
        System.out.println(integerReplacement(2147483646));
    }

    public static int integerReplacement(int n) {
        long m = n;
        return help(m);
    }

    public static int help(long m) {
        if (m == 1) {
            return 0;
        } else if (m == 2) {
            return 1;
        } else {
            if ((m & 1) == 1) {
                return 1 + Math.min(help(m + 1), help(m - 1));
            } else {
                return 1 + help((m / 2));
            }
        }
    }
}
