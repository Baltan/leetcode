package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2857. Count Pairs of Points With Distance k
 *
 * @author Baltan
 * @date 2023/9/18 22:17
 */
public class CountPairs5 {
    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(4, 2), Arrays.asList(1, 3), Arrays.asList(5, 2)), 5));
        System.out.println(countPairs(Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(1, 3), Arrays.asList(1, 3), Arrays.asList(1, 3), Arrays.asList(1, 3)), 0));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/count-pairs-of-points-with-distance-k/solutions/2445629/bao-li-zhu-yi-k-de-fan-wei-by-endlessche-3i1b/"></a>
     *
     * @param coordinates
     * @param k
     * @return
     */
    public static int countPairs(List<List<Integer>> coordinates, int k) {
        int result = 0;
        /**
         * x坐标 -> {y坐标 -> 坐标为(x,y)的点的个数}
         */
        Map<Integer, Map<Integer, Integer>> xMap = new HashMap<>();

        for (List<Integer> coordinate : coordinates) {
            int x1 = coordinate.get(0);
            int y1 = coordinate.get(1);
            /**
             * 因为(x1^x2)+(y1^y2)=k，假设(x1^x2)=m，则(y1^y2)=k-m，转换后得到x2=x1^m，y2=y1^(k-m)
             * 令m=i，则x2=x1^i，y2=y1^(k-i)
             */
            for (int i = 0; i <= k; i++) {
                int x2 = x1 ^ i;
                int y2 = y1 ^ (k - i);
                /**
                 * 在之前已遍历过的点中，查找坐标为(x2,y2)的点的个数
                 */
                result += xMap.getOrDefault(x2, Collections.emptyMap()).getOrDefault(y2, 0);
            }
            /**
             * 将坐标为(x1,y1)的点计数进xMap中
             */
            Map<Integer, Integer> yMap = xMap.computeIfAbsent(x1, i -> new HashMap<>());
            yMap.put(y1, yMap.getOrDefault(y1, 0) + 1);
        }
        return result;
    }
}
