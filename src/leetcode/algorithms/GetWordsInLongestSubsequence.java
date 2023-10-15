package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2900. Longest Unequal Adjacent Groups Subsequence I
 *
 * @author Baltan
 * @date 2023/10/15 23:02
 */
public class GetWordsInLongestSubsequence {
    public static void main(String[] args) {
        System.out.println(getWordsInLongestSubsequence(3, new String[]{"e", "a", "b"}, new int[]{0, 0, 1}));
        System.out.println(getWordsInLongestSubsequence(4, new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 1, 1}));
    }

    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        /**
         * 数组groups中的下一个目标数字，为了使得子序列尽可能长，根据贪心思想，groups中的第一个数字作为子序列的第一个数字
         */
        int target = groups[0];

        for (int i = 0; i < n; i++) {
            if (groups[i] == target) {
                result.add(words[i]);
                target = 1 - target;
            }
        }
        return result;
    }
}
