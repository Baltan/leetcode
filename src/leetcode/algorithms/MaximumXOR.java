package leetcode.algorithms;

/**
 * Description: 2317. Maximum XOR After Operations
 *
 * @author Baltan
 * @date 2023/1/19 09:55
 */
public class MaximumXOR {
    public static void main(String[] args) {
        System.out.println(maximumXOR(new int[]{3, 2, 4, 6}));
        System.out.println(maximumXOR(new int[]{1, 2, 3, 9, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-xor-after-operations/solutions/1625247/yi-bu-bu-tis-by-endlesscheng-89kw/"></a>
     *
     * @param nums
     * @return
     */
    public static int maximumXOR(int[] nums) {
        int result = 0;
        /**
         * 对于每个num，可以替换为num&(num^x)，其中x为任意值。
         * 因为x可以为任意值，所以num^x可以得到任意值，于是可以将num^x看做任意值y。
         * num&y只能将num的某些二进制位上的1变为0，而不能从0变为1。
         * 为了得到数组nums中所有num按位异或的最大值，需要尽可能让每个二进制位上，数组nums中只有奇数个num在该位上为1，因为奇数个1按位异或的结
         * 果仍为1，否则为0。
         * 对于某一个二进制位，数组nums中只需要至少有一个num在该位上为1，就能保证最终数组nums中只有奇数个num在该位上为1，通过或运算判断是否至
         * 少有一个num在该位上为1
         */
        for (int num : nums) {
            result |= num;
        }
        return result;
    }
}
