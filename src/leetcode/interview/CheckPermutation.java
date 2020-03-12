package leetcode.interview;

/**
 * Description: 面试题 01.02. 判定是否互为字符重排
 *
 * @author Baltan
 * @date 2020-03-10 14:49
 */
public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abc", "bad"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int length = s1.length();
        /**
         * 对s1中各个字符出现的次数计数
         */
        int[] count1 = new int[26];
        /**
         * 对s2中各个字符出现的次数计数
         */
        int[] count2 = new int[26];

        for (int i = 0; i < length; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        /**
         * 如果s1和s2中某个同一字符出现的次数不同，则s1重新排列后不能得到s2，返回false
         */
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
