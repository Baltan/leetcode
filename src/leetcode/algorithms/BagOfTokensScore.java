package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 948. Bag of Tokens
 *
 * @author Baltan
 * @date 2020-02-27 12:52
 */
public class BagOfTokensScore {
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        int result = 0;
        /**
         * 当前分数
         */
        int score = 0;
        /**
         * 剩余可用的令牌数
         */
        int restCount = tokens.length;
        /**
         * 将所有令牌按照能量值升序排列
         */
        Arrays.sort(tokens);
        /**
         * 始终指向剩余令牌中能量值最低的那个
         */
        int lo = 0;
        /**
         * 始终指向剩余令牌中能量值最高的那个
         */
        int hi = restCount - 1;
        /**
         * 只要可用的令牌数就还有操作的机会。每次操作尽可能先通过损失最小的能量来获得1分，如果能
         * 量值不够，就尝试损失1分来补充最大的能量值
         */
        while (restCount > 0) {
            /**
             * 如果当前能量值足够，就损失最小的能量来获得1分
             */
            if (tokens[lo] <= P) {
                P -= tokens[lo];
                restCount--;
                lo++;
                score += 1;
                result = Math.max(result, score);
            } else {
                /**
                 * 如果当前能量值不够但是分数足够，就损失1分来补充最大的能量
                 */
                if (score > 0) {
                    P += tokens[hi];
                    restCount--;
                    hi--;
                    score -= 1;
                } else {
                    /**
                     * 如果当前能量值和分数都不够，游戏就结束了
                     */
                    break;
                }
            }
        }
        return result;
    }
}
