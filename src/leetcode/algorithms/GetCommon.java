package leetcode.algorithms;

/**
 * Description: 2540. Minimum Common Value
 *
 * @author Baltan
 * @date 2023/2/1 10:34
 */
public class GetCommon {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println(getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        /**
         * 双指针从小到大分别遍历两个数组，直到找到公共整数，或者某一个数组已遍历完
         */
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] == nums2[index2]) {
                return nums1[index1];
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return -1;
    }
}
