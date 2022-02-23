package leetcode.interview;

/**
 * Description: 面试题 17.04. 消失的数字
 *
 * @author Baltan
 * @date 2022/2/23 11:13
 * @see leetcode.algorithms.MissingNumber
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 3};
        System.out.println(missingNumber(nums1));

        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums2));
    }

    public static int missingNumber(int[] nums) {
        /**
         * 缺了1个数，还剩nums.length个数，则正常情况下应该为[0,nums.length]共nums.length+1个数，
         * 计算这些数的和减去已有的数之和即可
         */
        int sum = (0 + nums.length) * (nums.length + 1) / 2;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
        }
        return sum - currSum;
    }
}
