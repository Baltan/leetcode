package leetcode.algorithms;

/**
 * Description: 35. Search Insert Position
 *
 * @author Baltan
 * @date 2017/11/8 13:55
 */
public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }
        /**
         * 如果nums中所有数字都小于target，则将target插入到nums数组最后
         */
        if (nums[length - 1] < target) {
            return length;
        }

        int lo = 0;
        int hi = length - 1;
        /**
         * 二分查找nums中第一个大于等于target的数字
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
