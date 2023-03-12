package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2587. Rearrange Array to Maximize Prefix Score
 *
 * @author Baltan
 * @date 2023/3/12 13:22
 */
public class MaxScore3 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{2, -1, 0, 1, -3, 3, -3}));
        System.out.println(maxScore(new int[]{-2, -3, 0}));
    }

    public static int maxScore(int[] nums) {
        int result = 0;
        /**
         * 排序后数组nums的前缀和
         */
        long prefixSum = 0L;
        /**
         * 将数组nums中越大的元素放在越前面就能保证前缀和都尽可能地大。因为sort()方法不支持降序排列，所以将数组nums升序排列，从后往前遍历计算
         * 各个前缀和
         */
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum += nums[i];
            result += prefixSum > 0 ? 1 : 0;
        }
        return result;
    }
}
