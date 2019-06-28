package leetcode.algorithms;

import java.util.*;

/**
 * Description: 373. Find K Pairs with Smallest Sums
 *
 * @author Baltan
 * @date 2019-06-28 11:16
 */
public class KSmallestPairs {
    public static void main(String[] args) {
        int[] nums11 = {1, 7, 11};
        int[] nums21 = {2, 4, 6};
        System.out.println(kSmallestPairs(nums11, nums21, 3));

        int[] nums12 = {1, 1, 2};
        int[] nums22 = {1, 2, 3};
        System.out.println(kSmallestPairs(nums12, nums22, 2));

        int[] nums13 = {1, 2};
        int[] nums23 = {3};
        System.out.println(kSmallestPairs(nums13, nums23, 3));

        int[] nums14 = {1, 1, 2};
        int[] nums24 = {1, 2, 3};
        System.out.println(kSmallestPairs(nums14, nums24, 10));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Integer[]> queue = new PriorityQueue<>((x, y) -> x[0] + x[1] - y[0] - y[1]);

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                queue.offer(new Integer[]{num1, num2});
            }
        }

        while (k > 0) {
            Integer[] pair = queue.poll();
            if (pair != null) {
                result.add(Arrays.asList(pair));
            } else {
                break;
            }
            k--;
        }
        return result;
    }
}
