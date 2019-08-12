package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1156. Swap For Longest Repeated Character Substring
 *
 * @author Baltan
 * @date 2019-08-12 10:22
 */
public class MaxRepOpt1 {
    public static void main(String[] args) {
        System.out.println(maxRepOpt1("ababa"));
        System.out.println(maxRepOpt1("aaabaaa"));
        System.out.println(maxRepOpt1("aaabbaaa"));
        System.out.println(maxRepOpt1("aaaaa"));
        System.out.println(maxRepOpt1("abcdef"));
    }

    public static int maxRepOpt1(String text) {
        int result = 0;
        /**
         * 统计每个单字符重复字符串的起始终止索引，存入map中
         */
        Map<Character, List<int[]>> map = new HashMap<>();
        int length = text.length();
        int start = 0;

        for (int i = 0; i < length - 1; i++) {
            char c1 = text.charAt(i);
            char c2 = text.charAt(i + 1);

            if (c1 != c2) {
                map.putIfAbsent(c1, new ArrayList<>());
                map.get(c1).add(new int[]{start, i});
                /**
                 * 保存当前单字符重复字符串的最大长度
                 */
                result = Math.max(result, i - start + 1);
                start = i + 1;
            }
        }
        /**
         * 处理最后一个字符，即最后一个单字符重复字符串
         */
        if (text.charAt(length - 1) == text.charAt(length - 2)) {
            char c = text.charAt(length - 1);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(new int[]{start, length - 1});
            /**
             * 保存当前单字符重复字符串的最大长度
             */
            result = Math.max(result, length - start);
        } else {
            char c = text.charAt(length - 1);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(new int[]{length - 1, length - 1});
            /**
             * 保存当前单字符重复字符串的最大长度
             */
            result = Math.max(result, 1);
        }

        for (char c : map.keySet()) {
            List<int[]> list = map.get(c);
            int size = list.size();
            /**
             * 如果某一个字符存在大于一个单字符重复字符串，那么可以进行一次字符交换获得更长的单字符重复字符串
             */
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    /**
                     * 假如某一个字符的单字符重复字符串的长度为l，那么肯定可以从另一个该字符的单字符重复字符串中交换一个
                     * 字符到当前单字符重复字符串的头部或尾部，获得长度至少为l+1的单字符重复字符串
                     */
                    int[] arr1 = list.get(i);
                    result = Math.max(result, arr1[1] - arr1[0] + 1 + 1);
                    int[] arr2 = list.get(i + 1);
                    result = Math.max(result, arr2[1] - arr2[0] + 1 + 1);
                    /**
                     * 如果两个同一字符的单字符重复字符串中间只隔了一个其他字符，并且除了这两个单字符重复字符串外，
                     * 如果还有第三个该字符的单字符重复字符串，可以通过交换中间间隔的字符和第三个单字符重复字符串中某一
                     * 个字符获得该字符长度为(arr1[1] - arr1[0] + 1) + (arr2[1] - arr2[0] + 1) + 1的单字符重复字符串；
                     * 如果只有这两个该字符的单字符重复字符串，可以通过交换中间间隔的字符和第一个单字符重复字符串的字一个字符
                     * 或者第二个单字符重复字符串的最后一个字符获得该字符长度为(arr1[1] - arr1[0] + 1) +
                     * (arr2[1] - arr2[0] + 1)的单字符重复字符串。
                     */
                    if (arr1[1] + 2 == arr2[0]) {
                        if (size > 2) {
                            result = Math.max(result, (arr1[1] - arr1[0] + 1) + (arr2[1] - arr2[0] + 1) + 1);
                        } else {
                            result = Math.max(result, (arr1[1] - arr1[0] + 1) + (arr2[1] - arr2[0] + 1));
                        }
                    }
                }
            }
        }
        return result;
    }
}
