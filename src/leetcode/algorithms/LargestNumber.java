package leetcode.algorithms;

import java.util.Arrays;
import java.util.Objects;

/**
 * Description: 179. Largest Number
 *
 * @author Baltan
 * @date 2019-04-03 10:14
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{0, 0}));
        System.out.println(largestNumber(new int[]{0, 30, 23, 0}));
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int length = nums.length;
        String[] strings = new String[length];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));

        if (Objects.equals("0", strings[length - 1])) {
            return "0";
        }

        for (int i = length - 1; i >= 0; i--) {
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}
