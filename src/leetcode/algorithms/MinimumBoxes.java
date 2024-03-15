package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3074. Apple Redistribution into Boxes
 *
 * @author Baltan
 * @date 2024/3/15 23:09
 */
public class MinimumBoxes {
    public static void main(String[] args) {
        System.out.println(minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
        System.out.println(minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        int result = 0;
        /**
         * 苹果总个数
         */
        int sum = 0;
        Arrays.sort(capacity);

        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }
        /**
         * 从剩余所有盒子中选择容量最大的，直到能够把所有苹果都装进盒子
         */
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum <= 0) {
                break;
            }
            sum -= capacity[i];
            result++;
        }
        return result;
    }
}
