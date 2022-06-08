package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1846. Maximum Element After Decreasing and Rearranging
 *
 * @author Baltan
 * @date 2022/6/7 09:07
 */
public class MaximumElementAfterDecrementingAndRearranging {
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            /**
             * 为了使最终最后一个数尽可能大，在逐一比较过程中，如果后一个数比前一个数大超过1，就要减小后一个数，使之刚好比前一个
             * 数大1，否则就保持后一个数不变
             */
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
