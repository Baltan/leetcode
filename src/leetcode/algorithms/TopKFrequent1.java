package leetcode.algorithms;

import java.util.*;

/**
 * Description: 692. Top K Frequent Words
 *
 * @author Baltan
 * @date 2019-10-03 10:27
 */
public class TopKFrequent1 {
    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words1, 2));

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Queue<String>> map1 = new TreeMap<>((k1, k2) -> k2 - k1);
        /**
         * 统计每个单词出现的频数
         */
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        /**
         * 统计每个频数下的单词，频数按递增顺序排列，统一频数下的单词按递增顺序排列
         */
        for (String word : map.keySet()) {
            int frequency = map.get(word);
            map1.putIfAbsent(frequency, new PriorityQueue<>());
            map1.get(frequency).offer(word);
        }
        /**
         * 找出出现频数最高的k个单词（不同的单词有相同出现频率，按字母顺序排序）
         */
        for (int frequency : map1.keySet()) {
            Queue<String> queue = map1.get(frequency);

            while (k > 0 && !queue.isEmpty()) {
                result.add(queue.poll());
                k--;
            }

            if (k == 0) {
                return result;
            }
        }
        return result;
    }
}
