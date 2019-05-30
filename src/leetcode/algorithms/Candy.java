package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 135. Candy
 *
 * @author Baltan
 * @date 2019-05-30 14:39
 */
public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1}));
        System.out.println(candy(new int[]{1, 1}));
        System.out.println(candy(new int[]{1, 2}));
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{1, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7, 5, 3, 2, 1}));
        System.out.println(
                candy(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 2, 3, 4, 5, 3, 2, 1, 2, 3, 4, 5, 3, 2, 4, 4, 3,
                        2}));
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int length = ratings.length;
        int result = length;
        int[] candies = new int[length];

        Arrays.fill(candies, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                result += (candies[i] - 1);
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i + 1] + 1 > candies[i]) {
                    result += (candies[i + 1] + 1 - candies[i]);
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }
        return result;
    }
}
