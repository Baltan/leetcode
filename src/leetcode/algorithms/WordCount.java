package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2135. Count Words Obtained After Adding a Letter
 *
 * @author Baltan
 * @date 2022/1/10 09:16
 */
public class WordCount {
    public static void main(String[] args) {
        System.out.println(wordCount(
                new String[]{"ant", "act", "tack"},
                new String[]{"tack", "act", "acti"}
        ));
        System.out.println(wordCount(
                new String[]{"ab", "a"},
                new String[]{"abc", "abcd"}
        ));
    }

    public static int wordCount(String[] startWords, String[] targetWords) {
        int result = 0;
        Set<String> startWordSet = new HashSet<>();
        /**
         * 将startWords中的每一个单词按照自身的字母重新排序后保存
         */
        for (String startWord : startWords) {
            char[] charArray = startWord.toCharArray();
            Arrays.sort(charArray);
            startWordSet.add(new String(charArray));
        }

        for (String targetWord : targetWords) {
            char[] charArray = targetWord.toCharArray();
            int length = charArray.length;
            Arrays.sort(charArray);
            /**
             * 将targetWord按照自身的字母重新排序，并去掉其中一个字母后，判断startWordSet中是否存在对应的单词
             */
            for (int i = 0; i < length; i++) {
                String word = new String(charArray, 0, i) + new String(charArray, i + 1, length - i - 1);

                if (startWordSet.contains(word)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
