package leetcode.algorithms;

/**
 * Description: 1512. Number of Good Pairs
 *
 * @author Baltan
 * @date 2020-07-23 23:34
 */
public class NumIdenticalPairs {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        /**
         * count[i]表示当前数字i已经出现过的次数
         */
        int[] count = new int[101];

        for (int num : nums) {
            /**
             * 当前数字num和之前已经出现过的count[num]次num可以构成count[num]个好数对
             */
            result += count[num];
            /**
             * 当前出现过的num的次数加1
             */
            count[num]++;
        }
        return result;
    }
}
