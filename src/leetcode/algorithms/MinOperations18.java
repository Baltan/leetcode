package leetcode.algorithms;

/**
 * Description: 2997. Minimum Number of Operations to Make Array XOR Equal to K
 *
 * @author Baltan
 * @date 2024/1/7 13:34
 */
public class MinOperations18 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 1, 3, 4}, 1));
        System.out.println(minOperations(new int[]{2, 0, 2, 0}, 0));
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        /**
         * 数组nums中所有元素按位异或的值
         */
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }
        /**
         * 从低位到高位依次判断k的二进制值和xor的二进制值的每一位是否相等，如果不相等，只需将数组nums中任意一个数的二进制值在该数位上翻转即
         * 可，即需要一次操作
         */
        for (int i = 0; i < 32; i++) {
            int kBit = k & (1 << i);
            int xorBit = xor & (1 << i);
            result += kBit == xorBit ? 0 : 1;
        }
        return result;
    }
}
