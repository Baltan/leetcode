package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1371. Find the Longest Substring Containing Vowels in Even Counts
 *
 * @author Baltan
 * @date 2020-03-08 13:59
 */
public class FindTheLongestSubstring {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }

    public static int findTheLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        /**
         * map的key为子串中"a"、"e"、"i"、"o"、"u"出现次数奇偶性的不同状态，value为对应状态第一次出现的索引位
         * 置。例如对于字符串"eleetminicoworoep"：
         *
         * 开始时，都出现0次，保存0b00000 -> -1
         *
         * 第0个字符为e，s.substring(0,1)中e出现奇数次，保存0b01000 -> 0
         *
         * 第1个字符为l，s.substring(0,2)中e出现奇数次，0b01000这个key已经在map中存在过了，所以
         * s.substring(map.get(0b01000)+1,2)符合条件
         *
         * 第2个字符为e，s.substring(0,3)中e出现偶数次，0b00000这个key已经在map中存在过了，所以
         * s.substring(map.get(0b00000)+1,3)符合条件
         *
         * ……
         *
         * 第13个字符为r，s.substring(0,14)中e出现奇数次，0b01000这个key已经在map中存在过了，所以
         * s.substring(map.get(0b01000)+1,14)符合条件
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * count最低位为0表示"u"出现偶数次，为1表示"u"出现奇数次；倒数第二位为0表示"o"出现偶数次，为1表示"o"出
         * 现奇数次；倒数第三位为0表示"i"出现偶数次，为1表示"i"出现奇数次；倒数第四位为0表示"e"出现偶数次，为1表
         * 示"e"出现奇数次；倒数第五位为0表示"a"出现偶数次，为1表示"a"出现奇数次
         */
        int count = 0b00000;
        map.put(count, -1);

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                /**
                 * 将count的倒数第五位取反，其余位保持不变
                 */
                count ^= 0b10000;
            } else if (c == 'e') {
                /**
                 * 将count的倒数第四位取反，其余位保持不变
                 */
                count ^= 0b1000;
            } else if (c == 'i') {
                /**
                 * 将count的倒数第三位取反，其余位保持不变
                 */
                count ^= 0b100;
            } else if (c == 'o') {
                /**
                 * 将count的倒数第二位取反，其余位保持不变
                 */
                count ^= 0b10;
            } else if (c == 'u') {
                /**
                 * 将count的最后一位取反，其余位保持不变
                 */
                count ^= 0b1;
            }
            /**
             * 如果当前奇偶状态还没有出现过，就将这种状态保存下来，否则可以得到一个符合条件的子串，更新最长子字符
             * 串的长度
             */
            if (map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return result;
    }
}
