package leetcode.algorithms;

/**
 * Description: 2730. Find the Longest Semi-Repetitive Substring
 *
 * @author Baltan
 * @date 2023/6/13 23:47
 */
public class LongestSemiRepetitiveSubstring {
    public static void main(String[] args) {
        System.out.println(longestSemiRepetitiveSubstring("52233"));
        System.out.println(longestSemiRepetitiveSubstring("5494"));
        System.out.println(longestSemiRepetitiveSubstring("1111111"));
    }

    public static int longestSemiRepetitiveSubstring(String s) {
        int result = 1;
        /**
         * 前前一个相邻且相等的字符对第二个字符的索引
         */
        int end1 = 0;
        /**
         * 前一个相邻且相等的字符对第二个字符的索引
         */
        int end2 = 0;
        /**
         * count表示遍历过程中已找到的相邻且相等的字符对的数量
         */
        int count = 0;
        char[] charArray = s.toCharArray();

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                if (count == 0) {
                    /**
                     * 如果从首个字符开始到字符s[i]为止第一次出现相邻且相等的字符对，则这部分子串是半重复子串，例如：abcdefgg
                     */
                    result = Math.max(result, i + 1);
                    end1 = i;
                    count++;
                } else if (count == 1) {
                    /**
                     * 如果从首个字符开始到字符s[i]为止第二次出现相邻且相等的字符对，则从第一个字符对第二个字符开始到当前字符这部分子串是
                     * 半重复字串，例如：abcddefghh，则“defghh”是半重复字串
                     */
                    result = Math.max(result, i - end1 + 1);
                    end2 = i;
                    count++;
                } else {
                    /**
                     * 如果从首个字符开始到字符s[i]为止至少3次出现相邻且相等的字符对，则从前前一个字符对第二个字符开始到当前字符对第一个
                     * 字符这部分子串是半重复字串，例如：abcddefghhijkk，则“defghhijk”是半重复字串
                     */
                    result = Math.max(result, i - end1);
                    end1 = end2;
                    end2 = i;
                }
            } else {
                if (count == 0 || count == 1) {
                    /**
                     * 如果从首个字符开始到字符s[i]为止出现相邻且相等的字符对的次数不大于2次，则这部分子串是半重复子串，例如：abcdeffgh、
                     * abcdef
                     */
                    result = Math.max(result, i + 1);
                } else {
                    /**
                     * 如果从首个字符开始到字符s[i]为止至少3次出现相邻且相等的字符对，则从前前一个字符对第二个字符开始到当前字符对第一个
                     * 字符这部分子串是半重复字串，例如：abcddefghhijkklm，则“hijkklm”是半重复字串
                     */
                    result = Math.max(result, i - end1 + 1);
                }
            }
        }
        return result;
    }
}
