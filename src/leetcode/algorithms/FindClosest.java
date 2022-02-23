package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 面试题 17.11. 单词距离
 *
 * @author Baltan
 * @date 2022/2/23 18:23
 */
public class FindClosest {
    public static void main(String[] args) {
        String[] words1 = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city" };
        System.out.println(findClosest(words1, "a", "student"));
    }

    public static int findClosest(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        /**
         * 当前已遍历的最后一个word1在数组words中的索引位置
         */
        int index1 = -1;
        /**
         * 当前已遍历的最后一个word2在数组words中的索引位置
         */
        int index2 = -1;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (Objects.equals(word, word1)) {
                /**
                 * 判断当前word1和已遍历到的最后一个word2的距离是否更小
                 */
                if (index2 != -1) {
                    result = Math.min(result, i - index2);
                }
                index1 = i;
            } else if (Objects.equals(word, word2)) {
                /**
                 * 判断当前word2和已遍历到的最后一个word1的距离是否更小
                 */
                if (index1 != -1) {
                    result = Math.min(result, i - index1);
                }
                index2 = i;
            }
        }
        return result;
    }
}