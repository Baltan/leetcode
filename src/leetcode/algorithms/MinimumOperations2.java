package leetcode.algorithms;

/**
 * Description: 2357. Make Array Zero by Subtracting Equal Amounts
 *
 * @author Baltan
 * @date 2023/2/14 10:12
 */
public class MinimumOperations2 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(minimumOperations(new int[]{0}));
    }

    public static int minimumOperations(int[] nums) {
        /**
         * 根据题意，nums[i]∈[0,100]
         */
        int max = 100;
        /**
         * boolean[i]表示数组nums中元素i存在
         */
        boolean[] isExisted = new boolean[max + 1];
        /**
         * 数组nums中不同正整数的个数
         */
        int differentCount = 0;

        for (int num : nums) {
            if (num > 0) {
                if (!isExisted[num]) {
                    /**
                     * 得到一个和之前都不同的正整数
                     */
                    differentCount++;
                }
                isExisted[num] = true;
            }
        }
        return differentCount;
    }
}
