package leetcode.algorithms;

/**
 * Description: 1837. Sum of Digits in Base K
 *
 * @author Baltan
 * @date 2022/6/10 09:16
 */
public class SumBase {
    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
        System.out.println(sumBase(10, 10));
    }

    public static int sumBase(int n, int k) {
        int result = 0;

        while (n != 0) {
            result += n % k;
            n /= k;
        }
        return result;
    }
}
