package leetcode.algorithms;

/**
 * Description: 190. Reverse Bits
 *
 * @author Baltan
 * @date 2020-03-07 12:11
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(0b00000010100101000001111010011100));
        System.out.println(reverseBits(0b11111111111111111111111111111101));
    }

    public static int reverseBits(int n) {
        int result = 0;
        /**
         * 将n当前的最后一位依次左移31位、30位……0位，例如：n=0b00000010100101000001111010011100
         *
         * 将n的最后一位0左移31位，然后将n右移一位消去最后一位，此时n=0b0000001010010100000111101001110；
         * 将n的最后一位0左移30位，然后将n右移一位消去最后一位，此时n=0b000000101001010000011110100111；
         * 将n的最后一位1左移29位，然后将n右移一位消去最后一位，此时n=0b00000010100101000001111010011；
         * 将n的最后一位1左移28位，然后将n右移一位消去最后一位，此时n=0b0000001010010100000111101001；
         * ……
         * 将n的最后一位0左移1位，然后将n右移一位消去最后一位，此时n=0b0
         * 将n的最后一位0左移0位，然后将n右移一位消去最后一位
         */
        for (int i = 31; i >= 0; i--) {
            result += (n & 1) << i;
            n >>= 1;
        }
        return result;
    }
}
