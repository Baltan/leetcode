package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 575. Distribute Candies
 *
 * @author Baltan
 * @date 2017/12/29 16:01
 */
public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
    }

    public static int distributeCandies(int[] candies) {
        Set<Integer> candySet = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            candySet.add(candies[i]);
        }
        return candySet.size() > candies.length / 2 ? candies.length / 2 : candySet.size();
    }
}
