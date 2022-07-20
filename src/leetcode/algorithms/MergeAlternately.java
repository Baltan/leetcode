package leetcode.algorithms;

/**
 * Description: 1768. Merge Strings Alternately
 *
 * @author Baltan
 * @date 2022/7/17 13:39
 */
public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder(word1.length() + word2.length());
        /**
         * 指向word1可以添加到builder中的字符
         */
        int index1 = 0;
        /**
         * 指向word2可以添加到builder中的字符
         */
        int index2 = 0;

        while (index1 < word1.length() || index2 < word2.length()) {
            if (index1 < word1.length()) {
                builder.append(word1.charAt(index1));
                index1++;
            }

            if (index2 < word2.length()) {
                builder.append(word2.charAt(index2));
                index2++;
            }
        }
        return builder.toString();
    }
}
