package leetcode.algorithms;

/**
 * Description: 2367. Number of Arithmetic Triplets
 *
 * @author Baltan
 * @date 2023/2/13 21:11
 */
public class ArithmeticTriplets {
    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println(arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        /**
         * 根据题意，nums[i]∈[0,200]
         */
        int max = 200;
        /**
         * 因为数组nums中元素严格递增，所以每个元素都不一样，isExisted[i]表示数组nums中是否存在元素i
         */
        boolean[] isExisted = new boolean[max + 1];

        for (int num : nums) {
            isExisted[num] = true;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            /**
             * 对于中间元素nums[i]判断其左边是否存在元素nums[i]-diff，右边是否存在元素nums[i]+diff，如果都存在则可以构成一个算数三元组
             */
            if (nums[i] - diff >= 0 && nums[i] + diff <= max && isExisted[nums[i] - diff] && isExisted[nums[i] + diff]) {
                result++;
            }
        }
        return result;
    }
}
