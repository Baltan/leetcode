package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2244. Minimum Rounds to Complete All Tasks
 *
 * @author Baltan
 * @date 2022/4/20 22:31
 */
public class MinimumRounds {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(minimumRounds(new int[]{2, 3, 3}));
    }

    public static int minimumRounds(int[] tasks) {
        int result = 0;
        /**
         * 难度i -> 难度i在数组tasks中出现过的次数
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        for (int count : countMap.values()) {
            /**
             * 如果某种难度只出现过1次，则不能完成该种难度的任务
             */
            if (count == 1) {
                return -1;
            }
            /**
             * 出现次数    2   3   4   5   6   7   8   9   10
             * 最少回合数  1   1   2   2   2   3   3   3   4
             *
             * 总结规律发现，最少回合数为难度出现次数/3后向上取整
             */
            result += Math.ceil(count / 3.0);
        }
        return result;
    }
}
