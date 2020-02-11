package leetcode.algorithms;

/**
 * Description: 649. Dota2 Senate
 *
 * @author Baltan
 * @date 2020-02-11 12:42
 */
public class PredictPartyVictory {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RRRDDD"));
        System.out.println(predictPartyVictory("RRRRDDDD"));
        System.out.println(predictPartyVictory("RDDRRDDR"));
        System.out.println(predictPartyVictory("RDRDRDDRDDRRDDRDDRRDRRD"));
        System.out.println(predictPartyVictory("DRDRRRDDDDRRDRRRDRRDRRDR"));
        System.out.println(predictPartyVictory(
                "DRRDRRDDRRDRRDDRDDRRDRDDRDDRDRDDDDRRDRDRDRDDRRDRDRDRDRDRRRRRDDDRDDDRRRDRR"));
    }

    public static String predictPartyVictory(String senate) {
        /**
         * Radiant阵营人数
         */
        int radiantCount = 0;
        /**
         * Dire阵营人数
         */
        int direCount = 0;
        int length = senate.length();
        /**
         * loseRights[i]标记第i个人是否已经失去了权利
         */
        boolean[] loseRights = new boolean[length];
        /**
         * Radiant阵营手中可以行使的权利次数
         */
        int radiantRightsCount = 0;
        /**
         * Dire阵营手中可以行使的权利次数
         */
        int direRightsCount = 0;

        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                radiantCount++;
            } else {
                direCount++;
            }
        }
        /**
         * 每个参议员的策略都是使对方阵营的下一个要行使权力的参议员丧失权利，直到某一方阵营的参议员
         * 都被丧失权利为止
         */
        while (radiantCount > 0 && direCount > 0) {
            for (int i = 0; i < length; i++) {
                if (loseRights[i]) {
                    continue;
                }

                if (senate.charAt(i) == 'R') {
                    /**
                     * 如果此时对方阵营Dire阵营手中还有未行使的权利，则当前参议员在之前就应该被丧
                     * 失权利了，否则本方阵营Radiant阵营的手中将增加一次权利，用于使对方阵营下一
                     * 个要行使权力的参议员丧失权利
                     */
                    if (direRightsCount > 0) {
                        direRightsCount--;
                        radiantCount--;
                        loseRights[i] = true;
                    } else {
                        radiantRightsCount++;
                    }
                } else {
                    /**
                     * 如果此时对方阵营Radiant阵营手中还有未行使的权利，则当前参议员在之前就应该
                     * 被丧失权利了，否则本方阵营Dire阵营的手中将增加一次权利，用于使对方阵营下一
                     * 个要行使权力的参议员丧失权利
                     */
                    if (radiantRightsCount > 0) {
                        radiantRightsCount--;
                        direCount--;
                        loseRights[i] = true;
                    } else {
                        direRightsCount++;
                    }
                }
            }
        }
        return radiantCount == 0 ? "Dire" : "Radiant";
    }
}
