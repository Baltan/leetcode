package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 457. Circular Array Loop
 *
 * @author Baltan
 * @date 2020-01-11 17:10
 */
public class CircularArrayLoop {
    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-1, 2}));
        System.out.println(circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(circularArrayLoop(new int[]{-1, -1, -1}));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        /**
         * isVisited[i]标记数组nums中索引为i的值是否被经过
         */
        boolean[] isVisited = new boolean[length];

        outer:
        for (int i = 0; i < length; i++) {
            /**
             * 如果数组nums中索引为i的值已经被经过过，就不再考虑
             */
            if (isVisited[i]) {
                continue;
            }
            /**
             * 假设nums[i]为起点，set保存运动经过的所有数字的索引
             */
            Set<Integer> set = new HashSet<>();
            int index = i;
            /**
             * directions保存这次运动的所有方向，向后运动时为true，向前运动时为false
             */
            Set<Boolean> directions = new HashSet<>();
            /**
             * 当set中出现了重复的索引，即出现了环形数组循环后，退出当前循环
             */
            while (!set.contains(index)) {
                set.add(index);
                /**
                 * 数组nums中索引为i的值已经被经过过
                 */
                isVisited[index] = true;
                /**
                 * 当nums[index]为正数时，向后运动directions中加入true，否则向前运动，加入false
                 */
                if (nums[index] > 0) {
                    directions.add(true);
                } else {
                    directions.add(false);
                }
                /**
                 * 如果directions中出现了两种运动方向，这次运动不会出现满足要求的环形数组循环，考虑
                 * 新的起点和新的运动路径
                 */
                if (directions.size() > 1) {
                    continue outer;
                }
                /**
                 * 下一步要到达的索引位置
                 */
                index = (index + nums[index] % length + length) % length;
            }

            set.clear();
            /**
             * 数组nums中索引为index的数被包含在一个环形数组循环中，但是上面的运动路径可能是一个"6"字
             * 形，而需要找到一个"o"字形的路径，所以从索引为index的数开始重新走一圈
             */
            while (!set.contains(index)) {
                set.add(index);
                index = (index + nums[index] % length + length) % length;
            }
            /**
             * 当找到的环形数组循环长度大于1时，才是符合要求的
             */
            if (set.size() > 1) {
                return true;
            }
        }
        return false;
    }
}
