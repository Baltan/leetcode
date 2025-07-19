package leetcode.algorithms;

/**
 * Description: 3582. Generate Tag for Video Caption
 *
 * @author Baltan
 * @date 2025/7/19 23:30
 */
public class GenerateTag {
    public static void main(String[] args) {
        System.out.println(generateTag("Leetcode daily streak achieved"));
        System.out.println(generateTag("can I Go There"));
        System.out.println(generateTag("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
        System.out.println(generateTag("  Hello  world  "));
    }

    public static String generateTag(String caption) {
        StringBuilder builder = new StringBuilder();
        /**
         * 字符串caption中遍历到的某个字符的前一个字符
         */
        char prev = '#';

        for (char c : caption.toCharArray()) {
            if (c == ' ') {
                prev = c;
                continue;
            }
            /**
             * 字符串caption中，只有前一个字符为' '，并且当前字符不是caption中出现的第一个英文字符时，当前字符才会作为一个新单词的第一个字
             * 母转换为大写，否则一律转换为小写
             */
            if (prev == ' ' && !builder.isEmpty()) {
                builder.append(Character.toUpperCase(c));
            } else {
                builder.append(Character.toLowerCase(c));
            }
            prev = c;
        }
        String tag = "#" + builder;
        /**
         * 最终标签的长度不能超过100
         */
        return tag.substring(0, Math.min(100, tag.length()));
    }
}
