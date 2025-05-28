package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3542. Minimum Operations to Convert All Elements to Zero
 *
 * @author baltan
 * @date 2025/5/26 10:56
 */
public class MinOperations29 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 2}));
        System.out.println(minOperations(new int[]{3, 1, 2, 1}));
        System.out.println(minOperations(new int[]{1, 2, 1, 2, 1, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/solutions/3673804/cong-fen-zhi-dao-dan-diao-zhan-jian-ji-x-mzbl/"></a>
     *
     * @param nums
     * @return
     */
    public static int minOperations(int[] nums) {
        int result = 0;
        /**
         * 单调栈保存数组nums中的元素，保持栈顶的元素始终大于其他元素，并且栈中每个元素都不相同
         */
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : nums) {
            /**
             * 如果栈顶的元素比num大，则说明栈顶元素在数组中左右两侧都有比它小的数，需要进行一次操作
             */
            while (!deque.isEmpty() && num < deque.peekFirst()) {
                deque.pollFirst();
                result++;
            }
            /**
             * 栈顶元素比num小，将num入栈
             */
            if (deque.isEmpty() || num > deque.peekFirst()) {
                deque.offerFirst(num);
            }
        }
        /**
         * 单调栈中剩余元素都需要进行操作，一共deque.size()次操作，但是如果栈底最小元素为0时，是不需要操作的，需要扣除这次操作
         */
        return result + deque.size() - (!deque.isEmpty() && deque.peekLast() == 0 ? 1 : 0);
    }
}
