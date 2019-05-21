package leetcode.algorithms;

/**
 * Description: 342. Power of Four
 *
 * @author Baltan
 * @date 2018/1/6 19:40
 */
public class IsPowerOfFour {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfFour(int num) {
        double value = Math.log10(num) / Math.log10(4);
        return value % 1 == 0;
    }
}
