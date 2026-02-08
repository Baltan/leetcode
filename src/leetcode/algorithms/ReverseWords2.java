package leetcode.algorithms;

/**
 * Description: 3775. Reverse Words With Same Vowel Count
 *
 * @author baltan
 * @date 2026/2/2 17:55
 */
public class ReverseWords2 {
    public static void main(String[] args) {
        System.out.println(reverseWords("cat and mice"));
        System.out.println(reverseWords("book is nice"));
        System.out.println(reverseWords("banana healthy"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        /**
         * 字符串s中第一个单词中的元音字母数
         */
        int vowelCount = 0;

        for (char c : words[0].toCharArray()) {
            vowelCount += isVowel(c) ? 1 : 0;
        }
        outer:
        for (int i = 1; i < words.length; i++) {
            /**
             * 当前单词words[i]中的元音字母数
             */
            int count = 0;

            for (char c : words[i].toCharArray()) {
                count += isVowel(c) ? 1 : 0;

                if (count > vowelCount) {
                    continue outer;
                }
            }
            /**
             * 将单词words[i]反转
             */
            if (count == vowelCount) {
                words[i] = reverseWord(words[i]);
            }
        }
        return String.join(" ", words);
    }

    /**
     * 反转单词word
     *
     * @param word
     * @return
     */
    public static String reverseWord(String word) {
        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }
        return new String(charArray);
    }

    /**
     * 判断字符c是否是元音字母
     *
     * @param c
     * @return
     */
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
