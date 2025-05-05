package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
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
        /**
         * 出现频率最高的回答出现的天数
         */
        int maxCount = Integer.MIN_VALUE;
        /**
         * 回答 -> 出现该回答的天数
         */
        Map<String, Integer> countMap = new HashMap<>();

        for (List<String> response : responses) {
            /**
             * 先对当天的所有回答去重后，再统计当前各个回答出现的天数
             */
            for (String s : new HashSet<>(response)) {
                countMap.merge(s, 1, Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey().compareTo(result) < 0)) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return result;
    }
}
