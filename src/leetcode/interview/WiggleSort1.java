package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 10.11. 峰与谷
 *
 * @author Baltan
 * @date 2019-06-21 10:20
 * @see WiggleSort
 * @see leetcode.algorithms.WiggleSort
 */
public class WiggleSort1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums1);
        OutputUtils.print1DIntegerArray(nums1);

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums2);
        OutputUtils.print1DIntegerArray(nums2);

        int[] nums3 = {9, 6, 8, 7, 3, 5, 1, 2, 4};
        wiggleSort(nums3);
        OutputUtils.print1DIntegerArray(nums3);

        int[] nums4 = {2, 1};
        wiggleSort(nums4);
        OutputUtils.print1DIntegerArray(nums4);

        int[] nums5 = {2};
        wiggleSort(nums5);
        OutputUtils.print1DIntegerArray(nums5);

        int[] nums6 = {};
        wiggleSort(nums6);
        OutputUtils.print1DIntegerArray(nums6);

        int[] nums7 = {4, 5, 5, 6};
        wiggleSort(nums7);
        OutputUtils.print1DIntegerArray(nums7);
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/peaks-and-valleys-lcci/solution/gelthin-xiang-lin-yuan-su-jiao-huan-by-gelthin/"></a>
     *
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        /**
         * 为了保证偶数索引位置永远是谷，奇数索引位置永远是峰，当偶数索引位置的数字比前一个数字大，就前后交
         * 换，当奇数索引位置的数字比前一个数字小，就前后交换
         */
        for (int i = 1; i < length; i++) {
            if ((i & 1) == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if ((i & 1) == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }

    /**
     * 交换索引i处的数字和索引j处的数字
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
