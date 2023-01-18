package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Description: 2349. Design a Number Container System
 *
 * @author Baltan
 * @date 2023/1/16 15:11
 */
public class NumberContainers {
    /**
     * 索引i -> 索引i处的数字
     */
    private Map<Integer, Integer> indexValueMap;
    /**
     * 数字i -> 数字i所在的索引集合，并且这些索引值按照升序排列
     */
    private Map<Integer, TreeSet<Integer>> valueIndexesMap;

    public NumberContainers() {
        indexValueMap = new HashMap<>();
        valueIndexesMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexValueMap.containsKey(index)) {
            int oldValue = indexValueMap.get(index);
            /**
             * 删除原有的数字oldValue所在的索引index
             */
            valueIndexesMap.get(oldValue).remove(index);
        }
        indexValueMap.put(index, number);
        valueIndexesMap.computeIfAbsent(number, x -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indexSet = valueIndexesMap.get(number);
        return indexSet == null || indexSet.isEmpty() ? -1 : indexSet.first();
    }

    public static void main(String[] args) {
        NumberContainers numberContainers1 = new NumberContainers();
        System.out.println(numberContainers1.find(10));
        numberContainers1.change(2, 10);
        numberContainers1.change(1, 10);
        numberContainers1.change(3, 10);
        numberContainers1.change(5, 10);
        System.out.println(numberContainers1.find(10));
        numberContainers1.change(1, 20);
        System.out.println(numberContainers1.find(10));
    }
}
