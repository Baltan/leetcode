package leetcode.algorithms;

/**
 * Description: 2789. Largest Element in an Array after Merge Operations
 *
 * @author Baltan
 * @date 2023/7/29 14:14
 */
public class MaxArrayValue {
    public static void main(String[] args) {
        System.out.println(maxArrayValue(new int[]{40, 15, 35, 98, 77, 79, 24, 62, 53, 84, 97, 16, 30, 22, 49}));
        System.out.println(maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println(maxArrayValue(new int[]{5, 3, 3}));
    }

    public static long maxArrayValue(int[] nums) {
        long result = 0L;
        /**
         * 初始化sum为数组nums中的最后一个元素的值
         */
        long sum = nums[nums.length - 1];
        /**
         * 因为相邻的两个数只要不是降序的就可以合并相加，所以总是希望两个数中索引值较大的数字越大越好，于是倒序遍历nums，逐一判断元素是否可以
         * 合并相加到sum中，如果不行的话就将sum重置为当前遍历到的数字，重复之前的操作
         */
        for (int i = nums.length - 2; i >= 0; i--) {
            if (sum >= nums[i]) {
                /**
                 * 将nums[i]合并累加到sum中
                 */
                sum += nums[i];
            } else {
                result = Math.max(result, sum);
                /**
                 * 重置sum的值
                 */
                sum = nums[i];
            }
        }
        /**
         * 数组nums倒序遍历完后，最后若干个元素的和
         */
        result = Math.max(result, sum);
        return result;
    }
}
