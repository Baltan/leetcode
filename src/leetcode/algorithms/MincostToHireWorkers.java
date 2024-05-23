package leetcode.algorithms;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 857. Minimum Cost to Hire K Workers
 *
 * @author Baltan
 * @date 2024/5/19 21:59
 */
public class MincostToHireWorkers {
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/description/"></a>
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int length = quality.length;
        /**
         * 所有工人的索引
         */
        Integer[] indexes = IntStream.range(0, length).boxed().toArray(Integer[]::new);
        /**
         * 大顶堆保存所有可选的工人中，最小的k个工作质量
         */
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        /**
         * 被选中的k个工人的工作质量之和
         */
        int totalQuality = 0;
        /**
         * 将所有工人的索引按照且期望工资和工作质量之比升序排列
         */
        Arrays.sort(indexes, Comparator.comparingDouble(x -> (double) wage[x] / quality[x]));
        /**
         * 假设被选中的k个工人中，期望工资和工作质量之比的最大值为r，则其余的k-1个工人如何也按照比例r发工资，一定不小于他们的期望工资。此时，
         * k个工人的总工资为r×totalQuality。先计算选择所有工人中期望工资和工作质量之比最小的k个人的情况
         */
        for (int i = 0; i < k; i++) {
            int index = indexes[i];
            pq.offer(quality[index]);
            totalQuality += quality[index];
        }
        double result = (double) wage[indexes[k - 1]] / quality[indexes[k - 1]] * totalQuality;
        /**
         * 按照期望工资和工作质量之比r逐渐增大的顺序选择工人，保持大顶堆pq中始终是所有按照期望工资和工作质量之比不大于r的工人中工作质量最小的
         * k个值
         */
        for (int i = k; i < length; i++) {
            int index = indexes[i];
            pq.offer(quality[index]);
            totalQuality += quality[index];
            /**
             * 将大顶堆pq中工作质量的最大值删除
             */
            totalQuality -= pq.poll();
            result = Math.min(result, (double) wage[index] / quality[index] * totalQuality);
        }
        return result;
    }
}
