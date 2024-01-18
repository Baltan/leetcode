package leetcode.algorithms;

/**
 * Description: 3005. Count Elements With Maximum Frequency
 *
 * @author baltan
 * @date 2024/1/18 09:32
 */
public class MaxFrequencyElements {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        System.out.println(maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maxFrequencyElements(int[] nums) {
        int result = 0;
        /**
         * 出现次数最多的数字的频数
         */
        int maxFrequency = 0;
        /**
         * frequencies[i]表示数字i在数组nums中的频数，根据题意，i∈[1,100]
         */
        int[] frequencies = new int[101];

        for (int num : nums) {
            frequencies[num]++;
            maxFrequency = Math.max(maxFrequency, frequencies[num]);
        }

        for (int frequency : frequencies) {
            result += frequency == maxFrequency ? maxFrequency : 0;
        }
        return result;
    }
}
