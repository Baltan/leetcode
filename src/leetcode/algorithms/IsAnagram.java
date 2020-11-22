package leetcode.algorithms;

/**
 * Description: 242. Valid Anagram
 *
 * @author Baltan
 * @date 2018/1/3 13:11
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int length = s.length();
        /**
         * 记录s和t中每个小写字母的个数
         */
        int[] count = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < length; i++) {
            /**
             * 当s中出现某个小写字母时，就在count中增加一个
             */
            count[sChars[i] - 'a']++;
            /**
             * 当t中出现某个小写字母时，就在count中消去一个
             */
            count[tChars[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            /**
             * 如果s和t中的某个小写字母的个数不同直接返回false
             */
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
