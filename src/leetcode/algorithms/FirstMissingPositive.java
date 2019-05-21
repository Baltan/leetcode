package leetcode.algorithms;

/**
 * Description: 41. First Missing Positive
 *
 * @author Baltan
 * @date 2018/9/4 14:53
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 5}));
        System.out.println(firstMissingPositive(new int[]{1000}));
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1 && nums[index] > 0 && nums[index] <= nums.length &&
                    nums[index] != nums[nums[index] - 1]) {
                int temp = nums[nums[index] - 1];
                nums[nums[index] - 1] = nums[index];
                nums[index] = temp;
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
