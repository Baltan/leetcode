package leetcode.algorithms;

/**
 * Description: 3577. Count the Number of Computer Unlocking Permutations
 *
 * @author baltan
 * @date 2025/6/25 09:29
 */
public class CountPermutations {
    public static void main(String[] args) {
        System.out.println(countPermutations(new int[]{1, 2, 3}));
        System.out.println(countPermutations(new int[]{3, 3, 3, 4, 4, 4}));
    }

    public static int countPermutations(int[] complexity) {
        long result = 1L;
        int mod = 1000000007;
        int positions = complexity.length - 1;
        /**
         * 如果存在密码复杂度小于等于complexity[0]的计算机，则它不可能被编号为0的计算机和其他任何计算机解锁，直接返回0。否则编号为0的计算机
         * 可以解锁其他所有计算机，即任意排列都满足要求，排列总数为(complexity.length-1)!
         */
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
            result = result * positions % mod;
            positions--;
        }
        return (int) result;
    }
}
