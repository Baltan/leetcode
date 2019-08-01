package leetcode.algorithms;

import java.util.*;

/**
 * Description: 332. Reconstruct Itinerary
 *
 * @author Baltan
 * @date 2019-08-01 09:16
 */
public class FindItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets1 = Arrays.asList(Arrays.asList(new String[]{"MUC", "LHR"}),
                Arrays.asList(new String[]{"JFK", "MUC"}), Arrays.asList(new String[]{"SFO", "SJC"}),
                Arrays.asList(new String[]{"LHR", "SFO"}));
        System.out.println(findItinerary(tickets1));

        List<List<String>> tickets2 = Arrays.asList(Arrays.asList(new String[]{"JFK", "SFO"}),
                Arrays.asList(new String[]{"JFK", "ATL"}), Arrays.asList(new String[]{"SFO", "ATL"}),
                Arrays.asList(new String[]{"ATL", "JFK"}), Arrays.asList(new String[]{"ATL", "SFO"}));
        System.out.println(findItinerary(tickets2));

        List<List<String>> tickets3 = Arrays.asList(Arrays.asList(new String[]{"JFK", "KUL"}),
                Arrays.asList(new String[]{"JFK", "NRT"}), Arrays.asList(new String[]{"NRT", "JFK"}));
        System.out.println(findItinerary(tickets3));

        List<List<String>> tickets4 = Arrays.asList(Arrays.asList(new String[]{"EZE", "TIA"}),
                Arrays.asList(new String[]{"EZE", "HBA"}), Arrays.asList(new String[]{"AXA", "TIA"}),
                Arrays.asList(new String[]{"JFK", "AXA"}),
                Arrays.asList(new String[]{"ANU", "JFK"}), Arrays.asList(new String[]{"ADL", "ANU"}),
                Arrays.asList(new String[]{"TIA", "AUA"}),
                Arrays.asList(new String[]{"ANU", "AUA"}), Arrays.asList(new String[]{"ADL", "EZE"}),
                Arrays.asList(new String[]{"ADL", "EZE"}),
                Arrays.asList(new String[]{"EZE", "ADL"}), Arrays.asList(new String[]{"AXA", "EZE"}),
                Arrays.asList(new String[]{"AUA", "AXA"}),
                Arrays.asList(new String[]{"JFK", "AXA"}), Arrays.asList(new String[]{"AXA", "AUA"}),
                Arrays.asList(new String[]{"AUA", "ADL"}),
                Arrays.asList(new String[]{"ANU", "EZE"}), Arrays.asList(new String[]{"TIA", "ADL"}),
                Arrays.asList(new String[]{"EZE", "ANU"}),
                Arrays.asList(new String[]{"AUA", "ANU"}));
        System.out.println(findItinerary(tickets4));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        String start = "JFK";
        /**
         * 将每个出发点作为key，该出发点可以到达的目的地加入到List中作为value
         */
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new LinkedList<>());
            map.get(from).add(to);
        }
        /**
         * 将各个出发点可以到达的目的地按照字典顺序升序排列
         */
        for (List<String> destinations : map.values()) {
            Collections.sort(destinations);
        }

        result.add(start);
        dfs(result, map, start);
        return result;
    }

    public static void dfs(List<String> result, Map<String, List<String>> map, String from) {
        List<String> destinations = map.get(from);
        /**
         * 如果当前出发点没有目的地可以到达，说明当前行程安排走不通，直接返回，尝试其他行程安排
         */
        if (destinations == null) {
            return;
        }
        /**
         * 遍历当前出发点可能到达的每一个目的地
         */
        for (String destination : destinations) {
            result.add(destination);
            /**
             * 处理当前出发点可以到达的目的地List，重新加入map中，用于后面的递归
             */
            if (destinations.size() == 1) {
                map.remove(from);
            } else {
                List<String> destinationsCopy = new LinkedList<>(destinations);
                destinationsCopy.remove(destination);
                map.put(from, destinationsCopy);
            }
            /**
             * 递归
             */
            dfs(result, map, destination);
            /**
             * 如果map为空了，说明没有机票了，直接返回
             */
            if (map.isEmpty()) {
                return;
            }
            /**
             * 当前出发点的下一站如果是当前目的地，行程安排走不通，将当前目的地从结果List最后移除
             */
            result.remove(result.size() - 1);
            /**
             * 还原map中当前出发点可以到达的目的地List，用于后面递归
             */
            map.put(from, destinations);
        }
    }
}
