package leetcode.algorithms;

/**
 * Description: 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 *
 * @author Baltan
 * @date 2020-07-05 14:40
 */
public class MinSumOfLengths {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 2, 4, 3};
        System.out.println(minSumOfLengths(arr1, 3));

        int[] arr2 = {7, 3, 4, 7};
        System.out.println(minSumOfLengths(arr2, 7));

        int[] arr3 = {4, 3, 2, 6, 2, 3, 4};
        System.out.println(minSumOfLengths(arr3, 6));

        int[] arr4 = {5, 5, 4, 4, 5};
        System.out.println(minSumOfLengths(arr4, 3));

        int[] arr5 = {3, 1, 1, 1, 5, 1, 2, 1};
        System.out.println(minSumOfLengths(arr5, 3));
    }

    public static int minSumOfLengths(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        int length = arr.length;
        /**
         * dp1[i]表示子数组arr.subarray(0,i+1)中的和为target的最小子数组的长度
         */
        int[] dp1 = new int[length];
        /**
         * dp2[i]表示子数组arr.subarray(i,length)中的和为target的最小子数组的长度
         */
        int[] dp2 = new int[length];
        dp1[0] = arr[0] == target ? 1 : Integer.MAX_VALUE;
        dp2[length - 1] = arr[length - 1] == target ? 1 : Integer.MAX_VALUE;

        for (int i = 1; i < length; i++) {
            /**
             * 最后一个元素为arr[i]的子数组的和
             */
            int sum = 0;
            /**
             * 最后一个元素为arr[i]的子数组的长度
             */
            int l = 0;
            int j = i;
            /**
             * 查找是否存在最后一个元素为arr[i]且和为target的子数组，即是否存在子数组arr[i-k]……arr[i-1]、arr[i]的和
             * 为target
             */
            while (sum < target && j >= 0) {
                sum += arr[j--];
                l++;
            }
            /**
             * 如果当前子数组的和为target，说明存在最后一个元素为arr[i]且和为target的子数组，更新dp1[i]
             */
            if (sum == target) {
                dp1[i] = Math.min(dp1[i - 1], l);
            } else {
                dp1[i] = dp1[i - 1];
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            /**
             * 第一个元素为arr[i]的子数组的和
             */
            int sum = 0;
            /**
             * 第一个元素为arr[i]的子数组的长度
             */
            int l = 0;
            int j = i;
            /**
             * 查找是否存在第一个元素为arr[i]且和为target的子数组，即是否存在子数组arr[i]、arr[i+1]……arr[length-2]、
             * arr[length-1]的和为target
             */
            while (sum < target && j < length) {
                sum += arr[j++];
                l++;
            }
            /**
             * 如果当前子数组的和为target，说明存在第一个元素为arr[i]且和为target的子数组，更新dp2[i]
             */
            if (sum == target) {
                dp2[i] = Math.min(dp2[i + 1], l);
            } else {
                dp2[i] = dp2[i + 1];
            }
        }
        /**
         * 将arr分成arr.subarray(0,i)和arr.subarray(i,length)两个子数组后如果能从两个子数组中各找到一个和为target
         * 的子数组，则说明满足题目要求，更新result
         */
        for (int i = 1; i < length; i++) {
            if (dp1[i - 1] != Integer.MAX_VALUE && dp2[i] != Integer.MAX_VALUE) {
                result = Math.min(result, dp1[i - 1] + dp2[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
