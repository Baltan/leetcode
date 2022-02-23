package leetcode.interview;

/**
 * Description: 面试题 17.10. 主要元素
 *
 * @author Baltan
 * @date 2022/2/23 18:02
 * @see leetcode.algorithms.MajorityElement
 * @see leetcode.algorithms.MajorityElement1
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 1, 3, 1};
        System.out.println(majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(majorityElement(nums3));
    }

    /**
     * Boyer-Moore 投票算法
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        /**
         * candidate在数组nums中出现的次数
         */
        count = 0;
        /**
         * 重新统计candidate在数组nums中出现的次数
         */
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count >= (nums.length + 1) / 2 ? candidate : -1;
    }
}
