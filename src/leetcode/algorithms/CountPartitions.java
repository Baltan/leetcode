package leetcode.algorithms;

/**
 * Description: 3432. Count Partitions with Even Sum Difference
 *
 * @author Baltan
 * @date 2025/2/2 13:48
 */
public class CountPartitions {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{10, 10, 3, 7, 6}));
        System.out.println(countPartitions(new int[]{1, 2, 2}));
        System.out.println(countPartitions(new int[]{2, 4, 6, 8}));
    }

    public static int countPartitions(int[] nums) {
        /**
         * 数组nums中所有元素之和
         */
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        /**
         * 当数组nums中所有元素之和为偶数时，左子数组元素之和与右子数组元素之和奇偶性一定相同，两个子数组之和的差也为偶数。此时，所有的分割都
         * 符合要求。反之当数组nums中所有元素之和为奇数时，所有的分割都不符合要求
         */
        return sum % 2 == 0 ? nums.length - 1 : 0;
    }
}
