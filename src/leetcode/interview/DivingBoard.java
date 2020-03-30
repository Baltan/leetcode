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
         * 一次计算用i块长木板和k-i块短木板可以拼成的跳水板的长度
         */
        for (int i = 0; i <= k; i++) {
            result[i] = longer * i + shorter * (k - i);
        }
        return result;
    }
}
