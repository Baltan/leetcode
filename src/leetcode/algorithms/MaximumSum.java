package leetcode.algorithms;

/**
 * Description: 1186. Maximum Subarray Sum with One Deletion
 *
 * @author Baltan
 * @date 2019-09-10 07:51
 */
public class MaximumSum {
    public static void main(String[] args) {
        int[] arr1 = {1, -2, 0, 3};
        System.out.println(maximumSum(arr1));

        int[] arr2 = {1, -2, -2, 3};
        System.out.println(maximumSum(arr2));

        int[] arr3 = {-1, -1, -1, -1};
        System.out.println(maximumSum(arr3));
    }

    public static int maximumSum(int[] arr) {
        int length = arr.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            result = Math.max(result, arr[i]);
            int min = arr[i];
            int sum = arr[i];

            for (int j = i + 1; j < length; j++) {
                sum += arr[j];
                min = Math.min(min, arr[j]);
                result = Math.max(result, Math.max(sum, sum - min));
            }
        }
        return result;
    }
}
