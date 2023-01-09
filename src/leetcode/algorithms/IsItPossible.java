package leetcode.algorithms;

/**
 * Description: 2531. Make Number of Distinct Characters Equal
 *
 * @author Baltan
 * @date 2023/1/8 13:57
 */
public class IsItPossible {
    public static void main(String[] args) {
        System.out.println(isItPossible("aa", "ab"));
        System.out.println(isItPossible("ac", "b"));
        System.out.println(isItPossible("abcc", "aab"));
        System.out.println(isItPossible("abcde", "fghij"));
    }

    public static boolean isItPossible(String word1, String word2) {
        /**
         * charCounts1[0]-charCounts1[25]依次表示字符a-z在字符串word1中出现的次数
         */
        int[] charCounts1 = getCharCounts(word1);
        /**
         * charCounts2[0]-charCounts2[25]依次表示字符a-z在字符串word2中出现的次数
         */
        int[] charCounts2 = getCharCounts(word2);
        /**
         * 字符串word1中不同字符的个数
         */
        int distinctCharCount1 = getDistinctCharCount(charCounts1);
        /**
         * 字符串word2中不同字符的个数
         */
        int distinctCharCount2 = getDistinctCharCount(charCounts2);
        /**
         * 依次判断，将字符串word1中的一个chars[i]和字符串word2中的一个chars[j]交换是否满足题意
         */
        for (int i = 0; i < 26; i++) {
            /**
             * 字符串word1中不存在字符chars[i]
             */
            if (charCounts1[i] == 0) {
                continue;
            }

            for (int j = 0; j < 26; j++) {
                /**
                 * 字符串word2中不存在字符chars[j]
                 */
                if (charCounts2[j] == 0) {
                    continue;
                }
                /**
                 * 字符串word1和字符串word2交换相同的字符（相当于没有交换字符）
                 */
                if (i == j) {
                    if (distinctCharCount1 == distinctCharCount2) {
                        return true;
                    } else {
                        continue;
                    }
                }
                /**
                 * 如果字符串word1中只有一个字符chars[i]，则交换后字符串word1中不同字符的个数少一个；如果字符串word1中没有字符chars[j]，
                 * 则交换后字符串word1中不同字符的个数多一个
                 */
                int count1 = distinctCharCount1 - (charCounts1[i] == 1 ? 1 : 0) + (charCounts1[j] == 0 ? 1 : 0);
                /**
                 * 如果字符串word2中只有一个字符chars[j]，则交换后字符串word2中不同字符的个数少一个；如果字符串word2中没有字符chars[i]，
                 * 则交换后字符串word2中不同字符的个数多一个
                 */
                int count2 = distinctCharCount2 - (charCounts2[j] == 1 ? 1 : 0) + (charCounts2[i] == 0 ? 1 : 0);

                if (count1 == count2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 计算字符串word中每种字符出现的次数
     *
     * @param word
     * @return
     */
    public static int[] getCharCounts(String word) {
        char[] charArray = word.toCharArray();
        /**
         * counts[0]-counts[25]依次表示字符a-z在字符串word中出现的次数
         */
        int[] counts = new int[26];

        for (char c : charArray) {
            counts[c - 'a']++;
        }
        return counts;
    }

    /**
     * 计算字符串word中不同字符的个数
     *
     * @param charCounts
     * @return
     */
    public static int getDistinctCharCount(int[] charCounts) {
        int distinctCharCount = 0;

        for (int charCount : charCounts) {
            if (charCount > 0) {
                distinctCharCount++;
            }
        }
        return distinctCharCount;
    }
}
