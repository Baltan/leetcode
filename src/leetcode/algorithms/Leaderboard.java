package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1244. Design A Leaderboard
 *
 * @author Baltan
 * @date 2019-11-03 18:04
 */
public class Leaderboard {
    /**
     * 保存每个参赛者和他的分数
     */
    private Map<Integer, Integer> playerMap;
    /**
     * 保存每档分数下，获得该得分的选手ID
     */
    private Map<Integer, Set<Integer>> scoreMap;

    public Leaderboard() {
        playerMap = new HashMap<>();
        /**
         * 将scoreMap按照分数降序排列
         */
        scoreMap = new TreeMap<>((x, y) -> y - x);
    }

    public void addScore(int playerId, int score) {
        if (playerMap.containsKey(playerId)) {
            int oldScore = playerMap.get(playerId);
            int newScore = oldScore + score;
            playerMap.put(playerId, newScore);
            scoreMap.get(oldScore).remove(new Integer(playerId));
            scoreMap.putIfAbsent(newScore, new HashSet<>());
            scoreMap.get(newScore).add(playerId);
        } else {
            playerMap.put(playerId, score);
            scoreMap.putIfAbsent(score, new HashSet<>());
            scoreMap.get(score).add(playerId);
        }
    }

    public int top(int K) {
        int total = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : scoreMap.entrySet()) {
            if (K == 0) {
                break;
            }

            int score = entry.getKey();
            int count = entry.getValue().size();

            if (count < K) {
                total += count * score;
                K -= count;
            } else {
                total += K * score;
                K = 0;
            }
        }
        return total;
    }

    public void reset(int playerId) {
        int score = playerMap.get(playerId);
        playerMap.remove(playerId);
        scoreMap.get(score).remove(new Integer(playerId));
    }

    public static void main(String[] args) {
        Leaderboard leaderboard1 = new Leaderboard();
        leaderboard1.addScore(1, 73);
        leaderboard1.addScore(2, 56);
        leaderboard1.addScore(3, 39);
        leaderboard1.addScore(4, 51);
        leaderboard1.addScore(5, 4);
        System.out.println(leaderboard1.top(1));
        leaderboard1.reset(1);
        leaderboard1.reset(2);
        leaderboard1.addScore(2, 51);
        System.out.println(leaderboard1.top(3));
    }
}
