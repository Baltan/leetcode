package leetcode.algorithms;

import java.util.*;

/**
 * Description: 373. Find K Pairs with Smallest Sums
 *
 * @author Baltan
 * @date 2019-06-28 11:16
 */
public class KSmallestPairs1 {
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

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        /**
         * queue中保存数组[value1,value2,index1,index2]
         */
        Queue<Integer[]> queue = new PriorityQueue<>((x, y) -> x[0] + x[1] - y[0] - y[1]);
        int length1 = nums1.length;
        int length2 = nums2.length;
        boolean[][] book = new boolean[length1][length2];

        queue.offer(new Integer[]{nums1[0], nums2[0], 0, 0});
        book[0][0] = true;

        while (!queue.isEmpty() && result.size() < k) {
            Integer[] pair = queue.poll();
            result.add(Arrays.asList(pair[0], pair[1]));

            if (pair[2] + 1 < length1 && !book[pair[2] + 1][pair[3]]) {
                queue.offer(new Integer[]{nums1[pair[2] + 1], nums2[pair[3]], pair[2] + 1, pair[3]});
                book[pair[2] + 1][pair[3]] = true;
            }

            if (pair[3] + 1 < length2 && !book[pair[2]][pair[3] + 1]) {
                queue.offer(new Integer[]{nums1[pair[2]], nums2[pair[3] + 1], pair[2], pair[3] + 1});
                book[pair[2]][pair[3] + 1] = true;
            }
        }
        return result;
    }
}
