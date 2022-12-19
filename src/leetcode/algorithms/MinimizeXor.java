package leetcode.algorithms;

/**
 * Description: 2429. Minimize XOR
 *
 * @author Baltan
 * @date 2022/12/11 13:01
 */
public class MinimizeXor {
    public static void main(String[] args) {
        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));
    }

    public static int minimizeXor(int num1, int num2) {
        /**
         * num1的置位数
         */
        int setBits1 = getSetBits(num1);
        /**
         * num2的置位数
         */
        int setBits2 = getSetBits(num2);
        /**
         * 当所求整数result为num1时，result^num1的值最小，为0
         */
        int result = num1;

        if (setBits1 < setBits2) {
            int diff = setBits2 - setBits1;
            int base = 1;
            /**
             * 将result二进制表示的低位上的diff个0变成1
             */
            while (diff > 0) {
                if ((num1 & 1) == 0) {
                    result += base;
                    diff--;
                }
                num1 >>= 1;
                base <<= 1;
            }
        } else if (setBits1 > setBits2) {
            int diff = setBits1 - setBits2;
            int base = 1;
            /**
             * 将result二进制表示的低位上的diff个1变成0
             */
            while (diff > 0) {
                if ((num1 & 1) == 1) {
                    result -= base;
                    diff--;
                }
                num1 >>= 1;
                base <<= 1;
            }
        }
        return result;
    }

    /**
     * 计算数字num的置位数
     *
     * @param num
     * @return
     */
    public static int getSetBits(int num) {
        int setBits = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                setBits++;
            }
            num >>= 1;
        }
        return setBits;
    }
}
