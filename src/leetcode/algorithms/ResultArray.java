package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3069. Distribute Elements Into Two Arrays I
 *
 * @author Baltan
 * @date 2024/3/6 21:53
 */
public class ResultArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(resultArray(new int[]{2, 1, 3}));
        OutputUtils.print1DIntegerArray(resultArray(new int[]{5, 4, 3, 8}));
    }

    public static int[] resultArray(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> arr1 = new ArrayDeque<>();
        Deque<Integer> arr2 = new ArrayDeque<>();
        arr1.offerLast(nums[0]);
        arr2.offerLast(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (arr1.peekLast() > arr2.peekLast()) {
                arr1.offerLast(nums[i]);
            } else {
                arr2.offerLast(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            /**
             * 现将队列arr1中的所有元素按顺序加入数组result中，再将arr2中的所有元素按顺序加入数组result中
             */
            result[i] = arr1.isEmpty() ? arr2.pollFirst() : arr1.pollFirst();
        }
        return result;
    }
}
