package leetcode.algorithms;

/**
 * Description: 795. Number of Subarrays with Bounded Maximum
 *
 * @author Baltan
 * @date 2020-02-17 13:26
 */
public class NumSubarrayBoundedMax {
    public static void main(String[] args) {
        int[] A1 = {2, 1, 4, 3};
        System.out.println(numSubarrayBoundedMax(A1, 2, 3));

        int[] A2 =
                {2, 4, 6, 7, 7, 7, 8, 3, 5, 6, 8, 3, 5, 9, 3, 4, 2, 5, 8, 9, 5, 3, 5, 9, 3, 5, 8, 5, 7, 8, 5,
                        6};
        System.out.println(numSubarrayBoundedMax(A2, 3, 7));
    }

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;
        int length = A.length;
        /**
         * 遍历到当前索引为止，最后一个大于R的元素的索引
         */
        int indexGreaterThanR = -1;
        /**
         * 遍历到当前索引位置，最后一个大于等于L并且小于等于R的元素的索引
         */
        int indexBetweenLAndR = -1;
        /**
         * 逐一将每个元素当做子数组的最后一个元素，判断在这种情况下，有多少子数组符合要求
         */
        for (int i = 0; i < length; i++) {
            /**
             * 如果当前元素（即子数组的最后一个元素）大于R，则这种情况下的所有子数组都不符合要求
             */
            if (A[i] > R) {
                indexGreaterThanR = i;
            } else if (A[i] >= L && A[i] <= R) {
                /**
                 * 如果当前元素（即子数组的最后一个元素）大于等于L并且小于等于R，则这种情况下逐
                 * 一在子数组的左侧添加之前的元素构成不同的子数组，直到某个元素大于R为止，则以
                 * (indexGreaterThanR,i]这段区间内的元素作为第一个元素的子数组都是符合要求的，
                 * 共有i-indexGreaterThanR个子数组
                 */
                indexBetweenLAndR = i;
                result += (i - indexGreaterThanR);
            } else {
                /**
                 * 如果当前元素（即子数组的最后一个元素）小于L，则这种情况下如果最后一个大于R的
                 * 元素的索引小于最后一个大于等于L并且小于等于R的元素的索引，则以
                 * (indexGreaterThanR,indexBetweenLAndR]这段区间内的元素作为第一个元素的子
                 * 数组都是符合要求的，共有indexBetweenLAndR-indexGreaterThanR个子数组
                 */
                if (indexBetweenLAndR > indexGreaterThanR) {
                    result += (indexBetweenLAndR - indexGreaterThanR);
                }
            }
        }
        return result;
    }
}
