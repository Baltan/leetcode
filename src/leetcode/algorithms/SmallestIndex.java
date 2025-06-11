package leetcode.algorithms;

/**
 * Description: 3550. Smallest Index With Digit Sum Equal to Index
 *
 * @author Baltan
 * @date 2025/6/11 23:53
 */
public class SmallestIndex {
    public static void main(String[] args) {
        System.out.println(smallestIndex(new int[]{1, 3, 2}));
        System.out.println(smallestIndex(new int[]{1, 10, 11}));
        System.out.println(smallestIndex(new int[]{1, 2, 3}));
    }

    public static int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            /**
             * 数字num各个数位上的数字之和
             */
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}
