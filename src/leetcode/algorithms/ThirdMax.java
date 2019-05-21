package leetcode.algorithms;

/**
 * Description: 414. Third Maximum Number
 * @author Baltan
 *
 * @date 2017/11/15 17:09
 */
public class ThirdMax {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 2, 3, 1};
        int[] nums4 = {1, 2, -2147483648};
        System.out.println(thirdMax(nums1));
        System.out.println(thirdMax(nums2));
        System.out.println(thirdMax(nums3));
        System.out.println(thirdMax(nums4));
    }

    public static int thirdMax(int[] nums) {
        long thirdMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] < max) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Long.MIN_VALUE || secondMax == Long.MIN_VALUE) {
            return (int) max;
        } else {
            return (int) thirdMax;
        }
    }
}