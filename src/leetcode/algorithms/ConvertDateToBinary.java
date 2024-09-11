package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description: 3280. Convert Date to Binary
 *
 * @author Baltan
 * @date 2024/9/11 20:37
 */
public class ConvertDateToBinary {
    public static void main(String[] args) {
        System.out.println(convertDateToBinary("2080-02-29"));
        System.out.println(convertDateToBinary("1900-01-01"));
    }

    public static String convertDateToBinary(String date) {
        return Arrays.stream(date.split("-"))
                .map(x -> toBinaryString(convert(x)))
                .collect(Collectors.joining("-"));
    }

    /**
     * 将数字字符串转换为整形数字
     *
     * @param num
     * @return
     */
    public static int convert(String num) {
        int value = 0;
        int weight = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            value += (num.charAt(i) - '0') * weight;
            weight *= 10;
        }
        return value;
    }

    /**
     * 将数字转换为二进制字符串
     *
     * @param value
     * @return
     */
    public static String toBinaryString(int value) {
        StringBuilder builder = new StringBuilder();

        while (value != 0) {
            builder.append(value % 2);
            value /= 2;
        }
        return builder.reverse().toString();
    }
}
