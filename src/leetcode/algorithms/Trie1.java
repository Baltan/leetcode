package leetcode.algorithms;

/**
 * Description: 208. Implement Trie (Prefix Tree)
 *
 * @author Baltan
 * @date 2019-06-07 13:15
 */
public class Trie1 {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie1() {
        root = new TrieNode('0');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int length = word.length();
        TrieNode node = root;

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int position = c - 'a';

            if (node.children[position] == null) {
                node.children[position] = new TrieNode(c);
            }
            node = node.children[position];
        }
        node.children[26] = new TrieNode('0');
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int length = word.length();
        TrieNode node = root;

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int position = c - 'a';

            if (node.children[position] == null) {
                return false;
            } else {
                node = node.children[position];
            }
        }

        if (node.children[26] != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int length = prefix.length();
        TrieNode node = root;

        for (int i = 0; i < length; i++) {
            char c = prefix.charAt(i);
            int position = c - 'a';

            if (node.children[position] == null) {
                return false;
            } else {
                node = node.children[position];
            }
        }
        return true;
    }

    private class TrieNode {
        char val;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[27];
        }
    }

    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();
        trie1.insert("apple");
        System.out.println(trie1.search("apple"));
        System.out.println(trie1.search("app"));
        System.out.println(trie1.startsWith("app"));
        trie1.insert("app");
        System.out.println(trie1.search("app"));
    }
}
