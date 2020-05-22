package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 1451. Rearrange Words in a Sentence
 *
 * @author Baltan
 * @date 2020-05-21 15:39
 */
public class ArrangeWords {
    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool"));
        System.out.println(arrangeWords("Keep calm and code on"));
        System.out.println(arrangeWords("To be or not to be"));
    }

    public static String arrangeWords(String text) {
        /**
         * 每个单词后面都追加一个空格，所以需要的长度为text.length()+1
         */
        StringBuilder builder = new StringBuilder(text.length() + 1);
        /**
         * 长度i -> 长度为i的所有单词的列表
         */
        Map<Integer, List<String>> map = new TreeMap<>();
        String[] words = text.split(" ");
        /**
         * 将原来的第一个单词转为小写
         */
        words[0] = words[0].toLowerCase();

        for (String word : words) {
            map.putIfAbsent(word.length(), new LinkedList<>());
            map.get(word.length()).add(word);
        }
        /**
         * 按照长度递增顺序将所有单词拼接在一起
         */
        for (List<String> wordList : map.values()) {
            for (String word : wordList) {
                builder.append(word).append(" ");
            }
        }
        /**
         * 删除最后一个多余的空格
         */
        builder.deleteCharAt(builder.length() - 1);
        /**
         * 将现在的第一个单词转为大写字母开头
         */
        builder.setCharAt(0, (char) (builder.charAt(0) + 'A' - 'a'));
        return builder.toString();
    }
}
