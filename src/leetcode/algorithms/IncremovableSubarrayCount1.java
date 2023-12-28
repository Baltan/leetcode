package leetcode.algorithms;

/**
 * Description: 2972. Count the Number of Incremovable Subarrays II
 *
 * @author baltan
 * @date 2023/12/27 11:43
 * @see IncremovableSubarrayCount
 */
public class IncremovableSubarrayCount1 {
    public static void main(String[] args) {
        System.out.println(incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
        System.out.println(incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
        System.out.println(incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
    }

    public static long incremovableSubarrayCount(int[] nums) {
        /**
         * 因为空数组也是一个严格递增数组，所以数组nums本身完全移除后剩下一个严格递增数组
         */
        long result = 1L;
        int length = nums.length;
        /**
         * 当前数字的前一个数字
         */
        int prev = -1;
        /**
         * 当前数字的后一个数字
         */
        int next = Integer.MAX_VALUE;
        int end = -1;
        int start = length;
        /**
         * 判断子数组[nums[0],……,nums[i]]是否是严格递增数组（不包括[nums[0],……,nums[length-1]]的情况）
         */
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] <= prev) {
                break;
            }
            end = i;
            prev = nums[i];
            result++;
        }
        /**
         * 判断子数组[nums[i],……,nums[length-1]]是否是严格递增数组（不包括[nums[0],……,nums[length-1]]的情况）
         */
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] >= next) {
                break;
            }
            start = i;
            next = nums[i];
            result++;
        }
        /**
         * 严格递增数组前半段最后一个元素的索引值
         */
        int index1 = 0;
        /**
         * 严格递增数组后半段第一个元素的索引值
         */
        int index2 = start;

        while (index1 <= end && index2 < length) {
            /**
             * 当前情况下的严格递增数组必须由两段不相交且不相连的子数组构成，所以index2-index1至少为2
             */
            if (index2 - index1 < 2) {
                index2++;
                continue;
            }

            if (nums[index1] < nums[index2]) {
                /**
                 * 可以得到严格递增数组：
                 * [nums[0],……,nums[index1],nums[index2],……,nums[length-1]]
                 * [nums[0],……,nums[index1],nums[index2+1],……,nums[length-1]]
                 * [nums[0],……,nums[index1],nums[index2+2],……,nums[length-1]]
                 * ……
                 * [nums[0],……,nums[index1],nums[length-1]]
                 */
                result += length - index2;
                index1++;
            } else {
                index2++;
            }
        }
        return result;
    }
}
