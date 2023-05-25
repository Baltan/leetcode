package leetcode.algorithms;

/**
 * Description: 2696. Minimum String Length After Removing Substrings
 *
 * @author Baltan
 * @date 2023/5/21 22:47
 */
public class MinLength {
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
        System.out.println(minLength("ACBBD"));
    }

    public static int minLength(String s) {
        int index;

        while ((index = help(s)) != -1) {
            /**
             * 截去查找到的子串"AB"或"CD"
             */
            s = s.substring(0, index) + s.substring(index + 2);
        }
        return s.length();
    }

    /**
     * 判断字符串s中是否存在子串"AB"或"CD"，返回第一个子串"AB"或"CD"的索引，否则返回-1
     *
     * @param s
     * @return
     */
    public static int help(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 'A' && (s.charAt(i) == 'B') || (s.charAt(i - 1) == 'C' && s.charAt(i) == 'D')) {
                return i - 1;
            }
        }
        return -1;
    }
}
