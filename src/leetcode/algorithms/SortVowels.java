package leetcode.algorithms;

/**
 * Description: 2785. Sort Vowels in a String
 *
 * @author Baltan
 * @date 2023/7/23 23:57
 */
public class SortVowels {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));
    }

    public static String sortVowels(String s) {
        char[] charArray = s.toCharArray();
        /**
         * counts[0]-counts[25]依次代表字符串s中字符A-Z的数量，counts[26]-counts[51]依次代表字符串s中字符a-z的数量。因为在ASCII表中
         * 大写字母的ASCII值小于小写字母，所以将大写字母的计数放在小写字母之前
         */
        int[] counts = new int[52];
        int index = 0;
        /**
         * 对字符串s中不同的元音字符计数
         */
        for (char c : charArray) {
            if (isVowel(c)) {
                if (Character.isUpperCase(c)) {
                    counts[c - 'A']++;
                } else {
                    counts[c - 'a' + 26]++;
                }
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (isVowel(charArray[i])) {
                /**
                 * 逐个取出已排序的元音字符
                 */
                while (counts[index] == 0) {
                    index++;
                }
                charArray[i] = index < 26 ? (char) ('A' + index) : (char) ('a' + index - 26);
                counts[index]--;
            }
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
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
