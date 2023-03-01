package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 2136. Earliest Possible Day of Full Bloom
 *
 * @author Baltan
 * @date 2023/2/27 16:29
 */
public class EarliestFullBloom {
    public static void main(String[] args) {
        System.out.println(earliestFullBloom(new int[]{1, 4, 3}, new int[]{2, 3, 1}));
        System.out.println(earliestFullBloom(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 1}));
        System.out.println(earliestFullBloom(new int[]{1}, new int[]{1}));
    }

    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int result = 0;
        /**
         * 开始播种的日期
         */
        int plantDay = 0;
        int length = plantTime.length;
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 按照花生长所需的天数倒序排列，生长时间越长的花越早播种
         */
        Arrays.sort(indexes, (x, y) -> growTime[y] - growTime[x]);

        for (int index : indexes) {
            result = Math.max(result, plantDay + plantTime[index] + growTime[index]);
            /**
             * 更新下一朵花播种的日期
             */
            plantDay += plantTime[index];
        }
        return result;
    }
}
