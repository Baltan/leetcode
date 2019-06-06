package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 208. Implement Trie (Prefix Tree)
 *
 * @author Baltan
 * @date 2019-06-06 14:16
 */
public class Trie {
    private Set<String> set;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        set = new HashSet<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        set.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return set.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie1 = new Trie();
        trie1.insert("apple");
        System.out.println(trie1.search("apple"));
        System.out.println(trie1.search("app"));
        System.out.println(trie1.startsWith("app"));
        trie1.insert("app");
        System.out.println(trie1.search("app"));
    }
}
