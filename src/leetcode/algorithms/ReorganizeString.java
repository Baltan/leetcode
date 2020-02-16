package leetcode.algorithms;

/**
 * Description: 767. Reorganize String
 *
 * @author Baltan
 * @date 2020-02-16 12:28
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aaaaaabbcc"));
        System.out.println(reorganizeString("aaaaaabbccd"));
        System.out.println(reorganizeString("aaaaaaabbcc"));
        System.out.println(reorganizeString("aaaaaaabbbcd"));
        System.out.println(reorganizeString("aaabbbccc"));
        System.out.println(reorganizeString("aaabbbcc"));
        System.out.println(reorganizeString("aabbcc"));
        System.out.println(reorganizeString("vvvlo"));
        System.out.println(reorganizeString("blflxll"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/reorganize-string/solution/zui-you-jie-fa-tong-guo-by-18520397110-2/"></a>
     *
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        int length = S.length();
        char[] result = new char[S.length()];
        /**
         * 对每个小写字母出现的次数计数
         */
        int[] count = new int[26];
        /**
         * 出现最多次的那个小写字母出现的次数
         */
        int maxCount = 0;

        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }
        /**
         * 如果有一个小写字母出现的次数大于(length + 1)/2，则这个小写字母一定会出现相邻的情况
         */
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        int evenIndex = 0;
        int oddIndex = 1;

        for (int i = 0; i < 26; i++) {
            /**
             * 如果存在出现次数为length/2+1的字母，S的长度只可能为奇数，例如：aabbbbc中的b，这
             * 种情况下，该字母一定是填充所有的偶数位置
             */
            if (count[i] == length / 2 + 1) {
                while (count[i] > 0) {
                    result[evenIndex] = (char) (i + 'a');
                    count[i]--;
                    evenIndex += 2;
                }
            } else {
                /**
                 * 将该字母先逐一填充奇数索引位置，如果奇数索引位置不够了，再从头开始逐一填充偶
                 * 数索引位置
                 */
                while (count[i] > 0 && oddIndex < length) {
                    result[oddIndex] = (char) (i + 'a');
                    count[i]--;
                    oddIndex += 2;
                }
                /**
                 * 逐一填充偶数索引位置
                 */
                while (count[i] > 0) {
                    result[evenIndex] = (char) (i + 'a');
                    count[i]--;
                    evenIndex += 2;
                }
            }
        }
        return new String(result);
    }
}
