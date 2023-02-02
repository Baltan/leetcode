package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1829. Maximum XOR for Each Query
 *
 * @author Baltan
 * @date 2023/1/29 15:32
 */
public class GetMaximumXor {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getMaximumXor(new int[]{0, 1, 1, 3}, 2));
        OutputUtils.print1DIntegerArray(getMaximumXor(new int[]{2, 3, 4, 7}, 3));
        OutputUtils.print1DIntegerArray(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3));
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefixXors = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixXors[i + 1] = prefixXors[i] ^ nums[i];
        }

        for (int i = 0; i < length; i++) {
            int xor = prefixXors[length - i];
            /**
             * k∈[0,1<<maximumBit)且xor^k尽可能大。假设m=xor^k，则m最大时，其二进制值的较低maximumBit位都可以为1，较高位和xor的较高位
             * 一致，因为k只有较低maximumBit位可能为0或1，较高位都为0，只有较低maximumBit位的0或1可以通过异或运算改变xor的较低maximumBit
             * 位的值，而xor较高位的值都是和0进行异或运算，不会被改变。xor>>maximumBit<<maximumBit将xor先右移消去较低maximumBit位，再
             * 左移maximumBit位得到m的高位部分。(1<<maximumBit)-1得到m的低位部分0b11……11（共maximumBit个1）
             */
            int m = (xor >> maximumBit << maximumBit) + ((1 << maximumBit) - 1);
            /**
             * 因为m=xor^k，所以根据按位异或运算的性质，k=xor^m
             */
            result[i] = xor ^ m;
        }
        return result;
    }
}
