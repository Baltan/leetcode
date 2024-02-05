package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3025. Find the Number of Ways to Place People I
 *
 * @author Baltan
 * @date 2024/2/4 21:53
 */
public class NumberOfPairs1 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[][]{{3, 5}, {3, 4}, {0, 5}}));
        System.out.println(numberOfPairs(new int[][]{{1, 6}, {0, 9}, {0, 3}}));
        System.out.println(numberOfPairs(new int[][]{{0, 5}, {6, 1}, {4, 5}}));
        System.out.println(numberOfPairs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(numberOfPairs(new int[][]{{6, 2}, {4, 4}, {2, 6}}));
        System.out.println(numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}));
    }

    public static int numberOfPairs(int[][] points) {
        int result = 0;
        /**
         * y坐标i -> y坐标等于i的所有点的x坐标集合，所有键值对按照y坐标降序排列
         */
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            map.computeIfAbsent(y, i -> new ArrayList<>()).add(x);
        }
        /**
         * 将y坐标相等的所有点的x坐标升序排列
         */
        map.values().forEach(Collections::sort);
        /**
         * 按照y坐标降序，x坐标升序的顺序（即从左上向右下）遍历所有点
         */
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> xList = entry.getValue();
            int rightmostX;
            /**
             * 当前Chisato所在位置为(xList[i],entry.getKey())
             */
            for (int i = 0; i < xList.size(); i++) {
                if (i + 1 == xList.size()) {
                    rightmostX = Integer.MAX_VALUE;
                } else {
                    /**
                     * 在(xList[i],entry.getKey())的右侧还有其他点，Takina可以安排在Chisato正右方的这个点上
                     */
                    result++;
                    /**
                     * Takina安排在y坐标小于entry.getKey()的点上时，x坐标不能大于rightmostX
                     */
                    rightmostX = xList.get(i + 1) - 1;
                }
                /**
                 * 判断能否将Takina安排在y坐标为y的水平线上
                 */
                int y = entry.getKey() - 1;

                while (map.ceilingEntry(y) != null) {
                    /**
                     * y坐标小于等于y的所有点中，y坐标值最大的点集
                     */
                    Map.Entry<Integer, List<Integer>> ceilingEntry = map.ceilingEntry(y);
                    /**
                     * ceilingEntry水平线上的所有点的x坐标集合
                     */
                    List<Integer> level = ceilingEntry.getValue();
                    /**
                     * 在x坐标集合level中二分查找大于等于x的最小值的索引，如果不存在则返回-1
                     */
                    int index = binarySearch(level, xList.get(i));

                    if (index != -1 && level.get(index) <= rightmostX) {
                        result++;
                        /**
                         * Takina安排在y坐标小于ceilingEntry.getKey()的点上时，x坐标不能大于rightmostX
                         */
                        rightmostX = level.get(index) - 1;
                    }
                    /**
                     * 继续在y坐标更小的点集中查找能安排Takina的点
                     */
                    y = ceilingEntry.getKey() - 1;
                }
            }
        }
        return result;
    }

    /**
     * 在有序数组xList中二分查找大于等于x的最小值的索引，如果不存在则返回-1
     *
     * @param xList
     * @param x
     * @return
     */
    public static int binarySearch(List<Integer> xList, int x) {
        if (x > xList.get(xList.size() - 1)) {
            return -1;
        }
        int lo = 0;
        int hi = xList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (xList.get(mid) < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
