package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2460. Apply Operations to an Array
 *
 * @author Baltan
 * @date 2023/2/8 09:27
 */
public class ApplyOperations {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(applyOperations(new int[]{1, 2, 2, 1, 1, 0}));
        OutputUtils.print1DIntegerArray(applyOperations(new int[]{0, 1}));
    }

    public static int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        int limit = nums.length - 1;
        int lo = 0;
        int hi = nums.length - 1;

        for (int i = 0; i < limit; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        /**
         * 将所有非0数字放在数组最前面，将所有的数字0放在数组最后面
         */
        for (int num : nums) {
            if (num != 0) {
                result[lo++] = num;
            } else {
                result[hi--] = num;
            }
        }
        return result;
    }
}
