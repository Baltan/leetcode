package leetcode.interview;

/**
 * Description: 面试题 05.07. 配对交换
 *
 * @author Baltan
 * @date 2020-03-15 14:45
 */
public class ExchangeBits {
    public static void main(String[] args) {
        System.out.println(exchangeBits(2));
        System.out.println(exchangeBits(3));
    }

    public static int exchangeBits(int num) {
        /**
         * num二进制表示的所有偶数位
         */
        int evenBits = num & 0b01010101010101010101010101010101;
        /**
         * num二进制表示的所有奇数位
         */
        int oddBits = num & 0b10101010101010101010101010101010;
        /**
         * 将所有偶数位左移一位后，全部偶数位交换到奇数位
         */
        evenBits <<= 1;
        /**
         * 将所有奇数位右移一位后，全部奇数位交换到偶数位
         */
        oddBits >>= 1;
        return evenBits + oddBits;
    }
}
