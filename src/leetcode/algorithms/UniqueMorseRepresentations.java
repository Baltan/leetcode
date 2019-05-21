package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 804. Unique Morse Code Words
 *
 * @author Baltan
 * @date 2018/7/30 10:03
 */
public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        Map<String, String> map = new HashMap<>(26);
        map.put("a", ".-");
        map.put("b", "-...");
        map.put("c", "-.-.");
        map.put("d", "-..");
        map.put("e", ".");
        map.put("f", "..-.");
        map.put("g", "--.");
        map.put("h", "....");
        map.put("i", "..");
        map.put("j", ".---");
        map.put("k", "-.-");
        map.put("l", ".-..");
        map.put("m", "--");
        map.put("n", "-.");
        map.put("o", "---");
        map.put("p", ".--.");
        map.put("q", "--.-");
        map.put("r", ".-.");
        map.put("s", "...");
        map.put("t", "-");
        map.put("u", "..-");
        map.put("v", "...-");
        map.put("w", ".--");
        map.put("x", "-..-");
        map.put("y", "-.--");
        map.put("z", "--..");

        Set<String> strSet = new HashSet<>();
        String word;

        for (int i = 0; i < words.length; i++) {
            word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(map.get(word.substring(j, j + 1)));
            }
            if (!strSet.contains(sb.toString())) {
                strSet.add(sb.toString());
            }
        }
        return strSet.size();
    }
}
