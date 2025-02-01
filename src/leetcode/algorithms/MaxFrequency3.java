package leetcode.algorithms;

/**
 * Description: 3434. Maximum Frequency After Subarray Operation
 *
 * @author baltan
 * @date 2025/2/1 14:48
 */
public class MaxFrequency3 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 3, 4, 5, 6}, 1));
        System.out.println(maxFrequency(new int[]{10, 2, 3, 4, 5, 5, 4, 3, 2, 2}, 10));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-frequency-after-subarray-operation/solutions/3058087/javascript-problem-3434-bian-zou-bian-su-ka3v/"></a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency(int[] nums, int k) {
        /**
         * 初始时，数组nums中元素k的个数
         */
        int kCount = 0;
        /**
         * isExisted[i]表示初始时，数组nums中是否存在元素i
         */
        boolean[] isExisted = new boolean[51];

        for (int num : nums) {
            if (num == k) {
                kCount++;
            }
            isExisted[num] = Boolean.TRUE;
        }
        /**
         * 如果将数组nums本身作为选定的子数组nums[i……j]，再将每个元素都加上0，最终可以得到kCount个元素k
         */
        int result = kCount;
        /**
         * 参考：<a href="https://cloud.tencent.com/developer/article/2482367"></a>
         * 通过Kadane算法，依次判断将某一个子数组nums[i……j]中的所有元素toK变为k后，数组nums中元素k的最大个数
         */
        for (int toK = 1; toK < isExisted.length; toK++) {
            if (!isExisted[toK] || toK == k) {
                continue;
            }
            /**
             * 假设从头开始已遍历过的前缀子数组为nums[0……m]，maxNewKCountSoFar表示在这个前缀子数组中选定一个子数组nums[i……j]，将这个子
             * 数组中的所有元素toK都变为k，如此可以从子数组nums[i……j]中得到元素k的最大个数
             */
            int maxNewKCountSoFar = 0;
            /**
             * 将数组nums的某一个子数组nums[i……j]中的所有元素toK变为k后，子数组中元素k的最大个数
             */
            int maxNewKCount = 0;

            for (int num : nums) {
                /**
                 * 如果元素num为toK，操作后会变为k，使得k的个数加1；如果元素num本身就是k，操作后反而不是k，使得k的个数减1；如果元素num既
                 * 不是k，又不是toK，则对最终数组中k的个数没有影响
                 */
                int newKCount = num == toK ? 1 : (num == k ? -1 : 0);
                /**
                 * 如果从元素num开始一个新的子数组nums[i……j]，则新子数组中最终k的个数为newKCount；如果将元素num追加在之前的子数组之后，
                 * 则最终子数组中k的个数为maxNewKCountSoFar+newKCount，两者取k的个数较多的情况
                 */
                maxNewKCountSoFar = Math.max(newKCount, maxNewKCountSoFar + newKCount);
                /**
                 * 更新子数组nums[i……j]中最终可以得到元素k的最大个数
                 */
                maxNewKCount = Math.max(maxNewKCount, maxNewKCountSoFar);
            }
            /**
             * 初始时，数组nums中元素k的个数为kCount，操作后，子数组nums[i……j]中新增k的最大个数为maxNewKCount，最终数组nums中k的个数
             * 为kCount+maxNewKCount
             */
            result = Math.max(result, kCount + maxNewKCount);
        }
        return result;
    }
}
