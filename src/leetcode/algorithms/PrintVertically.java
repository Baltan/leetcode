package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1324. Print Words Vertically
 *
 * @author Baltan
 * @date 2020-02-02 13:52
 */
public class PrintVertically {
    public static void main(String[] args) {
        System.out.println(printVertically("HOW ARE YOU"));
        System.out.println(printVertically("TO BE OR NOT TO BE"));
        System.out.println(printVertically("CONTEST IS COMING"));
    }

    public static List<String> printVertically(String s) {
        String[] words = s.split(" ");
        /**
         * 单词个数
         */
        int wordCount = words.length;
        /**
         * 最长的单词的长度
         */
        int longest = 0;

        for (String word : words) {
            longest = Math.max(longest, word.length());
        }

        List<String> result = new ArrayList<>(longest);

        for (int i = 0; i < longest; i++) {
            StringBuilder builder = new StringBuilder(wordCount);
            /**
             * 是否要添加空格
             */
            boolean addSpace = false;
            /**
             * 将单词写成多行的形式后，从后向前将每行的第i个字符拼接在一起。之所以要从后向前是因为不
             * 允许有尾随空格，当出现第一个字母后才会拼接空格。例如：
             * "TO BE OR NOT TO BE"写成多行的形式是：
             *
             * TO
             * BE
             * OR
             * NOT
             * TO
             * BE
             *
             * 对于i=2时，从后向前拼接，直到倒数第三行出现字母"T"，后面的单词长度不够时，才拼接空格
             */
            for (int j = wordCount - 1; j >= 0; j--) {
                if (i < words[j].length()) {
                    builder.insert(0, words[j].charAt(i));
                    /**
                     * 当出现第一个字母后，后面的单词如果长度不够就要拼接空格
                     */
                    addSpace = true;
                } else {
                    if (addSpace) {
                        builder.insert(0, " ");
                    }
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}
