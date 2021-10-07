package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2023. Number of Pairs of Strings With Concatenation Equal to Target
 *
 * @author Baltan
 * @date 2021/10/7 17:44
 */
public class NumOfPairs {
    public static void main(String[] args) {
        System.out.println(numOfPairs(new String[]{"777", "7", "77", "77"}, "7777"));
        System.out.println(numOfPairs(new String[]{"123", "4", "12", "34"}, "1234"));
        System.out.println(numOfPairs(new String[]{"1", "1", "1"}, "11"));
        System.out.println(numOfPairs(new String[]{"1", "111"}, "11"));
        System.out.println(numOfPairs(new String[]{"9", "93", "9", "2", "32", "32"}, "932"));
        System.out.println(numOfPairs(new String[]{"7", "7777"}, "7777"));
    }

    public static int numOfPairs(String[] nums, String target) {
        int result = 0;
        /**
         * 每个数字字符串出现的次数
         */
        Map<String, Integer> map = new HashMap<>();

        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /**
         * 考虑target可以被分割成两个相同数字字符串的情况
         */
        if (target.length() % 2 == 0) {
            int halfLength = target.length() / 2;
            String head = target.substring(0, halfLength);
            String tail = target.substring(halfLength);

            if (Objects.equals(head, tail)) {
                int count = map.getOrDefault(head, 0);

                if (count > 1) {
                    result += count * (count - 1);
                }
            }
        }
        /**
         * 考虑target被分割成两个不同数字字符串的情况
         */
        for (String num : nums) {
            if (!target.startsWith(num)) {
                continue;
            }

            String tail = target.substring(num.length());

            if (Objects.equals(num, tail)) {
                continue;
            }

            result += map.getOrDefault(tail, 0);
        }
        return result;
    }
}
