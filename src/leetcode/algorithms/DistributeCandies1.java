package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1103. Distribute Candies to People
 *
 * @author Baltan
 * @date 2019-07-01 09:16
 */
public class DistributeCandies1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(distributeCandies(7, 4));
        OutputUtils.print1DIntegerArray(distributeCandies(10, 3));
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0;
        int candyNum = 1;

        while (candies > 0) {
            result[index] += Math.min(candies, candyNum);
            candies -= candyNum;
            candyNum++;
            index = (index + 1) % num_people;
        }
        return result;
    }
}
