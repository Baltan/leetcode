package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2671. Frequency Tracker
 *
 * @author Baltan
 * @date 2023/5/7 19:56
 */
public class FrequencyTracker {
    /**
     * 数字i -> 数字i在数据结构中出现的次数
     */
    private Map<Integer, Integer> numFrequency;
    /**
     * 出现次数i -> 在数据结构中出现次数为i的所有数字的集合
     */
    private Map<Integer, Set<Integer>> frequencyNums;

    public FrequencyTracker() {
        numFrequency = new HashMap<>();
        frequencyNums = new HashMap<>();
    }

    public void add(int number) {
        int frequency = numFrequency.getOrDefault(number, 0);

        if (frequency > 0) {
            numFrequency.put(number, frequency + 1);
            frequencyNums.get(frequency).remove(number);
            Set<Integer> nums = frequencyNums.computeIfAbsent(frequency + 1, i -> new HashSet<>());
            nums.add(number);
        } else {
            numFrequency.put(number, 1);
            Set<Integer> nums = frequencyNums.computeIfAbsent(1, i -> new HashSet<>());
            nums.add(number);
        }
    }

    public void deleteOne(int number) {
        int frequency = numFrequency.getOrDefault(number, 0);

        if (frequency > 0) {
            numFrequency.put(number, frequency - 1);
            frequencyNums.get(frequency).remove(number);

            if (frequency > 1) {
                Set<Integer> nums = frequencyNums.computeIfAbsent(frequency - 1, i -> new HashSet<>());
                nums.add(number);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return frequencyNums.getOrDefault(frequency, Collections.emptySet()).size() > 0;
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker1 = new FrequencyTracker();
        frequencyTracker1.add(3);
        frequencyTracker1.add(3);
        System.out.println(frequencyTracker1.hasFrequency(2));

        System.out.println("-------------------------------");

        FrequencyTracker frequencyTracker2 = new FrequencyTracker();
        frequencyTracker2.add(1);
        frequencyTracker2.deleteOne(1);
        System.out.println(frequencyTracker2.hasFrequency(1));

        System.out.println("-------------------------------");

        FrequencyTracker frequencyTracker3 = new FrequencyTracker();
        System.out.println(frequencyTracker3.hasFrequency(2));
        frequencyTracker3.add(3);
        System.out.println(frequencyTracker3.hasFrequency(1));

        System.out.println("-------------------------------");

        FrequencyTracker frequencyTracker4 = new FrequencyTracker();
        frequencyTracker4.deleteOne(5);
        System.out.println(frequencyTracker4.hasFrequency(1));
        System.out.println(frequencyTracker4.hasFrequency(1));
        frequencyTracker4.deleteOne(3);
        System.out.println(frequencyTracker4.hasFrequency(1));
        System.out.println(frequencyTracker4.hasFrequency(1));
        frequencyTracker4.add(7);
        frequencyTracker4.deleteOne(7);
        frequencyTracker4.deleteOne(7);
    }
}
