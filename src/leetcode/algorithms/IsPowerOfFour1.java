package leetcode.algorithms;

/**
 * Description: 342. Power of Four
 *
 * @author Baltan
 * @date 2018/1/6 19:40
 */
public class IsPowerOfFour1 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfFour(3));
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(6));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(1073741823));
        System.out.println(isPowerOfFour(1073741824));
        System.out.println(isPowerOfFour(1073741825));
        System.out.println(isPowerOfFour(2147483647));
    }

    public static boolean isPowerOfFour(int num) {
        int i = 0b01010101010101010101010101010101;

        if (num <= 0) {
            return false;
        } else if ((num & (num - 1)) != 0) {
            return false;
        } else {
            return (num & i) == num;
        }
    }
}
