package leetcode.algorithms;

/**
 * Description: 287. Find the Duplicate Number
 *
 * @author Baltan
 * @date 2019-06-15 16:42
 * @see FindDuplicate
 * @see DetectCycle
 * @see HasCycle
 */
public class FindDuplicate1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums2));

        int[] nums3 = {1, 1};
        System.out.println(findDuplicate(nums3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/"></a>
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        /**
         * 对于数组中的每个元素，创建索引到值的映射，例如：[3,1,3,4,2]可以得到
         * 0 - 3
         * 1 - 1
         * 2 - 3
         * 3 - 4
         * 4 - 2
         *
         * 然后从索引0开始可以构建一条链表：0 -> 3 -> 4 -> 2
         *                                  |          |
         *                                  -----<-----
         * 因为数组nums中存在一个重复元素x，则指向x的入口至少有两个，则链表中一定存在一个环，并且元素x是这个环
         * 的入口
         *
         * Floyd算法查找链表入环的第一个节点：
         * <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/"></a>
         */
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}