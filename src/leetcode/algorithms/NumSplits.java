package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1525. Number of Good Ways to Split a String
 *
 * @author Baltan
 * @date 2020-07-28 08:39
 * @see NumSplits1
 */
public class NumSplits {
    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
        System.out.println(numSplits("abcd"));
        System.out.println(numSplits("aaaaa"));
        System.out.println(numSplits("acbadbaada"));
    }

    public static int numSplits(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        /**
         * 记录左边的子串中各个字符出现的次数
         */
        Map<Character, Integer> leftMap = new HashMap<>();
        /**
         * 记录右边的子串中各个字符出现的次数
         */
        Map<Character, Integer> rightMap = new HashMap<>();
        /**
         * 初始化左边的子串就是s本身，对子串中各个字符出现的次数进行计数
         */
        for (char c : charArray) {
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
        }
        /**
         * 逐一将s最右边的字符逐一移动到右边的子串中
         */
        for (int i = charArray.length - 1; i > 0; i--) {
            char c = charArray[i];
            /**
             * 更新右边子串中不同字符的个数
             */
            rightMap.put(c, rightMap.getOrDefault(c, 0) + 1);
            int leftCount = leftMap.get(c) - 1;
            /**
             * 更新左边子串中不同字符的个数
             */
            if (leftCount == 0) {
                leftMap.remove(c);
            } else {
                leftMap.put(c, leftCount);
            }

            if (leftMap.size() == rightMap.size()) {
                result++;
            } else if (leftMap.size() < rightMap.size()) {
                /**
                 * 如果左边的子串中的不同字符的个数少于右边的子串，直接退出循环
                 */
                break;
            }
        }
        return result;
    }
}
