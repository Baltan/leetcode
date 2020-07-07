package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 16.11. 跳水板
 *
 * @author Baltan
 * @date 2020-03-30 17:49
 */
public class DivingBoard {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(divingBoard(1, 2, 3));
        OutputUtils.print1DIntegerArray(divingBoard(2, 2, 3));
        OutputUtils.print1DIntegerArray(divingBoard(1, 1, 0));
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] result = new int[k + 1];
        /**
         * 生成的最短的跳水板的长度
         */
        result[0] = shorter * k;
        /**
         * 当把一块短木板换成长木板时，可以增加的长度
         */
        int difference = longer - shorter;
        /**
         * 每次把一块短木板换成长木板，就能逐一得到长度递增的木板
         */
        for (int i = 1; i <= k; i++) {
            result[i] = result[i - 1] + difference;
        }
        return result;
    }
}
