package leetcode.algorithms;

/**
 * Description: 1793. Maximum Score of a Good Subarray
 *
 * @author Baltan
 * @date 2023/10/26 23:51
 */
public class MaximumScore2 {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }

    public static int maximumScore(int[] nums, int k) {
        /**
         * 初始化状态为i=j=k
         */
        int result = nums[k];
        /**
         * 子数组[nums[i],nums[i+1],……,nums[k],……,nums[j-1],nums[j]]中的最小值
         */
        int min = nums[k];
        int i = k;
        int j = k;
        int length = nums.length;

        while (i - 1 >= 0 || j + 1 < length) {
            /**
             * 是否移动过i指针或j指针
             */
            boolean move = false;
            /**
             * 当左移i指针不会使得子数组[nums[i],nums[i+1],……,nums[k],……,nums[j-1],nums[j]中的最小值min变小时，尽可能地左移i指针
             */
            while (i - 1 >= 0 && nums[i - 1] >= min) {
                move = true;
                i--;
            }
            /**
             * 当右移j指针不会使得子数组[nums[i],nums[i+1],……,nums[k],……,nums[j-1],nums[j]中的最小值min变小时，尽可能地右移j指针
             */
            while (j + 1 < length && nums[j + 1] >= min) {
                move = true;
                j++;
            }

            if (move) {
                /**
                 * 计算当子数组[nums[i],nums[i+1],……,nums[k],……,nums[j-1],nums[j]中的最小值为min时，可以得到的最大分数
                 */
                result = Math.max(result, min * (j - i + 1));
            } else {
                if (i - 1 >= 0 && j + 1 < length) {
                    /**
                     * 当i指针左移或者j指针右移都会导致子数组[nums[i],nums[i+1],……,nums[k],……,nums[j-1],nums[j]中的最小值减小时，优先
                     * 移动操作后能使得这个最小值min尽可能大的指针
                     */
                    if (nums[i - 1] >= nums[j + 1]) {
                        i--;
                        min = nums[i];
                        result = Math.max(result, min * (j - i + 1));
                    } else {
                        j++;
                        min = nums[j];
                        result = Math.max(result, min * (j - i + 1));
                    }
                } else if (i - 1 >= 0) {
                    /**
                     * 左移左指针
                     */
                    i--;
                    min = nums[i];
                    result = Math.max(result, min * (j - i + 1));
                } else if (j + 1 < length) {
                    /**
                     * 右移右指针
                     */
                    j++;
                    min = nums[j];
                    result = Math.max(result, min * (j - i + 1));
                }
            }
        }
        return result;
    }
}
