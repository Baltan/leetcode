package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1488. Avoid Flood in The City
 *
 * @author Baltan
 * @date 2020-06-25 22:13
 */
public class AvoidFlood {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{2, 3, 0, 0, 3, 1, 0, 1, 0, 2, 2}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{1, 2, 3, 4}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{1, 2, 0, 0, 2, 1}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{1, 2, 0, 1, 2}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{69, 0, 0, 0, 69}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{10, 20, 20}));
        OutputUtils.print1DIntegerArray(avoidFlood(new int[]{0, 1, 1}));
    }

    public static int[] avoidFlood(int[] rains) {
        /**
         * 湖泊索引 -> 该湖泊装满水的日期
         */
        Map<Integer, Integer> fullMap = new HashMap<>();
        /**
         * 保存所有不下雨的日期
         */
        List<Integer> dryDays = new ArrayList<>();

        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];

            if (lake != 0) {
                /**
                 * 如果湖泊lake已经被注满水了
                 */
                if (fullMap.containsKey(lake)) {
                    /**
                     * 查找最近一次将湖泊lake注满的日期之后的第一个不下雨的日期
                     */
                    int dryDayIndex = binarySearch(dryDays, fullMap.get(lake));
                    /**
                     * 如果上次将lake注满之后没有不下雨的日期，则第i天lake就会发生洪水，直接返回一个
                     * 空数组
                     */
                    if (dryDayIndex == -1) {
                        return new int[]{};
                    } else {
                        /**
                         * 在上次将lake注满之后的第一个不下雨的日期，我们选择抽干湖泊lake中的水
                         */
                        rains[dryDays.get(dryDayIndex)] = lake;
                        rains[i] = -1;
                        /**
                         * 最近一次将湖泊lake注满水的日期更新为第i天
                         */
                        fullMap.put(lake, i);
                        /**
                         * 这个不下雨的日期已经被用来抽干湖泊lake的水了，以后不能再被利用
                         */
                        dryDays.remove(dryDayIndex);
                    }
                } else {
                    rains[i] = -1;
                    fullMap.put(lake, i);
                }
            } else {
                dryDays.add(i);
            }
        }
        /**
         * 还没被利用的不下雨的日期可以随意抽干某个湖泊的水，假设都抽干第一个湖泊的水即可
         */
        for (int dryDay : dryDays) {
            rains[dryDay] = 1;
        }
        return rains;
    }

    /**
     * 在dryDays中二分查找大于day的最小的元素的索引
     *
     * @param dryDays
     * @param day
     * @return
     */
    public static int binarySearch(List<Integer> dryDays, int day) {
        /**
         * 如果dryDays中没有元素，或者如果dryDays中最后一个元素都小于day，则dryDays中不存在大于day的元素
         */
        if (dryDays.isEmpty() || dryDays.get(dryDays.size() - 1) < day) {
            return -1;
        }

        int lo = 0;
        int hi = dryDays.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (dryDays.get(mid) < day) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
