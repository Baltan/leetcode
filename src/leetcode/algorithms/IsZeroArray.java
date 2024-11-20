package leetcode.algorithms;

/**
 * Description: 3355. Zero Array Transformation I
 *
 * @author Baltan
 * @date 2024/11/20 23:34
 * @see IsZeroArray1
 */
public class IsZeroArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 1};
        int[][] queries1 = {{0, 2}};
        System.out.println(isZeroArray(nums1, queries1));

        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {{1, 3}, {0, 2}};
        System.out.println(isZeroArray(nums2, queries2));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        /**
         * 假设存在数组x，其中x[i]表示数组nums中元素nums[i]最多可以被进行减1操作的次数。数组diffs为x的差分数组，其中diffs[0]=x[0],
         * diff[1]=x[1]-x[0],diff[2]=x[2]-x[1],……,diff[i]=x[i]-x[i-1]
         */
        int[] diffs = new int[nums.length + 1];
        int sum = 0;

        for (int[] query : queries) {
            /**
             * 对于query，数组nums中索引值在[query[0],query[1]]区间内的元素都可以被进行一次减1操作
             */
            diffs[query[0]]++;
            diffs[query[1] + 1]--;
        }
        /**
         * 如果存在某个元素nums[i]，最多可以被进行减1操作的次数小于nums[i]，则最终该元素无法变成0，直接返回false
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * 元素nums[i]最多可以被进行减1操作的次数
             */
            sum += diffs[i];

            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
