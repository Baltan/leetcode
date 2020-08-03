package leetcode.algorithms;

/**
 * Description: 1528. Shuffle String
 *
 * @author Baltan
 * @date 2020-08-03 23:43
 */
public class RestoreString {
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(restoreString("abc", new int[]{0, 1, 2}));
        System.out.println(restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
        System.out.println(restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
        System.out.println(restoreString("art", new int[]{1, 0, 2}));
    }

    public static String restoreString(String s, int[] indices) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        /**
         * 重新排列后的字符数组
         */
        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            /**
             * 原来的第i个字符重新排序后放到第indices[i]个位置（0-based）
             */
            chars[indices[i]] = charArray[i];
        }
        return new String(chars);
    }
}
