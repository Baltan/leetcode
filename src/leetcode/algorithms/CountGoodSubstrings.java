package leetcode.algorithms;

/**
 * Description: 1876. Substrings of Size Three with Distinct Characters
 *
 * @author Baltan
 * @date 2022/5/15 13:00
 */
public class CountGoodSubstrings {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    public static int countGoodSubstrings(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        /**
         * i表示长度为3的子串的第一个字符在字符串s中的索引位置
         */
        for (int i = s.length() - 3; i >= 0; i--) {
            if (charArray[i] != charArray[i + 1] && charArray[i] != charArray[i + 2] &&
                    charArray[i + 1] != charArray[i + 2]) {
                result++;
            }
        }
        return result;
    }
}
