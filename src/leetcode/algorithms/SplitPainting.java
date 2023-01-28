package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1943. Describe the Painting
 *
 * @author Baltan
 * @date 2023/1/27 15:49
 */
public class SplitPainting {
    public static void main(String[] args) {
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));
        System.out.println(splitPainting(new int[][]{{1, 7, 9}, {6, 8, 15}, {8, 10, 7}}));
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}}));
        System.out.println(splitPainting(new int[][]{{4, 16, 12}, {9, 10, 15}, {18, 19, 13}, {3, 13, 20}, {12, 16, 3}, {2, 10, 10}, {3, 11, 4}, {13, 16, 6}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/describe-the-painting/solutions/895477/miao-shu-hui-hua-jie-guo-by-leetcode-sol-tnvy/"></a>
     *
     * @param segments
     * @return
     */
    public static List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        /**
         * 所有线段的中最大的坐标
         */
        int max = Arrays.stream(segments).max(Comparator.comparingInt(x -> x[1])).get()[1];
        /**
         * 合并线段数组的差分数组
         */
        long[] diffs = new long[max + 1];
        /**
         * 由差分数组逆推得到的合并线段数组
         */
        long[] prefixSums = new long[max + 2];
        /**
         * 保存所有线段的端点坐标，并且按照升序排列
         */
        TreeSet<Integer> splits = new TreeSet<>();

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];
            /**
             * 保存线段的端点坐标
             */
            splits.add(start);
            splits.add(end);
            /**
             * 假设[1,2)为第1个单位线段，[2,3)为第2个单位线段……[max,max+1)为最右侧的第max个单位线段。当前线段影响了合并线段中的第start、
             * start+1、……、end-1个单位线段，这些单位线段的颜色都为color
             */
            diffs[start] += color;
            diffs[end] -= color;
        }
        /**
         * 由差分数组逆推得到的合并线段数组，第i条单位线段的颜色为prefixSums[i+1]
         */
        for (int i = 0; i <= max; i++) {
            prefixSums[i + 1] = prefixSums[i] + diffs[i];
        }

        int lo = splits.pollFirst();
        /**
         * 逐一得到每一条被染色的线段[lo,hi)，它是由第lo、lo+1、……、hi-1条单位线段相连构成的，颜色为prefixSums[lo+1]
         */
        for (int hi : splits) {
            /**
             * 只有被涂色了才加入结果中
             */
            if (prefixSums[lo + 1] != 0L) {
                result.add(Arrays.asList(Long.valueOf(lo), Long.valueOf(hi), prefixSums[lo + 1]));
            }
            lo = hi;
        }
        return result;
    }
}
