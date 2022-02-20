package leetcode.algorithms;

/**
 * Description: 1941. Check if All Characters Have Equal Number of Occurrences
 *
 * @author Baltan
 * @date 2022/2/20 13:58
 */
public class AreOccurrencesEqual {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
        System.out.println(areOccurrencesEqual("aaabb"));
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] countArray = new int[26];
        /**
         * 字符串s中索引最小的字符出现的次数
         */
        int count = 0;
        /**
         * 对字符串s中每个字符出现的次数计数
         */
        for (char c : s.toCharArray()) {
            countArray[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countArray[i] != 0) {
                if (count == 0) {
                    /**
                     * 字符串s中索引最小的字符出现的次数
                     */
                    count = countArray[i];
                } else if (countArray[i] != count) {
                    return false;
                }
            }
        }
        return true;
    }
}
