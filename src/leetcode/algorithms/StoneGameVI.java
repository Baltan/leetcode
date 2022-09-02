package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 1686. Stone Game VI
 *
 * @author Baltan
 * @date 2022/8/28 14:04
 * @see PredictTheWinner
 * @see PredictTheWinner1
 * @see StoneGame
 * @see StoneGameII
 * @see StoneGameIII
 * @see StoneGameIX
 * @see StoneGameVII
 */
public class StoneGameVI {
    public static void main(String[] args) {
        int[] aliceValues1 = {1, 3};
        int[] bobValues1 = {2, 1};
        System.out.println(stoneGameVI(aliceValues1, bobValues1));

        int[] aliceValues2 = {1, 2};
        int[] bobValues2 = {3, 1};
        System.out.println(stoneGameVI(aliceValues2, bobValues2));

        int[] aliceValues3 = {2, 4, 3};
        int[] bobValues3 = {1, 6, 7};
        System.out.println(stoneGameVI(aliceValues3, bobValues3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/stone-game-vi/solution/python-tan-xin-by-qubenhao-0vr4/"></a>
     *
     * @param aliceValues
     * @param bobValues
     * @return
     */
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int aliceScore = 0;
        int bobScore = 0;
        int n = aliceValues.length;
        /**
         * indexes中保存n块石头的n个索引值[0,n-1]
         */
        Integer[] indexes = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        /**
         * 将indexes中的n个索引值排序，排序的原则是aliceValues[index]+bobValues[index]最小的索引排在最前面，
         * aliceValues[index]+bobValues[index]最大的索引排在最后面
         */
        Arrays.sort(indexes, (x, y) -> (aliceValues[x] + bobValues[x] - aliceValues[y] - bobValues[y]));
        /**
         * 是否轮到Alice拿石头
         */
        boolean aliceTurn = true;
        /**
         * 对于Alice来说，假设拿了索引值为x的石头，则可以获得aliceValues[x]分，同时Bob失去了拿这块石头的机会，即损失了
         * bobValues[x]分，为了使得自己的得分比Bob尽可能多，Alice应该优先获取aliceValues[x]+bobValues[x]最大的石头。同理
         * Bob应该采取同样的策略
         */
        for (int i = n - 1; i >= 0; i--) {
            int index = indexes[i];

            if (aliceTurn) {
                aliceScore += aliceValues[index];
                aliceTurn = false;
            } else {
                bobScore += bobValues[index];
                aliceTurn = true;
            }
        }
        return aliceScore == bobScore ? 0 : (aliceScore > bobScore ? 1 : -1);
    }
}
