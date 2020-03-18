package leetcode.algorithms;

/**
 * Description: 704. Binary Search
 *
 * @author Baltan
 * @date 2018/8/11 00:48
 * @see Search1
 * @see Search2
 * @see leetcode.interview.Search
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(search(new int[]{2}, 2));
        System.out.println(search(new int[]{2}, 3));
        System.out.println(search(new int[]{2, 3}, 2));
        System.out.println(search(new int[]{2, 3}, 3));
        System.out.println(search(new int[]{2, 3, 4}, 4));
    }

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
