package leetcode.algorithms;

/**
 * Description: 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 *
 * @author Baltan
 * @date 2021/11/19 17:08
 */
public class WinnerOfGame {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAABABB"));
        System.out.println(winnerOfGame("AA"));
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }

    public static boolean winnerOfGame(String colors) {
        /**
         * Alice可以删除颜色片段"A"的次数
         */
        int aCount = 0;
        /**
         * Bob可以删除颜色片段"B"的次数
         */
        int bCount = 0;
        int firstIndex = 1;
        int lastIndex = colors.length() - 2;
        char[] charArray = colors.toCharArray();

        for (int i = firstIndex; i <= lastIndex; i++) {
            /**
             * 两边都是"A"的"A"可以被删除
             */
            if (charArray[i - 1] == 'A' && charArray[i] == 'A' && charArray[i + 1] == 'A') {
                aCount++;
                /**
                 * 两边都是"B"的"B"可以被删除
                 */
            } else if (charArray[i - 1] == 'B' && charArray[i] == 'B' && charArray[i + 1] == 'B') {
                bCount++;
            }
        }
        return aCount > bCount;
    }
}
