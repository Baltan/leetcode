package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1354. Construct Target Array With Multiple Sums
 *
 * @author Baltan
 * @date 2020-04-04 11:04
 */
public class IsPossible1 {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{9, 3, 5}));
        System.out.println(isPossible(new int[]{1, 1, 1, 2}));
        System.out.println(isPossible(new int[]{8, 5}));
        System.out.println(isPossible(new int[]{9, 9, 9}));
        System.out.println(isPossible(new int[]{1, 1000000000}));
        System.out.println(isPossible(new int[]{2}));
    }

    public static boolean isPossible(int[] target) {
        /**
         * 如果target中只有一个值，则只有这个值为1时，才能由[1]构造出target
         */
        if (target.length == 1) {
            return target[0] == 1;
        }
        /**
         * 降序保存target中的所有元素
         */
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        /**
         * queue中所有元素的和
         */
        int currentSum = 0;

        for (int value : target) {
            currentSum += value;
            queue.offer(value);
        }

        while (queue.peek() > 1) {
            /**
             * 当前queue中的最大值，也就是queue之前状态下所有元素的和
             */
            int max = queue.poll();
            /**
             * 当前queue中出最大值以外的所有元素的和
             */
            int restSum = currentSum - max;
            /**
             * 当前queue中的次大值
             */
            int secondMax = queue.peek();
            /**
             * 将queue中的最大值出队，并且加入max-restSum后，可以得到queue的之前状态下的所有元
             * 素，但是如果max-restSum加入queue中后仍旧是queue中的最大值，就会继续进行之前的操
             * 作，直到max-restSum不再是queue中的最大值为止，即max-restSum小于queue中当前的
             * 次大值secondMax，这一过程可以进行times次
             */
            int times = (int) Math.ceil(1.0 * (max - secondMax) / restSum);
            /**
             * times次操作后，加入queue的元素为oldValue
             */
            int oldValue = max - restSum * times;
            /**
             * 如果oldValue和max的值一样，即操作没有改变queue中的元素，例如：[9,9,9]，此时说明
             * target不能由[1,1,……,1]构造得到。当oldValue小于1时，target也不能由[1,1,……,1]构
             * 造得到，因为任何状态下，queue中的元素都不可能小于1
             */
            if (oldValue == max || oldValue < 1) {
                return false;
            }
            queue.offer(oldValue);
            /**
             * queue中之前状态下的所有元素的和
             */
            currentSum = restSum + oldValue;
        }
        /**
         * 当当前queue中所有元素的和与target的length相同时，说明此时queue为[1,1,……,1]
         */
        return currentSum == target.length;
    }
}
