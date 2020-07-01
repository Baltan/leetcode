package leetcode.algorithms;

/**
 * Description: 1493. Longest Subarray of 1's After Deleting One Element
 *
 * @author Baltan
 * @date 2020-07-01 19:35
 */
public class LongestSubarray1 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 0, 0}));
    }

    public static int longestSubarray(int[] nums) {
        int result = 0;
        /**
         * 前一串连续1的个数
         */
        int prev1Count = 0;
        /**
         * 当前连续1的个数
         */
        int curr1Count = 0;
        /**
         * 前一串连续0的个数
         */
        int prev0Count = 0;
        /**
         * 当前连续0的个数
         */
        int curr0Count = 0;

        for (int num : nums) {
            if (num == 1) {
                /**
                 * 此时出现一串1的第一个1
                 */
                if (curr1Count == 0) {
                    /**
                     * prev0Count记录这串1之前的一串0的个数
                     */
                    prev0Count = curr0Count;
                    curr0Count = 0;
                }
                /**
                 * 当前这串1的个数
                 */
                curr1Count++;
                /**
                 * 如果prev0Count少于2，则这串1和前一串1可以通过删除一个0连在一起
                 */
                if (prev0Count < 2) {
                    result = Math.max(result, prev1Count + curr1Count);
                } else {
                    result = Math.max(result, curr1Count);
                }
            } else {
                /**
                 * 此时出现一串0的第一个0
                 */
                if (curr0Count == 0) {
                    /**
                     * prev1Count记录这串0之前的一串1的个数
                     */
                    prev1Count = curr1Count;
                    curr1Count = 0;
                }
                /**
                 * 当前这串0的个数
                 */
                curr0Count++;
            }
        }
        /**
         * 如果result和nums的长度相同，说明nums中都是1，因为必须要删除一个元素，所以result要减1
         */
        return result == nums.length ? result - 1 : result;
    }
}
