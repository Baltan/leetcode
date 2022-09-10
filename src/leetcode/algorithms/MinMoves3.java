package leetcode.algorithms;

/**
 * Description: 1674. Minimum Moves to Make Array Complementary
 *
 * @author Baltan
 * @date 2022/9/4 19:28
 */
public class MinMoves3 {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 4, 3}, 4));
        System.out.println(minMoves(new int[]{1, 2, 2, 1}, 2));
        System.out.println(minMoves(new int[]{1, 2, 1, 2}, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/solution/by-stormsunshine-zwtc/"></a>
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int minMoves(int[] nums, int limit) {
        int result = Integer.MAX_VALUE;
        /**
         * 初始化操作次数为nums.length，表示假设数组nums中的每个数字都要进行一次操作
         */
        int operations = nums.length;
        /**
         * 因为最终每个元素∈[1,limit]，所以首尾两个元素之和的最大可能为2*limit
         */
        int maxSum = 2 * limit;
        int length = nums.length;
        /**
         * diffs[i]表示首尾元素之和为i时，比首尾元素之和为i-1时多的操作次数
         */
        int[] diffs = new int[maxSum + 1];

        for (int i = 0; i < nums.length / 2; i++) {
            int num = nums[i];
            int otherNum = nums[length - 1 - i];
            int min = Math.min(num, otherNum);
            int max = Math.max(num, otherNum);
            /**
             * 首尾两数将较大值替换成1后的和
             */
            int lowerLimit = min + 1;
            /**
             * 首尾两数将较小值替换成limit后的和
             */
            int upperLimit = max + limit;
            /**
             * 首尾两数操作前的和
             */
            int sum = num + otherNum;
            /**
             * 1、当首尾元素之和为sum时，不需要进行操作，共进行0次操作
             * 2、当首尾元素之和∈[lowerLimit,sum)和(sum,upperLimit]时，需要对其中的某个数进行一次操作，共进行1次操作
             * 3、当首尾元素之和∈[2,lowerLimit)或(upperLimit,maxSum)时，需要对两个数都进行操作，共进行2次操作
             *
             * 综上可得：
             * 1、首尾元素之和为lowerLimit时，比首尾元素之和为lowerLimit-1时少一次操作
             * 2、首尾元素之和为sum时，比首尾元素之和为sum-1时少一次操作
             * 3、首尾元素之和为sum+1时，比首尾元素之和为sum时多一次操作
             * 4、首尾元素之和为upperLimit+1时，比首尾元素之和为upperLimit时多一次操作
             */
            diffs[lowerLimit]--;
            diffs[sum]--;
            /**
             * 判断范围，防止越界
             */
            if (sum < maxSum) {
                diffs[sum + 1]++;
            }
            /**
             * 判断范围，防止越界
             */
            if (upperLimit < maxSum) {
                diffs[upperLimit + 1]++;
            }
        }
        /**
         * 计算当首尾元素之和为i时，需要进行的总操作次数，取最小值即可
         */
        for (int i = 1; i <= maxSum; i++) {
            operations += diffs[i];
            result = Math.min(result, operations);
        }
        return result;
    }
}
