package leetcode.algorithms;

/**
 * Description: 3583. Count Special Triplets
 *
 * @author baltan
 * @date 2025/7/7 10:15
 */
public class SpecialTriplets {
    public static void main(String[] args) {
        System.out.println(specialTriplets(new int[]{6, 3, 6}));
        System.out.println(specialTriplets(new int[]{0, 1, 0, 0}));
        System.out.println(specialTriplets(new int[]{8, 4, 2, 8, 4}));
    }

    public static int specialTriplets(int[] nums) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * left[i]表示nums[i]左侧元素nums[i]*2的个数
         */
        int[] left = new int[nums.length];
        /**
         * counts[i]表示正序遍历过程中元素counts[i]的个数，根据题意，i∈[0,100000]，当需要获取i*2的个数时，i*2的范围为[0,200000]
         */
        int[] counts = new int[200001];
        /**
         * 统计每个元素nums[i]的左侧元素nums[i]*2的个数
         */
        for (int i = 0; i < nums.length; i++) {
            left[i] = counts[nums[i] << 1];
            counts[nums[i]]++;
        }
        /**
         * counts[i]表示倒序遍历过程中元素counts[i]的个数，根据题意，i∈[0,100000]，当需要获取i*2的个数时，i*2的范围为[0,200000]
         */
        counts = new int[200001];

        for (int i = nums.length - 1; i >= 0; i--) {
            /**
             * 对于元素nums[i]其左侧元素nums[i]*2的个数为left[i]，右侧元素nums[i]*2的个数为counts[nums[i]*2]，则共可以构成
             * left[i]*counts[nums[i]*2]个特殊三元组
             */
            result = (result + (long) left[i] * counts[nums[i] << 1]) % mod;
            counts[nums[i]]++;
        }
        return (int) result;
    }
}
