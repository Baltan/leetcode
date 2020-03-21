package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 1376. Time Needed to Inform All Employees
 *
 * @author Baltan
 * @date 2020-03-21 10:55
 */
public class NumOfMinutes {
    public static void main(String[] args) {
        int n1 = 1;
        int headID1 = 0;
        int[] manager1 = {-1};
        int[] informTime1 = {0};
        System.out.println(numOfMinutes(n1, headID1, manager1, informTime1));

        int n2 = 6;
        int headID2 = 2;
        int[] manager2 = {2, 2, -1, 2, 2, 2};
        int[] informTime2 = {0, 0, 1, 0, 0, 0};
        System.out.println(numOfMinutes(n2, headID2, manager2, informTime2));

        int n3 = 7;
        int headID3 = 6;
        int[] manager3 = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime3 = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(numOfMinutes(n3, headID3, manager3, informTime3));

        int n4 = 15;
        int headID4 = 0;
        int[] manager4 = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] informTime4 = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(numOfMinutes(n4, headID4, manager4, informTime4));

        int n5 = 4;
        int headID5 = 2;
        int[] manager5 = {3, 3, -1, 2};
        int[] informTime5 = {0, 0, 162, 914};
        System.out.println(numOfMinutes(n5, headID5, manager5, informTime5));
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;
        /**
         * receiveTime[i]表示id为i的员工得到通知的时间
         */
        int[] receiveTime = new int[n];
        /**
         * subordinates[i]表示id为i的员工的所有直属下属的id列表
         */
        List<Integer>[] subordinates = new List[n];
        /**
         * 队列保存已经得到通知的员工的id
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(headID);

        for (int i = 0; i < n; i++) {
            subordinates[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            subordinates[manager[i]].add(i);
        }

        while (!queue.isEmpty()) {
            int ManageId = queue.poll();
            List<Integer> subordinateList = subordinates[ManageId];
            /**
             * id为ManageId的员工通知他的所有id为subordinateId的直属下属
             */
            for (int subordinateId : subordinateList) {
                queue.offer(subordinateId);
                /**
                 * 直属下属得到通知的时间
                 */
                receiveTime[subordinateId] = receiveTime[ManageId] + informTime[ManageId];
                result = Math.max(result, receiveTime[subordinateId]);
            }
        }
        return result;
    }
}
