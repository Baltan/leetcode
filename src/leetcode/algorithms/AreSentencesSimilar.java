package leetcode.algorithms;

import java.util.Arrays;
import java.util.Objects;

/**
 * Description: 1813. Sentence Similarity III
 *
 * @author Baltan
 * @date 2022/6/23 16:14
 */
public class AreSentencesSimilar {
    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(areSentencesSimilar("of", "A lot of words"));
        System.out.println(areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(
                areSentencesSimilar("xD iP tqchblXgqvNVdi", "FmtdCzv Gp YZf UYJ xD iP tqchblXgqvNVdi"));
        System.out.println(areSentencesSimilar("B",
                "ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH"));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (Objects.equals(sentence1, sentence2)) {
            return true;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        /**
         * 如果sentence1和sentence2中的单词数相同，但是两个句子不相同，则两句话肯定不相似
         */
        if (words1.length == words2.length) {
            return false;
        }
        return words1.length < words2.length ? help(words2, words1) : help(words1, words2);
    }

    /**
     * 判断能否在数组words2最后连续加上几个单词得到数组words1，即数组words1是否以子数组words2开头
     *
     * @param words1
     * @param words2
     * @return
     */
    public static boolean startsWith(String[] words1, String[] words2) {
        for (int i = 0; i < words2.length; i++) {
            if (!Objects.equals(words1[i], words2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断能否在数组words2开头连续加上几个单词得到数组words1，即数组words1是否以子数组words2结尾
     *
     * @param words1
     * @param words2
     * @return
     */
    public static boolean endsWith(String[] words1, String[] words2) {
        int diffLength = words1.length - words2.length;

        for (int i = words2.length - 1; i >= 0; i--) {
            if (!Objects.equals(words1[i + diffLength], words2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断能否在数组words2中某一处连续加上几个单词得到数组words1
     *
     * @param words1
     * @param words2
     * @return
     */
    public static boolean help(String[] words1, String[] words2) {
        if (startsWith(words1, words2)) {
            return true;
        }

        if (endsWith(words1, words2)) {
            return true;
        }
        /**
         * 数组words1和words2从左到右比较后，第一个不同单词的索引位置
         */
        int i = 0;
        /**
         * 先查找数组words1和words2开头相同的部门
         */
        while (Objects.equals(words1[i], words2[i])) {
            i++;
        }
        /**
         * 判断除了开头相同的部分，words1剩余的子数组是否以words2剩余的子数组结尾
         */
        return endsWith(Arrays.copyOfRange(words1, i, words1.length),
                Arrays.copyOfRange(words2, i, words2.length));
    }
}
