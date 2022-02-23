package leetcode.algorithms;

/**
 * Description: 169. Majority Element
 *
 * @author Baltan
 * @date 2017/11/7 16:10
 * @see MajorityElement
 * @see leetcode.interview.MajorityElement
 * @see MajorityElement2
 */
public class MajorityElement1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 1, 1, 3, 1};
        System.out.println(majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2));
    }

    /**
     * Boyer-Moore 投票算法
     * 参考：
     * <a href="https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/"></a>
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
        return candidate;
    }
}
