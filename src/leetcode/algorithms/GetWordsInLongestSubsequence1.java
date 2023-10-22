package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2901. Longest Unequal Adjacent Groups Subsequence II
 *
 * @author baltan
 * @date 2023/10/16 10:08
 * @see GetWordsInLongestSubsequence
 */
public class GetWordsInLongestSubsequence1 {
    public static void main(String[] args) {
        System.out.println(getWordsInLongestSubsequence(3, new String[]{"bab", "dab", "cab"}, new int[]{1, 2, 2}));
        System.out.println(getWordsInLongestSubsequence(4, new String[]{"a", "b", "c", "d"}, new int[]{1, 2, 3, 4}));
    }

    public static List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> result = Collections.emptyList();
        /**
         * indexesArray[i]按顺序保存数组words中长度为i的所有字符串的索引
         */
        List<Integer>[] indexesArray = new List[11];
        /**
         * neighborMatrices[i][j][k]表示在长度为i的所有字符串中，words[indexesArray[i][j]]能否在words[indexesArray[i][k]]前面
         */
        boolean[][][] neighborMatrices = new boolean[11][][];
        Arrays.setAll(indexesArray, x -> new ArrayList<>());
        /**
         * 将words中的所有字符串按照长度进行分类
         */
        for (int i = 0; i < n; i++) {
            String word = words[i];
            indexesArray[word.length()].add(i);
        }

        for (int i = 0; i < 11; i++) {
            int size = indexesArray[i].size();
            /**
             * words[indexesArray[i][j]]能否在words[indexesArray[i][k]]前面
             */
            neighborMatrices[i] = new boolean[size][size];

            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int indexX = indexesArray[i].get(j);
                    int indexY = indexesArray[i].get(k);
                    /**
                     * words[indexesArray[i][j]]可以在words[indexesArray[i][k]]前面的条件是这两个字符串不相等且海明距离为1
                     */
                    neighborMatrices[i][j][k] = groups[indexX] != groups[indexY] && hammingDistance(words, indexX, indexY, i) == 1;
                }
            }
        }

        for (int i = 0; i < 11; i++) {
            boolean[][] neighborMatrix = neighborMatrices[i];
            /**
             * words中长度为i的所有字符串的索引值
             */
            List<Integer> indexes = indexesArray[i];
            /**
             * dp[n]表示以字符串words[indexes[n]]结尾的最长子序列
             */
            List<String>[] dp = new List[indexes.size()];

            for (int j = 0; j < indexes.size(); j++) {
                dp[j] = new ArrayList<>();

                for (int k = j - 1; k >= 0; k--) {
                    if (neighborMatrix[k][j] && dp[k].size() > dp[j].size()) {
                        dp[j] = dp[k];
                    }
                }
                /**
                 * 拷贝dp[j]到新数组，保留dp[j]原来的值
                 */
                dp[j] = new ArrayList<>(dp[j]);
                dp[j].add(words[indexes.get(j)]);

                if (dp[j].size() > result.size()) {
                    result = dp[j];
                }
            }
        }
        return result;
    }

    /**
     * 计算字符串words[indexX]和words[indexY]的汉明距离
     *
     * @param words
     * @param indexX
     * @param indexY
     * @param length
     * @return
     */
    public static int hammingDistance(String[] words, int indexX, int indexY, int length) {
        int distance = 0;
        String wordX = words[indexX];
        String wordY = words[indexY];

        for (int i = 0; i < length; i++) {
            if (wordX.charAt(i) != wordY.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
