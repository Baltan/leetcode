package leetcode.algorithms;

/**
 * Description: 2302. Count Subarrays With Score Less Than K
 *
 * @author Baltan
 * @date 2024/7/27 15:50
 */
public class CountSubarrays2 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
        System.out.println(countSubarrays(new int[]{1, 1, 1}, 5));
    }

    public static long countSubarrays(int[] nums, long k) {
        long result = 0L;
        /**
         * prefixSums[i]表示数组nums前i个元素的和
         */
        long[] prefixSums = new long[nums.length + 1];
        /**
         * 对于数组nums中的某个元素而言，符合要求的子数组的最后一个元素索引值不可能大于rightmost
         */
        int rightmost = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            /**
             * 如果元素nums[i]本身就不小于k，则包含它的任意子数组的得分都不小于k，所以对于索引值小于i的元素而言，如果存在符合要求的子数组，
             * 则子数组的最后一个元素肯定在nums[i]左侧，即索引值小于rightmost
             */
            if (nums[i] >= k) {
                rightmost--;
                continue;
            }
            int lo = i;
            int hi = rightmost;
            /**
             * 在数组nums中二分查找nums[i]右侧最靠右的元素nums[j]，使得子数组[nums[i],nums[i+1],……,nums[j]]的得分严格小于k
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                /**
                 * 子数组[nums[i],nums[i+1],……,nums[mid]]的得分
                 */
                long score = (prefixSums[mid + 1] - prefixSums[i]) * (mid - i + 1);

                if (score < k) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            result += lo - i + 1;
        }
        return result;
    }
}
