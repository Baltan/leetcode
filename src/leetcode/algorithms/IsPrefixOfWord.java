package leetcode.algorithms;

/**
 * Description: 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 *
 * @author Baltan
 * @date 2020-05-25 23:00
 */
public class IsPrefixOfWord {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(isPrefixOfWord("i am tired", "you"));
        System.out.println(isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(isPrefixOfWord("hello from the other side", "they"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int length = words.length;

        for (int i = 0; i < length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
