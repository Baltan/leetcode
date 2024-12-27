package leetcode.algorithms;

/**
 * Description: 3396. Minimum Number of Operations to Make Elements in Array Distinct
 *
 * @author Baltan
 * @date 2024/12/27 23:42
 */
public class MinimumOperations7 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(minimumOperations(new int[]{4, 5, 6, 4, 4}));
        System.out.println(minimumOperations(new int[]{6, 7, 8, 9}));
    }

    public static int minimumOperations(int[] nums) {
        /**
         * isVisited[i]表示从后向前遍历数组nums的过程中，数字i是否已出现过，根据题意，数组nums中的数字∈[1,100]
         */
        boolean[] isVisited = new boolean[101];

        for (int i = nums.length - 1; i >= 0; i--) {
            /**
             * 此前已出现过数字nums[i]时，当前数字以及它前面的数字都必须被移除
             */
            if (isVisited[nums[i]]) {
                return i / 3 + 1;
            }
            isVisited[nums[i]] = true;
        }
        return 0;
    }
}
