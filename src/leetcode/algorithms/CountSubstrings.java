package leetcode.algorithms;

/**
 * Description: 647. Palindromic Substrings
 *
 * @author Baltan
 * @date 2018/1/11 14:35
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < s.length(); i++) {
            /**
             * 向两侧延伸的长度
             */
            int extendNum = 0;
            /**
             * 以字符charArray[i]作为中心向两侧延伸，查找回文子串
             */
            while (i - extendNum >= 0 && i + extendNum < length &&
                    charArray[i - extendNum] == charArray[i + extendNum]) {
                result++;
                extendNum++;
            }

            extendNum = 0;
            /**
             * 如果charArray[i]和charArray[i+1]相等，则以这两个字符作为中心想两侧延伸，查找回文子串
             */
            if (i + 1 < length && charArray[i] == charArray[i + 1]) {
                while (i - extendNum >= 0 && i + 1 + extendNum < length &&
                        charArray[i - extendNum] == charArray[i + 1 + extendNum]) {
                    result++;
                    extendNum++;
                }
            }
        }
        return result;
    }
}
