package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: Replace Words
 *
 * @author Baltan
 * @date 2019-04-04 09:14
 */
public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict1, sentence1));
    }

    public static String replaceWords(List<String> dict, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dict);
        int length = wordArray.length;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int wordLength = wordArray[i].length();
            for (int j = 0; j < wordLength; j++) {
                String subWord = wordArray[i].substring(0, j + 1);
                if (dictSet.contains(subWord)) {
                    wordArray[i] = subWord;
                    break;
                }
            }
            builder.append(wordArray[i]);
            if (i < length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
