package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 1817. Finding the Users Active Minutes
 *
 * @author Baltan
 * @date 2022/6/19 15:32
 */
public class FindingUsersActiveMinutes {
    public static void main(String[] args) {
        int[][] logs1 = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k1 = 5;
        OutputUtils.print1DIntegerArray(findingUsersActiveMinutes(logs1, k1));

        int[][] logs2 = {{1, 1}, {2, 2}, {2, 3}};
        int k2 = 4;
        OutputUtils.print1DIntegerArray(findingUsersActiveMinutes(logs2, k2));
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        /**
         * 用户id -> 用户的活跃分钟集合
         */
        Map<Integer, Set<Integer>> activeMinutesMap = new HashMap<>();
        /**
         * 计算每个用户的活跃分钟集合
         */
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            Set<Integer> activeMinutes = activeMinutesMap.computeIfAbsent(id, i -> new HashSet<>());
            activeMinutes.add(time);
        }

        for (Set<Integer> activeMinutes : activeMinutesMap.values()) {
            result[activeMinutes.size() - 1]++;
        }
        return result;
    }
}
