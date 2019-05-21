package leetcode.algorithms;

import java.util.stream.IntStream;

/**
 * Description: 526. Beautiful Arrangement
 *
 * @author Baltan
 * @date 2019-04-26 10:45
 */
public class CountArrangement {
    public static void main(String[] args) {
        System.out.println(countArrangement(1));
        System.out.println(countArrangement(2));
        System.out.println(countArrangement(3));
        System.out.println(countArrangement(15));
    }

    public static int countArrangement(int N) {
        int[] nums = IntStream.rangeClosed(1, N).toArray();
        return help(1, nums);
    }

    public static int help(int position, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] % position == 0 || position % nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;

        for (int i = 0, len = nums.length; i < len; i++) {
            if (position % nums[i] == 0 || nums[i] % position == 0) {
                int[] restNums = new int[len - 1];
                for (int j = 0; j < len - 1; j++) {
                    if (j < i) {
                        restNums[j] = nums[j];
                    } else {
                        restNums[j] = nums[j + 1];
                    }
                }
                result += help(position + 1, restNums);
            }
        }
        return result;
    }
}
