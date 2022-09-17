package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1657. Determine if Two Strings Are Close
 *
 * @author Baltan
 * @date 2022/9/11 19:43
 */
public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("uau", "ssx"));
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] countArray1 = help(word1);
        int[] countArray2 = help(word2);

        for (int i = 0; i < 26; i++) {
            /**
             * 如果word1中出现过的字符word2中没出现过，或者word2中出现过的字符word1中没出现过，两个字符串不接近
             */
            if ((countArray1[i] == 0 && countArray2[i] != 0) ||
                    (countArray2[i] == 0 && countArray1[i] != 0)) {
                return false;
            }
        }
        Arrays.sort(countArray1);
        Arrays.sort(countArray2);
        /**
         * 操作1不改变字符串word1中的字符种类，只有操作2可以改变字符串word1中的字符种类，但是不论怎么使用操作2，字符串中某一频
         * 次的不同字符的个数是不会变的。如果可以通过多次使用操作2，使得word1中的每种字符出现的频次都和word2中对应上，只需要再多
         * 次使用操作1调整字符的排序，就能得到word2。反之，如果某一频次word1和word2中不同字符的个数不同，则一定无法通过word1得
         * 到word2
         */
        for (int i = 0; i < 26; i++) {
            if (countArray1[i] != countArray2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计字符串word中每个字符出现的次数
     *
     * @param word
     * @return
     */
    public static int[] help(String word) {
        /**
         * 字符串word都由小写字母组成，所以一共可能有26种字符
         */
        int length = 26;
        /**
         * countArrayA[0]-countArrayA[25]依次表示字符a-z在字符串a中出现的次数
         */
        int[] countArray = new int[length];

        for (char c : word.toCharArray()) {
            countArray[c - 'a']++;
        }
        return countArray;
    }
}
