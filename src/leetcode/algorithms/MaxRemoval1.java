package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3362. Zero Array Transformation III
 *
 * @author Baltan
 * @date 2024/11/24 20:27
 * @see IsZeroArray
 * @see MinZeroArray
 */
public class MaxRemoval1 {
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(maxRemoval(nums1, queries1));

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(maxRemoval(nums2, queries2));

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(maxRemoval(nums3, queries3));

        int[] nums4 = {0, 0, 3};
        int[][] queries4 = {{0, 2}, {1, 1}, {0, 0}, {0, 0}};
        System.out.println(maxRemoval(nums4, queries4));

        int[] nums5 = {0, 1, 3};
        int[][] queries5 = {{1, 2}, {0, 2}, {0, 1}, {0, 2}, {2, 2}, {0, 1}, {0, 1}};
        System.out.println(maxRemoval(nums5, queries5));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/zero-array-transformation-iii/solutions/2998650/tan-xin-zui-da-dui-chai-fen-shu-zu-pytho-35o6/"></a>
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int maxRemoval(int[] nums, int[][] queries) {
        /**
         * 被使用的查询的个数
         */
        int used = 0;
        int index = 0;
        /**
         * 此前已被使用的查询对数组nums中的每个元素最多可以减少的值所表示的数组的差分数组
         */
        int[] diffs = new int[nums.length + 1];
        /**
         * 此前已被使用的查询对数组nums中后续的元素最多可以减少的值
         */
        int total = 0;
        /**
         * 将已有查询按照查询的结束索引倒序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        /**
         * 将所有查询按照起始索引升序排列
         */
        Arrays.sort(queries, Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < nums.length; i++) {
            /**
             * 将所有能够减小nums[i]的查询（即当前剩余的查询中起始索引为i的所有查询）都加入到队列pq中
             */
            while (index < queries.length && queries[index][0] == i) {
                pq.offer(queries[index]);
                index++;
            }
            /**
             * 此前已被使用的查询可以使得nums[i]最多减少total+diffs[i]
             */
            nums[i] -= total + diffs[i];
            /**
             * 如果nums[i]仍旧大于0，则从当前剩余的查询中选择结束索引尽可能大的查询令nums[i]减1。选择结束索引尽可能大的查询是为了使得数组
             * nums中后续的元素也能尽快被减小，从而使得减少后续使用查询的数量
             */
            while (nums[i] > 0 && !pq.isEmpty()) {
                int[] query = pq.poll();
                int end = query[1];

                if (end >= i) {
                    nums[i]--;
                    /**
                     * 只需要考虑当前查询对nums[i……end]这部分元素减1的作用。事实上，如果更新的是diffs[query[0]]++，则之后对total更新
                     * 后，total会小于此前已被使用的查询令后续元素最多可以减少的值
                     */
                    diffs[i]++;
                    diffs[end + 1]--;
                    used++;
                }
            }
            /**
             * 所有可用查询都无法使得nums[i]减少为0，直接返回-1
             */
            if (nums[i] > 0) {
                return -1;
            }
            /**
             * 累计此前已被使用的查询令下一元素nums[i+1]最多可以减少的值
             */
            total += diffs[i];
        }
        return queries.length - used;
    }
}
