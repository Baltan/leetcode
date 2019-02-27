package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3Sum Closest
 *
 * @author Baltan
 * @date 2018/8/29 10:45
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int closedSum = target;
        for (int i = 0; i < length - 2; i++) {
            int firstIndex = i + 1;
            int lastIndex = length - 1;
            while (firstIndex < lastIndex) {
                int sum = nums[i] + nums[firstIndex] + nums[lastIndex];
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closedSum = sum;
                }
                if (sum < target) {
                    firstIndex++;
                } else if (sum > target) {
                    lastIndex--;
                } else {
                    return closedSum;
                }
            }
        }
        return closedSum;
    }
}
