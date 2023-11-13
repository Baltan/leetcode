package leetcode.algorithms;

/**
 * Description: 2928. Distribute Candies Among Children I
 *
 * @author Baltan
 * @date 2023/11/13 23:43
 */
public class DistributeCandies2 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(5, 2));
        System.out.println(distributeCandies(3, 3));
    }

    public static int distributeCandies(int n, int limit) {
        int result = 0;
        /**
         * 穷举：假设三个人得到的糖果数量依次为i、j、k，当i、j、k之和为n，且都不大于limit时，可以得到一种分配方案
         */
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
