package leetcode.algorithms;

/**
 * Description: Pairs of Songs With Total Durations Divisible by 60
 *
 * @author Baltan
 * @date 2019-03-18 10:29
 */
public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
        System.out.println(numPairsDivisibleBy60(new int[]{0, 60, 90, 150, 180, 90}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        int[] remainderArray = new int[60];

        for (int num : time) {
            int remainder = num % 60;
            remainderArray[remainder]++;
        }

        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) {
                pairs += (remainderArray[i] * (remainderArray[i] - 1) / 2);
            } else {
                pairs += (remainderArray[i] * remainderArray[60 - i]);
            }
        }
        return pairs;
    }
}
