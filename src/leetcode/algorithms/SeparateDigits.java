package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2553. Separate the Digits in an Array
 *
 * @author Baltan
 * @date 2023/2/7 09:35
 */
public class SeparateDigits {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(separateDigits(new int[]{13, 25, 83, 77}));
        OutputUtils.print1DIntegerArray(separateDigits(new int[]{7, 1, 3, 9}));
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        /**
         * 将数组nums中所有数字的各个数位分开
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }
        }
        int[] result = new int[list.size()];
        int index = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            result[index++] = list.get(i);
        }
        return result;
    }
}
