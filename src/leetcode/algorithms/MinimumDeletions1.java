package leetcode.algorithms;

/**
 * Description: 1653. Minimum Deletions to Make String Balanced
 *
 * @author Baltan
 * @date 2022/9/14 09:37
 */
public class MinimumDeletions1 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
        System.out.println(minimumDeletions("aaaaaaaaa"));
        System.out.println(minimumDeletions("bbbbbbbbb"));
        System.out.println(minimumDeletions("bbbbbaaaaa"));
        System.out.println(minimumDeletions("aaaabbbbb"));
    }

    public static int minimumDeletions(String s) {
        int result = Integer.MAX_VALUE;
        int length = s.length();
        char[] charArray = s.toCharArray();
        /**
         * dpA[i]表示charArray[i]右边（包括charArray[i]）的字符'a'的个数
         */
        int[] dpA = new int[length + 1];
        /**
         * dpB[i]表示charArray[i-1]左边（包括charArray[i-1]）的字符'b'的个数
         */
        int[] dpB = new int[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            dpA[i] = dpA[i + 1] + (charArray[i] == 'a' ? 1 : 0);
        }

        for (int i = 0; i < length; i++) {
            dpB[i + 1] = dpB[i] + (charArray[i] == 'b' ? 1 : 0);
            /**
             * charArray[i]左边的字符'b'和charArray[i]右边的字符'a'需要被删除（都不包括charArray[i]）
             */
            int sum = dpB[i] + dpA[i + 1];
            result = Math.min(result, sum);
        }
        return result;
    }
}
