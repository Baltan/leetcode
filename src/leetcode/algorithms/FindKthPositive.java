package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 1539. Kth Missing Positive Number
 *
 * @author Baltan
 * @date 2022/10/27 16:57
 * @see FindKthPositive1
 */
public class FindKthPositive {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        int target = 1;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        /**
         * 从1开始依次判断每个正整数在数组arr中是否存在
         */
        while (true) {
            if (!set.contains(target)) {
                k--;
            }
            /**
             * 第k个缺失的正整数已找到
             */
            if (k == 0) {
                return target;
            }
            target++;
        }
    }
}
