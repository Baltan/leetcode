package leetcode.algorithms;

/**
 * Description: 2220. Minimum Bit Flips to Convert Number
 *
 * @author Baltan
 * @date 2022/4/11 22:59
 */
public class MinBitFlips {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(minBitFlips(3, 4));
    }

    public static int minBitFlips(int start, int goal) {
        int result = 0;
        /**
         * 两数异或得到使两数二进制表示中不同的数位变为1，相同的数位变为0
         */
        int xor = start ^ goal;
        /**
         * 计算xor的二进制表示中1的个数
         */
        while (xor != 0) {
            if ((xor & 1) == 1) {
                result++;
            }
            xor >>= 1;
        }
        return result;
    }
}
