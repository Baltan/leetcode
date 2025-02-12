package leetcode.algorithms;

/**
 * Description: 3438. Find Valid Pair of Adjacent Digits in String
 *
 * @author Baltan
 * @date 2025/2/12 23:20
 */
public class FindValidPair {
    public static void main(String[] args) {
        System.out.println(findValidPair("2523533"));
        System.out.println(findValidPair("221"));
        System.out.println(findValidPair("22"));
    }

    public static String findValidPair(String s) {
        /**
         * counts[i]表示字符串s中字符i出现的次数
         */
        int[] counts = new int[10];

        for (char c : s.toCharArray()) {
            counts[c - '0']++;
        }

        for (int i = 1; i < s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            int second = s.charAt(i) - '0';

            if (first != second && counts[first] == first && counts[second] == second) {
                return s.substring(i - 1, i + 1);
            }
        }
        return "";
    }
}
