package leetcode.algorithms;

/**
 * Description: 3046. Split the Array
 *
 * @author Baltan
 * @date 2024/3/2 22:32
 */
public class IsPossibleToSplit {
    public static void main(String[] args) {
        System.out.println(isPossibleToSplit(new int[]{1, 1, 2, 2, 3, 4}));
        System.out.println(isPossibleToSplit(new int[]{1, 1, 1, 1}));
    }

    public static boolean isPossibleToSplit(int[] nums) {
        /**
         * counts[i]表示数组nums中数字i的个数，根据题意，i∈[1,100]
         */
        int[] counts = new int[101];

        for (int num : nums) {
            /**
             * 根据抽屉原理，如果数字num在数组nums中出现了三次，则分割后的两个数组中至少有一个存在多个num，则无法按照题意分割数组nums
             */
            if (counts[num] == 2) {
                return false;
            }
            counts[num]++;
        }
        return true;
    }
}
