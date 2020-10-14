package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1002. Find Common Characters
 *
 * @author Baltan
 * @date 2019-03-13 11:06
 */
public class CommonChars {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        /**
         * 记录每个字母在各个单词中出现的最大次数
         */
        int[] maxCount = new int[26];
        Arrays.fill(maxCount, Integer.MAX_VALUE);

        for (String word : A) {
            /**
             * 记录每个字母在单词word中出现的次数
             */
            int[] count = new int[26];
            int strLength = word.length();

            for (int i = 0; i < strLength; i++) {
                count[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                maxCount[i] = maxCount[i] < count[i] ? maxCount[i] : count[i];
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < maxCount[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}