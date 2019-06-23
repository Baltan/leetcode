package leetcode.algorithms;

/**
 * Description: 334. Increasing Triplet Subsequence
 *
 * @author Baltan
 * @date 2019-06-23 11:26
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(num1));

        int[] num2 = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(num2));

        int[] num3 = {1, 2, 2};
        System.out.println(increasingTriplet(num3));

        int[] num4 = {1, 1, -2, 6};
        System.out.println(increasingTriplet(num4));
    }

    public static boolean increasingTriplet(int[] nums) {
        int least = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= least) {
                least = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
