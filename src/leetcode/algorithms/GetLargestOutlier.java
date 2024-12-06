package leetcode.algorithms;

/**
 * Description: 3371. Identify the Largest Outlier in an Array
 *
 * @author Baltan
 * @date 2024/12/6 23:05
 */
public class GetLargestOutlier {
    public static void main(String[] args) {
        System.out.println(getLargestOutlier(new int[]{-947, -326, 200, -747}));
        System.out.println(getLargestOutlier(new int[]{2, 3, 5, 10}));
        System.out.println(getLargestOutlier(new int[]{-2, -1, -3, -6, 4}));
        System.out.println(getLargestOutlier(new int[]{1, 1, 1, 1, 1, 5, 5}));
    }

    public static int getLargestOutlier(int[] nums) {
        /**
         * counts[i]表示数组nums中数字i-1000的个数，根据题意，i-1000∈[-1000,1000]
         */
        int[] counts = new int[2001];
        /**
         * 数组nums中所有数字之和
         */
        int sum = 0;

        for (int num : nums) {
            counts[num + 1000]++;
            sum += num;
        }
        /**
         * 从大到小枚举可能的异常值
         */
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 0) {
                continue;
            }
            /**
             * 假设异常值为outlier
             */
            int outlier = i - 1000;
            int leftSum = sum - outlier;
            /**
             * 如果剩余数字中存在特殊数字，因为特殊数字等于数组nums中除异常值和自身外其他所有数字之和，所以数组nums中除异常值外其他所有数字
             * 之和一定为偶数
             */
            if (leftSum % 2 != 0) {
                continue;
            }
            int special = leftSum / 2;
            int specialIndex = special + 1000;
            /**
             * 异常值为outlier时，特殊数字special不在[-1000,1000]范围内，与题意矛盾
             */
            if (specialIndex < 0 || specialIndex >= counts.length) {
                continue;
            }
            /**
             * 如果特殊数字special等于outlier，则数组nums中至少要有两个数字special，否则数组nums中至少有一个special即可
             */
            if ((special != outlier && counts[specialIndex] > 0) || (special == outlier && counts[specialIndex] > 1)) {
                return outlier;
            }
        }
        return 0;
    }
}
