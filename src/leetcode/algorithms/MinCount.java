package leetcode.algorithms;

/**
 * Description: LCP 06. 拿硬币
 *
 * @author Baltan
 * @date 2020-05-02 13:22
 */
public class MinCount {
    public static void main(String[] args) {
        System.out.println(minCount(new int[]{4, 2, 1}));
        System.out.println(minCount(new int[]{2, 3, 10}));
    }

    public static int minCount(int[] coins) {
        int result = 0;
        /**
         * 对于每堆硬币总是先两个两个拿，如果最后只剩一个了才只拿一个
         */
        for (int coin : coins) {
            result += (coin + 1) / 2;
        }
        return result;
    }
}
