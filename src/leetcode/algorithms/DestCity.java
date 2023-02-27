package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: 1436. Destination City
 *
 * @author Baltan
 * @date 2023/2/18 21:05
 */
public class DestCity {
    public static void main(String[] args) {
        System.out.println(destCity(Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"))));
        System.out.println(destCity(Arrays.asList(Arrays.asList("B", "C"), Arrays.asList("D", "B"), Arrays.asList("C", "A"))));
        System.out.println(destCity(Arrays.asList(Arrays.asList("A", "Z"))));
    }

    public static String destCity(List<List<String>> paths) {
        /**
         * 所有线路起点城市的集合
         */
        Set<String> startSet = new HashSet<>();

        for (List<String> path : paths) {
            startSet.add(path.get(0));
        }

        for (List<String> path : paths) {
            /**
             * 终点城市不会通往其他城市，所以不在起点城市的集合中
             */
            if (!startSet.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
