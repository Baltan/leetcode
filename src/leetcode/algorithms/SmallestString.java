package leetcode.algorithms;

/**
 * Description: 2734. Lexicographically Smallest String After Substring Operation
 *
 * @author Baltan
 * @date 2023/6/11 17:34
 */
public class SmallestString {
    public static void main(String[] args) {
        System.out.println(smallestString("cbabc"));
        System.out.println(smallestString("acbbc"));
        System.out.println(smallestString("leetcode"));
    }

    public static String smallestString(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 是否已找到除a以外的小写字母
         */
        boolean find = false;
        /**
         * 在字符串s中找到第一个不为a的小写字母，将其作为子串的起点，依次开始将后续的字母变小一位，直到字符串s最后或者找到下一个字母a为止
         */
        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'a') {
                if (find) {
                    break;
                }
            } else {
                find = true;
                charArray[i] = (char) (charArray[i] - 1);
            }
        }
        /**
         * 如果没有找到除a以外的小写字母，说明字符串s中的字母都是a，将最后一个a变小一位成z即可得到字典顺序最小的新字符串
         */
        if (!find) {
            charArray[length - 1] = 'z';
        }
        return new String(charArray);
    }
}
