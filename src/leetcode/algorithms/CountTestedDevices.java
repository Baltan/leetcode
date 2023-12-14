package leetcode.algorithms;

/**
 * Description: 2960. Count Tested Devices After Test Operations
 *
 * @author baltan
 * @date 2023/12/14 08:58
 */
public class CountTestedDevices {
    public static void main(String[] args) {
        System.out.println(countTestedDevices(new int[]{1, 1, 2, 1, 3}));
        System.out.println(countTestedDevices(new int[]{0, 1, 2}));
    }

    public static int countTestedDevices(int[] batteryPercentages) {
        int result = 0;
        /**
         * 设备累计减少的电量
         */
        int decrement = 0;

        for (int batteryPercentage : batteryPercentages) {
            /**
             * 当前设备的电量在之前所有设备执行完测试操作后已被减少decrement
             */
            if (batteryPercentage - decrement > 0) {
                result++;
                decrement++;
            }
        }
        return result;
    }
}
