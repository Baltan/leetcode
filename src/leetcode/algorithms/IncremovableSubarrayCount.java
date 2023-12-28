package leetcode.algorithms;

/**
 * Description: 2970. Count the Number of Incremovable Subarrays I
 *
 * @author baltan
 * @date 2023/12/27 09:12
 * @see IncremovableSubarrayCount1
 */
public class IncremovableSubarrayCount {
    public static void main(String[] args) {
        System.out.println(incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
        System.out.println(incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
        System.out.println(incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
    }

    public static int incremovableSubarrayCount(int[] nums) {
        /**
         * 因为空数组也是一个严格递增数组，所以数组nums本身完全移除后剩下一个严格递增数组
         */
        int result = 1;
        int length = nums.length;
        /**
         * 当前数字的前一个数字
         */
        int prev = -1;
        /**
         * 当前数字的后一个数字
         */
        int next = Integer.MAX_VALUE;
        /**
         * help[i][j]表示子数组[nums[i],nums[i+1],……,nums[j-1],nums[j]]是否为一个严格递增数组
         */
        boolean[][] help = new boolean[length][length];
        /**
         * 判断子数组[nums[0],……,nums[i]]是否是严格递增数组（不包括[nums[0],……,nums[length-1]]的情况）
         */
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] <= prev) {
                break;
            }
            result++;
            help[0][i] = true;
            prev = nums[i];
        }
        /**
         * 判断子数组[nums[i],……,nums[length-1]]是否是严格递增数组（不包括[nums[0],……,nums[length-1]]的情况）
         */
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] >= next) {
                break;
            }
            result++;
            help[i][length - 1] = true;
            next = nums[i];
        }
        /**
         * 判断子数组[nums[0],……,nums[i],nums[j],……,nums[length-1]]是否是严格递增数组
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j < length; j++) {
                if (help[0][i] && help[j][length - 1] && nums[j] > nums[i]) {
                    result++;
                }
            }
        }
        return result;
    }
}
