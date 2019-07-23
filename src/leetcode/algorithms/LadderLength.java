package leetcode.algorithms;

import java.util.*;

/**
 * Description: 127. Word Ladder
 *
 * @author Baltan
 * @date 2019-07-23 15:07
 */
public class LadderLength {
    public static void main(String[] args) {
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord1, endWord1, wordList1));

        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(ladderLength(beginWord2, endWord2, wordList2));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        /**
         * 将beginWord加入队列
         */
        queue.offer(beginWord);
        int listLength = wordList.size();
        /**
         * 用于标记单词表中某一个单词是否已经被使用过
         */
        boolean[] book = new boolean[listLength];

        while (!queue.isEmpty()) {
            int length = queue.size();
            result++;
            /**
             * 将当前队列中的单词修改一个字母后可以得到的单词都加入到队列中
             */
            for (int i = 0; i < length; i++) {
                String word = queue.poll();

                for (int j = 0; j < listLength; j++) {
                    String str = wordList.get(j);

                    if (!book[j] && isOneLetterDifferent(str, word)) {
                        /**
                         * 如果修改一个字母后的单词和endWord相同，已经完成转换，可以直接返回结果
                         */
                        if (Objects.equals(str, endWord)) {
                            return result;
                        } else {
                            queue.offer(str);
                            /**
                             * 将修改一个字母后的单词标记为已使用过，避免重复使用
                             */
                            book[j] = true;
                        }
                    }
                }
            }
        }
        /**
         * 没有找到转换序列，返回0
         */
        return 0;
    }

    /**
     * 判断两个单词是否只相差一个字母
     */
    public static boolean isOneLetterDifferent(String word1, String word2) {
        int length = word1.length();
        int differentLetterCount = 0;

        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentLetterCount++;

                if (differentLetterCount > 1) {
                    return false;
                }
            }
        }
        return differentLetterCount == 1;
    }
}
