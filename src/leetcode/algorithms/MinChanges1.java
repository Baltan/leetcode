package leetcode.algorithms;

/**
 * Description: 3224. Minimum Array Changes to Make Differences Equal
 *
 * @author baltan
 * @date 2024/7/24 11:56
 */
public class MinChanges1 {
    public static void main(String[] args) {
        System.out.println(minChanges(new int[]{1, 0, 1, 2, 4, 3}, 4));
        System.out.println(minChanges(new int[]{0, 1, 2, 3, 3, 6, 5, 4}, 6));
    }

    public static int minChanges(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        /**
         * 假设存在数组counts，其中counts[x]表示使得数组nums中的所有数对之差的绝对值都变为x的总操作次数。数组diffs为counts的差分数组
         */
        int[] diffs = new int[k + 2];
        int count = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            int x = nums[i];
            int y = nums[nums.length - 1 - i];
            int diff = Math.abs(x - y);
            /**
             * 如果将x变为[0,k]中的一个数，y不变，则可以得到差值的绝对值范围为[y,k-y]；如果将y变为[0,k]中的一个数，x不变，则可以得到差值
             * 的绝对值范围为[x,k-x]。所以操作后数对(x,y)之差的绝对值范围为[0,max]
             */
            int max = getMax(y, k - y, x, k - x);
            /**
             * 修改x或y中的一个数可以得到差值的绝对值[0,diff-1]
             */
            if (diff - 1 >= 0) {
                diffs[0]++;
                diffs[diff]--;
            }
            /**
             * 修改x或y中的一个数可以得到差值的绝对值[diff+1,max]
             */
            if (max >= diff + 1) {
                diffs[diff + 1]++;
                diffs[max + 1]--;
            }
            /**
             * 修改x和y两个数可以得到差值的绝对值[max+1,k]
             */
            if (k >= max + 1) {
                diffs[max + 1] += 2;
                diffs[k + 1] -= 2;
            }
        }
        /**
         * 从差分数组diffs还原得到数组counts
         */
        for (int i = 0; i <= k; i++) {
            count += diffs[i];
            result = Math.min(result, count);
        }
        return result;
    }

    /**
     * 计算数组nums中所有数字的最大值
     *
     * @param nums
     * @return
     */
    public static int getMax(int... nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
