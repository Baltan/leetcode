package leetcode.algorithms;

/**
 * Description: 2496. Maximum Value of a String in an Array
 *
 * @author Baltan
 * @date 2023/2/6 10:03
 */
public class MaximumValue {
    public static void main(String[] args) {
        System.out.println(maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"}));
        System.out.println(maximumValue(new String[]{"1", "01", "001", "0001"}));
    }

    public static int maximumValue(String[] strs) {
        int result = Integer.MIN_VALUE;

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            /**
             * 当前字符串是否完全由数字构成
             */
            boolean flag = true;
            /**
             * 当前字符串在十进制下的所表示的数字
             */
            int value = 0;
            /**
             * 数位的权重
             */
            int weight = 1;

            for (int i = charArray.length - 1; i >= 0; i--) {
                if (Character.isDigit(charArray[i])) {
                    value += (charArray[i] - '0') * weight;
                    weight *= 10;
                } else {
                    flag = false;
                    break;
                }
            }
            result = Math.max(result, flag ? value : charArray.length);
        }
        return result;
    }
}
