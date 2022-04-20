package leetcode.algorithms;

/**
 * Description: 2239. Find Closest Number to Zero
 *
 * @author Baltan
 * @date 2022/4/19 08:50
 */
public class FindClosestNumber {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));
        System.out.println(findClosestNumber(new int[]{-10000, -10000}));
    }

    public static int findClosestNumber(int[] nums) {
        int result = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num > 0 && num <= diff) {
                result = num;
                diff = num;
            } else if (num < 0 && -num < diff) {
                result = num;
                diff = -num;
            }
        }
        return result;
    }
}
