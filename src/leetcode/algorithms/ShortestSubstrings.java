package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Description: 3076. Shortest Uncommon Substring in an Array
 *
 * @author baltan
 * @date 2024/3/13 15:09
 */
public class ShortestSubstrings {
    public static void main(String[] args) {
        OutputUtils.print1DStringArray(shortestSubstrings(new String[]{"cab", "ad", "bad", "c"}));
        OutputUtils.print1DStringArray(shortestSubstrings(new String[]{"abc", "bcd", "abcd"}));
    }

    public static String[] shortestSubstrings(String[] arr) {
        String[] result = new String[arr.length];
        /**
         * 数组arr中所有字符串的所有子串的数量
         */
        Map<String, Integer> totalCount = new HashMap<>();
        /**
         * countMaps[i]表示字符串arr[i]的所有子串的数量
         */
        Map<String, Integer>[] countMaps = new Map[arr.length];

        for (int i = 0; i < arr.length; i++) {
            /**
             * 将所有子串key优先按照长度升序排列，如果长度相同则按照字典顺序升序排列
             */
            Map<String, Integer> countMap = new TreeMap<>((x, y) -> x.length() == y.length() ? x.compareTo(y) : x.length() - y.length());
            /**
             * 遍历字符串arr[i]中的所有子串并计数
             */
            for (int j = 0; j < arr[i].length(); j++) {
                for (int k = j + 1; k <= arr[i].length(); k++) {
                    String substring = arr[i].substring(j, k);
                    countMap.put(substring, countMap.getOrDefault(substring, 0) + 1);
                    totalCount.put(substring, totalCount.getOrDefault(substring, 0) + 1);
                }
            }
            countMaps[i] = countMap;
        }
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<String, Integer> entry : countMaps[i].entrySet()) {
                String substring = entry.getKey();
                /**
                 * 如果字符串arr[i]中子串substring的数量和数组arr中所有字符串中子串substring的数量相等，则说明这个子串只在字符串arr[i]
                 * 中出现过
                 */
                if (Objects.equals(totalCount.get(substring), entry.getValue())) {
                    result[i] = substring;
                    continue outer;
                }
            }
            result[i] = "";
        }
        return result;
    }
}
