package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3186. Maximum Total Damage With Spell Casting
 *
 * @author baltan
 * @date 2024/6/18 09:12
 */
public class MaximumTotalDamage {
    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[]{7, 1, 6, 6}));
        System.out.println(maximumTotalDamage(new int[]{1, 1, 3, 4}));
    }

    public static long maximumTotalDamage(int[] power) {
        long result = Integer.MIN_VALUE;
        /**
         * 伤害值i -> 伤害值为i的咒语的数量
         */
        Map<Integer, Integer> countMap = new HashMap<>((int) (power.length / 0.75 + 1));

        for (int damage : power) {
            countMap.put(damage, countMap.getOrDefault(damage, 0) + 1);
        }
        List<Integer> damages = new ArrayList<>(countMap.keySet());
        /**
         * 将所有可能造成的伤害值按照升序排列
         */
        Collections.sort(damages);

        if (damages.size() == 1) {
            return (long) damages.getFirst() * countMap.get(damages.getFirst());
        } else if (damages.size() == 2) {
            /**
             * 如果damages[1]-damages[0]>2，则可以同时选择damages[0]和damages[1]，否则只能选择damages[0]和damages[1]两者其中一个
             */
            if (damages.get(1) - damages.getFirst() > 2) {
                return (long) damages.getFirst() * countMap.get(damages.getFirst()) + (long) damages.get(1) * countMap.get(damages.get(1));
            } else {
                return Math.max(damages.getFirst() * countMap.get(damages.getFirst()), damages.get(1) * countMap.get(damages.get(1)));
            }
        }
        /**
         * dp[i][0]表示damage[i]和damage[i-1]都不选择时的最大伤害，dp[i][1]表示选择damage[i-1]并且不选择damage[i]时的最大伤害，
         * dp[i][2]表示选择damage[i]并且不选择damage[i-1]时的最大伤害，dp[i][3]表示damage[i]和damage[i-1]都选择时的最大伤害
         */
        long[][] dp = new long[damages.size()][4];
        dp[1][0] = 0;
        dp[1][1] = (long) damages.getFirst() * countMap.get(damages.getFirst());
        dp[1][2] = (long) damages.get(1) * countMap.get(damages.get(1));
        dp[1][3] = damages.get(1) - damages.get(0) <= 2 ? -1 :
                (long) damages.getFirst() * countMap.get(damages.getFirst()) + (long) damages.get(1) * countMap.get(damages.get(1));

        for (int i = 2; i < damages.size(); i++) {
            Arrays.fill(dp[i], -1);
            /**
             * 如果不选择damages[i-1]和damages[i-2]，则可能出现：
             * 1、不选择damages[i-1]和damages[i]
             * 2、不选择damages[i-1]，选择damages[i]
             */
            if (dp[i - 1][0] != -1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
                dp[i][2] = Math.max(dp[i][2], dp[i - 1][0] + (long) damages.get(i) * countMap.get(damages.get(i)));
            }
            /**
             * 如果选择damages[i-2]，不选择damages[i-1]，则可能出现：
             * 1、不选择damages[i-1]和damages[i]
             * 2、不选择damages[i-1]，选择damages[i]（damages[i]-damages[i-2]>2时）
             */
            if (dp[i - 1][1] != -1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1]);

                if (damages.get(i) - damages.get(i - 2) > 2) {
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][1] + (long) damages.get(i) * countMap.get(damages.get(i)));
                }
            }
            /**
             * 如果不选择damages[i-2]，选择damages[i-1]，则可能出现：
             * 1、选择damages[i-1]，不选择damages[i]
             * 2、选择damages[i-1]和damages[i]（damages[i]-damages[i-1]>2时）
             */
            if (dp[i - 1][2] != -1) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][2]);

                if (damages.get(i) - damages.get(i - 1) > 2) {
                    dp[i][3] = Math.max(dp[i][3], dp[i - 1][2] + (long) damages.get(i) * countMap.get(damages.get(i)));
                }
            }
            /**
             * 如果选择damages[i-2]和damages[i-1]，则可能出现：
             * 1、选择damages[i-1]，不选择damages[i]
             * 2、选择damages[i-1]和damages[i]（damages[i]-damages[i-2]>2时）
             */
            if (dp[i - 1][3] != -1) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][3]);

                if (damages.get(i) - damages.get(i - 1) > 2) {
                    dp[i][3] = Math.max(dp[i][3], dp[i - 1][3] + (long) damages.get(i) * countMap.get(damages.get(i)));
                }
            }
        }

        for (long value : dp[damages.size() - 1]) {
            result = Math.max(result, value);
        }
        return result;
    }
}
