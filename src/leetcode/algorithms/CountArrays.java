package leetcode.algorithms;

/**
 * Description: 3468. Find the Number of Copy Arrays
 *
 * @author Baltan
 * @date 2025/3/3 22:36
 */
public class CountArrays {
    public static void main(String[] args) {
        int[] original1 = {1, 2, 3, 4};
        int[][] bounds1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(countArrays(original1, bounds1));

        int[] original2 = {1, 2, 3, 4};
        int[][] bounds2 = {{1, 10}, {2, 9}, {3, 8}, {4, 7}};
        System.out.println(countArrays(original2, bounds2));

        int[] original3 = {1, 2, 1, 2};
        int[][] bounds3 = {{1, 1}, {2, 3}, {3, 3}, {2, 3}};
        System.out.println(countArrays(original3, bounds3));
    }

    public static int countArrays(int[] original, int[][] bounds) {
        int lowerLimit = Integer.MIN_VALUE;
        int upperLimit = Integer.MAX_VALUE;
        /**
         * 因为对于i∈[1,n-1]，copy[i]-copy[i-1]==original[i]-original[i-1]，也就是对每一个i∈[1,n-1]，original[i]-copy[i]都相
         * 等。又因为对于每一个i∈[0,n-1]，copy[i]∈[bounds[i][0],bounds[i][1]]，计算i∈[1,n-1]时，所有区间
         * [original[i]-bounds[i][1],original[i]-bounds[i][0]]的交集即可
         */
        for (int i = 1; i < original.length; i++) {
            lowerLimit = Math.max(lowerLimit, bounds[i][0] - original[i]);
            upperLimit = Math.min(upperLimit, bounds[i][1] - original[i]);
        }
        return Math.max(0, upperLimit - lowerLimit + 1);
    }
}
