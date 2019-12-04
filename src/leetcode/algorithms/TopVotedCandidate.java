package leetcode.algorithms;

import java.util.*;

/**
 * Description: 911. Online Election
 *
 * @author Baltan
 * @date 2019-12-04 09:01
 */
public class TopVotedCandidate {
    /**
     * [i,j]保存某个投票时刻i的得票领先者为j
     */
    private List<int[]> states;
    /**
     * 保存候选人的得票数
     */
    private Map<Integer, Integer> voteCount;
    /**
     * 当前得票领先者的得票数
     */
    private int currentMost;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.states = new ArrayList<>(persons.length);
        this.voteCount = new HashMap<>();
        vote(persons, times);
    }

    /**
     * 完成投票
     *
     * @param persons
     * @param times
     */
    public void vote(int[] persons, int[] times) {
        int length = persons.length;

        for (int i = 0; i < length; i++) {
            /**
             * 当前得票人
             */
            int person = persons[i];
            /**
             * 当前投票时刻
             */
            int time = times[i];
            /**
             * 该时刻投票完成后，当前得票人的得票数
             */
            int personVoteCount = voteCount.getOrDefault(person, 0) + 1;
            /**
             * 该时刻投票前，得票领先者的得票数
             */
            int mostVoteCount = voteCount.getOrDefault(currentMost, 0);
            voteCount.put(person, personVoteCount);
            /**
             * 如果当前得票人的得票数不少于之前得票领先者的得票数了，则当前得票人成为得票领先着，更新当前得票领
             * 先者的得票数，并保存下当前时刻的得票领先着
             */
            if (personVoteCount >= mostVoteCount) {
                states.add(new int[]{time, person});
                currentMost = person;
            } else {
                states.add(new int[]{time, currentMost});
            }
        }
    }

    public int q(int t) {
        /**
         * 最后一次投票后的状态
         */
        int[] eventualState = states.get(states.size() - 1);
        /**
         * 最后一次投票的时刻
         */
        int eventualTime = eventualState[0];
        /**
         * 如果t时刻不早于最后一次投票的时刻，直接返回最后一次投票后的得票领先者
         */
        if (t >= eventualTime) {
            return eventualState[1];
        }

        int loIndex = 0;
        int hiIndex = states.size() - 1;
        /**
         * 二分查找t时刻的得票领先者
         */
        while (true) {
            int midIndex = (loIndex + hiIndex) / 2;
            int[] state = states.get(midIndex);

            if (state[0] < t) {
                loIndex = midIndex + 1;
                /**
                 * 如果下一投票时刻loIndex晚于t时刻，则当前时刻midIndex的得票领先者就是t时刻的得票领先者
                 */
                if (states.get(loIndex)[0] > t) {
                    return state[1];
                }
            } else if (state[0] > t) {
                hiIndex = midIndex - 1;
                /**
                 * 如果前一投票时刻hiIndex早于t时刻，则前一投票时刻hiIndex的得票领先者就是t时刻的得票领先者
                 */
                if (states.get(hiIndex)[0] < t) {
                    return states.get(hiIndex)[1];
                }
            } else {
                /**
                 * 如果当前时刻midIndex等于t时刻，直接返回当前时刻的得票领先者
                 */
                return state[1];
            }
        }
    }

    public static void main(String[] args) {
        int[] persons1 = {0, 1, 1, 0, 0, 1, 0};
        int[] times1 = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate candidate1 = new TopVotedCandidate(persons1, times1);

        for (int i = 0; i <= 31; i++) {
            System.out.println(i + "时刻的领先者：" + candidate1.q(i));
        }
    }
}
