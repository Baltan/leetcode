package leetcode.algorithms;

/**
 * Description: 4. Median of Two Sorted Arrays
 *
 * @author Baltan
 * @date 2018/1/12 09:53
 * @see FindMedianSortedArrays1
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 如果nums1为空数组，返回nums2的中位数
         */
        if (nums1.length == 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0 :
                    nums2[nums2.length / 2] / 1.0;
        }
        /**
         * 如果nums2为空数组，返回nums1的中位数
         */
        if (nums2.length == 0) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0 :
                    nums1[nums1.length / 2] / 1.0;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        /**
         * 合并后数组的总长度
         */
        int mergeLength = length1 + length2;
        /**
         * nums1和nums2合并后的数组，数组中的所有元素按照升序排列
         */
        int[] nums = new int[length1 + length2];
        /**
         * 合并nums1和nums2
         */
        for (int i = 0; i < mergeLength; i++) {
            if (index1 < length1 && index2 < length2) {
                if (nums1[index1] <= nums2[index2]) {
                    nums[i] = nums1[index1];
                    index1++;
                } else {
                    nums[i] = nums2[index2];
                    index2++;
                }
            } else if (index1 >= length1) {
                nums[i] = nums2[index2];
                index2++;
            } else {
                nums[i] = nums1[index1];
                index1++;
            }
        }
        /**
         * 合并后数组nums的中位数
         */
        double median =
                mergeLength % 2 == 0 ? (nums[mergeLength / 2 - 1] + nums[mergeLength / 2]) / 2.0 :
                        nums[mergeLength / 2] / 1.0;
        return median;
    }
}
