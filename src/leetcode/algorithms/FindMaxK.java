package leetcode.algorithms;

/**
 * Description: 2441. Largest Positive Integer That Exists With Its Negative
 *
 * @author Baltan
 * @date 2023/2/9 09:50
 */
public class FindMaxK {
    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println(findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
    }

    public static int findMaxK(int[] nums) {
        /**
         * 根据题意，nums[i]∈[-1000,1000]
         */
        int max = 1000;
        /**
         * positiveCounts[i]表示数组nums中正数i的个数
         */
        int[] positiveCounts = new int[max + 1];
        /**
         * negativeCounts[i]表示数组nums中负数-i的个数
         */
        int[] negativeCounts = new int[max + 1];

        for (int num : nums) {
            if (num > 0) {
                positiveCounts[num]++;
            } else {
                negativeCounts[-num]++;
            }
        }

        for (int i = max; i > 0; i--) {
            /**
             * 当正数i和负数-i在数组nums中都存在时，直接返回i
             */
            if (positiveCounts[i] > 0 && negativeCounts[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
