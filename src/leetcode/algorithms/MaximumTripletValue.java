package leetcode.algorithms;

/**
 * Description: 2873. Maximum Value of an Ordered Triplet I
 *
 * @author Baltan
 * @date 2023/10/5 22:52
 */
public class MaximumTripletValue {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(maximumTripletValue(new int[]{1, 2, 3}));
    }

    public static long maximumTripletValue(int[] nums) {
        long result = 0L;
        int length = nums.length;
        /**
         * 枚举所有可能的三元组
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int diff = nums[i] - nums[j];
                /**
                 * 如果nums[i]-nums[j]的值不为正数，因为nums[k]∈[1,1000000]，所以三元组的值可能不为正数，直接跳过
                 */
                if (diff <= 0) {
                    continue;
                }

                for (int k = j + 1; k < length; k++) {
                    result = Math.max(result, (long) diff * nums[k]);
                }
            }
        }
        return result;
    }
}
