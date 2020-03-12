package leetcode.algorithms;

/**
 * Description: 1347. Minimum Number of Steps to Make Two Strings Anagram
 *
 * @author Baltan
 * @date 2020-03-12 13:16
 */
public class MinSteps2 {
    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("xxyyzz", "xxyyzz"));
        System.out.println(minSteps("friend", "family"));
    }

    public static int minSteps(String s, String t) {
        int result = 0;
        int length = s.length();
        /**
         * s中每个字符出现的次数
         */
        int[] count1 = new int[26];
        /**
         * t中每个字符出现的次数
         */
        int[] count2 = new int[26];
        /**
         * 对s和t中每个字符出现的次数计数
         */
        for (int i = 0; i < length; i++) {
            count1[s.charAt(i) - 'a']++;
            count2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            /**
             * 当某个字符在t中出现的次数比s中多时，多出的次数必然要替换成其他字符
             */
            if (count2[i] > count1[i]) {
                result += (count2[i] - count1[i]);
            }
        }
        return result;
    }
}
