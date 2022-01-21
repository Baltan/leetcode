package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 1980. Find Unique Binary String
 *
 * @author Baltan
 * @date 2022/1/21 10:19
 */
public class FindDifferentBinaryString {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        /**
         * 长度为length的二进制字符串转为十进制数字的最小可能值
         */
        int min = 0;
        /**
         * 长度为length的二进制字符串转为十进制数字的最大可能值
         */
        int max = (1 << length) - 1;
        /**
         * 已有二进制字符串转为十进制数字的集合
         */
        Set<Integer> values =
                Arrays.stream(nums)
                        .map(num -> getValue(num))
                        .collect(Collectors.toSet());

        for (int i = min; i <= max; i++) {
            if (!values.contains(i)) {
                return getNum(i, length);
            }
        }
        return "";
    }

    /**
     * 将二进制字符串转为十进制数字
     *
     * @param num
     * @return
     */
    public static int getValue(String num) {
        int value = 0;
        int base = 1;
        char[] charArray = num.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {
            value += (charArray[i] - '0') * base;
            base <<= 1;
        }
        return value;
    }

    /**
     * 将十进制数字转为长度为length的二进制字符串，不足位数的前导补0
     *
     * @param value
     * @param length
     * @return
     */
    public static String getNum(int value, int length) {
        StringBuilder builder = new StringBuilder(length);

        while (value != 0 || length > 0) {
            int remainder = value % 2;
            builder.insert(0, remainder);
            value /= 2;
            length--;
        }
        return builder.toString();
    }
}
