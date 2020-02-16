package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
 *
 * @author Baltan
 * @date 2020-02-16 15:23
 */
public class FilterRestaurants {
    public static void main(String[] args) {
        int[][] restaurants1 =
                {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        System.out.println(filterRestaurants(restaurants1, 1, 50, 10));

        int[][] restaurants2 =
                {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        System.out.println(filterRestaurants(restaurants2, 0, 50, 10));

        int[][] restaurants3 =
                {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        System.out.println(filterRestaurants(restaurants3, 0, 30, 3));
    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
                                                  int maxDistance) {
        /**
         * 1、过滤出所有满足素食、价格和距离约束的餐厅
         * 2、将上述餐厅按照先rating降序后id降序的规则排序
         * 3、顺次取出排序后的餐厅的id
         */
        return Arrays.stream(restaurants)
                .filter(x -> x[2] >= veganFriendly && x[3] <= maxPrice && x[4] <= maxDistance)
                .sorted((x, y) -> x[1] == y[1] ? y[0] - x[0] : y[1] - x[1])
                .map(x -> x[0])
                .collect(Collectors.toList());
    }
}
