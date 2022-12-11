package leetcode.algorithms;

/**
 * Description: 2439. Minimize Maximum of Array
 *
 * @author Baltan
 * @date 2022/12/6 10:37
 */
public class MinimizeArrayValue {
    public static void main(String[] args) {
        System.out.println(minimizeArrayValue(new int[]{3, 7, 1, 6}));
        System.out.println(minimizeArrayValue(new int[]{10, 1}));
        System.out.println(minimizeArrayValue(new int[]{10, 9, 8, 7, 6, 5, 4}));
        System.out.println(minimizeArrayValue(new int[]{1, 10, 100, 1000, 10000}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimize-maximum-of-array/solutions/1894993/cppjava-you-shi-yi-dao-jing-dian-de-er-f-w3i6/"></a>
     *
     * @param nums
     * @return
     */
    public static int minimizeArrayValue(int[] nums) {
        int length = nums.length;
        int lo = 0;
        int hi = 1000000000;
        /**
         * 二分查找判断能否使数组nums中的所有元素都不大于mid
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (check(nums, length, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 校验能否使数组nums中的所有元素都不大于mid
     *
     * @param nums
     * @param length
     * @param mid
     * @return
     */
    public static boolean check(int[] nums, int length, int mid) {
        /**
         * 前方的数字还可以帮后方的大数承载多少数字
         */
        long have = 0L;

        for (int i = 0; i < length; i++) {
            /**
             * 如果nums[i]小于mid，则可以使nums[i]增加mid-nums[i]次，同时为后面的元素累加mid-nums[i]次承载量
             */
            if (nums[i] < mid) {
                have += (mid - nums[i]);
            } else {
                /**
                 * 如果nums[i]大于等于mid，为了使nums[i]不超过mid，需要扣除前面积累的nums[i]-mid次承载量，如果承载量不够，则说明无法使得
                 * 数组nums中的所有元素都不大于mid
                 */
                if (have < nums[i] - mid) {
                    return false;
                } else {
                    have -= (nums[i] - mid);
                }
            }
        }
        return true;
    }
}
