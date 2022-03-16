package leetcode.algorithms;

/**
 * Description: 1903. Largest Odd Number in String
 *
 * @author Baltan
 * @date 2022/3/16 09:13
 */
public class LargestOddNumber {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }

    public static String largestOddNumber(String num) {
        /**
         * 最后一个奇数字符的索引位置
         */
        int index = -1;
        char[] charArray = num.toCharArray();
        /**
         * 查找最后一个奇数字符的索引位置
         */
        for (int i = charArray.length - 1; i >= 0; i--) {
            if ((charArray[i] - '0') % 2 == 1) {
                index = i;
                break;
            }
        }
        return index == -1 ? "" : num.substring(0, index + 1);
    }
}
