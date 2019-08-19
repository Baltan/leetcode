package leetcode.algorithms;

/**
 * Description: 1160. Find Words That Can Be Formed by Characters
 *
 * @author Baltan
 * @date 2019-08-19 08:56
 */
public class CountCharacters {
    public static void main(String[] args) {
        String[] words1 = {"cat", "bt", "hat", "tree"};
        System.out.println(countCharacters(words1, "atach"));

        String[] words2 = {"hello", "world", "leetcode"};
        System.out.println(countCharacters(words2, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        int[] charCount = new int[26];
        /**
         * 统计chars中每个字母出现的次数
         */
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (String word : words) {
            result += getLength(word, charCount.clone());
        }
        return result;
    }

    /**
     * 如果单词word可以用chars中的字母拼成，返回word的长度，否则返回0
     *
     * @param word
     * @param charCount
     * @return
     */
    public static int getLength(String word, int[] charCount) {
        for (char c : word.toCharArray()) {
            /**
             * word当前字母在chars中没有了，直接返回0
             */
            if (charCount[c - 'a'] == 0) {
                return 0;
            }
            charCount[c - 'a']--;
        }
        return word.length();
    }
}
