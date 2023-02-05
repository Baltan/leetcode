package leetcode.algorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 2554. Maximum Number of Integers to Choose From a Range I
 *
 * @author Baltan
 * @date 2023/2/5 12:45
 */
public class MaxCount1 {
    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1, 6, 5}, 5, 6));
        System.out.println(maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1));
        System.out.println(maxCount(new int[]{11}, 7, 50));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        int result = 0;
        /**
         * 所选数字的和
         */
        int sum = 0;
        Set<Integer> bannedSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        /**
         * 从较小的数开始选择即可，直到所选数字的和大于maxSum
         */
        for (int i = 1; i <= n && sum < maxSum; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i;
                result++;
            }
        }
        return result;
    }
}
