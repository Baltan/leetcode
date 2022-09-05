package leetcode.algorithms;


/**
 * Description: 1684. Count the Number of Consistent Strings
 *
 * @author Baltan
 * @date 2022/9/3 11:42
 * @see CountConsistentStrings
 */
public class CountConsistentStrings1 {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(
                countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(
                countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        int allowedValue = getValue(allowed);

        for (String word : words) {
            int wordValue = getValue(word);
            /**
             * 参考：
             * <a href="https://leetcode.cn/problems/count-the-number-of-consistent-strings/solution/zhuang-tai-ya-suo-wei-yun-suan-by-zheng-xl00a/"></a>
             */
            if ((allowedValue & wordValue) == wordValue) {
                result++;
            }
        }
        return result;
    }

    /**
     * 计算word的二进制值
     *
     * @param word
     * @return
     */
    public static int getValue(String word) {
        int value = 0;
        /**
         * 如果word中包含字符"a"，则将value的最低位记为1；如果word中包含字符"b"，则将value的第2个最低位记为1；以此类推，如果
         * word中包含字符"z"，则将value的第26个最低位记为1
         */
        for (char c : word.toCharArray()) {
            value |= (1 << (c - 'a'));
        }
        return value;
    }
}
