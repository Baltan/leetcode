package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 722. Remove Comments
 *
 * @author Baltan
 * @date 2020-01-21 18:53
 */
public class RemoveComments {
    public static void main(String[] args) {
        String[] source1 =
                {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
                        "/* This is a test", "   multiline  ", "   comment for ", "   testing */",
                        "a = b + c;", "}"};
        System.out.println(removeComments(source1));

        String[] source2 = {"a/*comment", "line", "more_comment*/b"};
        System.out.println(removeComments(source2));

        String[] source3 =
                {"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};"};
        System.out.println(removeComments(source3));

        String[] source4 =
                {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/",
                        "}"};
        System.out.println(removeComments(source4));
    }

    public static List<String> removeComments(String[] source) {
        List<String> result = new LinkedList<>();
        /**
         * 当前行要输出的内容
         */
        StringBuilder builder = new StringBuilder();
        /**
         * flag为false表示当前字符不在注释代码中，flag为true表示当前字符在块注释中
         */
        boolean flag = false;

        for (String code : source) {
            int length = code.length();

            for (int i = 0; i < length; ) {
                char c = code.charAt(i);

                if (!flag) {
                    if (c == '/') {
                        if (i + 1 < length) {
                            char nextChar = code.charAt(i + 1);
                            /**
                             * 如果当前字符为"/"，并且下一个字符也为"/"，则之后的内容都位于行内注
                             * 释中，可以不作判断。这行代码已经记录的内容如果不是空字符串，就输出
                             * 该行
                             */
                            if (nextChar == '/') {
                                String line = builder.toString();

                                if (!Objects.equals(line, "")) {
                                    result.add(line);
                                }
                                builder = new StringBuilder();
                                break;
                                /**
                                 * 如果当前字符为"/"，并且下一个字符为"*"，进入块注释块中，跳过下
                                 * 一个字符"*"，继续判断后面的字符
                                 */
                            } else if (nextChar == '*') {
                                /**
                                 * 标记代码进入块注释中
                                 */
                                flag = true;
                                i += 2;
                                /**
                                 * 如果当前字符为"/"，并且下一个字符不为"/"和"*"，不会产生注释，
                                 * 记录当前字符，继续判断后面的字符
                                 */
                            } else {
                                builder.append(c);
                                i++;
                            }
                            /**
                             * 如果当前字符"/"是这行最后一个字符，不会产生注释，记录当前字符，继续
                             * 判断后面的字符
                             */
                        } else {
                            builder.append(c);
                            i++;
                        }
                        /**
                         * 如果当前字符不为"/"，不会产生注释，记录当前字符，继续判断后面的字符
                         */
                    } else {
                        builder.append(c);
                        i++;
                    }
                } else {
                    /**
                     * 如果当前在块注释块中，当出现连续的"*"和"/"时，块注释结束，跳过"*"和"/"这两
                     * 个字符，继续判断后面的字符
                     */
                    if (c == '*' && i + 1 < length && code.charAt(i + 1) == '/') {
                        /**
                         * 标记代码不在注释块中
                         */
                        flag = false;
                        i += 2;
                        /**
                         * 如果当前在块注释块中，没有连续出现"*"和"/"，块注释没有结束，继续判断后
                         * 面的字符
                         */
                    } else {
                        i++;
                    }
                }
            }
            /**
             * 当前行代码如果不在注释块中，并且这行代码不是空字符串，就输出该行
             */
            if (!flag) {
                String line = builder.toString();

                if (!Objects.equals(line, "")) {
                    result.add(builder.toString());
                }

                builder = new StringBuilder();
            }
        }
        return result;
    }
}
