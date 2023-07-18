package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2780. Minimum Index of a Valid Split
 *
 * @author Baltan
 * @date 2023/7/16 13:48
 */
public class MinimumIndex {
    public static void main(String[] args) {
        System.out.println(minimumIndex(Arrays.asList(1, 2, 2, 2)));
        System.out.println(minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));
        System.out.println(minimumIndex(Arrays.asList(3, 3, 3, 3, 7, 2, 2)));
    }

    public static int minimumIndex(List<Integer> nums) {
        if (nums.size() == 1) {
            return -1;
        }
        int length = nums.size();
        /**
         * 元素i -> 第一个子数组中元素i的个数
         */
        Map<Integer, Integer> countMap1 = new HashMap<>();
        /**
         * 元素i -> 第二个子数组中元素i的个数
         */
        Map<Integer, Integer> countMap2 = new HashMap<>();
        /**
         * 出现频数i -> 第一个子数组中所有出现过i次的元素的集合
         */
        TreeMap<Integer, Set<Integer>> frequencyMap1 = new TreeMap<>(Collections.reverseOrder());
        /**
         * 出现频数i -> 第二个子数组中所有出现过i次的元素的集合
         */
        TreeMap<Integer, Set<Integer>> frequencyMap2 = new TreeMap<>(Collections.reverseOrder());
        /**
         * 初始化nums的所有元素都在第二个子数组中，第一个子数组为空数组，计算nums中不同元素出现的次数
         */
        for (int num : nums) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }
        /**
         * 计算nums中不同出现频数的元素的集合
         */
        for (Map.Entry<Integer, Integer> entry : countMap2.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            frequencyMap2.computeIfAbsent(frequency, x -> new HashSet<>()).add(num);
        }
        /**
         * 逐一将第二个子数组中的元素移动到第一个子数组中，判断此时是否得到一个有效分割
         */
        for (int i = 0; i < length - 1; i++) {
            int num = nums.get(i);
            /**
             * 第一个子数组中原来有oldFrequency1个数字num，移入一个数字num后有newFrequency1个数字num
             */
            int oldFrequency1 = countMap1.getOrDefault(num, 0);
            int newFrequency1 = oldFrequency1 + 1;
            /**
             * 更新第一个子数组中数字num的个数
             */
            countMap1.put(num, newFrequency1);
            /**
             * 更新第一个子数组中出现频数为oldFrequency1和newFrequency1的元素的集合
             */
            frequencyMap1.computeIfAbsent(oldFrequency1, x -> new HashSet<>()).remove(num);
            frequencyMap1.computeIfAbsent(newFrequency1, x -> new HashSet<>()).add(num);

            if (frequencyMap1.get(oldFrequency1).isEmpty()) {
                frequencyMap1.remove(oldFrequency1);
            }
            /**
             * 第二个子数组中原来有oldFrequency2个数字num，移出一个数字num后有newFrequency2个数字num
             */
            int oldFrequency2 = countMap2.get(num);
            int newFrequency2 = oldFrequency2 - 1;
            /**
             * 更新第二个子数组中数字num的个数
             */
            countMap2.put(num, newFrequency2);
            /**
             * 更新第二个子数组中出现频数为oldFrequency2和newFrequency2的元素的集合
             */
            frequencyMap2.computeIfAbsent(oldFrequency2, x -> new HashSet<>()).remove(num);
            frequencyMap2.computeIfAbsent(newFrequency2, x -> new HashSet<>()).add(num);

            if (frequencyMap2.get(oldFrequency2).isEmpty()) {
                frequencyMap2.remove(oldFrequency2);
            }
            /**
             * 第一个子数组中元素的最大频数
             */
            int maxFrequency1 = frequencyMap1.firstKey();
            /**
             * 第二个子数组中元素的最大频数
             */
            int maxFrequency2 = frequencyMap2.firstKey();

            if (maxFrequency1 * 2 > i + 1 && maxFrequency2 * 2 > length - i - 1) {
                /**
                 * 第一个子数组中的主导元素
                 */
                Integer x = frequencyMap1.get(maxFrequency1).toArray(new Integer[0])[0];
                /**
                 * 第二个子数组中的主导元素
                 */
                Integer y = frequencyMap2.get(maxFrequency2).toArray(new Integer[0])[0];

                if (Objects.equals(x, y)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
