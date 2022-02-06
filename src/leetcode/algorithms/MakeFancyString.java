package leetcode.algorithms;

/**
 * Description: 1957. Delete Characters to Make Fancy String
 *
 * @author Baltan
 * @date 2022/2/6 10:38
 */
public class MakeFancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyString("aab"));
    }

    public static String makeFancyString(String s) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        int index = 0;

        while (index < s.length()) {
            /**
             * 如果当前字符前面还存在两个一样的字符，则跳过当前字符，继续判断下一个字符，否在就保留当前字符
             */
            if (index >= 2 && charArray[index] == charArray[index - 1] &&
                    charArray[index] == charArray[index - 2]) {
                index++;
                continue;
            }
            builder.append(charArray[index++]);
        }
        return builder.toString();
    }
}
