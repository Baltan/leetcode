package leetcode.algorithms;

/**
 * Description: 2256. Minimum Average Difference
 *
 * @author Baltan
 * @date 2022/5/9 09:27
 */
public class MinimumAverageDifference {
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
        System.out.println(minimumAverageDifference(new int[]{0}));
    }

    public static int minimumAverageDifference(int[] nums) {
        int result = 0;
        /**
         * 最小平均差值
         */
        long minAvgDiff = Long.MAX_VALUE;
        int length = nums.length;
        /**
         * 前半部分元素的和
         */
        long firstSum = 0L;
        /**
         * 后半部分元素的和
         */
        long lastSum = 0L;
        /**
         * 初始状态，前半部分没有元素，所有元素都在后半部分中
         */
        for (int num : nums) {
            lastSum += num;
        }

        for (int i = 0; i < length; i++) {
            /**
             * 逐一将后半部分的每个元素移出，移入到前半部分的元素中
             */
            firstSum += nums[i];
            lastSum -= nums[i];
            /**
             * 前半部分元素的平均值
             */
            long firstAvg = firstSum / (i + 1);
            /**
             * 后半部分元素的平均值
             */
            long lastAvg = i == length - 1 ? 0 : lastSum / (length - i - 1);
            long avgDiff = Math.abs(firstAvg - lastAvg);

            if (avgDiff < minAvgDiff) {
                minAvgDiff = avgDiff;
                result = i;
            }
        }
        return result;
    }
}
