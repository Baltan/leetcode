package leetcode.algorithms;

/**
 * Description: 3698. Split Array With Minimum Difference
 *
 * @author baltan
 * @date 2025/11/13 10:10
 */
public class SplitArray3 {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{5, 1, 9, 8}));
        System.out.println(splitArray(new int[]{1, 3, 2}));
        System.out.println(splitArray(new int[]{1, 2, 4, 3}));
        System.out.println(splitArray(new int[]{3, 1, 2}));
    }

    public static long splitArray(int[] nums) {
        long result = Long.MAX_VALUE;
        /**
         * 从右向左遍历数组nums时的前一个元素，初始化一个极小值作为哨兵
         */
        int rightPrev = Integer.MIN_VALUE;
        /**
         * 数组nums的前缀和数组
         */
        long[] prefixSums = new long[nums.length + 1];
        /**
         * isLeftEnd[i]表示元素nums[i]能否作为严格递增子数组left的最后一个元素
         */
        boolean[] isLeftEnd = new boolean[nums.length];
        /**
         * 元素nums[0]作为严格递增子数组left的唯一一个元素的情况
         */
        isLeftEnd[0] = true;
        prefixSums[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                break;
            }
            /**
             * 只有当前元素nums[i]严格大于左侧元素时，才能将当前元素nums[i]作为严格递增子数组left的最后一个元素
             */
            isLeftEnd[i] = true;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= rightPrev) {
                break;
            }
            /**
             * 只有当前元素nums[i]严格大于右侧元素时，才能将当前元素nums[i]作为严格递减子数组right的第一个元素。如果此时元素nums[i-1]可
             * 以作为递增子数组left的最后一个元素，则得到了一个有效分割，即子数组left为nums[0……i-1]，子数组right为nums[i……length-1]
             */
            if (isLeftEnd[i - 1]) {
                /**
                 * 子数组left的元素和为prefixSums[i]，子数组right的元素和为prefixSums[nums.length]-prefixSums[i]
                 */
                result = Math.min(result, Math.abs(prefixSums[i] - (prefixSums[nums.length] - prefixSums[i])));
            }
            rightPrev = nums[i];
        }
        return result == Long.MAX_VALUE ? -1 : result;
    }
}
