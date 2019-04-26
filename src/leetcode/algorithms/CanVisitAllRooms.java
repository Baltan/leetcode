package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: Keys and Rooms
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
        boolean[] book = new boolean[roomNum];
        Queue<Integer> queue = new LinkedList<>();
        int notVisitedRoomNum = roomNum - 1;

        book[0] = true;
        for (int value : rooms.get(0)) {
            queue.offer(value);
        }

        while (!queue.isEmpty()) {
            if (notVisitedRoomNum == 0) {
                return true;
            }

            int num = queue.poll();
            if (!book[num]) {
                book[num] = true;
                notVisitedRoomNum--;
                List<Integer> keys = rooms.get(num);
                for (int value : keys) {
                    queue.offer(value);
                }
            }
        }
        return notVisitedRoomNum == 0;
    }
}
