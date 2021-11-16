package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2070. Most Beautiful Item for Each Query
 *
 * @author Baltan
 * @date 2021/11/16 16:03
 */
public class MaximumBeauty {
    public static void main(String[] args) {
        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        OutputUtils.print1DIntegerArray(maximumBeauty(items1, queries1));

        int[][] items2 = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[] queries2 = {1};
        OutputUtils.print1DIntegerArray(maximumBeauty(items2, queries2));

        int[][] items3 = {{10, 1000}};
        int[] queries3 = {5};
        OutputUtils.print1DIntegerArray(maximumBeauty(items3, queries3));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int length = queries.length;
        int[] result = new int[length];
        /**
         * 价格 -> 当前价格可以获得的最大美丽值
         */
        Map<Integer, Integer> beautyMap = new HashMap<>();
        /**
         * 当前已处理过的价格可以获得的最大美丽值
         */
        int currMaxBeauty = 0;
        /**
         * 将items中元素按照价格升序排列，如果价格相同则按照美丽值升序排列
         */
        Arrays.sort(items, (x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        /**
         * 查询每个价格可以获得的最大美丽值
         */
        for (int[] item : items) {
            currMaxBeauty = Math.max(currMaxBeauty, item[1]);
            beautyMap.put(item[0], currMaxBeauty);
        }
        /**
         * 将items中的所有价格按照升序排列
         */
        List<Integer> priceList = new ArrayList<>(beautyMap.keySet());
        Collections.sort(priceList);

        for (int i = 0; i < length; i++) {
            int price = queries[i];
            int maxPrice = binarySearch(priceList, price);
            result[i] = maxPrice == -1 ? 0 : beautyMap.get(maxPrice);
        }
        return result;
    }

    /**
     * 在priceList中查找不大于price的最大值，如果priceList中所有值都大于price，返回-1
     *
     * @param priceList
     * @param price
     * @return
     */
    public static int binarySearch(List<Integer> priceList, int price) {
        if (priceList.get(0) > price) {
            return -1;
        }

        int lo = 0;
        int hi = priceList.size() - 1;
        /**
         * 在priceList中二分查找小于等于price的最大值
         */
        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (priceList.get(mid) == price) {
                return price;
            } else if (priceList.get(mid) > price) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return priceList.get(lo);
    }
}
