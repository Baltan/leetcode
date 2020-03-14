package leetcode.interview;

/**
 * Description: 面试题 05.03. 翻转数位
 *
 * @author Baltan
 * @date 2020-03-14 22:40
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(0b11011101111));
        System.out.println(reverseBits(0b0111));
        System.out.println(reverseBits(0b0111011111001111));
        System.out.println(reverseBits(0b1001001101001101100110));
        System.out.println(reverseBits(0b1110110011110111101000001101100));
    }

    public static int reverseBits(int num) {
        int result = 0;
        /**
         * 之前一段连续的1的长度
         */
        int currentLength = 0;
        /**
         * 再前面的一段连续的1的长度
         */
        int prevLength = 0;
        /**
         * 两段连续的1之间0的个数
         */
        int zeroCount = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                currentLength++;
            } else {
                /**
                 * 前面两段连续的1之间0的个数如果为1个，可以将这个0翻转，从而将两段连续的1连在一起
                 */
                if (zeroCount == 1) {
                    result = Math.max(result, prevLength + currentLength + 1);
                }
                zeroCount = 1;
                prevLength = currentLength;
                /**
                 * 重新开始计数新的一段连续的1的长度
                 */
                currentLength = 0;
            }
            num >>= 1;
        }
        /**
         * 如果num的二进制表示最高位为1，例如：0b111、0b111011111001111，需要最后进行一次判断
         */
        if (zeroCount <= 1) {
            result = Math.max(result, prevLength + currentLength + 1);
        }
        return result;
    }
}
