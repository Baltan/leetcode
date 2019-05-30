package leetcode.algorithms;

/**
 * Description: 136. Single Number
 *
 * @author Baltan
 * @date 2017/12/29 20:10
 */
public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 4, 2, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 3, 4, 4, 1}));
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 4, 2, 3}));
    }


    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            /**
             * 原理：
             * 0 ^ n = n
             * n ^ n = 0
             */
            result ^= num;
        }
        return result;
    }
}
