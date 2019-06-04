package leetcode.algorithms;

/**
 * Description: 162. Find Peak Element
 *
 * @author Baltan
 * @date 2019-06-04 11:22
 */
public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
