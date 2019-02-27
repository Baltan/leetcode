package leetcode.algorithms;

/**
 * Description: Binary Search
 *
 * @author Baltan
 * @date 2018/8/11 00:48
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
        int head = 0;
        int tail = nums.length - 1;
        int mid = head + (tail - head) / 2;

        while (head < tail) {
            if (target == nums[head]) {
                return head;
            }
            if (target == nums[tail]) {
                return tail;
            }
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                head = mid + 1;
                mid = head + (tail - head) / 2;
            } else if (target < nums[mid]) {
                tail = mid - 1;
                mid = head + (tail - head) / 2;
            }
        }
        return nums[head] == target ? head : -1;
    }
}
