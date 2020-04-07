package leetcode.algorithms;

/**
 * Description: 1400. Construct K Palindrome Strings
 *
 * @author Baltan
 * @date 2020-04-07 21:16
 */
public class CanConstruct1 {
    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
        System.out.println(canConstruct("leetcode", 3));
        System.out.println(canConstruct("true", 4));
        System.out.println(canConstruct("yzyzyzyzyzyzyzy", 2));
        System.out.println(canConstruct("cr", 7));
        System.out.println(canConstruct("aaa", 2));
    }

    public static boolean canConstruct(String s, int k) {
        /**
         * count保存字符串s中各个小写字母出现的次数
         */
        int[] count = new int[26];
        /**
         * 出现奇数次的小写字母的个数
         */
        int oddCount = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int value : count) {
            if ((value & 1) == 1) {
                oddCount++;
            }
        }
        /**
         * 一个回文字符串中出现奇数次的字母至多只有1个，即正中间的字母或者没有出现奇数次的字母，
         * 则k个回文字符串中出现奇数次的字母至多只有k个。需要构成k个回文字符串，至少需要k个字
         * 母，每个回文字符串只包含一个字母
         */
        return oddCount <= k && s.length() >= k;
    }
}
