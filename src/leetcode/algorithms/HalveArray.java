package leetcode.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2208. Minimum Operations to Halve Array Sum
 *
 * @author Baltan
 * @date 2022/3/24 22:19
 */
public class HalveArray {
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{5, 19, 8, 1}));
        System.out.println(halveArray(new int[]{3, 8, 20}));
    }

    public static int halveArray(int[] nums) {
        int result = 0;
        /**
         * 数组nums中所有数字之和
         */
        double sum = 0d;
        /**
         * 已减去的数字之和
         */
        double reduceSum = 0;
        /**
         * 倒序排列剩余的所有数字
         */
        Queue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            sum += num;
            maxHeap.offer((double) num);
        }
        /**
         * 至少需要减去的数字之和
         */
        double halfSum = sum / 2;
        /**
         * 总是从剩余的所有数字中取出最大的数字减去它的一半，知道减去的数字之和不小于halfSum为止
         */
        while (reduceSum < halfSum) {
            double max = maxHeap.poll();
            double halfMax = max / 2;
            reduceSum += halfMax;
            maxHeap.offer(halfMax);
            result++;
        }
        return result;
    }
}
