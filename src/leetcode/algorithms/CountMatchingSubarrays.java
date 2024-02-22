package leetcode.algorithms;

/**
 * Description: 3034. Number of Subarrays That Match a Pattern I
 *
 * @author baltan
 * @date 2024/2/19 09:37
 * @see CountMatchingSubarrays1
 */
public class CountMatchingSubarrays {
    public static void main(String[] args) {
        System.out.println(countMatchingSubarrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1}));
        System.out.println(countMatchingSubarrays(new int[]{1, 4, 4, 1, 3, 5, 5, 3}, new int[]{1, 0, -1}));
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int result = 0;
        /**
         * 依次判断数组nums中每一个长度为pattern.length+1的子数组是否匹配模式pattern
         */
        outer:
        for (int i = nums.length - pattern.length - 1; i >= 0; i--) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == -1 && nums[i + j + 1] >= nums[i + j]) {
                    continue outer;
                }

                if (pattern[j] == 0 && nums[i + j + 1] != nums[i + j]) {
                    continue outer;
                }

                if (pattern[j] == 1 && nums[i + j + 1] <= nums[i + j]) {
                    continue outer;
                }
            }
            result++;
        }
        return result;
    }
}
