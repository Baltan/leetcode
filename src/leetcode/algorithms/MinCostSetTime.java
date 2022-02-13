package leetcode.algorithms;

/**
 * Description: 2162. Minimum Cost to Set Cooking Time
 *
 * @author Baltan
 * @date 2022/2/13 21:41
 */
public class MinCostSetTime {
    public static void main(String[] args) {
        System.out.println(minCostSetTime(0, 6578, 6577, 17));
        System.out.println(minCostSetTime(4, 7, 6, 312));
        System.out.println(minCostSetTime(0, 100000, 100000, 6039));
        System.out.println(minCostSetTime(0, 1, 4, 9));
        System.out.println(minCostSetTime(1, 2, 1, 600));
        System.out.println(minCostSetTime(0, 1, 2, 76));
    }

    public static int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int result = Integer.MAX_VALUE;
        /**
         * 最大可能输入的分钟数
         */
        int maxMinutes = targetSeconds / 60;

        for (int minutes = maxMinutes; minutes >= 0; minutes--) {
            if (minutes > 99) {
                continue;
            }
            /**
             * 需要输入的秒数
             */
            int seconds = targetSeconds - minutes * 60;
            /**
             * 如果输入的秒数大于99，就没有其余的输入方式了（输入的分钟数越小，需要输入的秒数只会越大）
             */
            if (seconds > 99) {
                break;
            }
            /**
             * 当前这种输入方式需要花费的总时间
             */
            int totalCost = 0;
            /**
             * 当前手指所在的数字
             */
            int startNum = startAt;
            StringBuilder clock = new StringBuilder(4);
            /**
             * 如果分钟数大于0时，才需要输入数字，否则前缀"0"会自动补全，不需要输入
             */
            if (minutes > 0) {
                clock.append(minutes);
            }
            /**
             * 如果分钟数不为0并且秒数为一位数，需要输入秒数十位上的"0"
             */
            if (minutes != 0 && seconds <= 9) {
                clock.append(0);
            }
            clock.append(seconds);

            for (char c : clock.toString().toCharArray()) {
                int currNum = c - '0';

                if (currNum == startNum) {
                    /**
                     * 当前手指就在需要输入的数字上，直接输入即可
                     */
                    totalCost += pushCost;
                } else {
                    /**
                     * 手指先移动到需要输入的数字上，再输入数字
                     */
                    totalCost = totalCost + pushCost + moveCost;
                    startNum = currNum;
                }
            }
            result = Math.min(result, totalCost);
        }
        return result;
    }
}
