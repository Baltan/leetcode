package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 936. Stamping The Sequence
 *
 * @author Baltan
 * @date 2023/3/15 17:57
 */
public class MovesToStamp {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(movesToStamp("abc", "ababc"));
        OutputUtils.print1DIntegerArray(movesToStamp("abca", "aabcaca"));
    }

    public static int[] movesToStamp(String stamp, String target) {
        List<Integer> result = new ArrayList<>();
        char[] stampChars = stamp.toCharArray();
        char[] targetChars = target.toCharArray();
        /**
         * 还未被还原为"?"的字母的数量
         */
        int leftCount = targetChars.length;
        /**
         * 逆序思考，将所有字母都还原为"?"，直到所有字母都被还原
         */
        while (leftCount != 0) {
            /**
             * 戳印的起始索引
             */
            int start = -1;
            /**
             * 本次盖章可以将字母还原为"?"的个数
             */
            int maxCount = 0;
            /**
             * 贪心，尽可能还原更多的字母为"?"，对所有可能的情况进行比较判断
             */
            for (int i = targetChars.length - stampChars.length; i >= 0; i--) {
                int count = match(stampChars, targetChars, i);

                if (count > maxCount) {
                    maxCount = count;
                    start = i;
                }
            }
            /**
             * 说明序列target中剩余的字母不能用戳印还原为"?"，反之不能通过若干次盖章得到序列target
             */
            if (start == -1) {
                return new int[0];
            }
            result.add(start);
            leftCount -= maxCount;
            /**
             * 将本次盖章后序列target中的字母都替换为"?"
             */
            for (int i = start + stampChars.length - 1; i >= start; i--) {
                targetChars[i] = '?';
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(x -> x).toArray();
    }

    /**
     * 判断印章上的字符是否匹配序列target中的字符，如果匹配则返回可以将字母还原为"?"的个数，否则返回-1
     *
     * @param stampChars
     * @param targetChars
     * @param start
     * @return
     */
    public static int match(char[] stampChars, char[] targetChars, int start) {
        int count = 0;

        for (int i = 0; i < stampChars.length; i++) {
            /**
             * 序列target中当前索引不是"?"，且是和戳印上不同的字母，说明印章上的字符不能完全匹配序列target中的字符
             */
            if (targetChars[start + i] != '?' && targetChars[start + i] != stampChars[i]) {
                return -1;
            }
            /**
             * 可以将当前序列target中的字母还原为"?"
             */
            if (targetChars[start + i] != '?') {
                count++;
            }
        }
        return count;
    }
}
