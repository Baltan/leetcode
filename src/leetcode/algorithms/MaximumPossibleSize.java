package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3523. Make Array Non-decreasing
 *
 * @author Baltan
 * @date 2025/4/29 22:54
 */
public class MaximumPossibleSize {
    public static void main(String[] args) {
        System.out.println(maximumPossibleSize(new int[]{4, 2, 5, 3, 5}));
        System.out.println(maximumPossibleSize(new int[]{1, 2, 3}));
    }

    public static int maximumPossibleSize(int[] nums) {
        /**
         * 单调栈，保持栈底元素到栈顶元素非递减
         */
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (deque.isEmpty() || nums[i] <= deque.peekLast()) {
                deque.offer(nums[i]);
            } else {
                /**
                 * 将栈顶大于nums[i]的元素全部出栈
                 */
                while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }
        }
        return deque.size();
    }
}
