package leetcode.algorithms;

/**
 * Description: 2186. Minimum Number of Steps to Make Two Strings Anagram II
 *
 * @author Baltan
 * @date 2022/2/27 22:34
 * @see MinSteps2
 */
public class MinSteps3 {
    public static void main(String[] args) {
        System.out.println(minSteps("leetcode", "coats"));
        System.out.println(minSteps("night", "thing"));
    }

    public static int minSteps(String s, String t) {
        int result = 0;
        int letterCount = 26;
        /**
         * 统计字符串s中每个字符出现的次数
         */
        int[] sCount = new int[letterCount];
        /**
         * 统计字符串t中每个字符出现的次数
         */
        int[] tCount = new int[letterCount];

        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tCount[c - 'a']++;
        }

        for (int i = 0; i < letterCount; i++) {
            /**
             * 同一个字符在两个字符串中出现的次数之差是需要在较少的那个字符串后面追加这个字符的个数
             */
            result += Math.abs(sCount[i] - tCount[i]);
        }
        return result;
    }
}
