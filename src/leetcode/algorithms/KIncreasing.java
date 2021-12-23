package leetcode.algorithms;

/**
 * Description: 2111. Minimum Operations to Make the Array K-Increasing
 *
 * @author Baltan
 * @date 2021/12/22 19:30
 */
public class KIncreasing {
    public static void main(String[] args) {
        System.out.println(kIncreasing(new int[]{2, 2, 2, 2, 2, 1, 1, 4, 4, 3, 3, 3, 3, 3}, 1));
        System.out.println(kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
        System.out.println(kIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
        System.out.println(kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-k-increasing/solution/shi-shu-zu-k-di-zeng-de-zui-shao-cao-zuo-3e62/"></a>
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kIncreasing(int[] arr, int k) {
        int result = 0;

        for (int i = 0; i < k; i++) {
            /**
             * 数组arr中起始索引为i，步长为k的子数组的长度
             */
            int length = (arr.length - 1 - i) / k + 1;
            int index = 0;
            /**
             * 数组arr中对应的索引位置
             */
            int startIndex = i;
            /**
             * 数组arr中起始索引为i，步长为k的子数组
             */
            int[] subArr = new int[length];

            while (index < length) {
                subArr[index++] = arr[startIndex];
                startIndex += k;
            }
            /**
             * 子数组的长度减去最长非严格递增子数组的长度即为当前子数组需要修改数字的最小操作次数
             */
            result += length - lengthOfLIS(subArr);
        }
        return result;
    }

    /**
     * 查询数组nums的最长非严格递增子数组
     * 参考：
     * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/"></a>
     *
     * @param nums
     * @return
     * @see LengthOfLIS
     */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        /**
         * d[i]表示长度为i的非严格递增子数组的最后一个元素的大小
         */
        int[] d = new int[length + 1];
        /**
         * 非严格递增子数组的长度
         */
        int lengthOfLIS = 1;
        /**
         * 数组nums的第一个元素构成一个长度为1的非严格递增子数组
         */
        d[1] = nums[0];

        for (int i = 1; i < length; i++) {
            /**
             * 如果nums[i]大于等于非严格递增子数组d中的最后一个元素，则可以使非严格递增子数组的长度增加1，否则通过二分查找得到
             * 非严格递增子数组中第一个大于nums[i]的数字，用nums[i]替换这个数字，使得非严格递增子数组中的数字尽可能小，从而后
             * 面拼接得到更长非严格递增子数组的概率更大
             */
            if (nums[i] >= d[lengthOfLIS]) {
                lengthOfLIS++;
                d[lengthOfLIS] = nums[i];
            } else {
                int index = binarySearch(d, lengthOfLIS, nums[i]);
                d[index] = nums[i];
            }
        }
        return lengthOfLIS;
    }

    /**
     * 在数组d中找到第一个比target大的数，返回索引位置
     *
     * @param d
     * @param hi
     * @param target
     * @return
     */
    public static int binarySearch(int[] d, int hi, int target) {
        int lo = 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (d[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
