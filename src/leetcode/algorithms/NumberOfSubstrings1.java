package leetcode.algorithms;

/**
 * Description: 1358. Number of Substrings Containing All Three Characters
 *
 * @author Baltan
 * @date 2020-02-24 13:30
 */
public class NumberOfSubstrings1 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abab"));
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
        System.out.println(numberOfSubstrings(
                "abcabcacbacbacaacbaacbacabaabcaacbacabacabcabcabacabcabcabacaacacbaacabcabcaabcabca"));
    }

    public static int numberOfSubstrings(String s) {
        int result = 0;
        /**
         * 当前字符之后第一个出现的"a"的索引位置
         */
        int aIndex = Integer.MAX_VALUE;
        /**
         * 当前字符之后第一个出现的"b"的索引位置
         */
        int bIndex = Integer.MAX_VALUE;
        /**
         * 当前字符之后第一个出现的"c"的索引位置
         */
        int cIndex = Integer.MAX_VALUE;
        int length = s.length();

        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == 'a') {
                aIndex = Math.min(aIndex, i);
                /**
                 * 如果当前字符"a"之后"b"和"c"都出现过，则以索引i开始，以Math.max(bIndex,cIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (bIndex != Integer.MAX_VALUE && cIndex != Integer.MAX_VALUE) {
                    result += (length - Math.max(bIndex, cIndex));
                }
            } else if (c == 'b') {
                bIndex = Math.min(bIndex, i);
                /**
                 * 如果当前字符"b"之后"a"和"c"都出现过，则以索引i开始，以Math.max(aIndex,cIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (aIndex != Integer.MAX_VALUE && cIndex != Integer.MAX_VALUE) {
                    result += (length - Math.max(aIndex, cIndex));
                }
            } else {
                cIndex = Math.min(cIndex, i);
                /**
                 * 如果当前字符"c"之后"a"和"b"都出现过，则以索引i开始，以Math.max(aIndex,bIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (aIndex != Integer.MAX_VALUE && bIndex != Integer.MAX_VALUE) {
                    result += (length - Math.max(aIndex, bIndex));
                }
            }
        }
        return result;
    }
}
