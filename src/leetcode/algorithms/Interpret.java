package leetcode.algorithms;

/**
 * Description: 1678. Goal Parser Interpretation
 *
 * @author Baltan
 * @date 2022/9/4 14:50
 */
public class Interpret {
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));
    }

    public static String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = command.toCharArray();

        for (int i = 0; i < charArray.length; ) {
            char c = charArray[i];

            if (c == 'G') {
                builder.append("G");
                i++;
            } else if (c == '(') {
                /**
                 * 如果遇到"("，则后续字符串可能是")"，连起来构成"()"，也可能是"al)"，连起来构成"(al)"，分两种情况判断
                 */
                if (charArray[i + 1] == ')') {
                    builder.append("o");
                    i += 2;
                } else {
                    builder.append("al");
                    i += 4;
                }
            }
        }
        return builder.toString();
    }
}
