package leetcode.algorithms;

/**
 * Description: 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * @author Baltan
 * @date 2020-02-09 10:41
 */
public class NumOfSubarrays {
    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(numOfSubarrays(arr1, 3, 4));

        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println(numOfSubarrays(arr2, 1, 0));

        int[] arr3 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        System.out.println(numOfSubarrays(arr3, 3, 5));

        int[] arr4 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(numOfSubarrays(arr4, 7, 7));

        int[] arr5 = {4, 4, 4, 4};
        System.out.println(numOfSubarrays(arr5, 4, 1));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int length = arr.length;
        int sum = 0;
        int total = k * threshold;
        /**
         * 第一个长度为k的子数组所有元素的和
         */
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= total) {
            result++;
        }
        /**
         * 逐次计算每一个长度为k的子数组的所有元素的和，将前一个子数组的第一个元素删去，再在后面加上
         * 一个元素即可
         */
        for (int i = k; i < length; i++) {
            sum += arr[i];
            sum -= arr[i - k];

            if (sum >= total) {
                result++;
            }
        }
        return result;
    }
}
