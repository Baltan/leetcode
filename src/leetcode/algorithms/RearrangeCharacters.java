package leetcode.algorithms;

/**
 * Description: 2287. Rearrange Characters to Make Target String
 *
 * @author Baltan
 * @date 2023/2/17 09:49
 */
public class RearrangeCharacters {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println(rearrangeCharacters("abcba", "abc"));
        System.out.println(rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }

    public static int rearrangeCharacters(String s, String target) {
        int result = Integer.MAX_VALUE;
        /**
         * sCounts[0]-sCounts[25]依次表示字符串s中字母a-z的个数
         */
        int[] sCounts = new int[26];
        /**
         * targetCounts[0]-targetCounts[25]依次表示字符串target中字母a-z的个数
         */
        int[] targetCounts = new int[26];

        for (char c : s.toCharArray()) {
            sCounts[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            targetCounts[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (targetCounts[i] > 0) {
                /**
                 * 字符串target中的当前字符最多形成sCounts[i]/targetCounts[i]个副本
                 */
                result = Math.min(result, sCounts[i] / targetCounts[i]);
            }
        }
        return result;
    }
}
