package leetcode.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 2053. Kth Distinct String in an Array
 *
 * @author Baltan
 * @date 2021/11/18 14:42
 */
public class KthDistinct {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(kthDistinct(new String[]{"aaa", "aa", "a"}, 1));
        System.out.println(kthDistinct(new String[]{"a", "b", "a"}, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        /**
         * 字符串 -> 字符串在arr中出现的次数
         */
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        /**
         * 遍历查找第k个独一无二的字符串
         */
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                k--;
            }

            if (k == 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}
