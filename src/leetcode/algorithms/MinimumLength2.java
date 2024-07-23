package leetcode.algorithms;

/**
 * Description: 3223. Minimum Length of String After Operations
 *
 * @author baltan
 * @date 2024/7/23 09:23
 */
public class MinimumLength2 {
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
    }

    public static int minimumLength(String s) {
        int result = 0;
        /**
         * counts[0]-counts[25]依次表示字符串s中字母a-z的个数
         */
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int count : counts) {
            if (count == 0) {
                continue;
            }
            /**
             * 如果某个字符在字符串s中出现偶数次，则除了最中间的两个字符其余字符都能被删除；如果某个字符在字符串s中出现奇数次，则除了最中间的
             * 字符其余字符都能被删除
             */
            if (count % 2 == 0) {
                result += 2;
            } else {
                result += 1;
            }
        }
        return result;
    }
}
