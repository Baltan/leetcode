package leetcode.algorithms;

/**
 * Description: 3084. Count Substrings Starting and Ending with Given Character
 *
 * @author Baltan
 * @date 2024/3/20 21:08
 */
public class CountSubstrings2 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abada", 'a'));
        System.out.println(countSubstrings("zzz", 'z'));
    }

    public static long countSubstrings(String s, char c) {
        /**
         * 字符串s中字母c的总个数
         */
        long count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count * (count + 1) / 2;
    }
}
