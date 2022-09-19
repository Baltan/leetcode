package leetcode.algorithms;

/**
 * Description: 1662. Check If Two String Arrays are Equivalent
 *
 * @author Baltan
 * @date 2022/9/11 13:17
 * @see ArrayStringsAreEqual1
 */
public class ArrayStringsAreEqual {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        /**
         * 指向数组word1中当时正在比较的字符串
         */
        int wordIndex1 = 0;
        /**
         * 指向数组word2中当时正在比较的字符串
         */
        int wordIndex2 = 0;
        /**
         * 指向数组word1中当时正在比较的字符串中的某个字符
         */
        int letterIndex1 = 0;
        /**
         * 指向数组word2中当时正在比较的字符串中的某个字符
         */
        int letterIndex2 = 0;

        while (true) {
            /**
             * 数组word1中的上一个单词已比较完，指针移动到下一个单词的第一个字符
             */
            if (letterIndex1 == word1[wordIndex1].length()) {
                wordIndex1++;
                letterIndex1 = 0;
            }
            /**
             * 数组word2中的上一个单词已比较完，指针移动到下一个单词的第一个字符
             */
            if (letterIndex2 == word2[wordIndex2].length()) {
                wordIndex2++;
                letterIndex2 = 0;
            }
            /**
             * 如果两个字符串数组同时比较结束，说明它们相等；如果其中一个结束了而另一个没结束，说明它们不相等；如果当时指向的两个
             * 字符不同，说明它们不相等
             */
            if (wordIndex1 == word1.length && wordIndex2 == word2.length) {
                return true;
            } else if (wordIndex1 == word1.length || wordIndex2 == word2.length) {
                return false;
            } else {
                if (word1[wordIndex1].charAt(letterIndex1) != word2[wordIndex2].charAt(letterIndex2)) {
                    return false;
                }
            }
            letterIndex1++;
            letterIndex2++;
        }
    }
}
