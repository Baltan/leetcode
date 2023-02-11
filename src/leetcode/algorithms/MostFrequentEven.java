package leetcode.algorithms;

/**
 * Description: 2404. Most Frequent Even Element
 *
 * @author Baltan
 * @date 2023/2/10 21:06
 */
public class MostFrequentEven {
    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));
        System.out.println(mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }

    public static int mostFrequentEven(int[] nums) {
        int result = Integer.MAX_VALUE;
        /**
         * 出现最频繁的偶数元素的频数
         */
        int maxFrequency = 0;
        /**
         * frequencies[i]表示数组nums中元素2i出现的频数，根据题意，nums[i]∈[0,100000]
         */
        int[] frequencies = new int[50001];

        for (int num : nums) {
            if ((num & 1) == 0) {
                /**
                 * 元素num的频数在数组frequencies中的索引
                 */
                int index = num >> 1;
                frequencies[index]++;

                if (frequencies[index] > maxFrequency || (frequencies[index] == maxFrequency && num < result)) {
                    maxFrequency = frequencies[index];
                    result = num;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
