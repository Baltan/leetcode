package leetcode.algorithms;

/**
 * Description: 2917. Find the K-or of an Array
 *
 * @author Baltan
 * @date 2023/11/5 01:18
 */
public class FindKOr {
    public static void main(String[] args) {
        System.out.println(findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        System.out.println(findKOr(new int[]{2, 12, 1, 11, 4, 5}, 6));
        System.out.println(findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1));
    }

    public static int findKOr(int[] nums, int k) {
        int result = 0;
        /**
         * counts[i]表示数组nums中所有元素的二进制值从低到高第i位为1的元素的个数
         */
        int[] counts = new int[32];
        int weight = 1;

        for (int num : nums) {
            int bit = 0;

            while (num != 0) {
                /**
                 * 判断num从低到高第bit位是否为1
                 */
                counts[bit++] += num & 1;
                num >>= 1;
            }
        }

        for (int count : counts) {
            if (count >= k) {
                result += weight;
            }
            weight <<= 1;
        }
        return result;
    }
}
