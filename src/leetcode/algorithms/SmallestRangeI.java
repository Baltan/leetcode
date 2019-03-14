package leetcode.algorithms;

/**
 * Description: Smallest Range I
 *
 * @author Baltan
 * @date 2019-03-14 15:31
 */
public class SmallestRangeI {
    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{1}, 0));
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    public static int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : A) {
            min = min < num ? min : num;
            max = max > num ? max : num;
        }

        int difference = max - min;

        if (difference <= 2 * K) {
            return 0;
        } else {
            return difference - 2 * K;
        }
    }
}
