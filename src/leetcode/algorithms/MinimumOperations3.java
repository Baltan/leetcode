package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2826. Sorting Three Groups
 *
 * @author baltan
 * @date 2023/8/22 09:42
 */
public class MinimumOperations3 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(Arrays.asList(2, 1, 3, 2, 1)));
        System.out.println(minimumOperations(Arrays.asList(1, 3, 2, 1, 3, 3)));
        System.out.println(minimumOperations(Arrays.asList(2, 2, 2, 2, 3, 3)));
    }

    public static int minimumOperations(List<Integer> nums) {
        int result = Integer.MAX_VALUE;
        int size = nums.size();
        /**
         * prefixCounts1[i]表示数组nums前i个元素中1的个数
         */
        int[] prefixCounts1 = new int[size + 1];
        /**
         * prefixCounts2[i]表示数组nums前i个元素中2的个数
         */
        int[] prefixCounts2 = new int[size + 1];
        /**
         * prefixCounts3[i]表示数组nums前i个元素中3的个数
         */
        int[] prefixCounts3 = new int[size + 1];

        for (int i = 0; i < size; i++) {
            if (nums.get(i) == 1) {
                prefixCounts1[i + 1] = prefixCounts1[i] + 1;
                prefixCounts2[i + 1] = prefixCounts2[i];
                prefixCounts3[i + 1] = prefixCounts3[i];
            } else if (nums.get(i) == 2) {
                prefixCounts1[i + 1] = prefixCounts1[i];
                prefixCounts2[i + 1] = prefixCounts2[i] + 1;
                prefixCounts3[i + 1] = prefixCounts3[i];
            } else {
                prefixCounts1[i + 1] = prefixCounts1[i];
                prefixCounts2[i + 1] = prefixCounts2[i];
                prefixCounts3[i + 1] = prefixCounts3[i] + 1;
            }
        }
        /**
         * 假设由数组nums得到的美丽数组中前i个数字为1，中间j个数字为2，最后k个数字为3
         */
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size - i; j++) {
                int k = size - i - j;
                /**
                 * 将前i个数字变为1需要的操作次数为i-prefixCounts1[i]，将中间j个数字变为2需要的操作次数为
                 * j-(prefixCounts2[i+j]-prefixCounts2[i])，将最后k个数字变为3需要的操作次数为
                 * k-(prefixCounts3[size]-prefixCounts3[i+j])
                 */
                result = Math.min(result, (i - prefixCounts1[i]) + (j - (prefixCounts2[i + j] - prefixCounts2[i])) + (k - (prefixCounts3[size] - prefixCounts3[i + j])));
            }
        }
        return result;
    }
}
