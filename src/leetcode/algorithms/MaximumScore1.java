package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1753. Maximum Score From Removing Stones
 *
 * @author Baltan
 * @date 2022/7/24 11:57
 */
public class MaximumScore1 {
    public static void main(String[] args) {
        System.out.println(maximumScore(6, 2, 1));
        System.out.println(maximumScore(2, 4, 6));
        System.out.println(maximumScore(4, 4, 6));
        System.out.println(maximumScore(1, 8, 8));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-score-from-removing-stones/solution/c0msjian-dan-yi-dong-si-lu-by-zhi-xun-du-trzw/"></a>
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);

        if (arr[0] + arr[1] <= arr[2]) {
            /**
             * 每次都取a堆和c堆或者b堆和c堆，直到最后只剩下c堆有石头，或者三堆都没有石头
             */
            return arr[0] + arr[1];
        } else {
            /**
             * 一开始每次先取a堆和b堆，直到a堆和b堆石头总数不大于c堆，可以取的次数为石头数量之差除以2，向上取整
             */
            int score = (arr[0] + arr[1] - arr[2] + 1) / 2;
            arr[0] -= score;
            arr[1] -= score;
            /**
             * 接下去每次都取a堆和c堆或者b堆和c堆，直到最后只剩下c堆有石头，或者三堆都没有石头
             */
            return score + arr[0] + arr[1];
        }
    }
}
