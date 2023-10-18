package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2904. Shortest and Lexicographically Smallest Beautiful String
 *
 * @author Baltan
 * @date 2023/10/17 23:21
 */
public class ShortestBeautifulSubstring {
    public static void main(String[] args) {
        System.out.println(shortestBeautifulSubstring("100011001", 3));
        System.out.println(shortestBeautifulSubstring("1011", 2));
        System.out.println(shortestBeautifulSubstring("000", 1));
    }

    public static String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        char[] charArray = s.toCharArray();
        int minLength = Integer.MAX_VALUE;
        /**
         * 按顺序保存字符串s中所有1的索引
         */
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                indexes.add(i);
                /**
                 * 当出现1的个数不小于k时，可以得到一个以当前字符1结尾的一个美丽子字符串
                 */
                if (indexes.size() >= k) {
                    /**
                     * 美丽子字符串的第一个1的索引位置
                     */
                    int headIndex = indexes.get(indexes.size() - k);
                    /**
                     * 当前美丽子字符串的长度
                     */
                    int length = i - headIndex + 1;

                    if (length < minLength) {
                        minLength = length;
                        result = s.substring(headIndex, i + 1);
                    } else if (length == minLength && s.substring(headIndex, i + 1).compareTo(result) < 0) {
                        result = s.substring(headIndex, i + 1);
                    }
                }
            }
        }
        return result;
    }
}
