package leetcode.algorithms;

/**
 * Description: 1748. Sum of Unique Elements
 *
 * @author Baltan
 * @date 2022/7/27 09:24
 */
public class SumOfUnique {
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
        System.out.println(sumOfUnique(new int[]{1, 1, 1, 1, 1}));
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 4, 5}));
    }

    public static int sumOfUnique(int[] nums) {
        int result = 0;
        /**
         * 根据题意，nums[i]∈[1,100]，countArray[i]表示i在nums中出现的次数
         */
        int[] countArray = new int[101];

        for (int num : nums) {
            countArray[num]++;
        }

        for (int i = 0; i < 101; i++) {
            /**
             * 在nums中出现正好一次的数字
             */
            if (countArray[i] == 1) {
                result += i;
            }
        }
        return result;
    }
}
