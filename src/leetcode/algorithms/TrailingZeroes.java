package leetcode.algorithms;

/**
 * Description:Factorial Trailing Zeroes
 *
 * @author Baltan
 * @date 2018/1/6 20:30
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        int zeroNum = 0;
        while (n >= 5) {
            zeroNum += (n / 5);
            n /= 5;
        }
        return zeroNum;
    }
}
