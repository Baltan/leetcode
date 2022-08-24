package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1705. Maximum Number of Eaten Apples
 *
 * @author Baltan
 * @date 2022/8/20 13:29
 */
public class EatenApples {
    public static void main(String[] args) {
        int[] apples1 = {1, 2, 3, 5, 2};
        int[] days1 = {3, 2, 1, 4, 2};
        System.out.println(eatenApples(apples1, days1));

        int[] apples2 = {3, 0, 0, 0, 0, 2};
        int[] days2 = {3, 0, 0, 0, 0, 2};
        System.out.println(eatenApples(apples2, days2));
    }

    public static int eatenApples(int[] apples, int[] days) {
        int result = 0;
        /**
         * 队列中保存元素为[苹果个数，苹果过期时间]，按照苹果过期时间升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int length = apples.length;

        for (int i = 0; i < length; i++) {
            /**
             * 如果当天会长出苹果，就加入队列中
             */
            if (apples[i] != 0) {
                pq.offer(new int[]{apples[i], i + days[i] - 1});
            }
            /**
             * 将队首那些过期的苹果都出队，不能食用
             */
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int[] apple = pq.poll();
                result++;
                /**
                 * 将剩下还未过期（可供后面的日子食用）的苹果重新入队
                 */
                if (apple[0] > 1 && apple[1] > i) {
                    apple[0]--;
                    pq.offer(apple);
                }
            }
        }

        int day = length;
        /**
         * 继续判断之后不长苹果了，是否还有苹果可以食用
         */
        while (!pq.isEmpty()) {
            /**
             * 将队首那些过期的苹果都出队，不能食用
             */
            if (pq.peek()[1] < day) {
                pq.poll();
            } else {
                int[] apple = pq.poll();
                /**
                 * 如果x个苹果最多还能放y天，因为每天最多只能吃一个苹果，那么最多吃Math.min(x,y)个
                 */
                int count = Math.min(apple[0], apple[1] - day + 1);
                result += count;
                day += count;
            }
        }
        return result;
    }
}
