package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 205. Isomorphic Strings
 *
 * @author Baltan
 * @date 2018/1/6 23:46
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String sLetter = s.substring(i, i + 1);
            String tLetter = t.substring(i, i + 1);
            if (!map.containsKey(sLetter) && !map.containsValue(tLetter)) {
                map.put(sLetter, tLetter);
            } else if (!map.containsKey(sLetter) && map.containsValue(tLetter)) {
                return false;
            } else if (map.containsKey(sLetter) && !map.containsValue(tLetter)) {
                return false;
            } else {
                if (!map.get(sLetter).equals(tLetter)) {
                    return false;
                }
            }
        }
        return true;
    }
}
