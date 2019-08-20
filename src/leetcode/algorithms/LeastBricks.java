package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 554. Brick Wall
 *
 * @author Baltan
 * @date 2019-08-20 09:10
 */
public class LeastBricks {
    public static void main(String[] args) {
        List<List<Integer>> wall1 =
                Arrays.asList(Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 4), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1));
        System.out.println(leastBricks(wall1));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        /**
         * 统计从每一行最左边开始，到最后一块砖块前，向右逐次添加砖块可以覆盖的长度。
         * 例如第一行砖块长度为1, 2, 2, 1，则从左向右可以覆盖的长度为1，3，5
         */
        for (List<Integer> level : wall) {
            int length = 0;
            int size = level.size();

            for (int i = 0; i < size - 1; i++) {
                int currentLength = level.get(i);
                length += currentLength;
                map.put(length, map.getOrDefault(length, 0) + 1);
                /**
                 * max保存一个长度，能覆盖该长度的行数最多
                 */
                max = Math.max(max, map.get(length));
            }
        }
        /**
         * 无法覆盖max长度的行的砖块将会被穿过
         */
        return wall.size() - max;
    }
}
