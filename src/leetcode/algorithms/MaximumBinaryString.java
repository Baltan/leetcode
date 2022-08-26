package leetcode.algorithms;

/**
 * Description: 1702. Maximum Binary String After Change
 *
 * @author Baltan
 * @date 2022/8/20 14:21
 */
public class MaximumBinaryString {
    public static void main(String[] args) {
        System.out.println(maximumBinaryString("000110"));
        System.out.println(maximumBinaryString("01"));
        System.out.println(maximumBinaryString("00000000"));
        System.out.println(maximumBinaryString("11111111"));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-binary-string-after-change/solution/maximum-binary-string-after-change-by-ik-tugt/"></a>
     *
     * @param binary
     * @return
     */
    public static String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        /**
         * 字符串binary最左边连续的"1"的个数
         */
        int leftOnes = 0;
        /**
         * 字符串binary中"0"的个数
         */
        int zeros = 0;
        /**
         * 是否继续计算字符串binary最左边连续的"1"的个数
         */
        boolean countLeftOnes = true;

        for (char c : charArray) {
            if (c == '0') {
                zeros++;
                countLeftOnes = false;
            } else {
                if (countLeftOnes) {
                    leftOnes++;
                }
            }
        }
        /**
         * 如果字符串binary本身完全由"1"构成，不需要任何变换，本身就是最大二进制字符串
         */
        if (leftOnes == charArray.length) {
            return binary;
        }
        /**
         * 为了让字符串binary变成最大二进制字符串，左边要尽可能的变成"1"，所以原来最左边连续的"1"都不需要变换。通过"10"到"01"
         * 的变换将字符串binary中其余的"1"都移到最右边，所有的"0"都集中到中间部分，最后将中间的"0000……0000"通过"00"到"10"的
         * 变换变成"1111……1110"。所以最终字符串中只剩一个"0"，索引位置为leftOnes+zeros-1，其余都是"1"
         */
        int zeroIndex = leftOnes + zeros - 1;

        for (int i = leftOnes; i < charArray.length; i++) {
            if (i == zeroIndex) {
                charArray[i] = '0';
            } else {
                charArray[i] = '1';
            }
        }
        return new String(charArray);
    }
}
