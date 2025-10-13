package leetcode.algorithms;

/**
 * Description: 3663. Find The Least Frequent Digit
 *
 * @author Baltan
 * @date 2025/10/13 23:17
 */
public class GetLeastFrequentDigit {
    public static void main(String[] args) {
        System.out.println(getLeastFrequentDigit(1553322));
        System.out.println(getLeastFrequentDigit(723344511));
    }

    public static int getLeastFrequentDigit(int n) {
        int result = -1;
        /**
         * n中出现次数最少的数字出现的频数
         */
        int minFrequency = Integer.MAX_VALUE;
        /**
         * counts[i]表示数字i在n中出现的次数
         */
        int[] counts = new int[10];

        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0 && (counts[i] < minFrequency || (counts[i] == minFrequency && i < result))) {
                minFrequency = counts[i];
                result = i;
            }
        }
        return result;
    }
}
