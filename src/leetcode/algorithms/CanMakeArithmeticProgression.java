package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1502. Can Make Arithmetic Progression From Sequence
 *
 * @author Baltan
 * @date 2020-07-08 21:12
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(canMakeArithmeticProgression(new int[]{1, 2, 4}));
        System.out.println(canMakeArithmeticProgression(new int[]{1, 2}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
