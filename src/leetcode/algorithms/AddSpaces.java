package leetcode.algorithms;

/**
 * Description: 2109. Adding Spaces to a String
 *
 * @author Baltan
 * @date 2021/12/21 16:08
 */
public class AddSpaces {
    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
        System.out.println(addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
        System.out.println(addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5, 6}));
    }

    public static String addSpaces(String s, int[] spaces) {
        /**
         * 字符串s处理后的字符数组
         */
        char[] chars = new char[s.length() + spaces.length];
        int spaceIndex = spaces.length - 1;
        int charsIndex = chars.length - 1;
        /**
         * 从后向前遍历s的每一个字符，遇到要添加空格的索引位置，在该位置之前添加空格即可
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            chars[charsIndex--] = s.charAt(i);

            if (spaceIndex >= 0 && i == spaces[spaceIndex]) {
                spaceIndex--;
                chars[charsIndex--] = ' ';
            }
        }
        return new String(chars);
    }
}
