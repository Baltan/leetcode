package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 2350. Shortest Impossible Sequence of Rolls
 *
 * @author Baltan
 * @date 2023/3/2 10:04
 */
public class ShortestSequence {
    public static void main(String[] args) {
        System.out.println(shortestSequence(new int[]{4, 2, 1, 2, 3, 3, 2, 4, 1}, 4));
        System.out.println(shortestSequence(new int[]{1, 1, 2, 2}, 2));
        System.out.println(shortestSequence(new int[]{1, 1, 3, 2, 2, 2, 3, 3}, 4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/shortest-impossible-sequence-of-rolls/solutions/1693351/by-endlesscheng-diiq/"></a>
     *
     * @param rolls
     * @param k
     * @return
     */
    public static int shortestSequence(int[] rolls, int k) {
        int result = 1;
        /**
         * 保存数组rolls的一个子数组中的所有数字
         */
        Set<Integer> set = new HashSet<>();
        /**
         * 循环从数组rolls及其剩余的子数组中找到包含[1,k]的最短前缀，假设能找到x个包含[1,k]的子数组，则长度为x的所有子序列都能通过从每个子数
         * 组中各取一个数得到，而长度为x+1的子序列则不一定，只需要令最后一个数不在数组rolls最后剩下的后缀中即可
         */
        for (int roll : rolls) {
            set.add(roll);

            if (set.size() == k) {
                result++;
                set.clear();
            }
        }
        return result;
    }
}
