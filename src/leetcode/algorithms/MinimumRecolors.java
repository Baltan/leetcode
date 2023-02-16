package leetcode.algorithms;

/**
 * Description: 2379. Minimum Recolors to Get K Consecutive Black Blocks
 *
 * @author Baltan
 * @date 2023/2/13 20:07
 */
public class MinimumRecolors {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }

    public static int minimumRecolors(String blocks, int k) {
        /**
         * 长度为k的子串中字符"W"的个数
         */
        int whiteCount = 0;
        char[] charArray = blocks.toCharArray();

        for (int i = 0; i < k; i++) {
            if (charArray[i] == 'W') {
                whiteCount++;
            }
        }
        int result = whiteCount;

        for (int i = k; i < charArray.length; i++) {
            /**
             * 子串新增一个字符，判断是否是字符"W"
             */
            if (charArray[i] == 'W') {
                whiteCount++;
            }
            /**
             * 子串移除一个字符，判断是否是字符"W"
             */
            if (charArray[i - k] == 'W') {
                whiteCount--;
            }
            result = Math.min(result, whiteCount);
        }
        return result;
    }
}
