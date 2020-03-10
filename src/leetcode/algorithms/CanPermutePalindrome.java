package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 面试题 01.04. 回文排列
 *
 * @author Baltan
 * @date 2020-03-10 15:19
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
        System.out.println(canPermutePalindrome("AaBb//a"));
    }

    public static boolean canPermutePalindrome(String s) {
        /**
         * 对s中出现的各种字符计数
         */
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        /**
         * s中一共出现奇数次的字符的个数
         */
        int oddCount = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int value : map.values()) {
            if ((value & 1) == 1) {
                oddCount++;
            }
        }
        /**
         * 如果s的长度为偶数并且s中有出现奇数次的字符，或者s的长度为奇数并且s中出现奇数次的字符不止一个，则s都
         * 无法排列成一个回文串，返回false
         */
        if ((length & 1) == 0 && oddCount > 0) {
            return false;
        } else if ((length & 1) == 1 && oddCount > 1) {
            return false;
        }
        return true;
    }
}
