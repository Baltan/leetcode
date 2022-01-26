package leetcode.algorithms;

/**
 * Description: 2145. Count the Hidden Sequences
 *
 * @author Baltan
 * @date 2022/1/26 09:29
 */
public class NumberOfArrays {
    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{1, -3, 4}, 1, 6));
        System.out.println(numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5));
        System.out.println(numberOfArrays(new int[]{4, -7, 2}, 3, 6));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        /**
         * 假设数组hidden的第一个元素是0
         */
        long curr = 0L;
        /**
         * 假设数组hidden的第一个元素是0时，数组hidden中的最小值
         */
        long min = 0;
        /**
         * 假设数组hidden的第一个元素是0时，数组hidden中的最大值
         */
        long max = 0;
        /**
         * 查找假设数组hidden的第一个元素是0时，数组hidden中的最小值和最大值
         */
        for (int difference : differences) {
            curr += difference;
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }
        /**
         * 如果[min,max]包含的范围大于[lower,upper]，则没有符合条件的隐藏数组，否则[lower,lower+(max-min)]……
         * [upper-(max-min),upper]都是满足要求的[hidden_MIN,hidden_MAX]组合
         */
        return max - min > upper - lower ? 0 : (int) ((upper - lower) - (max - min) + 1);
    }
}
