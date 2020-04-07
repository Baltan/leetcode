package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 16.15. 珠玑妙算
 *
 * @author Baltan
 * @date 2020-04-07 22:33
 */
public class MasterMind {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(masterMind("RGBY", "GGRR"));
    }

    public static int[] masterMind(String solution, String guess) {
        int[] result = {0, 0};
        /**
         * solutionCount[0]为solution中除去猜中位置，字母"R"出现的次数；
         * solutionCount[1]为solution中除去猜中位置，字母"Y"出现的次数；
         * solutionCount[2]为solution中除去猜中位置，字母"G"出现的次数；
         * solutionCount[3]为solution中除去猜中位置，字母"B"出现的次数。
         */
        int[] solutionCount = new int[4];
        /**
         * guessCount[0]为guess中除去猜中位置，字母"R"出现的次数；
         * guessCount[1]为guess中除去猜中位置，字母"Y"出现的次数；
         * guessCount[2]为guess中除去猜中位置，字母"G"出现的次数；
         * guessCount[3]为guess中除去猜中位置，字母"B"出现的次数。
         */
        int[] guessCount = new int[4];

        for (int i = 0; i < 4; i++) {
            char solutionChar = solution.charAt(i);
            char guessChar = guess.charAt(i);
            /**
             * 如果solution和guess相同索引位置上的字母相同，则为一次猜中
             */
            if (solutionChar == guessChar) {
                result[0]++;
                continue;
            }

            if (solutionChar == 'R') {
                solutionCount[0]++;
            } else if (solutionChar == 'Y') {
                solutionCount[1]++;
            } else if (solutionChar == 'G') {
                solutionCount[2]++;
            } else {
                solutionCount[3]++;
            }

            if (guessChar == 'R') {
                guessCount[0]++;
            } else if (guessChar == 'Y') {
                guessCount[1]++;
            } else if (guessChar == 'G') {
                guessCount[2]++;
            } else {
                guessCount[3]++;
            }
        }
        /**
         * 对于solution其他位置的字母，判断伪猜中的次数，即每个字母在solution和guess出现次数取较小值
         */
        for (int i = 0; i < 4; i++) {
            result[1] += Math.min(solutionCount[i], guessCount[i]);
        }
        return result;
    }
}
