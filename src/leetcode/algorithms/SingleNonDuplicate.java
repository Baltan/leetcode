package leetcode.algorithms;

/**
 * Description: 540. Single Element in a Sorted Array
 *
 * @author Baltan
 * @date 2018/1/11 13:58
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 11, 11, 13}));
    }

    public static int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 2; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
