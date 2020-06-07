package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 870. Advantage Shuffle
 *
 * @author Baltan
 * @date 2020-06-07 13:06
 */
public class AdvantageCount {
    public static void main(String[] args) {
        int[] A1 = {2, 7, 11, 15};
        int[] B1 = {1, 10, 4, 11};
        OutputUtils.print1DIntegerArray(advantageCount(A1, B1));

        int[] A2 = {12, 24, 8, 32};
        int[] B2 = {13, 25, 32, 11};
        OutputUtils.print1DIntegerArray(advantageCount(A2, B2));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        int[] result = new int[length];
        /**
         * 数组B中某个值i -> 洗牌后数组A中和i对应的值的集合
         */
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Arrays.sort(A);
        int[] copyB = B.clone();
        Arrays.sort(copyB);
        /**
         * 保存数组A升序排列后的所有值
         */
        Deque<Integer> dequeA = new ArrayDeque<>(length);
        /**
         * 保存数组B升序排列后的所有值
         */
        Deque<Integer> dequeB = new ArrayDeque<>(length);

        for (int value : A) {
            dequeA.offerLast(value);
        }

        for (int value : copyB) {
            dequeB.offerLast(value);
        }

        while (!dequeA.isEmpty()) {
            /**
             * 如果当前数组A中剩余的最小值大于数组B中剩余的最小值，这两个数可以在洗牌后配对；否则数组A中剩余
             * 的最小值就和数组B中剩余的最大值再洗牌后配对（田忌赛马）
             */
            if (dequeA.peekFirst() > dequeB.peekFirst()) {
                int a = dequeA.pollFirst();
                int b = dequeB.pollFirst();
                map.putIfAbsent(b, new LinkedList<>());
                map.get(b).offer(a);
            } else {
                int a = dequeA.pollFirst();
                int b = dequeB.pollLast();
                map.putIfAbsent(b, new LinkedList<>());
                map.get(b).offer(a);
            }
        }
        /**
         * 得到将洗牌后的数组A
         */
        for (int i = 0; i < length; i++) {
            result[i] = map.get(B[i]).poll();
        }
        return result;
    }
}
