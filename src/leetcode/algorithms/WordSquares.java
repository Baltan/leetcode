package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 3799. Word Squares II
 *
 * @author baltan
 * @date 2026/2/12 17:09
 */
public class WordSquares {
    public static void main(String[] args) {
        System.out.println(wordSquares(new String[]{"able", "area", "echo", "also"}));
        System.out.println(wordSquares(new String[]{"code", "cafe", "eden", "edge"}));
    }

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        int length = words.length;
        /**
         * 方块上侧边可能的单词
         */
        for (int i = 0; i < length; i++) {
            /**
             * 方块左侧边可能的单词
             */
            for (int j = 0; j < length; j++) {
                /**
                 * 上侧边单词的第一个字母和左侧边单词的第一个字母应相同
                 */
                if (j == i || words[i].charAt(0) != words[j].charAt(0)) {
                    continue;
                }
                /**
                 * 方块右侧边可能的单词
                 */
                for (int k = 0; k < length; k++) {
                    /**
                     * 上侧边单词的最后一个字母和右侧边单词的第一个字母应相同
                     */
                    if (k == i || k == j || words[i].charAt(3) != words[k].charAt(0)) {
                        continue;
                    }
                    /**
                     * 方块下侧边可能的单词
                     */
                    for (int l = 0; l < length; l++) {
                        /**
                         * 下侧边单词的第一个字母和左侧边单词的第一个字母应相同，下侧边单词的最后一个字母和右侧边单词的最后一个字母应相同
                         */
                        if (l == i || l == j || l == k || words[j].charAt(3) != words[l].charAt(0) || words[k].charAt(3) != words[l].charAt(3)) {
                            continue;
                        }
                        result.add(List.of(words[i], words[j], words[k], words[l]));
                    }
                }
            }
        }
        /**
         * 将所有四元组按照字典顺序升序排列
         */
        result.sort((x, y) -> {
            for (int i = 0; i < 4; i++) {
                if (!Objects.equals(x.get(i), y.get(i))) {
                    return x.get(i).compareTo(y.get(i));
                }
            }
            return 0;
        });
        return result;
    }
}
