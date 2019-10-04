package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 567. Permutation in String
 *
 * @author Baltan
 * @date 2019-10-04 11:21
 */
public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int length1 = s1.length();
        int length2 = s2.length();
        /**
         * 计算s1中每个字符出现的次数
         */
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        /**
         * 逐一计算s2中每个长度和s1相等的子串中每个字符出现的次数，如果该子串的统计结果和s1的统计结果一致，
         * 说明该子串即为s1的排列，直接返回true，否则继续迭代判断
         */
        for (int i = 0; i < length1; i++) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = length1; i < length2; i++) {
            /**
             * 当前子串要将前一个子串的第一个字符删除
             */
            char deleteChar = s2.charAt(i - length1);
            char addChar = s2.charAt(i);
            count2[deleteChar - 'a']--;
            count2[addChar - 'a']++;

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }
}
