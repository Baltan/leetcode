package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2530. Maximal Score After Applying K Operations
 *
 * @author Baltan
 * @date 2023/1/8 13:46
 */
public class MaxKelements {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    public static long maxKelements(int[] nums, int k) {
        long result = 0L;
        /**
         * pq降序保存数组nums中的所有数字
         */
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        for (int num : nums) {
            pq.offer(num);
        }

        while (k-- > 0) {
            int max = pq.poll();
            result += max;
            pq.offer((int) Math.ceil(max / 3.0));
        }
        return result;
    }
}
