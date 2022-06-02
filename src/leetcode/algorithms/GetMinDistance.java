package leetcode.algorithms;

/**
 * Description: 1848. Minimum Distance to the Target Element
 *
 * @author Baltan
 * @date 2022/6/1 17:00
 */
public class GetMinDistance {
    public static void main(String[] args) {
        System.out.println(getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
        System.out.println(getMinDistance(new int[]{1}, 1, 0));
        System.out.println(getMinDistance(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        /**
         * 以start为圆心，从0开始扩大逐渐扩大半径，查找是否有target
         */
        for (int radius = 0; ; radius++) {
            if (start - radius >= 0 && nums[start - radius] == target) {
                return radius;
            }

            if (start + radius < nums.length && nums[start + radius] == target) {
                return radius;
            }
        }
    }
}
