package leetcode.algorithms;

/**
 * Description: 3737. Count Subarrays With Majority Element I
 *
 * @author baltan
 * @date 2026/1/19 15:16
 */
public class CountMajoritySubarrays {
    public static void main(String[] args) {
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2));
        System.out.println(countMajoritySubarrays(new int[]{1, 1, 1, 1}, 1));
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 3}, 4));
    }

    public static int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 统计子数组nums[i……j]中元素target的个数
             */
            int count = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }

                if (count * 2 > j - i + 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
