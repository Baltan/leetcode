package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 792. Number of Matching Subsequences
 *
 * @author Baltan
 * @date 2019-10-18 10:06
 */
public class NumMatchingSubseq {
    public static void main(String[] args) {
        String[] words1 = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq("abcde", words1));

        String[] words2 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(numMatchingSubseq("dsahjpjauf", words2));
    }

    public static int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        int sLength = S.length();
        /**
         * 统计S中每个字符出现的位置索引，保存在集合中
         */
        for (int i = 0; i < sLength; i++) {
            char c = S.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        outer:
        for (String word : words) {
            int position = -1;

            for (char c : word.toCharArray()) {
                /**
                 * 如果map中没有字符c这个key，说明S中不包含字符c，该单词不为S的子序列
                 */
                if (!map.containsKey(c)) {
                    continue outer;
                }

                List<Integer> list = map.get(c);
                /**
                 * 在字符c的位置集合中查找在position之后的最靠前的位置，即查找list中大于position的最小值
                 */
                int index = find(list, position);
                /**
                 * 如果在position之后的位置的字符都不为字符c，说明该单词不为S的子序列
                 */
                if (index == -1) {
                    continue outer;
                }
                position = index;
            }
            result++;
        }
        return result;
    }

    /**
     * 查找list中大于position的最小值，如果list中没有大于position的值，返回-1
     *
     * @param list
     * @param position
     * @return
     */
    public static int find(List<Integer> list, int position) {
        int lo = 0;
        int hi = list.size() - 1;
        int mid = (lo + hi) / 2;
        /**
         * 如果位置集合中最后一个位置都不在position之后，即list中的最大值都不大于position，直接返回-1
         */
        if (list.get(list.size() - 1) <= position) {
            return -1;
        }

        while (lo <= hi) {
            if (position == list.get(mid)) {
                /**
                 * 如果位置集合中mid位置的值等于position，mid位置的下一个值即为所求
                 */
                return list.get(mid + 1);
            } else if (position > list.get(mid)) {
                lo = mid + 1;
                /**
                 * 如果位置集合中mid位置的值小于position，所求值必定在mid位置之后，如果mid位置的下一个值就大于
                 * position，下一个值即为所求
                 */
                if (position < list.get(lo)) {
                    return list.get(lo);
                }
            } else {
                /**
                 * 如果位置集合中mid位置的值大于position，所求值必定在mid位置之前
                 */
                hi = mid - 1;
            }
            mid = (lo + hi) / 2;
        }
        return list.get(mid);
    }
}
