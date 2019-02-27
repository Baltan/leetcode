package leetcode.algorithms;

/**
 * Description:Binary Number with Alternating Bits
 *
 * @author Baltan
 * @date 2017/12/29 16:59
 */
public class HasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(2147483647));
    }

    public static boolean hasAlternatingBits(int n) {
        long max = 0;
        for (int i = 30; i >= 0; i -= 2) {
            max += Math.pow(2, i);
        }
        if (n < 0 || n > max) {
            return false;
        } else if (n % 2 == 0) {
            int sum = 0;
            int i = 1;
            while (sum < n) {
                sum += Math.pow(2, i);
                i += 2;
                if (sum == n) {
                    return true;
                }
            }
        } else {
            int sum = 0;
            int i = 0;
            while (sum < n) {
                sum += Math.pow(2, i);
                i += 2;
                if (sum == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
