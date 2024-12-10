package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 3376. Minimum Time to Break Locks I
 *
 * @author Baltan
 * @date 2024/12/8 14:40
 */
public class FindMinimumTime {
    public static void main(String[] args) {
        System.out.println(findMinimumTime(Arrays.asList(7, 3, 6, 18, 22, 50), 4));
        System.out.println(findMinimumTime(Arrays.asList(21, 45, 2), 8));
        System.out.println(findMinimumTime(Arrays.asList(3), 8));
        System.out.println(findMinimumTime(Arrays.asList(3, 4, 1), 1));
        System.out.println(findMinimumTime(Arrays.asList(2, 5, 4), 2));
    }

    private static int result;

    public static int findMinimumTime(List<Integer> strength, int K) {
        result = Integer.MAX_VALUE;
        /**
         * isVisited[i]表示锁strength[i]是否被破解
         */
        boolean[] isVisited = new boolean[strength.size()];
        /**
         * 递归枚举所有破解锁的顺序
         */
        backtrack(strength, 1, K, 0, isVisited, strength.size());
        return result;
    }

    /**
     * 递归计算破解所有锁的最少时间
     *
     * @param strength
     * @param X         能量增加因子
     * @param K         能量增加因子的增加因子
     * @param time      当前已用时间
     * @param isVisited 标记已破解的锁
     * @param leftCount 未破解锁的数量
     */
    public static void backtrack(List<Integer> strength, int X, int K, int time, boolean[] isVisited, int leftCount) {
        /**
         * 如果当前已经消耗的时间不小于之前已有的方案，则不需要再继续尝试
         */
        if (time >= result) {
            return;
        }
        /**
         * 剩余锁的数量为0，即所有锁都已破解，更新破解锁的最少时间
         */
        if (leftCount == 0) {
            result = time;
            return;
        }
        /**
         * 枚举接下去要破解的锁
         */
        for (int i = 0; i < strength.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                /**
                 * 破解锁strength[i]的用时为strength[i]/X的结果向上取整
                 */
                time += (strength.get(i) - 1) / X + 1;
                X += K;
                backtrack(strength, X, K, time, isVisited, leftCount - 1);
                /**
                 * 还原到破解锁strength[i]前的状态
                 */
                X -= K;
                time -= (strength.get(i) - 1) / X + 1;
                isVisited[i] = false;
            }
        }
    }
}
