package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.List;

/**
 * Description: 3315. Construct the Minimum Bitwise Array II
 *
 * @author baltan
 * @date 2024/10/14 09:07
 * @see MinBitwiseArray
 */
public class MinBitwiseArray1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minBitwiseArray(List.of(2, 3, 5, 7)));
        OutputUtils.print1DIntegerArray(minBitwiseArray(List.of(11, 13, 31)));
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        /**
         * 观察发现，如果n|(n+1)=m，n和m的二进制值的差异在于，某一个位上m为1，n为0，其他位上的值都相等。从高位到低位遍历m的二进制值，如果
         * 某一位上为1，将这一位改为0后得到n，判断n|(n+1)是否等于m，找到第一个这样的n即可
         */
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            /**
             * num的二进制值的字符串表示
             */
            String binaryString = Integer.toBinaryString(num);
            char[] chars = binaryString.toCharArray();
            result[i] = -1;

            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    chars[j] = '0';
                    /**
                     * 将二进制字符串转换为数值
                     */
                    int x = Integer.parseInt(new String(chars), 2);

                    if ((x | (x + 1)) == num) {
                        result[i] = x;
                        chars[j] = '1';
                        break;
                    }
                    chars[j] = '1';
                }
            }
        }
        return result;
    }
}
