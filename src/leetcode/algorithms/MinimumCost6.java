package leetcode.algorithms;

/**
 * Description: 3010. Divide an Array Into Subarrays With Minimum Cost I
 *
 * @author Baltan
 * @date 2024/1/21 23:25
 */
public class MinimumCost6 {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 2, 3, 12}));
        System.out.println(minimumCost(new int[]{5, 4, 3}));
        System.out.println(minimumCost(new int[]{10, 3, 1, 1}));
    }

    public static int minimumCost(int[] nums) {
        /**
         * nums[0]一定是第一个子数组的代价
         */
        int result = nums[0];
        /**
         * 还需要累加两个子数组的代价
         */
        int remainingCount = 2;
        /**
         * counts[i]表示数组nums中元素i的个数（除nums[0]外）
         */
        int[] counts = new int[51];

        for (int i = 1; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        /**
         * 选择数组nums中除nums[0]外，最小的两个元素作为另外两个子数组的第一个元素即可
         */
        for (int i = 1; i < counts.length && remainingCount > 0; i++) {
            if (counts[i] > 0) {
                int availableCount = Math.min(remainingCount, counts[i]);
                result += availableCount * i;
                remainingCount -= availableCount;
            }
        }
        return result;
    }
}
