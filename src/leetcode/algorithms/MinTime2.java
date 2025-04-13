package leetcode.algorithms;

/**
 * Description: 3494. Find the Minimum Amount of Time to Brew Potions
 *
 * @author Baltan
 * @date 2025/4/13 13:24
 */
public class MinTime2 {
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1539, 3208, 2653, 1697, 2885, 4065, 1984, 3356, 3223, 1056, 13, 4960, 4728, 2356, 4012, 553, 1601, 2356, 1377, 1932, 1101, 1802, 2621, 4023, 507, 4165, 3048, 4676, 1012, 737, 2573, 3417, 4503, 3729, 956, 1175, 2282, 1868, 4974, 2570, 1980, 2301, 3148, 1436, 3662, 4212, 1951}, new int[]{3271, 1584, 466, 4543, 2483, 651, 2281, 2739, 534, 1729, 4646, 3573, 2544, 2743, 4728, 4888, 3411, 2519, 3358, 185, 1547, 1114, 2557, 618, 342, 2904}));
        System.out.println(minTime(new int[]{1, 5, 2, 4}, new int[]{5, 1, 4, 2}));
        System.out.println(minTime(new int[]{1, 1, 1}, new int[]{1, 1, 1}));
        System.out.println(minTime(new int[]{1, 2, 3, 4}, new int[]{1, 2}));
    }

    public static long minTime(int[] skill, int[] mana) {
        /**
         * endTimes[i]表示巫师skill[i]酿造上一瓶药水的完成时间
         */
        long[] endTimes = new long[skill.length];

        for (int i = 0; i < mana.length; i++) {
            /**
             * 药水mana[i]的最早开始酿造时间
             */
            long startTime = 0;
            /**
             * 酿造药水mana[i]的累计时间
             */
            long usedTime = 0;
            /**
             * 对于每一个巫师而言，当前药水mana[i]的开始酿造时间不能早于他酿造上一瓶药水的完成时间：
             * startTime>=endTimes[0]
             * startTime+skill[0]*mana[i]>=endTimes[1]
             * startTime+skill[0]*mana[i]+skill[1]*mana[i]>=endTimes[2]
             * ……
             * startTime+skill[0]*mana[i]+skill[1]*mana[i]+……+skill[skill.length-2]*mana[i]>=endTimes[skill.length-1]
             */
            for (int j = 0; j < skill.length; j++) {
                startTime = Math.max(startTime, endTimes[j] - usedTime);
                usedTime += (long) skill[j] * mana[i];
            }
            usedTime = 0;

            for (int j = 0; j < skill.length; j++) {
                usedTime += (long) skill[j] * mana[i];
                endTimes[j] = startTime + usedTime;
            }
        }
        return endTimes[skill.length - 1];
    }
}
