package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1282. Group the People Given the Group Size They Belong To
 *
 * @author Baltan
 * @date 2019-12-10 08:36
 */
public class GroupThePeople {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int length = groupSizes.length;
        /**
         * 将所在组人数相同的用户加入同一队列
         */
        for (int i = 0; i < length; i++) {
            int groupSize = groupSizes[i];
            map.putIfAbsent(groupSize, new LinkedList<>());
            map.get(groupSize).offer(i);
        }

        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            /**
             * 所在组人数
             */
            int groupSize = entry.getKey();
            Queue<Integer> queue = entry.getValue();

            while (!queue.isEmpty()) {
                List<Integer> group = new LinkedList<>();
                /**
                 * 每次从队列中出队groupSize人，放到同一组
                 */
                for (int i = 0; i < groupSize; i++) {
                    group.add(queue.poll());
                }
                result.add(group);
            }
        }
        return result;
    }
}
