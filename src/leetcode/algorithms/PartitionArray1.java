package leetcode.algorithms;

/**
 * Description: 3659. Partition Array Into K-Distinct Groups
 *
 * @author baltan
 * @date 2025/9/23 17:20
 */
public class PartitionArray1 {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{1, 2, 3, 4}, 2));
        System.out.println(partitionArray(new int[]{3, 5, 2, 2}, 2));
        System.out.println(partitionArray(new int[]{1, 5, 2, 3}, 3));
    }

    public static boolean partitionArray(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        /**
         * 组数
         */
        int groups = nums.length / k;
        /**
         * counts[i]表示数组nums中元素i的个数，根据题意，nums[i]∈[1,100000]
         */
        int[] counts = new int[100001];

        for (int num : nums) {
            counts[num]++;
            /**
             * 根据抽屉原理，如果某个元素出现的次数超过组数，就返回false
             */
            if (counts[num] > groups) {
                return false;
            }
        }
        return true;
    }
}
