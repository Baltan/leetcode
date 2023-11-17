package leetcode.algorithms;

/**
 * Description: 2934. Minimum Operations to Maximize Last Elements in Arrays
 *
 * @author Baltan
 * @date 2023/11/17 21:49
 */
public class MinOperations17 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2}, new int[]{2, 1}));
        System.out.println(minOperations(new int[]{10, 18, 12, 12}, new int[]{19, 6, 5, 12}));
        System.out.println(minOperations(new int[]{17, 13, 19, 9, 6, 14}, new int[]{17, 14, 15, 1, 19, 19}));
        System.out.println(minOperations(new int[]{1, 2, 7}, new int[]{4, 5, 3}));
        System.out.println(minOperations(new int[]{2, 3, 4, 5, 9}, new int[]{8, 8, 4, 4, 4}));
        System.out.println(minOperations(new int[]{1, 5, 4}, new int[]{2, 5, 3}));
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int count1 = help(nums1, nums2);
        int temp = nums1[length - 1];
        nums1[length - 1] = nums2[length - 1];
        nums2[length - 1] = temp;
        int count2 = help(nums1, nums2);
        /**
         * 对于第二种方案而言，本身是基于先交换数组nums1和nums2的最后一个元素的，需要加上这一次操作
         */
        if (count2 != -1) {
            count2++;
        }

        if (count1 == -1 && count2 == -1) {
            return -1;
        } else if (count1 == -1) {
            return count2;
        } else if (count2 == -1) {
            return count1;
        } else {
            /**
             * 保留操作次数较少的方案
             */
            return Math.min(count2, count1);
        }
    }

    /**
     * 通过若干次交换数组nums1和nums1中相同索引上的数字，使得最终nums1和nums2中的最后一个数字各自为数组中的最大值，如果无法实现则返回-1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int help(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int count = 0;
        int end1 = nums1[length - 1];
        int end2 = nums2[length - 1];
        int max = Math.max(end1, end2);
        int min = Math.min(end1, end2);

        for (int i = 0; i < length; i++) {
            /**
             * nums1[i]和nums2[i]中存在既大于end1，又大于end2的数字，直接返回-1
             */
            if (nums1[i] > max || nums2[i] > max) {
                return -1;
            }
            /**
             * end1和end2中存在既小于nums1[i]，又小于nums2[i]的数字，直接返回-1
             */
            if (nums1[i] > min && nums2[i] > min) {
                return -1;
            }

            if (nums1[i] > end1 || nums2[i] > end2) {
                count++;
            }
        }
        /**
         * 如果通过交换数组中的count对索引的元素可以实现需求，则相对应的从一开始只交换另外length-count对索引的元素也能实现需求，保留操作次
         * 数较少的方案
         */
        return Math.min(count, length - count);
    }
}
