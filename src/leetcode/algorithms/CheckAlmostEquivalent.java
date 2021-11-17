package leetcode.algorithms;

/**
 * Description: 2068. Check Whether Two Strings are Almost Equivalent
 *
 * @author Baltan
 * @date 2021/11/17 09:12
 */
public class CheckAlmostEquivalent {
    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int length = word1.length();
        /**
         * 记录word1中每个字母出现的次数
         */
        int[] count1 = new int[26];
        /**
         * 记录word2中每个字母出现的次数
         */
        int[] count2 = new int[26];

        for (int i = 0; i < length; i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }
        /**
         * 逐一比较每个字母在word1和word2中出现的次数
         */
        for (int i = 0; i < 26; i++) {
            if (count1[i] - count2[i] > 3 || count2[i] - count1[i] > 3) {
                return false;
            }
        }
        return true;
    }
}
