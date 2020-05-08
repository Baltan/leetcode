package leetcode.algorithms;

/**
 * Description: 1433. Check If a String Can Break Another String
 *
 * @author Baltan
 * @date 2020-05-08 08:03
 */
public class CheckIfCanBreak {
    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
        System.out.println(checkIfCanBreak("abe", "acd"));
        System.out.println(checkIfCanBreak("leetcodee", "interview"));
    }

    public static boolean checkIfCanBreak(String s1, String s2) {
        /**
         * s1中每个字母出现的次数
         */
        int[] count1 = new int[26];
        /**
         * s2中每个字母出现的次数
         */
        int[] count2 = new int[26];
        int length = s1.length();

        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            count1[c1 - 'a']++;
            count2[c2 - 'a']++;
        }
        /**
         * s1能否打破s2
         */
        boolean flag = true;
        /**
         * s1当前比s2大的字母的个数
         */
        int difference = 0;
        /**
         * 判断s1能否打破s2
         */
        for (int i = 0; i < 26; i++) {
            difference = difference - count2[i] + count1[i];
            /**
             * 如果difference小于0，说明两个字符串中的字母都按照字典顺序升序排列后，存在某个对应位置上s1的字母
             * 小于s2的字母，s1不能打破s2
             */
            if (difference < 0) {
                flag = false;
                break;
            }
        }
        /**
         * 如果s1打破s2，直接返回true
         */
        if (flag) {
            return true;
        }
        /**
         * s2当前比s1大的字母的个数
         */
        difference = 0;
        /**
         * 判断s2能否打破s1
         */
        for (int i = 0; i < 26; i++) {
            difference = difference - count1[i] + count2[i];

            if (difference < 0) {
                return false;
            }
        }
        return true;
    }
}
