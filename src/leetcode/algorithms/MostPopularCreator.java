package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2456. Most Popular Video Creator
 *
 * @author Baltan
 * @date 2022/11/30 11:23
 */
public class MostPopularCreator {
    public static void main(String[] args) {
        String[] creators1 = {"alice", "bob", "alice", "chris"};
        String[] ids1 = {"one", "two", "three", "four"};
        int[] views1 = {5, 10, 5, 4};
        System.out.println(mostPopularCreator(creators1, ids1, views1));

        String[] creators2 = {"alice", "alice", "alice"};
        String[] ids2 = {"a", "b", "c"};
        int[] views2 = {1, 2, 2};
        System.out.println(mostPopularCreator(creators2, ids2, views2));
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        /**
         * 创作者 -> {播放量 -> 视频id列表}
         */
        Map<String, TreeMap<Integer, List<String>>> creatorMap = new HashMap<>();
        /**
         * 创作者 -> 视频总播放量
         */
        Map<String, Long> viewSumMap = new HashMap<>();
        /**
         * 最大总播放量
         */
        long maxView = Long.MIN_VALUE;
        int length = creators.length;

        for (int i = 0; i < length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            TreeMap<Integer, List<String>> viewMap = creatorMap.computeIfAbsent(creator, x -> new TreeMap<>());
            List<String> idList = viewMap.computeIfAbsent(view, x -> new ArrayList<>());
            idList.add(id);
            /**
             * 创作者creator的视频总播放量
             */
            long totalView = viewSumMap.getOrDefault(creator, 0L) + view;
            viewSumMap.put(creator, 1L * totalView);

            if (totalView > maxView) {
                maxView = totalView;
            }
        }

        for (Map.Entry<String, Long> entry : viewSumMap.entrySet()) {
            String creator = entry.getKey();
            long totalView = entry.getValue();
            /**
             * 找到视频总播放量等于最大总播放量的创作者，即流行度最高的创作者
             */
            if (totalView < maxView) {
                continue;
            }
            TreeMap<Integer, List<String>> viewMap = creatorMap.get(creator);
            /**
             * 创作者creator的播放量最大的视频列表
             */
            List<String> idList = viewMap.lastEntry().getValue();
            Collections.sort(idList);
            result.add(Arrays.asList(creator, idList.get(0)));
        }
        return result;
    }
}
