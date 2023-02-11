package leetcode.algorithms;

/**
 * Description: 2475. Number of Unequal Triplets in Array
 *
 * @author Baltan
 * @date 2023/2/7 09:53
 */
public class UnequalTriplets {
    public static void main(String[] args) {
        System.out.println(unequalTriplets(new int[]{1000, 999, 998}));
        System.out.println(unequalTriplets(new int[]{1, 3, 1, 2, 4}));
        System.out.println(unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println(unequalTriplets(new int[]{1, 1, 1, 1, 1}));
    }

    public static int unequalTriplets(int[] nums) {
        int result = 0;
        /**
         * 数组nums中不同数字的个数
         */
        int count = 0;
        /**
         * counts[i]表示数组nums中数字i的个数，根据题意，i∈[1,1000]，
         */
        int[] counts = new int[1001];
        /**
         * 三元组三个数升序排列后最小数的情况数
         */
        int prevCount = 0;
        int length = nums.length;

        for (int num : nums) {
            counts[num]++;
        }
        /**
         * 假设三元组三个数升序排列后中间的数字为i，遍历i的情况
         */
        for (int i = 1; i <= 1000; i++) {
            if (counts[i] > 0) {
                count++;
                /**
                 * 三元组三个数升序排列后，最小数的情况数为prevCount，中间数的情况数为counts[i]，数组nums中剩下的数字都能作为最大数
                 */
                result += prevCount * counts[i] * (length - prevCount - counts[i]);
                prevCount += counts[i];
            }
        }
        /**
         * 只有数组nums中至少存在3种不同的数字才可能存在满足题意的三元数组
         */
        return count < 3 ? 0 : result;
    }
}
