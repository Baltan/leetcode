package leetcode.algorithms;

/**
 * Description: Sum of Two Integers
 *
 * @author Baltan
 * @date 2019-03-15 14:41
 */
public class GetSum {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(-2, 3));
    }

    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
