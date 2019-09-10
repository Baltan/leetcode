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
        if (arr.length == 1) {
            return arr[0];
        }
        /**
         * 保存子数组最大和
         */
        int result = Integer.MIN_VALUE;
        int length = arr.length;
        /**
         * 保存不删除元素的子数组的最大和
         */
        int[] dp1 = new int[length];
        /**
         * 保存删除一个元素的子数组的最大和
         */
        int[] dp2 = new int[length];
        dp1[0] = arr[0];
        /**
         * 取当前元素（包含）之前的一串连续元素之和和当前元素的较大值
         */
        dp1[1] = Math.max(dp1[0] + arr[1], arr[1]);
        /**
         * 因为必须删除一个元素，dp2[0]不存在，dp2[1]为删除第一个元素或删除第二个元素后的较大值
         */
        dp2[1] = Math.max(arr[0], arr[1]);
        /**
         * dp2[1]一定比dp1[0]大，不用比较dp1[0]
         */
        result = Math.max(result, dp2[1]);
        result = Math.max(result, dp1[1]);
        /**
         * 遍历数组，同时保存每一轮操作后的子数组最大和
         */
        for (int i = 2; i < length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            result = Math.max(result, dp1[i]);
            dp2[i] = Math.max(dp2[i - 1] + arr[i], dp1[i - 1]);
            result = Math.max(result, dp2[i]);
        }
        return result;
    }
}
