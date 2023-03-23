package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2449. Minimum Number of Operations to Make Arrays Similar
 *
 * @author Baltan
 * @date 2023/3/9 18:38
 */
public class MakeSimilar {
    public static void main(String[] args) {
        System.out.println(makeSimilar(new int[]{8, 12, 6}, new int[]{2, 14, 10}));
        System.out.println(makeSimilar(new int[]{1, 2, 5}, new int[]{4, 1, 3}));
        System.out.println(makeSimilar(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }

    public static long makeSimilar(int[] nums, int[] target) {
        /**
         * 数组nums和target一一配对后所有差值绝对值之和
         */
        long diff = 0L;
        /**
         * 数组nums中所有奇数，按照升序排列
         */
        Queue<Integer> oddNums = new PriorityQueue<>();
        /**
         * 数组nums中所有偶数，按照升序排列
         */
        Queue<Integer> evenNums = new PriorityQueue<>();
        /**
         * 数组target中所有奇数，按照升序排列
         */
        Queue<Integer> oddTarget = new PriorityQueue<>();
        /**
         * 数组target中所有偶数，按照升序排列
         */
        Queue<Integer> evenTarget = new PriorityQueue<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                evenNums.offer(num);
            } else {
                oddNums.offer(num);
            }
        }

        for (int num : target) {
            if (num % 2 == 0) {
                evenTarget.offer(num);
            } else {
                oddTarget.offer(num);
            }
        }
        /**
         * 将队列oddNums中最小的奇数变为队列oddTarget中最小的奇数，将队列oddNums中第二小的奇数变为队列oddTarget中第二小的奇数，……，将队列
         * oddNums中最大的奇数变为队列oddTarget中最大的奇数
         */
        while (!oddNums.isEmpty()) {
            diff += Math.abs(oddNums.poll() - oddTarget.poll());
        }
        /**
         * 将队列evenNums中最小的偶数变为队列evenTarget中最小的偶数，将队列evenNums中第二小的偶数变为队列evenTarget中第二小的偶数，……，
         * 将队列evenNums中最大的偶数变为队列evenTarget中最大的偶数
         */
        while (!evenNums.isEmpty()) {
            diff += Math.abs(evenNums.poll() - evenTarget.poll());
        }
        /**
         * 因为每次操作对一个数加2，另一个数减2，实质是将两个配对的四个数字的差值绝对值之和减4
         */
        return diff / 4;
    }
}
