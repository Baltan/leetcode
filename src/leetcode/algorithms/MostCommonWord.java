package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 819. Most Common Word
 *
 * @author Baltan
 * @date 2018/8/2 10:36
 */
public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] wordArray = paragraph.toLowerCase().split(" ");
        String punctuationStr = "!?',;.";
        List<String> bannedList =
                Arrays.asList(banned).stream().map(String::toLowerCase).collect(Collectors.toList());

        int strLength;
        int times = 0;
        String mostWord = null;

        Map<String, Integer> map = new HashMap<>();
        for (String str : wordArray) {
            strLength = str.length();
            if (punctuationStr.indexOf(str.substring(strLength - 1, strLength)) != -1) {
                str = str.substring(0, strLength - 1);
            }
            if (!bannedList.contains(str)) {
                if (map.get(str) == null) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }
                if (map.get(str) > times) {
                    mostWord = str;
                    times = map.get(str);
                }
            }
        }
        return mostWord;
    }
}
