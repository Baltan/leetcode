package leetcode.algorithms;

/**
 * Description: 3326. Minimum Division Operations to Make Array Non Decreasing
 *
 * @author Baltan
 * @date 2024/10/20 16:44
 */
public class MinOperations25 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{105, 11}));
        System.out.println(minOperations(new int[]{25, 7}));
        System.out.println(minOperations(new int[]{7, 7, 6}));
        System.out.println(minOperations(new int[]{1, 1, 1, 1}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        /**
         * 贪心思想，倒序遍历数组nums，依次使得每个元素操作后不大于其后一个元素，并且操作后的元素尽可能大
         */
        outer:
        for (int i = nums.length - 2; i >= 0; i--) {
            /**
             * 不需要对nums[i]进行操作
             */
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            /**
             * nums[i]所有不大于nums[i+1]的真因数中的最大值
             */
            int num = 0;

            for (int j = 2; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    int k = nums[i] / j;

                    if (k <= nums[i + 1]) {
                        /**
                         * 将nums[i]除以j后，使得nums[i]变为k
                         */
                        result++;
                        nums[i] = k;
                        continue outer;
                    }
                    /**
                     * 虽然j不大于nums[i+1]，但因为是升序遍历j，所以后续可能可以令操作后nums[i]的值更大
                     */
                    if (j <= nums[i + 1]) {
                        num = Math.max(num, j);
                    }
                }
            }
            /**
             * 没有能够使得nums[i]变得不大于nums[i+1]，直接结束
             */
            if (num == 0) {
                return -1;
            }
            nums[i] = num;
            result++;
        }
        return result;
    }
}
