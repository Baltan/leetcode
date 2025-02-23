package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3458. Select K Disjoint Special Substrings
 *
 * @author Baltan
 * @date 2025/2/23 13:44
 */
public class MaxSubstringLength {
    public static void main(String[] args) {
        System.out.println(maxSubstringLength("nbuirvanjiccnsyyyoirleqsrwrvxepaglcidqplyryujytzqoncxjgwdmatytgwhzyhlsodrbzrpbbitovtdasazjtoyyfhowqqrzuvjveydceouscrfazzoblqhalhfybwheybkpcroijxvarrtqrqnmwslkpdducfeblvfecyjyulxgahxlzlyztssfzwvfujrriryslkvdwhmkcyebfhkadrahunvxivkwitilyzknwyujtylahgmlddymlbrbrniomepbmdieasuvdcqnzfwspxewbbpruxrznjxwnjjxvblxyrgv", 1));
        System.out.println(maxSubstringLength("gaixgqpgdrhhxuurgrriwovkbjjbffnlnjcnyzbmblymcmvnftlpaiqepgxgiperurhgduaqpqxqgaxdexur", 6));
        System.out.println(maxSubstringLength("abcdbaefab", 2));
        System.out.println(maxSubstringLength("cdefdc", 3));
        System.out.println(maxSubstringLength("abeabe", 0));
    }

    public static boolean maxSubstringLength(String s, int k) {
        /**
         * ranges[0]-ranges[25]依次表示字符串s中字符a-z出现的索引范围，如果某个字符在s中没出现过，则对应的索引范围为[-1,-1]
         */
        int[][] ranges = new int[26][2];
        Arrays.setAll(ranges, x -> new int[]{-1, -1});

        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            /**
             * 当前字符在字符串s中首次出现
             */
            if (ranges[offset][0] == -1) {
                ranges[offset] = new int[2];
                ranges[offset][0] = i;
            }
            /**
             * 更新当前字符在字符串s中最后一次出现的索引
             */
            ranges[offset][1] = i;
        }
        /**
         * 保存特殊子串的在字符串s中的索引范围，并且按照每个特殊子串的最后一个字符在s中的索引升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        outer:
        for (int[] range : ranges) {
            if (range[0] == -1) {
                continue;
            }
            /**
             * 如果令字符s[range[0]]作为某个特殊子串的首字符，计算该特殊子串最短情况下的最后一个字符的索引，记为range[1]
             */
            for (int i = range[0] + 1; i < range[1]; i++) {
                int offset = s.charAt(i) - 'a';
                /**
                 * 如果当前子串包含字符s[i]，则必须包含字符串s中的所有字符s[i]，而当前子串是从s[range[0]]开始的，不可能包含s中第一次出现
                 * 的字符s[i]（即s[ranges[offset][0]]），所以不可能存在以s[range[0]]开头的特殊子串，直接结束判断
                 */
                if (ranges[offset][0] < range[0]) {
                    continue outer;
                }
                /**
                 * 因为当前子串必须包含字符串s中的所有字符s[i]，所以子串必须包含s中最后一次出现的字符s[i]（即s[ranges[offset][1]]），
                 * 也就是说，当前特殊子串最短情况下的最后一个字符的索引不小于ranges[offset][1]
                 */
                range[1] = Math.max(range[1], ranges[offset][1]);
            }
            /**
             * 字符串s本身不能作为特殊子串
             */
            if (range[0] != 0 || range[1] != s.length() - 1) {
                pq.offer(range);
            }
        }
        /**
         * 哨兵
         */
        int prevEnd = -1;
        /**
         * 按顺序查找k个特殊子串，要求当前特殊子串和前一个特殊子串不相交
         */
        while (k > 0 && !pq.isEmpty()) {
            int[] range = pq.poll();

            if (range[0] > prevEnd) {
                k--;
                prevEnd = range[1];
            }
        }
        return k == 0;
    }
}
