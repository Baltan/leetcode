package leetcode.algorithms;

/**
 * Description: 1523. Count Odd Numbers in an Interval Range
 *
 * @author Baltan
 * @date 2023/2/17 14:29
 */
public class CountOdds {
    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
        System.out.println(countOdds(8, 10));
        System.out.println(countOdds(3, 3));
        System.out.println(countOdds(4, 4));
    }

    public static int countOdds(int low, int high) {
        /**
         * 大于等于low的最小奇数
         */
        int max = high % 2 == 0 ? high - 1 : high;
        /**
         * 小于等于high的最大奇数
         */
        int min = low % 2 == 0 ? low + 1 : low;
        /**
         * max<min时，说明low=high=一个偶数，返回0
         */
        return max < min ? 0 : (max - min) / 2 + 1;
    }
}
