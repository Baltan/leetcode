package leetcode.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 3527. Find the Most Common Response
 *
 * @author Baltan
 * @date 2025/5/5 16:56
 */
public class FindCommonResponse {
    public static void main(String[] args) {
        System.out.println(findCommonResponse(List.of(
                List.of("good", "ok", "good", "ok"),
                List.of("ok", "bad", "good", "ok", "ok"),
                List.of("good"),
                List.of("bad"))));
        System.out.println(findCommonResponse(List.of(
                List.of("good", "ok", "good"),
                List.of("ok", "bad"),
                List.of("bad", "notsure"),
                List.of("great", "good"))));
    }

    public static String findCommonResponse(List<List<String>> responses) {
        String result = "";
        int maxCount = Integer.MIN_VALUE;
        int days = responses.size();
        Map<String, Condition> conditionMap = new HashMap<>();

        for (int i = 0; i < days; i++) {
            for (String response : responses.get(i)) {
                Condition condition = conditionMap.computeIfAbsent(response, x -> new Condition(days));

                if (!condition.isVisited[i]) {
                    condition.isVisited[i] = true;
                    condition.count++;
                }
            }
        }

        for (Map.Entry<String, Condition> entry : conditionMap.entrySet()) {
            if (entry.getValue().count > maxCount || (entry.getValue().count == maxCount && entry.getKey().compareTo(result) < 0)) {
                result = entry.getKey();
                maxCount = entry.getValue().count;
            }
        }
        return result;
    }

    public static class Condition {
        private int count;
        private final boolean[] isVisited;

        public Condition(int days) {
            this.count = 0;
            this.isVisited = new boolean[days];
        }
    }
}
