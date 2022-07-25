package leetcode.algorithms;

/**
 * Description: 1760. Minimum Limit of Balls in a Bag
 *
 * @author Baltan
 * @date 2022/7/22 09:37
 */
public class MinimumSize1 {
    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{1, 1, 1}, 2));
        System.out.println(minimumSize(new int[]{9}, 2));
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
        System.out.println(minimumSize(new int[]{7, 17}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.com/submissions/detail/755876996/"></a>
     *
     * @param nums
     * @param maxOperations
     * @return
     */
    public static int minimumSize(int[] nums, int maxOperations) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        /**
         * 二分查找最终单个袋子里球数目的最大值
         */
        while (min < max) {
            int mid = (min + max) / 2;
            /**
             * 最终每个袋子中球的个数不超过mid个时，一共需要的操作次数
             */
            int operations = 0;

            for (int num : nums) {
                /**
                 * 一共num个球，每个袋子中球的个数不超过mid个，需要的操作次数。如果用Math.ceil()会大大减慢计算速度
                 */
                operations += (num - 1) / mid;
            }

            if (operations <= maxOperations) {

                max = mid;
            } else {
                /**
                 * 需要操作的次数超过了maxOperations次，最终每个袋子里球数目不小于mid个
                 */
                min = mid + 1;
            }
        }
        return min;
    }
}
