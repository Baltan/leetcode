package leetcode.algorithms;

/**
 * Description: 477. Total Hamming Distance
 *
 * @author Baltan
 * @date 2019-07-30 09:23
 */
public class TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums1 = {4, 14, 2};
        System.out.println(totalHammingDistance(nums1));
    }

    public static int totalHammingDistance(int[] nums) {
        int result = 0;
        /**
         * 对于整型32位的每一位，统计数组中的所有数字在该位上0的个数和1的个数，相乘即为该位上的汉明距离总和，
         * 将32位上的汉明距离总和求和，即为结果
         */
        for (int i = 0; i < 32; i++) {
            int count0 = 0;
            int count1 = 0;
            /**
             * 用于确定该位是否为0的比较基准，二进制为1、10、100、1000……10000000000000000000000000000000
             */
            int value = 1 << i;

            for (int num : nums) {
                if ((num & value) == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
            result += count0 * count1;
        }
        return result;
    }
}
