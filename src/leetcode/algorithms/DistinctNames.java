package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2306. Naming a Company
 *
 * @author Baltan
 * @date 2023/2/10 11:17
 */
public class DistinctNames {
    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"alrgtxxdj", "illqfngl", "rlrgtxxdj"}));
        System.out.println(distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
        System.out.println(distinctNames(new String[]{"lack", "back"}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/naming-a-company/solutions/1596320/by-endlesscheng-ruz8/"></a>
     *
     * @param ideas
     * @return
     */
    public static long distinctNames(String[] ideas) {
        long result = 0L;
        /**
         * 字符串后缀 -> 分组中的首字母情况i，i的二进制值从低位到高位为1依次表示分组中首字母存在a-z
         */
        Map<String, Integer> suffixMap = new HashMap<>();
        /**
         * book[i][j]表示首字母不包含i，但包含j的分组的数量
         */
        int[][] book = new int[26][26];
        /**
         * 统计每个分组中首字母的情况
         */
        for (String idea : ideas) {
            String suffix = idea.substring(1);
            int status = suffixMap.getOrDefault(suffix, 0);
            status |= (1 << (idea.charAt(0) - 'a'));
            suffixMap.put(suffix, status);
        }

        for (int status : suffixMap.values()) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    /**
                     * 当前分组中首字母不存在字母i，存在字母j
                     */
                    if ((status >> i & 1) == 0 && (status >> j & 1) == 1) {
                        book[i][j]++;
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                /**
                 * 第一个分组中首字母不存在字母i，存在字母j，第二个分组中首字母不存在字母j，存在字母i，则第一个分组中j开头的字符串可以和第二个
                 * 分组中i开头的字符串互换首字母
                 */
                result += book[i][j] * book[j][i];
            }
        }
        return result;
    }
}
