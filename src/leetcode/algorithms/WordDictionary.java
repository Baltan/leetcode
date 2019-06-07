package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 211. Add and Search Word - Data structure design
 *
 * @author Baltan
 * @date 2019-06-07 11:12
 */
public class WordDictionary {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode('-');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (Objects.equals("", word)) {
            if (node.children[26] != null) {
                return true;
            } else {
                return false;
            }
        }

        int length = word.length();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        String str = word.substring(i + 1);

                        if (search(str, node.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int position = c - 'a';

                if (node.children[position] == null) {
                    return false;
                } else {
                    node = node.children[position];
                }
            }

            if (i == length - 1) {
                if (node.children[26] != null) {
                    return true;
                } else {
                    return false;
                }
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
        WordDictionary dictionary1 = new WordDictionary();
        dictionary1.addWord("bad");
        dictionary1.addWord("dad");
        dictionary1.addWord("mad");
        System.out.println(dictionary1.search("pad"));
        System.out.println(dictionary1.search("bad"));
        System.out.println(dictionary1.search(".ad"));
        System.out.println(dictionary1.search("b.."));
        System.out.println(dictionary1.search("m.d"));
        System.out.println(dictionary1.search("m.e"));
        System.out.println(dictionary1.search("m.d."));
        System.out.println(dictionary1.search("..d"));
        System.out.println(dictionary1.search("ma"));
        System.out.println(dictionary1.search(".."));
        System.out.println(dictionary1.search("..."));
        System.out.println(dictionary1.search("...."));

        System.out.println("-------------------");

        WordDictionary dictionary2 = new WordDictionary();
        dictionary2.addWord("at");
        dictionary2.addWord("and");
        dictionary2.addWord("an");
        dictionary2.addWord("add");
        System.out.println(dictionary2.search("a"));
        System.out.println(dictionary2.search(".at"));
        dictionary2.addWord("bat");
        System.out.println(dictionary2.search(".at"));
        System.out.println(dictionary2.search("an."));
        System.out.println(dictionary2.search("a.d."));
        System.out.println(dictionary2.search("b."));
        System.out.println(dictionary2.search("a.d"));
        System.out.println(dictionary2.search("."));

        System.out.println("-------------------");

        WordDictionary dictionary3 = new WordDictionary();
        dictionary3.addWord("a");
        dictionary3.addWord("ab");
        System.out.println(dictionary3.search("a"));
        System.out.println(dictionary3.search("a."));
        System.out.println(dictionary3.search("ab"));
        System.out.println(dictionary3.search(".a"));
        System.out.println(dictionary3.search(".b"));
        System.out.println(dictionary3.search("ab."));
        System.out.println(dictionary3.search("."));
        System.out.println(dictionary3.search(".."));
    }
}