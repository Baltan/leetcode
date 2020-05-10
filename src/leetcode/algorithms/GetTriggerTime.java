package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: LCP 08. 剧情触发时间
 *
 * @author Baltan
 * @date 2020-05-10 22:34
 */
public class GetTriggerTime {
    public static void main(String[] args) {
        int[][] increase1 = {{2, 8, 4}, {2, 5, 0}, {10, 9, 8}};
        int[][] requirements1 = {{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};
        OutputUtils.print1DIntegerArray(getTriggerTime(increase1, requirements1));

        int[][] increase2 = {{0, 4, 5}, {4, 8, 8}, {8, 6, 1}, {10, 10, 0}};
        int[][] requirements2 = {{12, 11, 16}, {20, 2, 6}, {9, 2, 6}, {10, 18, 3}, {8, 14, 9}};
        OutputUtils.print1DIntegerArray(getTriggerTime(increase2, requirements2));

        int[][] increase3 = {{1, 1, 1}};
        int[][] requirements3 = {{0, 0, 0}};
        OutputUtils.print1DIntegerArray(getTriggerTime(increase3, requirements3));
    }

    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] result = new int[requirements.length];
        int dayCount = increase.length;
        /**
         * statusEveryday[i]为一个长度为3的一维数组，表示第i天过后，三种属性的值
         */
        int[][] statusEveryday = new int[dayCount + 1][3];
        statusEveryday[0] = new int[]{0, 0, 0};
        /**
         * 计算每天过后三种属性的值
         */
        for (int i = 0; i < dayCount; i++) {
            statusEveryday[i + 1] = new int[]{statusEveryday[i][0] + increase[i][0],
                    statusEveryday[i][1] + increase[i][1], statusEveryday[i][2] + increase[i][2]};
        }

        for (int i = 0; i < requirements.length; i++) {
            /**
             * 假设第i种剧情无法被触发，则result[i]为-1
             */
            result[i] = -1;
            /**
             * 依次计算如果要触发第i种剧情，三种属性分别至少需要的天数
             */
            for (int j = 0; j < requirements[i].length; j++) {
                /**
                 * 触发第i种剧情的当前属性需要的值
                 */
                int requirement = requirements[i][j];
                int lo = 0;
                int hi = dayCount;
                /**
                 * 二分查找
                 */
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (statusEveryday[mid][j] < requirement) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                /**
                 * 如果最后找到的那一天的属性值还是达不到requirement，即最后一天的属性值也不足requirement，
                 * 则剧情无法被触发，同时不需要再判断剩余的属性需要的天数
                 */
                if (statusEveryday[lo][j] < requirement) {
                    result[i] = -1;
                    break;
                } else {
                    /**
                     * 更新触发第i种剧情需要的天数
                     */
                    result[i] = Math.max(result[i], lo);
                }
            }
        }
        return result;
    }
}
