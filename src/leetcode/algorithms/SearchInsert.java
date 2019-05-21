package leetcode.algorithms;

/**
 * Description: 35. Search Insert Position
 * @author Baltan
 *
 * @date 2017/11/8 13:55
 */
public class SearchInsert {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target || nums[i] > target) {
                    return i;
                }
            }
        }
        return nums.length;
    }
}
