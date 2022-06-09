package leetcode.algorithms;

/**
 * Description: 1855. Maximum Distance Between a Pair of Values
 *
 * @author Baltan
 * @date 2022/6/5 12:47
 */
public class MaxDistance3 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
        System.out.println(maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1}));
        System.out.println(maxDistance(new int[]{30, 29, 19, 5}, new int[]{25, 25, 25, 25, 25}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/solution/xia-biao-dui-zhong-de-zui-da-ju-chi-by-l-dsou/"></a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        int i = 0;

        for (int j = 0; j < nums2.length; j++) {
            /**
             * 从前向后在nums1中找到第一个小于等于nums2[j]的数（如果存在的话）
             */
            while (i < nums1.length && nums1[i] > nums2[j]) {
                i++;
            }

            if (i < nums1.length) {
                result = Math.max(result, j - i);
            } else {
                /**
                 * 如果nums1中不存在小于等于nums2[j]的数，则也不存在小于等于nums2[j+1],……,nums2[nums2.length-1]的数，
                 * 结束判断
                 */
                break;
            }
        }
        return result;
    }
}
