package leetcode.algorithms;

/**
 * Description: 3720. Lexicographically Smallest Permutation Greater Than Target
 *
 * @author baltan
 * @date 2026/1/26 15:58
 */
public class LexGreaterPermutation {
    public static void main(String[] args) {
        System.out.println(lexGreaterPermutation("ab", "ab"));
        System.out.println(lexGreaterPermutation("abc", "bba"));
        System.out.println(lexGreaterPermutation("leet", "code"));
        System.out.println(lexGreaterPermutation("baba", "bbaa"));
    }

    public static String lexGreaterPermutation(String s, String target) {
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * counts[0]-counts[25]依次表示字符串s重排列过程中剩余字符a-z的个数
         */
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        /**
         * 按顺序逐一遍历字符串s的重排列中每个位置上可能的字符
         */
        for (int i = 0; i < s.length(); i++) {
            /**
             * 字符串target长度为i+1的前缀子串
             */
            String targetPrefix = target.substring(0, i + 1);
            /**
             * 因为需要找到字符串s字典顺序最小的重排列，所以重排列中当前位置上的字符的字典顺序应尽可能地小
             */
            for (int j = 0; j < 26; j++) {
                if (counts[j] == 0) {
                    continue;
                }
                /**
                 * 假设s的重排列中当前位置上的字符为j
                 */
                builder.append((char) (j + 'a'));
                /**
                 * 如果此时s的重排列长度为i+1的前缀子串字典顺序小于targetPrefix，该重排列不符合字典顺序严格大于target的要求，还原重排列
                 * 中当前位置上的字符j，考虑字典顺序更大的字符
                 */
                if (builder.toString().compareTo(targetPrefix) < 0) {
                    builder.deleteCharAt(builder.length() - 1);
                    continue;
                }
                counts[j]--;
                /**
                 * s的重排列除去前缀子串builder外，剩余部分字典顺序最大的子串
                 */
                String maxSuffix = "";

                for (int k = counts.length - 1; k >= 0; k--) {
                    if (counts[k] > 0) {
                        maxSuffix += String.valueOf((char) (k + 'a')).repeat(counts[k]);
                    }
                }
                /**
                 * 如果当前s的重排列builder+maxSuffix的字典顺序大于target，说明s的重排列中当前位置上的字符可以为j，继续计算下一位置上的
                 * 字符。否则，还原重排列中当前位置上的字符j，考虑字典顺序更大的字符
                 */
                if ((builder + maxSuffix).compareTo(target) > 0) {
                    break;
                }
                builder.deleteCharAt(builder.length() - 1);
                counts[j]++;
            }
        }
        return builder.length() == s.length() ? builder.toString() : "";
    }
}
