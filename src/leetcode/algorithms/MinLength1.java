package leetcode.algorithms;

/**
 * Description: 3795. Minimum Subarray Length With Distinct Sum At Least K
 *
 * @author baltan
 * @date 2026/2/10 15:38
 */
public class MinLength1 {
    public static void main(String[] args) {
        System.out.println(minLength(new int[]{2, 2, 3, 1}, 4));
        System.out.println(minLength(new int[]{3, 2, 3, 4}, 5));
        System.out.println(minLength(new int[]{5, 5, 4}, 5));
    }

    public static int minLength(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        /**
         * 初始化滑动窗口为空数组的情况
         */
        int left = 0;
        int right = -1;
        /**
         * counts[i]表示滑动窗口nums[left……right]中元素i的个数。根据题意，i∈[1,100000]
         */
        int[] counts = new int[100001];
        /**
         * 滑动窗口nums[left……right]中不同元素之和
         */
        long sum = 0;
        /**
         * 当滑动窗口中不同元素之和小于k时，向右移动右端点，向窗口中新增元素
         */
        while (sum < k && right < nums.length - 1) {
            int addedNum = nums[++right];
            /**
             * 滑动窗口中之前没有元素counts[addedNum]
             */
            if (counts[addedNum]++ == 0) {
                sum += addedNum;
            }

            if (sum >= k) {
                result = Math.min(result, right - left + 1);
                /**
                 * 当滑动窗口中不同元素之和不小于k时，向右移动左端点，从窗口中移除元素
                 */
                while (sum >= k && left < right) {
                    int removedNum = nums[left++];
                    /**
                     * 滑动窗口中唯一一个元素counts[removedNum]被移除
                     */
                    if (--counts[removedNum] == 0) {
                        sum -= removedNum;
                    }

                    if (sum >= k) {
                        result = Math.min(result, right - left + 1);
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
