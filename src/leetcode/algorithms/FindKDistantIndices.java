package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 2200. Find All K-Distant Indices in an Array
 *
 * @author Baltan
 * @date 2022/3/15 18:11
 */
public class FindKDistantIndices {
    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
        System.out.println(findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 100));
        System.out.println(findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new LinkedList<>();
        /**
         * 已找到的索引最大的K近邻下标
         */
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                /**
                 * 新找到的K近邻下标的最小索引
                 */
                int start = Math.max(i - k, last + 1);
                /**
                 * 新找到的K近邻下标的最大索引
                 */
                int end = Math.min(nums.length - 1, i + k);
                last = end;

                for (int j = start; j <= end; j++) {
                    result.add(j);
                }
            }
        }
        return result;
    }
}
