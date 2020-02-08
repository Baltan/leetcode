package leetcode.algorithms;

import java.util.*;

/**
 * Description: 522. Longest Uncommon Subsequence II
 *
 * @author Baltan
 * @date 2020-02-08 11:52
 */
public class FindLUSlength1 {
    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
        System.out.println(findLUSlength(new String[]{"qqqqq", "qqqqq", "qqqq", "qqqq"}));
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"}));
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "c", "e"}));
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "cb", "abc"}));
    }

    public static int findLUSlength(String[] strs) {
        /**
         * 统计每个字符串出现的次数，出现次数大于一次的字符串的子串显然不可能是最长特殊序列
         */
        Map<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        /**
         * 保存所有只出现过一次的字符串
         */
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        /**
         * 如果没有只出现一次的字符串，则最长特殊序列不存在，返回-1
         */
        if (list.isEmpty()) {
            return -1;
        }
        /**
         * 对所有只出现一次字符串按照字符串长度降序排列
         */
        Collections.sort(list, (x, y) -> y.length() - x.length());
        int size = list.size();
        /**
         * 最长特殊序列可能的最大长度就是所有只出现一次的字符串中最长的那个的长度，即最长的那个就
         * 是最长特殊序列
         */
        int subsequenceLength = list.get(0).length();
        /**
         * 保存已经判断过的子序列，避免重复判断
         */
        Set<String> subsequenceSet = new HashSet<>();
        /**
         * 按照子序列可能的长度逐一降序判断
         */
        while (subsequenceLength > 0) {
            for (int i = 0; i < size; i++) {
                /**
                 * 如果当前字符串长度小于要产生的子序列的长度了，则当前长度下所有子序列都已经判断
                 * 过了，继续对长度更小的子序列进行判断
                 */
                if (list.get(i).length() < subsequenceLength) {
                    break;
                }
                /**
                 * 字符串list.get(i)可以产生的所有长度为subsequenceLength的子序列
                 */
                Queue<String> sequences = createSubsequence(list.get(i), subsequenceLength, subsequenceSet);
                /**
                 * 对每个子序列进行判断，检查是不是strs中其他字符串的子序列
                 */
                for (String sequence : sequences) {
                    /**
                     * 如果子序列sequence不是其他字符串的子序列，则已经找到一个最长特殊序列，返
                     * 回当前处理的子序列的长度
                     */
                    if (!checkAll(strs, sequence)) {
                        return subsequenceLength;
                    }
                }
            }
            /**
             * 将尝试的子序列长度减小后继续判断是否是最长特殊序列
             */
            subsequenceLength--;
        }
        return -1;
    }

    /**
     * 字符串str可以产生的所有长度为subsequenceLength的子序列
     *
     * @param str
     * @param subsequenceLength
     * @param subsequenceSet
     * @return
     */
    public static Queue<String> createSubsequence(String str, int subsequenceLength,
                                                  Set<String> subsequenceSet) {
        Queue<String> result = new LinkedList<>();
        /**
         * 要删除的字符个数
         */
        int deleteCount = str.length() - subsequenceLength;
        /**
         * 如果要删除的字符个数为0，即str本身就是唯一满足要求的子序列
         */
        if (deleteCount == 0) {
            result.offer(str);
            return result;
        }

        result.offer(str);
        /**
         * 每次循环将当前队列中的每个字符串删除一个字母
         */
        for (int i = 0; i < deleteCount; i++) {
            int size = result.size();

            for (int j = 0; j < size; j++) {
                String s = result.poll();
                int length = s.length();
                /**
                 * 对于字符串s，删除一个字母后，得到的子序列如果subsequenceSet中不存在，就先加
                 * 入result队列
                 */
                for (int k = 0; k < length; k++) {
                    String subsequence = s.substring(0, k) + s.substring(k + 1);

                    if (!subsequenceSet.contains(subsequence)) {
                        result.offer(subsequence);
                        subsequenceSet.add(subsequence);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 检查子序列subsequence是不是strs中其他字符串的子序列
     *
     * @param strs
     * @param subsequence
     * @return
     */
    public static boolean checkAll(String[] strs, String subsequence) {
        /**
         * 如果子序列subsequence是strs中某个字符串的子序列，就将count加1
         */
        int count = 0;
        int length = strs.length;

        for (int i = 0; i < length; i++) {
            /**
             * 判断子序列subsequence是否是字符串strs[i]的子序列
             */
            if (isSubsequence(subsequence, strs[i])) {
                count++;
                /**
                 * 如果count大于1，说明子序列subsequence至少是strs中其他某个字符串的子序列，返
                 * 回true
                 */
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断子序列subsequence是否是字符串str的子序列
     *
     * @param subsequence
     * @param str
     * @return
     */
    public static boolean isSubsequence(String subsequence, String str) {
        /**
         * 子序列subsequence中字符发索引位置
         */
        int index = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            /**
             * 如果子序列subsequence的当前字符在str中找到了，将index加1，继续查找subsequence
             * 中的下一个字符
             */
            if (str.charAt(i) == subsequence.charAt(index)) {
                index++;
            }
            /**
             * 如果index值和子序列subsequence的长度相等，说明subsequence中的所有字符都在字符串
             * str中按顺序找到了，即subsequence时字符串str的一个子序列
             */
            if (index == subsequence.length()) {
                return true;
            }
        }
        return false;
    }
}
