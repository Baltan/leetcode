package leetcode.algorithms;

/**
 * Description: 3039. Apply Operations to Make String Empty
 *
 * @author baltan
 * @date 2024/2/21 09:22
 */
public class LastNonEmptyString {
    public static void main(String[] args) {
        System.out.println(lastNonEmptyString("aabcbbca"));
        System.out.println(lastNonEmptyString("abcd"));
    }

    public static String lastNonEmptyString(String s) {
        StringBuilder result = new StringBuilder();
        /**
         * 字符串s中出现次数最多的字母的频数
         */
        int maxCount = 0;
        /**
         * counts[0]-counts[25]依次表示字符串s中字母a-z的个数
         */
        int[] counts = new int[26];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            int offset = c - 'a';
            counts[offset]++;
            maxCount = Math.max(maxCount, counts[offset]);
        }
        /**
         * 字符串s中，出现次数为maxCount次的字母最终会被保留下来，从后向前找到该字母最后一次出现的位置即可
         */
        for (int i = charArray.length - 1; i >= 0; i--) {
            int offset = charArray[i] - 'a';

            if (counts[offset] == maxCount) {
                result.insert(0, charArray[i]);
                /**
                 * 减小字母charArray[i]的频数，避免再次被拼接进子序列result中
                 */
                counts[offset]--;
            }
        }
        return result.toString();
    }
}
