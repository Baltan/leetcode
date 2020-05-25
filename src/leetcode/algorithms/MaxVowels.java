package leetcode.algorithms;

/**
 * Description: 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * @author Baltan
 * @date 2020-05-24 16:15
 */
public class MaxVowels {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
        System.out.println(maxVowels("rhythms", 4));
        System.out.println(maxVowels("tryhard", 4));
    }

    public static int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 当前窗口中元音字母的个数
         */
        int count = 0;
        /**
         * 对最左边的长度为k的窗口中的元音字母的个数进行计数
         */
        for (int i = 0; i < k; i++) {
            if (isVowel(charArray[i])) {
                count++;
            }
        }

        int result = count;
        /**
         * 逐位右移窗口，每次移动后计算新窗口中的元音字母的个数
         */
        for (int i = k; i < length; i++) {
            if (isVowel(charArray[i])) {
                count++;
            }

            if (isVowel(charArray[i - k])) {
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
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
