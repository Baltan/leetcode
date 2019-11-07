package leetcode.algorithms;

/**
 * Description: 307. Range Sum Query - Mutable
 *
 * @author Baltan
 * @date 2019-11-07 09:31
 */
public class NumArray1 {
    private int[] nums;
    /**
     * 数组的前缀和数组
     */
    private int[] prefixSum;
    private int length;

    public NumArray1(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        this.prefixSum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        if (i >= length || i < 0) {
            throw new ArrayIndexOutOfBoundsException("i=" + i);
        }

        int old = nums[i];
        nums[i] = val;
        /**
         * 更新数组的前缀和数组
         */
        for (int j = i + 1; j <= length; j++) {
            prefixSum[j] = prefixSum[j] - old + val;
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("i=" + i);
        }

        if (j >= length) {
            throw new ArrayIndexOutOfBoundsException("j=" + j);
        }

        if (i > j) {
            return 0;
        }
        return prefixSum[j + 1] - prefixSum[i];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        NumArray1 numArray1 = new NumArray1(arr1);
        System.out.println(numArray1.sumRange(0, 2));
        numArray1.update(1, 2);
        System.out.println(numArray1.sumRange(0, 2));
    }
}
