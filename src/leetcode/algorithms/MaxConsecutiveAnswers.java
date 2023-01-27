package leetcode.algorithms;

/**
 * Description: 2024. Maximize the Confusion of an Exam
 *
 * @author Baltan
 * @date 2023/1/26 15:07
 */
public class MaxConsecutiveAnswers {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 1;
        char[] charArray = answerKey.toCharArray();
        int length = charArray.length;
        /**
         * 滑动窗口的起始索引
         */
        int lo = 0;
        /**
         * 滑动窗口的结束索引
         */
        int hi = -1;
        /**
         * 滑动窗口中字符T的数量
         */
        int countT = 0;
        /**
         * 滑动窗口中字符F的数量
         */
        int countF = 0;

        while (hi < length) {
            /**
             * 滑动窗口已经不可能再扩大，结束循环
             */
            if (hi == length - 1) {
                break;
            }
            /**
             * 如果窗口扩大一个长度，仍可以在k次操作内使窗口中的字符T都变成字符F或者使窗口中的字符F都变成字符T，则扩大窗口
             */
            if (countT + (charArray[hi + 1] == 'T' ? 1 : 0) <= k || countF + (charArray[hi + 1] == 'F' ? 1 : 0) <= k) {
                hi++;
                /**
                 * 窗口中新增了字符charArray[hi]
                 */
                if (charArray[hi] == 'T') {
                    countT++;
                } else {
                    countF++;
                }
                result = Math.max(result, hi - lo + 1);
            } else {
                /**
                 * 缩小窗口，减少了字符charArray[lo]
                 */
                if (charArray[lo] == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                lo++;
            }
        }
        return result;
    }
}
