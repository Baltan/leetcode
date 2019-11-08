package leetcode.algorithms;

import java.util.*;

/**
 * Description: 756. Pyramid Transition Matrix
 *
 * @author Baltan
 * @date 2019-11-08 09:10
 */
public class PyramidTransition {
    public static void main(String[] args) {
        System.out.println(pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF")));
        System.out.println(pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
        System.out.println(pyramidTransition("CACAC",
                Arrays.asList("ACB", "AAC", "AAB", "BCD", "BCC", "BAA", "CCD", "CCA", "CAD", "DAD", "DAC",
                        "DCD", "ACD", "DCA", "ABA", "BDA", "BDC", "BDB", "BBA", "ADD", "ADC", "CDB", "DDA",
                        "CBB", "CBC", "CBA", "CDA", "CBD", "DBA", "DBC", "DBD")));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        /**
         * 保存金字塔每相邻的两块砖块，上面可能堆砌的砖块
         */
        Map<String, Set<Character>> allowedMap = new HashMap<>();

        for (String s : allowed) {
            String bottomKey = s.substring(0, 2);
            char topValue = s.charAt(2);
            allowedMap.putIfAbsent(bottomKey, new HashSet<>());
            allowedMap.get(bottomKey).add(topValue);
        }
        return pyramidTransition(bottom, allowedMap);
    }

    public static boolean pyramidTransition(String bottom, Map<String, Set<Character>> allowedMap) {
        /**
         * 如果当前金字塔的最上层只有两块砖块，对于这个一层的两块砖块若能找到可以堆砌的砖块，则金字塔可以堆到塔尖
         */
        if (bottom.length() == 2) {
            return allowedMap.containsKey(bottom);
        }

        int length = bottom.length();
        /**
         * 对于当前金字塔最上层相邻的的两块砖块，依次保存更上一层可能堆砌的砖块
         */
        List<Set<Character>> topList = new ArrayList<>();

        for (int i = 0; i < length - 1; i++) {
            String bottomKey = bottom.substring(i, i + 2);
            /**
             * 如果当前两块相邻的砖块上面找不到可以堆砌的砖块，则金字塔无法堆到塔尖
             */
            if (!allowedMap.containsKey(bottomKey)) {
                return false;
            }
            Set<Character> tops = allowedMap.get(bottomKey);
            topList.add(tops);
        }
        /**
         * 金字塔当前最上层上面可能堆砌的新的一层
         */
        Queue<String> newBottoms = getNewBottoms(topList, allowedMap);
        /**
         * 对于所有可能的新的一层，只要有任何一种可能金字塔可以堆到塔尖，则初始时金字塔的底就能堆到塔尖
         */
        for (String newBottom : newBottoms) {
            if (pyramidTransition(newBottom, allowedMap)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 金字塔当前最上层上面可能堆砌的新的一层，即依次从topList的每个Set中选择一个字符拼接新的字符串
     *
     * @param topList
     * @param allowedMap
     * @return
     */
    public static Queue<String> getNewBottoms(List<Set<Character>> topList,
                                              Map<String, Set<Character>> allowedMap) {
        Queue<String> queue = new LinkedList<>();
        int index = 0;
        int size = topList.size();

        for (Character c : topList.get(index)) {
            queue.offer(String.valueOf(c));
        }

        index++;

        while (!queue.isEmpty() && index < size) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                /**
                 * 当前已经拼接一部分的字符串
                 */
                String bottom = queue.poll();
                /**
                 * 当前已经拼接一部分的字符串的最后一个字符
                 */
                String leftBottom = bottom.substring(bottom.length() - 1);
                /**
                 * 下一个可能接上的字符
                 */
                Set<Character> rightBottoms = topList.get(index);

                for (Character rightBottom : rightBottoms) {
                    String newBottom = leftBottom + rightBottom;
                    /**
                     * 如果接上一个字符后，最后两个字符构成的两块砖块上面可能堆砌其他砖块，则将新的字符串入队
                     */
                    if (allowedMap.containsKey(newBottom)) {
                        queue.offer(bottom + rightBottom);
                    }
                }
            }
            /**
             * 处理topList的下一个Set
             */
            index++;
        }
        return queue;
    }
}
