package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1921. Eliminate Maximum Number of Monsters
 *
 * @author Baltan
 * @date 2022/3/2 21:49
 */
public class EliminateMaximum {
    public static void main(String[] args) {
        int[] dist1 = {1, 3, 4};
        int[] speed1 = {1, 1, 1};
        System.out.println(eliminateMaximum(dist1, speed1));

        int[] dist2 = {1, 1, 2, 3};
        int[] speed2 = {1, 1, 1, 1};
        System.out.println(eliminateMaximum(dist2, speed2));

        int[] dist3 = {3, 2, 4};
        int[] speed3 = {5, 3, 2};
        System.out.println(eliminateMaximum(dist3, speed3));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int result = 0;
        int length = dist.length;
        /**
         * latest[i]表示第i个怪物到达城市的最迟时间，如果在这个时间前怪物不被清除，就会到达城市
         */
        int[] latest = new int[length];
        int currentTime = 0;

        for (int i = 0; i < length; i++) {
            latest[i] = (dist[i] - 1) / speed[i];
        }
        /**
         * 将怪物到达城市的时间按照升序排列
         */
        Arrays.sort(latest);

        for (int i = 0; i < length; i++) {
            /**
             * 如果时刻currentTime没有怪物到达城市，就将到达时间最近的那个怪物清除，否则游戏结束
             */
            if (latest[i] >= currentTime) {
                result++;
                currentTime++;
            } else {
                break;
            }
        }
        return result;
    }
}
