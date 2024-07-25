package leetcode.algorithms;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 2751. Robot Collisions
 *
 * @author Baltan
 * @date 2024/7/21 17:00
 */
public class SurvivedRobotsHealths {
    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
        System.out.println(survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL"));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> result = new ArrayList<>();
        /**
         * 将所有机器人的编号按照初始时的所在位置升序排列
         */
        Integer[] indexes = IntStream.range(0, positions.length).boxed().sorted(Comparator.comparingInt(x -> positions[x])).toArray(Integer[]::new);
        /**
         * 保存所有在路线上向右移动的机器人的编号
         */
        Deque<Integer> rightwards = new ArrayDeque<>();

        for (int index : indexes) {
            if (directions.charAt(index) == 'R') {
                rightwards.offerFirst(index);
            } else {
                /**
                 * 对于当前向左移动的机器人，依次判断它和它左侧的向右移动的机器人发生碰撞的情况
                 */
                while (!rightwards.isEmpty()) {
                    /**
                     * 当前遇到的向右移动的机器人的编号
                     */
                    int rightwardsIndex = rightwards.peekFirst();

                    if (healths[rightwardsIndex] > healths[index]) {
                        /**
                         * 因为向右移动的机器人健康度较高，所以它的健康度被减1。同时向左移动的机器人从路线中移除，不需要继续判断更左侧的向
                         * 右移动的机器人的碰撞情况
                         */
                        healths[rightwardsIndex]--;
                        healths[index] = 0;
                        break;
                    } else if (healths[rightwardsIndex] < healths[index]) {
                        /**
                         * 因为向右移动的机器人健康度较低，所以它被从路线中移除。同时向左移动的机器人的健康度减1，继续判断它和更左侧的向右
                         * 移动的机器人的碰撞情况
                         */
                        healths[rightwardsIndex] = 0;
                        rightwards.pollFirst();
                        healths[index]--;
                    } else {
                        /**
                         * 因为两个机器人健康度相同，所以它们都被从路线中移除
                         */
                        healths[rightwardsIndex] = 0;
                        rightwards.pollFirst();
                        healths[index] = 0;
                        break;
                    }
                }
            }
        }
        /**
         * 根据健康度筛选出所有仍幸存的机器人
         */
        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }
        return result;
    }
}
