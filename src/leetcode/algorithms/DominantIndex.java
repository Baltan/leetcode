package leetcode.algorithms;

/**
 * Description: 747. Largest Number At Least Twice of Others
 *
 * @author Baltan
 * @date 2017/12/31 13:46
 */
public class DominantIndex {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(dominantIndex(new int[]{0, 0, 0, 0}));
        System.out.println(dominantIndex(new int[]{0, 0, 0, 1}));
        System.out.println(dominantIndex(new int[]{-1, 1, 3, 9}));
        System.out.println(dominantIndex(new int[]{1}));
        System.out.println(dominantIndex(new int[]{1, 2}));
        System.out.println(dominantIndex(new int[]{}));
        System.out.println(dominantIndex(new int[]{1, 0}));
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                return -1;
            } else if (nums.length == 1) {
                return 0;
            } else {
                if (nums[i] > max) {
                    secondMax = max;
                    max = nums[i];
                    maxIndex = i;
                } else if (nums[i] < max && nums[i] > secondMax) {
                    secondMax = nums[i];
                }
            }
        }
        if (secondMax == 0 && max > 0) {
            return maxIndex;
        } else if (secondMax > 0 && max / secondMax >= 2) {
            return maxIndex;
        }
        return -1;
    }
}
