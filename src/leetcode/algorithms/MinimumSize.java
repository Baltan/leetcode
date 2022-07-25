package leetcode.algorithms;

/**
 * Description: 1760. Minimum Limit of Balls in a Bag
 *
 * @author Baltan
 * @date 2022/7/22 09:37
 */
public class MinimumSize {
    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{1, 1, 1}, 2));
        System.out.println(minimumSize(new int[]{9}, 2));
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
        System.out.println(minimumSize(new int[]{7, 17}, 2));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        if (nums.length == 1) {
            return (int) Math.ceil(nums[0] * 1.0 / (maxOperations + 1));
        }
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        /**
         * 如果每个袋子中都只有1个球，则无法完成操作，直接返回结果
         */
        if (max == 1) {
            return 1;
        }
        /**
         * 如果每个袋子中球的个数相等，并且袋子的个数多余最大操作次数，则总有袋子中的球不能被分到两个袋子中，直接返回结果
         */
        if (min == max && nums.length > maxOperations) {
            return max;
        }
        /**
         * 最终每个袋子中至少有一个球
         */
        min = 1;
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
                 * 一共num个球，每个袋子中球的个数不超过mid个，需要的操作次数
                 */
                operations += Math.ceil(num * 1.0 / mid) - 1;
            }

            if (operations > maxOperations) {
                /**
                 * 需要操作的次数超过了maxOperations次，最终每个袋子里球数目不小于mid个
                 */
                min = mid + 1;
            } else {
                max = mid;
                result = Math.min(result, mid);
            }
        }
        return result;
    }
}
