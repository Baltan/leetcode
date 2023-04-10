package leetcode.algorithms;

/**
 * Description: 2614. Prime In Diagonal
 *
 * @author Baltan
 * @date 2023/4/9 21:51
 */
public class DiagonalPrime {
    public static void main(String[] args) {
        System.out.println(diagonalPrime(new int[][]{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}}));
        System.out.println(diagonalPrime(new int[][]{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}}));
    }

    public static int diagonalPrime(int[][] nums) {
        int result = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            /**
             * 判断主对角线上的数字是否是质数
             */
            if (isPrime(nums[i][i])) {
                result = Math.max(result, nums[i][i]);
            }
            /**
             * 判断副对角线上的数字是否是质数
             */
            if (isPrime(nums[i][length - i - 1])) {
                result = Math.max(result, nums[i][length - i - 1]);
            }
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
