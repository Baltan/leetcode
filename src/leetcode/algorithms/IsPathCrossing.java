package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 1496. Path Crossing
 *
 * @author Baltan
 * @date 2022/11/1 09:28
 */
public class IsPathCrossing {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
    }

    public static boolean isPathCrossing(String path) {
        /**
         * isVisited保存所有到达过的坐标，x轴坐标 -> y轴坐标集合
         */
        Map<Integer, Set<Integer>> isVisited = new HashMap<>();
        int x = 0;
        int y = 0;
        /**
         * 标记原点已到达过
         */
        Set<Integer> set = isVisited.computeIfAbsent(x, i -> new HashSet<>());
        set.add(y);

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'E') {
                x++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'W') {
                x--;
            }
            /**
             * 判断坐标(x,y)是否之前到达过
             */
            Set<Integer> yAxes = isVisited.computeIfAbsent(x, i -> new HashSet<>());

            if (yAxes.contains(y)) {
                return true;
            }
            yAxes.add(y);
        }
        return false;
    }
}
