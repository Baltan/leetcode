package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 2080. Range Frequency Queries
 *
 * @author Baltan
 * @date 2021/11/22 09:44
 */
public class RangeFreqQuery {
    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery1 =
                new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery1.query(1, 2, 4));
        System.out.println(rangeFreqQuery1.query(0, 11, 33));

        System.out.println("-------------------");

        RangeFreqQuery rangeFreqQuery2 =
                new RangeFreqQuery(new int[]{1, 1, 1, 2, 2});
        System.out.println(rangeFreqQuery2.query(0, 1, 2));
        System.out.println(rangeFreqQuery2.query(0, 2, 1));
        System.out.println(rangeFreqQuery2.query(3, 3, 2));
        System.out.println(rangeFreqQuery2.query(2, 2, 1));
    }

    /**
     * value -> value在arr中出现的索引位置列表
     */
    private Map<Integer, List<Integer>> indexMap;

    public RangeFreqQuery(int[] arr) {
        indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            indexMap.putIfAbsent(value, new ArrayList<>());
            indexMap.get(value).add(i);
        }
    }

    public int query(int left, int right, int value) {
        int leftmostIndex = queryLeftmostIndex(indexMap.get(value), left, right);
        /**
         * 数组arr的[left,right]子数组中不包括value
         */
        if (leftmostIndex == -1) {
            return 0;
        }

        int rightmostIndex = queryRightmostIndex(indexMap.get(value), left, right);
        /**
         * 数组arr的[left,right]子数组中不包括value
         */
        if (rightmostIndex == -1) {
            return -1;
        }
        return rightmostIndex - leftmostIndex + 1;
    }

    /**
     * 在indexList中二分查找大于等于left，小于等于right的最小值的索引位置
     *
     * @param indexList 索引位置列表
     * @param left
     * @param right
     * @return
     */
    private int queryLeftmostIndex(List<Integer> indexList, int left, int right) {
        if (indexList == null) {
            return -1;
        }

        if (indexList.get(indexList.size() - 1) < left) {
            return -1;
        }

        int lo = 0;
        int hi = indexList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (indexList.get(mid) < left) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return indexList.get(lo) <= right ? lo : -1;
    }

    /**
     * 在indexList中二分查找大于等于left，小于等于right的最大值的索引位置
     *
     * @param indexList 索引位置列表
     * @param left
     * @param right
     * @return
     */
    private int queryRightmostIndex(List<Integer> indexList, int left, int right) {
        if (indexList == null) {
            return -1;
        }

        if (indexList.get(0) > right) {
            return -1;
        }

        int lo = 0;
        int hi = indexList.size() - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (indexList.get(mid) > right) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return indexList.get(lo) >= left ? lo : -1;
    }
}
