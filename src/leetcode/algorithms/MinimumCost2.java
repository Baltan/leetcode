package leetcode.algorithms;

/**
 * Description: 2712. Minimum Cost to Make All Characters Equal
 *
 * @author Baltan
 * @date 2023/6/1 23:38
 */
public class MinimumCost2 {
    public static void main(String[] args) {
        System.out.println(minimumCost("0011"));
        System.out.println(minimumCost("010101"));
    }

    public static long minimumCost(String s) {
        char[] charArray = s.toCharArray();
        return Math.min(invert(charArray, '0'), invert(charArray, '1'));
    }

    /**
     * 通过两种操作将数组中所有元素都变为字符target需要的总计操作次数
     *
     * @param charArray
     * @param target
     * @return
     */
    public static long invert(char[] charArray, char target) {
        long result = 0L;
        int length = charArray.length;
        int half = length >> 1;
        /**
         * 判断当前字符是否已经在最原始字符的基础上发生变化
         */
        boolean isConverted = false;

        for (int i = half; i >= 0; i--) {
            /**
             * !isConverted&&(charArray[i]!=target)或isConverted&&(charArray[i]==target)时，都需要对charArray[0]到
             * charArray[i]这部分子数组进行翻转操作
             */
            if (isConverted == (charArray[i] == target)) {
                result += i + 1;
                isConverted = !isConverted;
            }
        }
        isConverted = false;

        for (int i = half + 1; i < length; i++) {
            /**
             * !isConverted&&(charArray[i]!=target)或isConverted&&(charArray[i]==target)时，都需要对charArray[i]到
             * charArray[length-1]这部分子数组进行翻转操作
             */
            if (isConverted == (charArray[i] == target)) {
                result += length - i;
                isConverted = !isConverted;
            }
        }
        return result;
    }
}
