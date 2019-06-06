package leetcode.algorithms;

import java.util.*;

/**
 * Description: 187. Repeated DNA Sequences
 *
 * @author Baltan
 * @date 2019-06-06 09:18
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        int end = s.length() - 10;

        for (int i = 0; i <= end; i++) {
            String sub = s.substring(i, i + 10);

            if (!map.containsKey(sub)) {
                map.put(sub, false);
            } else {
                if (!map.get(sub)) {
                    result.add(sub);
                    map.put(sub, true);
                }
            }
        }
        return result;
    }
}
