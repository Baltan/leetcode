package leetcode.algorithms;

/**
 * Description: 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 *
 * @author Baltan
 * @date 2024/1/7 15:21
 */
public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(missingInteger(new int[]{1, 2, 3, 2, 5}));
        System.out.println(missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13}));
    }

    public static int missingInteger(int[] nums) {
        /**
         * 根据题意nums[i]∈[1,50]
         */
        int max = 50;
        /**
         * 数组nums的有序前缀的和
         */
        int prefixSum = nums[0];
        /**
         * isExisted[i]表示数组nums中是否存在元素i
         */
        boolean[] isExisted = new boolean[max + 1];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                break;
            }
            prefixSum += nums[i];
        }

        for (int num : nums) {
            isExisted[num] = true;
        }

        if (prefixSum <= max) {
            /**
             * 在[prefixSum,50]中从小到大判断是否有元素不在数组nums中，找到直接返回
             */
            for (int i = prefixSum; i <= max; i++) {
                if (!isExisted[i]) {
                    return i;
                }
            }
        }
        /**
         * 最小的缺失整数不仅大于max，而且大于等于prefixSum
         */
        return Math.max(prefixSum, max + 1);
    }
}
