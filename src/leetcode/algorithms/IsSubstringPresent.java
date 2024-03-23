package leetcode.algorithms;

/**
 * Description: 3083. Existence of a Substring in a String and Its Reverse
 *
 * @author Baltan
 * @date 2024/3/23 15:14
 */
public class IsSubstringPresent {
    public static void main(String[] args) {
        System.out.println(isSubstringPresent("leetcode"));
        System.out.println(isSubstringPresent("abcba"));
        System.out.println(isSubstringPresent("abcd"));
    }

    public static boolean isSubstringPresent(String s) {
        /**
         * isExisted[i][j]表示正序遍历字符串s，所有长度为2的子串中是否存在字符串ij
         */
        boolean[][] isExisted = new boolean[26][26];
        char[] charArray = s.toCharArray();

        for (int i = 1; i < charArray.length; i++) {
            isExisted[charArray[i - 1] - 'a'][charArray[i] - 'a'] = true;
        }
        /**
         * 倒序遍历字符串s，判断每一个长度为2的子串是否在正序遍历的子串中存在，找到一个即可
         */
        for (int i = charArray.length - 1; i > 0; i--) {
            if (isExisted[charArray[i] - 'a'][charArray[i - 1] - 'a']) {
                return true;
            }
        }
        return false;
    }
}
