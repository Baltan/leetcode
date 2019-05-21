package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 953. Verifying an Alien Dictionary
 *
 * @author Baltan
 * @date 2019-03-15 09:54
 */
public class IsAlienSorted {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int length = words.length;
        int dictionaryLength = order.length();
        Map<Character, Integer> dictionary = new HashMap<>(dictionaryLength);

        for (int i = 0; i < dictionaryLength; i++) {
            dictionary.put(order.charAt(i), i);
        }

        for (int i = 1; i < length; i++) {
            int j = 0;
            while (words[i - 1].length() > j || words[i].length() > j) {
                if (words[i - 1].length() > j && words[i].length() <= j) {
                    return false;
                } else if (words[i - 1].length() > j && words[i].length() > j) {
                    if (dictionary.get(words[i - 1].charAt(j)) >
                            dictionary.get(words[i].charAt(j))) {
                        return false;
                    } else if (dictionary.get(words[i - 1].charAt(j)) <
                            dictionary.get(words[i].charAt(j))) {
                        break;
                    }
                }
                j++;
            }
        }
        return true;
    }
}
