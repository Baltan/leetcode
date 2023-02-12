package leetcode.algorithms;

/**
 * Description: 2562. Find the Array Concatenation Value
 *
 * @author Baltan
 * @date 2023/2/12 13:11
 */
public class FindTheArrayConcVal {
    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[]{7, 52, 2, 4}));
        System.out.println(findTheArrayConcVal(new int[]{5, 14, 13, 8, 12}));
    }

    public static long findTheArrayConcVal(int[] nums) {
        long result = 0L;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            /**
             * 将nums[lo]和nums[hi]两数拼接在一起
             */
            result += Long.valueOf(nums[lo++] + "" + nums[hi--]);
        }
        /**
         * 还剩最后一个数字
         */
        if (lo == hi) {
            result += nums[lo];
        }
        return result;
    }
}
