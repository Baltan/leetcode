package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1431. Kids With the Greatest Number of Candies
 *
 * @author Baltan
 * @date 2020-06-01 09:07
 */
public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        List<Boolean> result = new ArrayList<>(length);
        /**
         * 数组candies中的最大值
         */
        int max = Integer.MIN_VALUE;

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int i = 0; i < length; i++) {
            /**
             * 如果candies+extraCandies>=max，则第i个孩子可以拥有最多的糖果
             */
            result.add(max - candies[i] <= extraCandies);
        }
        return result;
    }
}
