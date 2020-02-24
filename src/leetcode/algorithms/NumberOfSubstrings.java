package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1358. Number of Substrings Containing All Three Characters
 *
 * @author Baltan
 * @date 2020-02-23 15:11
 */
public class NumberOfSubstrings {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abab"));
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
        System.out.println(numberOfSubstrings(
                "abcabcacbacbacaacbaacbacabaabcaacbacabacabcabcabacabcabcabacaacacbaacabcabcaabcabca"));
    }

    public static int numberOfSubstrings(String s) {
        int result = 0;
        int length = s.length();
        /**
         * 按顺序记录"a"所在的索引位置
         */
        List<Integer> aIndexes = new ArrayList<>();
        /**
         * 按顺序记录"b"所在的索引位置
         */
        List<Integer> bIndexes = new ArrayList<>();
        /**
         * 按顺序记录"c"所在的索引位置
         */
        List<Integer> cIndexes = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                aIndexes.add(i);
            } else if (c == 'b') {
                bIndexes.add(i);
            } else {
                cIndexes.add(i);
            }
        }

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                /**
                 * 这个"a"之后"b"最早出现的索引位置
                 */
                int bIndex = help(bIndexes, i);
                /**
                 * 这个"a"之后"c"最早出现的索引位置
                 */
                int cIndex = help(cIndexes, i);
                /**
                 * 如果这个"a"之后"b"和"c"都存在，则以索引i开始，以Math.max(bIndex,cIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (bIndex != -1 && cIndex != -1) {
                    result += (length - Math.max(bIndex, cIndex));
                }
            } else if (c == 'b') {
                /**
                 * 这个"b"之后"a"最早出现的索引位置
                 */
                int aIndex = help(aIndexes, i);
                /**
                 * 这个"b"之后"c"最早出现的索引位置
                 */
                int cIndex = help(cIndexes, i);
                /**
                 * 如果这个"b"之后"a"和"c"都存在，则以索引i开始，以Math.max(aIndex,cIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (aIndex != -1 && cIndex != -1) {
                    result += (length - Math.max(aIndex, cIndex));
                }
            } else {
                /**
                 * 这个"c"之后"a"最早出现的索引位置
                 */
                int aIndex = help(aIndexes, i);
                /**
                 * 这个"c"之后"b"最早出现的索引位置
                 */
                int bIndex = help(bIndexes, i);
                /**
                 * 如果这个"c"之后"a"和"b"都存在，则以索引i开始，以Math.max(aIndex,bIndex)
                 * 索引结尾的子串符合要求，并且这之后所有的索引结尾的子串都符合要求
                 */
                if (aIndex != -1 && bIndex != -1) {
                    result += (length - Math.max(aIndex, bIndex));
                }
            }
        }
        return result;
    }

    /**
     * 在indexes中二分查找大于i的最小值，如果找不到返回-1
     *
     * @param indexes
     * @param i
     * @return
     */
    public static int help(List<Integer> indexes, int i) {
        /**
         * 如果indexes中没有元素或者最后一个元素也不大于i，则indexes中没有大于i的元素，返回-1
         */
        if (indexes.isEmpty() || i >= indexes.get(indexes.size() - 1)) {
            return -1;
        }

        int lo = 0;
        int hi = indexes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (indexes.get(mid) < i) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return indexes.get(hi);
    }
}
