package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1306. Jump Game III
 *
 * @author Baltan
 * @date 2020-01-03 10:58
 */
public class CanReach {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(canReach(arr1, 5));

        int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(canReach(arr2, 0));

        int[] arr3 = {3, 0, 2, 1, 2};
        System.out.println(canReach(arr3, 2));

        int[] arr4 = {3, 0, 2, 1, 2};
        System.out.println(canReach(arr4, 1));
    }

    public static boolean canReach(int[] arr, int start) {
        int length = arr.length;
        /**
         * isVisited[i]标记索引为i的元素是否到达过
         */
        boolean[] isVisited = new boolean[length];
        /**
         * 将元素的索引入队
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            isVisited[index] = true;

            if (arr[index] == 0) {
                return true;
            }

            int leftIndex = index - arr[index];
            int rightIndex = index + arr[index];
            /**
             * 向左跳如果没有越界并且落点位置没有到达过，将向左跳的索引入队
             */
            if (leftIndex >= 0 && !isVisited[leftIndex]) {
                queue.offer(leftIndex);
            }
            /**
             * 向右跳如果没有越界并且落点位置没有到达过，将向右跳的索引入队
             */
            if (rightIndex < length && !isVisited[rightIndex]) {
                queue.offer(rightIndex);
            }
        }
        return false;
    }
}
