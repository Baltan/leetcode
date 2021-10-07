package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2028. Find Missing Observations
 *
 * @author Baltan
 * @date 2021/10/7 16:11
 */
public class MissingRolls {
    public static void main(String[] args) {
        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4;
        int n1 = 2;
        System.out.println(Arrays.toString(missingRolls(rolls1, mean1, n1)));

        int[] rolls2 = {1, 5, 6};
        int mean2 = 3;
        int n2 = 4;
        System.out.println(Arrays.toString(missingRolls(rolls2, mean2, n2)));

        int[] rolls3 = {1, 2, 3, 4};
        int mean3 = 6;
        int n3 = 4;
        System.out.println(Arrays.toString(missingRolls(rolls3, mean3, n3)));

        int[] rolls4 = {1};
        int mean4 = 3;
        int n4 = 1;
        System.out.println(Arrays.toString(missingRolls(rolls4, mean4, n4)));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int observedSum = Arrays.stream(rolls).sum();
        /**
         * 剩余n个数字之和
         */
        int lostSum = mean * (rolls.length + n) - observedSum;

        if (lostSum > n * 6 || lostSum < n * 1) {
            return new int[]{};
        }

        int[] result = new int[n];
        int average = lostSum / n;
        int left = lostSum - average * n;

        for (int i = 0; i < left; i++) {
            result[i] = average + 1;
        }

        for (int i = left; i < n; i++) {
            result[i] = average;
        }
        return result;
    }
}
