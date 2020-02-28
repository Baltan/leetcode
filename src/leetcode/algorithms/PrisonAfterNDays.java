package leetcode.algorithms;


import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 957. Prison Cells After N Days
 *
 * @author Baltan
 * @date 2020-02-28 11:55
 */
public class PrisonAfterNDays {
    public static void main(String[] args) {
        int[] cells1 = {0, 1, 0, 1, 1, 0, 0, 1};
        OutputUtils.print1DIntegerArray(prisonAfterNDays(cells1, 7));

        int[] cells2 = {1, 0, 0, 1, 0, 0, 1, 0};
        OutputUtils.print1DIntegerArray(prisonAfterNDays(cells2, 1000000000));

        int[] cells3 = {1, 1, 0, 1, 1, 0, 1, 1};
        OutputUtils.print1DIntegerArray(prisonAfterNDays(cells3, 6));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int length = cells.length;
        /**
         * 牢房状态每隔loop天会回到相同的状态
         */
        int loop = Integer.MAX_VALUE;
        /**
         * 保存牢房从第1天（0-based）开始每天的状态
         */
        List<int[]> prisonList = new ArrayList<>();
        /**
         * 牢房第1天后的状态
         */
        int[] prisonsDay1 = new int[length];

        for (int j = 1; j < length - 1; j++) {
            prisonsDay1[j] = 1 - (cells[j - 1] ^ cells[j + 1]);
        }

        prisonList.add(prisonsDay1);
        /**
         * 更新牢房每天的状态，直到某一天和第一天时的状态相同，此时找到了循环
         */
        for (int i = 1; i < N; i++) {
            int[] prisonsToday = new int[length];
            int[] prisonsYesterday = prisonList.get(i - 1);

            for (int j = 1; j < length - 1; j++) {
                prisonsToday[j] = 1 - (prisonsYesterday[j - 1] ^ prisonsYesterday[j + 1]);
            }
            /**
             * 如果今天牢房的状态和第一天后的相同，此时找到了循环的天数
             */
            if (Arrays.equals(prisonList.get(0), prisonsToday)) {
                loop = i;
                break;
            }
            prisonList.add(prisonsToday);
        }
        /**
         * 如果N%loop=0，说明牢房第N天的状态和第loop天的状态相同
         */
        N = N % loop == 0 ? loop : N % loop;
        return prisonList.get(N - 1);
    }
}
