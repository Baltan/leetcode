package leetcode.algorithms;

/**
 * Description:Power of Three
 *
 * @author Baltan
 * @date 2018/1/5 13:47
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(28));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(243));
    }

    public static boolean isPowerOfThree(int n) {
        double value = Math.log10(n) / Math.log10(3);
        return value % 1 == 0;
    }
}
