package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3347. Maximum Frequency of an Element After Performing Operations II
 *
 * @author Baltan
 * @date 2024/11/10 15:19
 * @see MaxFrequency1
 */
public class MaxFrequency2 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 4, 5}, 1, 2));
        System.out.println(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1));
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {
            int j = i;
            /**
             * 数组nums中索引范围为[i,j)的元素都等于nums[i]
             */
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            /**
             * 假设操作完成后，最终数组nums中出现次数最多的数字为nums[i]，则范围[nums[left],nums[right]]内的数字都可以被变成nums[i]，
             * 需要操作的数字至多为right-left+1-(j-i)个，但是可被操作的数字不多于numOperations，还有j-i个数字本来就等于nums[i]，不需
             * 要被操作
             */
            int left = getLeft(nums, nums[i] - k);
            int right = getRight(nums, nums[i] + k);
            result = Math.max(result, Math.min(numOperations, right - left + 1 - (j - i)) + (j - i));
            /**
             * 假设操作完成后，最终数组nums中出现次数最多的数字为x，并且可以使得nums[i]变成x，则则范围[nums[i],nums[max]]内的数字都可
             * 以被变成nums[i]，需要操作的数字至多为max-i+1个，但是可被操作的数字不多于numOperations
             */
            int max = getRight(nums, nums[i] + 2 * k);
            result = Math.max(result, Math.min(numOperations, max - i + 1));
            i = j;
        }
        return result;
    }

    /**
     * 在递增数组nums中查找大于等于limit的第一个元素的索引
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int getLeft(int[] nums, int limit) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < limit) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在递增数组nums中查找小于等于limit的最后一个元素的索引
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int getRight(int[] nums, int limit) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (nums[mid] > limit) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
