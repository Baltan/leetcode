package leetcode.algorithms;

import java.util.*;

/**
 * Description: 826. Most Profit Assigning Work
 *
 * @author Baltan
 * @date 2020-02-20 11:03
 */
public class MaxProfitAssignment {
    public static void main(String[] args) {
        int[] difficulty1 = {2, 4, 6, 8, 10};
        int[] profit1 = {10, 20, 30, 40, 50};
        int[] worker1 = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty1, profit1, worker1));

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        System.out.println(maxProfitAssignment(difficulty2, profit2, worker2));

        int[] difficulty3 = {100, 200, 300};
        int[] profit3 = {10, 40, 30};
        int[] worker3 = {400, 400, 400};
        System.out.println(maxProfitAssignment(difficulty3, profit3, worker3));

        int[] difficulty4 =
                {64448, 79457, 42016, 11665, 2469, 91969, 46731, 54320, 5882, 93835, 21708, 50277, 16955,
                        45755, 72327, 12268, 15839, 18850, 10936, 86865, 31179, 70806, 862, 89380, 85395,
                        37685, 35989, 22400, 65446, 89518, 87777, 70913, 94050, 19520, 32338, 6472, 5200,
                        80772, 51039, 17062, 50872, 15560, 72431, 78446, 60361, 6777, 31654, 21757, 14900,
                        97226};
        int[] profit4 =
                {55170, 24810, 99019, 14644, 60739, 86776, 3656, 85057, 88453, 42411, 63691, 60967, 64863,
                        28688, 57126, 98045, 43420, 1719, 81693, 43774, 89525, 86382, 83018, 5553, 3184, 1542,
                        40108, 39794, 79829, 30024, 96082, 41089, 60930, 38049, 63082, 94078, 7062, 33691,
                        18438, 35911, 30367, 21478, 97103, 32558, 53184, 24942, 53365, 48591, 38949, 88794};
        int[] worker4 =
                {1934, 65871, 592, 76268, 61862, 74422, 53430, 95603, 70312, 43409, 30258, 54173, 99791,
                        21407, 42909, 96179, 64854, 77416, 24428, 68409, 21827, 4982, 72940, 99041, 52118,
                        94881, 31780, 84764, 7679, 56624, 41536, 87404, 39901, 61306, 81696, 61301, 46775,
                        19110, 95183, 84615, 2265, 56050, 69873, 14041, 41356, 18511, 15227, 5037, 23642,
                        36803};
        System.out.println(maxProfitAssignment(difficulty4, profit4, worker4));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        int length = difficulty.length;
        /**
         * 题目约束的最大难度为100000
         */
        int difficultyThreshold = 100001;
        /**
         * maxProfits[i]为难度i的工作的最大收益
         */
        int[] maxProfits = new int[difficultyThreshold + 1];
        /**
         * 保存难度和收益的映射关系，如果出现难度更大但收益却更小的工作，则不保存这份工作，这种情
         * 况下可以保证难度更大的工作收益一定也更大
         */
        Map<Integer, Integer> jobs = new HashMap<>();
        /**
         * 遍历所有工作，保存已经遍历过的最大收益
         */
        int currentMaxProfit = 0;

        for (int i = 0; i < length; i++) {
            int currentDifficulty = difficulty[i];
            int currentProfit = profit[i];
            /**
             * 更新每个难度下工作的最大收益
             */
            maxProfits[currentDifficulty] = Math.max(maxProfits[currentDifficulty], currentProfit);
        }

        for (int i = 0; i <= difficultyThreshold; i++) {
            /**
             * 如果当前工作的收益比已经遍历过的最大收益currentMaxProfit小，但是当前工作的难度
             * 却更大，显然有更划算的工作做，此时不保存这份工作
             */
            if (maxProfits[i] > currentMaxProfit) {
                jobs.put(i, maxProfits[i]);
                currentMaxProfit = maxProfits[i];
            }
        }
        /**
         * 所有备选工作的难度列表，并且进行升序排列
         */
        List<Integer> difficultyList = new ArrayList<>(jobs.keySet());
        Collections.sort(difficultyList);
        /**
         * 备选工作的最低难度
         */
        int minDifficulty = difficultyList.get(0);
        /**
         * 备选工作的最高难度
         */
        int maxDifficulty = difficultyList.get(difficultyList.size() - 1);

        for (int limit : worker) {
            /**
             * 如果工人能力超过备选工作的最高难度工作，则做最难的工作能获得最高收益；如果工人能
             * 力低于备选工作的最低难度，则所有工作他都做不了，不能获得收益；否则备选工作难度列
             * 表中二分查找不大于工人能力的最高难度
             */
            if (limit >= maxDifficulty) {
                result += jobs.get(maxDifficulty);
            } else if (limit >= minDifficulty) {
                int max = help(difficultyList, limit);
                result += jobs.get(max);
            }
        }
        return result;
    }

    /**
     * 二分查找不大于工人能力limit的最高难度
     *
     * @param difficultyList
     * @param limit
     * @return
     */
    public static int help(List<Integer> difficultyList, int limit) {
        int lo = 0;
        int hi = difficultyList.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (difficultyList.get(mid) > limit) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return difficultyList.get(hi);
    }
}
