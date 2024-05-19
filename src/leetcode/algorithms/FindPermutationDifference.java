package leetcode.algorithms;

/**
 * Description: 3146. Permutation Difference between Two Strings
 *
 * @author Baltan
 * @date 2024/5/18 21:59
 */
public class FindPermutationDifference {
    public static void main(String[] args) {
        System.out.println(findPermutationDifference("abc", "bac"));
        System.out.println(findPermutationDifference("abcde", "edbac"));
    }

    public static int findPermutationDifference(String s, String t) {
        int result = 0;
        /**
         * sIndexes[0]-sIndexes[25]依次表示字符串s中字符a-z各自的索引位置
         */
        int[] sIndexes = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sIndexes[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < t.length(); i++) {
            /**
             * 当前字符t.charAt(i)在字符串s中的索引值为sIndexes[t.charAt(i)-'a']
             */
            result += Math.abs(i - sIndexes[t.charAt(i) - 'a']);
        }
        return result;
    }
}
