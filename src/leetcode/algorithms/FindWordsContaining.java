package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2942. Find Words Containing Character
 *
 * @author baltan
 * @date 2023/11/29 09:18
 */
public class FindWordsContaining {
    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"leet", "code"}, 'e'));
        System.out.println(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a'));
        System.out.println(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            /**
             * 遍历字符串words[i]中的每个字符，判断是否与字符x相同
             */
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
