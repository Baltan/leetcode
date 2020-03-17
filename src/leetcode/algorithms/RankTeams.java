package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1366. Rank Teams by Votes
 *
 * @author Baltan
 * @date 2020-03-17 07:06
 */
public class RankTeams {
    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        System.out.println(rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
        System.out.println(rankTeams(new String[]{"M", "M", "M", "M"}));
    }

    public static String rankTeams(String[] votes) {
        /**
         * 团队数量
         */
        int teamCount = votes[0].length();
        StringBuilder builder = new StringBuilder(teamCount);
        /**
         * 团队名称 -> 团队信息
         */
        Map<Character, Info> infos = new HashMap<>();
        /**
         * 将各个团队按照"排位第一"的得票数降序排列，如果"排位第一"的得票数相同，则按照"排位第二"的得票数降序
         * 排列，如果"排位第二"的得票数相同，则按照"排位第三"的得票数降序排列，以此类推，如果各个排位的得票数
         * 都相同，则按照团队名称的字典顺序升序排列
         */
        Queue<Info> queue = new PriorityQueue<>((x, y) -> {
            for (int i = 0; i < teamCount; i++) {
                if (x.voteCounts[i] > y.voteCounts[i]) {
                    return -1;
                } else if (x.voteCounts[i] < y.voteCounts[i]) {
                    return 1;
                }
            }
            return x.team - y.team;
        });

        for (String vote : votes) {
            for (int i = 0; i < teamCount; i++) {
                /**
                 * 获得"排位第i+1"的票的团队名称
                 */
                char c = vote.charAt(i);
                infos.putIfAbsent(c, new Info(teamCount, c));
                infos.get(c).voteCounts[i]++;
            }
        }
        /**
         * 对各个团队按照得票情况进行排队
         */
        for (Info info : infos.values()) {
            queue.offer(info);
        }

        while (!queue.isEmpty()) {
            builder.append(queue.poll().team);
        }
        return builder.toString();
    }

    private static class Info {
        /**
         * 团队名称
         */
        private char team;
        /**
         * 得票数，voteCounts[0]为"排位第一"的得票数，voteCounts[1]为"排位第二"的得票数，以此类推
         */
        private int[] voteCounts;

        public Info(int teamCount, char team) {
            this.team = team;
            this.voteCounts = new int[teamCount];
        }
    }
}
