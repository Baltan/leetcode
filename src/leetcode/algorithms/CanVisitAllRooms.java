package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 841. Keys and Rooms
 *
 * @author Baltan
 * @date 2019-04-26 15:06
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms1 =
                Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
        System.out.println(canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 =
                Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2),
                        Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms2));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomNum = rooms.size();
        /**
         * 标记房间i是否被访问过
         */
        boolean[] isVisited = new boolean[roomNum];
        /**
         * 保存当前已拿到的房间的钥匙
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 剩余还未被访问的房间的个数
         */
        int notVisitedRoomNum = roomNum;
        isVisited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            /**
             * 如果所有房间都已被访问了，直接返回true
             */
            if (notVisitedRoomNum == 0) {
                return true;
            }

            int num = queue.poll();
            notVisitedRoomNum--;
            List<Integer> keys = rooms.get(num);

            for (int value : keys) {
                /**
                 * 只有房间value未被访问过才保存该房间的钥匙，避免重复进入房间
                 */
                if (!isVisited[value]) {
                    queue.offer(value);
                    isVisited[value] = true;
                }
            }
        }
        return notVisitedRoomNum == 0;
    }
}
