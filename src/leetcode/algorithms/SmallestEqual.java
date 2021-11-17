package leetcode.algorithms;

/**
 * Description: 2057. Smallest Index With Equal Value
 *
 * @author Baltan
 * @date 2021/11/17 23:04
 */
public class SmallestEqual {
    public static void main(String[] args) {
        System.out.println(smallestEqual(new int[]{0, 1, 2}));
        System.out.println(smallestEqual(new int[]{4, 3, 2, 1}));
        System.out.println(smallestEqual(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(smallestEqual(new int[]{2, 1, 3, 5, 2}));
    }

    public static int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
