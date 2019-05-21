package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 676. Implement Magic Dictionary
 *
 * @author Baltan
 * @date 2019-04-04 09:41
 */
public class MagicDictionary {

    Map<Character, Set<String>> map;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        map = new HashMap<>(26);
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            char firstLetter = word.charAt(0);
            if (map.get(firstLetter) == null) {
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(firstLetter, set);
            } else {
                map.get(firstLetter).add(word);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one
     * character
     */
    public boolean search(String word) {
        int wordLength = word.length();
        char firstLetter = word.charAt(0);
        Set<String> set1 = map.get(firstLetter);
        if (set1 != null) {
            for (String w : set1) {
                if (w.length() == wordLength) {
                    int differentCharCount = 0;
                    for (int i = 1; i < wordLength; i++) {
                        if (w.charAt(i) != word.charAt(i)) {
                            differentCharCount++;
                        }
                    }
                    if (differentCharCount == 1) {
                        return true;
                    }
                }
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (i != firstLetter) {
                String w = word.replaceFirst(String.valueOf(firstLetter), String.valueOf(i));
                if (map.get(i) != null && map.get(i).contains(w)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary obj1 = new MagicDictionary();
        obj1.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(obj1.search("hello"));
        System.out.println(obj1.search("hhllo"));
        System.out.println(obj1.search("hell"));
        System.out.println(obj1.search("leetcoded"));

        System.out.println("------------------");

        MagicDictionary obj2 = new MagicDictionary();
        obj2.buildDict(new String[]{"hello", "hallo", "leetcode", "judge"});
        System.out.println(obj2.search("hello"));
        System.out.println(obj2.search("hallo"));
        System.out.println(obj2.search("hell"));
        System.out.println(obj2.search("leetcodd"));
        System.out.println(obj2.search("aaaaa"));

        System.out.println("------------------");

        MagicDictionary obj3 = new MagicDictionary();
        obj3.buildDict(new String[]{"a", "b"});
        System.out.println(obj3.search("a"));
        System.out.println(obj3.search("b"));
        System.out.println(obj3.search("c"));
        System.out.println(obj3.search("d"));
        System.out.println(obj3.search("e"));
        System.out.println(obj3.search("f"));
    }
}
