package leetcode.algorithms;

/**
 * Description: 3517. Smallest Palindromic Rearrangement I
 *
 * @author baltan
 * @date 2025/4/27 09:20
 */
public class SmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("z"));
        System.out.println(smallestPalindrome("babab"));
        System.out.println(smallestPalindrome("daccad"));
    }

    public static String smallestPalindrome(String s) {
        /**
         * counts[0]-counts[25]依次表示字符串s中字母a-z的个数
         */
        int[] counts = new int[26];
        char[] charArray = s.toCharArray();
        int index = 0;

        for (char c : charArray) {
            counts[c - 'a']++;
        }
        /**
         * 为了使回文字符串的字典顺序最小，将字典顺序小的字符尽可能放在回文字符串的前部
         */
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                char c = (char) ('a' + i);

                for (int j = counts[i] / 2; j > 0; j--) {
                    charArray[index] = c;
                    charArray[charArray.length - 1 - index] = c;
                    index++;
                }
                /**
                 * 如果字符c在字符串s中出现奇数次，则回文字符串最中间的字符为c
                 */
                if (counts[i] % 2 == 1) {
                    charArray[charArray.length / 2] = c;
                }
            }
        }
        return new String(charArray);
    }
}
