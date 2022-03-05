package leetcode.algorithms;

/**
 * Description: 1910. Remove All Occurrences of a Substring
 *
 * @author Baltan
 * @date 2022/3/5 22:16
 */
public class RemoveOccurrences {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder builder = new StringBuilder(s);
        int index;
        /**
         * 逐次将字符串builder中最先出现的子串part删除，直到builder中没有子串part为止
         */
        while ((index = builder.indexOf(part)) != -1) {
            builder.delete(index, index + part.length());
        }
        return builder.toString();
    }
}
