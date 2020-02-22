package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description: 881. Boats to Save People
 *
 * @author Baltan
 * @date 2020-02-22 12:43
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        LinkedList<Integer> list = new LinkedList();
        /**
         * 将升序排列的体重数组逐一加入list
         */
        for (int weight : people) {
            list.add(weight);
        }

        while (!list.isEmpty()) {
            /**
             * 如果当前最大体重和最小体重和不大于limit，就将这两人安排在同一艘船上，否则当前最大
             * 体重只能独自安排在一艘船上
             */
            if (list.peekFirst() + list.peekLast() <= limit) {
                result++;
                list.pollFirst();
                list.pollLast();
            } else {
                result++;
                list.pollLast();
            }
        }
        return result;
    }
}
