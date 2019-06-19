package leetcode.algorithms;

/**
 * Description: 231. Power of Two
 *
 * @author Baltan
 * @date 2018/1/5 14:03
 */
public class IsPowerOfTwo1 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(1024));
        System.out.println(isPowerOfTwo(1023));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
