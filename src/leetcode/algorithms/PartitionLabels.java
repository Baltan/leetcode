package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 763. Partition Labels
 *
 * @author Baltan
 * @date 2018/8/11 20:41
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("qwerty"));
        System.out.println(partitionLabels("qwertyq"));
        System.out.println(partitionLabels("a"));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/"></a>
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        /**
         * 记录每个字母最后一次出现的位置
         */
        int[] lastIndexes = new int[26];
        char[] charArray = S.toCharArray();
        int length = charArray.length;
        /**
         * 每个片段的起始索引位置
         */
        int start = 0;
        /**
         * 每个片段的结束索引位置
         */
        int end = 0;
        /**
         * 获取每个字母最后一次出现的位置
         */
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            lastIndexes[c - 'a'] = i;
        }

        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            /**
             * 当前片段的结束索引位置不会小于lastIndexes[c-'a']
             */
            end = Math.max(end, lastIndexes[c - 'a']);
            /**
             * 如果当前遍历到的位置就是当前片段的结束索引位置，则已经得到一个符合要求的片段，将片段长度
             * 加入result即可，继续查找下一个片段
             */
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
