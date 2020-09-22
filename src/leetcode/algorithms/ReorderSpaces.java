package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1592. Rearrange Spaces Between Words
 *
 * @author Baltan
 * @date 2020-09-22 23:16
 */
public class ReorderSpaces {
    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
        System.out.println(reorderSpaces("hello   world"));
        System.out.println(reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(reorderSpaces("a"));
    }

    public static String reorderSpaces(String text) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = text.toCharArray();
        /**
         * text中空格的个数
         */
        int spaceCount = 0;
        /**
         * text中单词的个数
         */
        int wordCount = 0;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (c == ' ') {
                spaceCount++;
            } else {
                /**
                 * 只有出现在开头和空格之后的字母，才视为一个单词的开头，计算为一个单词
                 */
                if (i == 0 || charArray[i - 1] == ' ') {
                    wordCount++;
                }
            }
        }
        /**
         * 如果text中只有一个单词，将所有的空格移到单词最后即可
         */
        if (wordCount == 1) {
            builder.append(text.trim());

            for (int i = 0; i < spaceCount; i++) {
                builder.append(" ");
            }
            return builder.toString();
        }
        /**
         * 单词与单词间空格的个数
         */
        int averageSpaceCount = spaceCount / (wordCount - 1);
        /**
         * 最后一个单词之后空格的个数
         */
        int leftSpaceCount = spaceCount - (wordCount - 1) * averageSpaceCount;
        String[] wordArray = text.split(" ");

        for (String word : wordArray) {
            word = word.trim();
            /**
             * 判断是否是单词
             */
            if (!Objects.equals(word, "")) {
                builder.append(word);
                /**
                 * 在每个单词后追加averageSpaceCount个空格
                 */
                for (int i = 0; i < averageSpaceCount; i++) {
                    builder.append(" ");
                }
            }
        }
        /**
         * 最后一个单词后追加了averageSpaceCount个空格，实际需要leftSpaceCount个空格，多删少补
         */
        if (leftSpaceCount > averageSpaceCount) {
            for (int i = 0; i < leftSpaceCount - averageSpaceCount; i++) {
                builder.append(" ");
            }
        } else if (leftSpaceCount < averageSpaceCount) {
            for (int i = 0; i < averageSpaceCount - leftSpaceCount; i++) {
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return builder.toString();
    }
}
