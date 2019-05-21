package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 1023. Camelcase Matching
 *
 * @author Baltan
 * @date 2019-04-09 09:27
 */
public class CamelMatch {
    public static void main(String[] args) {
        String[] queries1 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern1 = "FB";
        System.out.println(camelMatch(queries1, pattern1));

        String[] queries2 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern2 = "FoBa";
        System.out.println(camelMatch(queries2, pattern2));

        String[] queries3 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern3 = "FoBaT";
        System.out.println(camelMatch(queries3, pattern3));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int arrLength = queries.length;
        List<Boolean> result = new ArrayList<>(arrLength);

        for (int i = 0; i < arrLength; i++) {
            result.add(isMatched(queries[i], pattern));
        }
        return result;
    }

    public static boolean isMatched(String word, String pattern) {
        int wordLength = word.length();
        int patternLength = pattern.length();

        if (Objects.equals(pattern, word)) {
            return true;
        }

        if (wordLength <= patternLength) {
            return false;
        }

        int index = 0;

        for (int i = 0; i < wordLength; i++) {
            char c1 = word.charAt(i);
            char c2 = index < patternLength ? pattern.charAt(index) : pattern.charAt(patternLength - 1);
            if (c1 == c2) {
                index++;
            } else {
                if (c1 < 'a' || c1 > 'z') {
                    return false;
                }
            }
        }

        if (index < patternLength) {
            return false;
        } else {
            return true;
        }
    }
}
