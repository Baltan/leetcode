package leetcode.algorithms;

import java.util.*;

/**
 * Description: 460. LFU Cache
 *
 * @author Baltan
 * @date 2020-04-05 00:04
 */
public class LFUCache {
    /**
     * 缓存容量
     */
    private int capacity;
    /**
     * 缓存key -> value
     */
    private Map<Integer, Integer> container;
    /**
     * 缓存key -> key的使用频率
     */
    private Map<Integer, Integer> useFrequency;
    /**
     * 使用频率key -> 使用频率为key值的所有缓存集合，集合中元素按照加入集合的顺序排列
     */
    private Map<Integer, Set<Integer>> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.container = new HashMap<>();
        this.useFrequency = new HashMap<>();
        this.frequencyMap = new TreeMap<>();
    }

    public int get(int key) {
        if (!container.containsKey(key)) {
            return -1;
        }
        /**
         * 缓存key之前的使用频率
         */
        int prevFrequency = useFrequency.get(key);
        /**
         * 更新缓存key的使用频率
         */
        useFrequency.put(key, prevFrequency + 1);
        frequencyMap.get(prevFrequency).remove(key);
        frequencyMap.putIfAbsent(prevFrequency + 1, new LinkedHashSet<>());
        frequencyMap.get(prevFrequency + 1).add(key);
        /**
         * 如果使用频率为prevFrequency的缓存不存在了，删除对应集合
         */
        if (frequencyMap.get(prevFrequency).isEmpty()) {
            frequencyMap.remove(prevFrequency);
        }
        return container.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (container.containsKey(key)) {
            container.put(key, value);
            /**
             * 缓存key之前的使用频率
             */
            int prevFrequency = useFrequency.get(key);
            /**
             * 更新缓存key的使用频率
             */
            useFrequency.put(key, prevFrequency + 1);
            frequencyMap.get(prevFrequency).remove(key);
            frequencyMap.putIfAbsent(prevFrequency + 1, new LinkedHashSet<>());
            frequencyMap.get(prevFrequency + 1).add(key);
            /**
             * 如果使用频率为prevFrequency的缓存不存在了，删除对应集合
             */
            if (frequencyMap.get(prevFrequency).isEmpty()) {
                frequencyMap.remove(prevFrequency);
            }
        } else {
            if (container.size() < capacity) {
                container.put(key, value);
                /**
                 * 更新缓存key的使用频率
                 */
                useFrequency.put(key, 0);
                frequencyMap.putIfAbsent(0, new LinkedHashSet<>());
                frequencyMap.get(0).add(key);
            } else {
                /**
                 * 所有缓存key中使用频率最小的
                 */
                int minFrequency = frequencyMap.keySet().iterator().next();
                /**
                 * 将所有使用频率最小的缓存key中，最近最少使用的删除
                 */
                int element = frequencyMap.get(minFrequency).iterator().next();
                container.remove(element);
                useFrequency.remove(element);
                frequencyMap.get(minFrequency).remove(element);
                /**
                 * 如果使用频率为minFrequency的缓存不存在了，删除对应集合
                 */
                if (frequencyMap.get(minFrequency).isEmpty()) {
                    frequencyMap.remove(minFrequency);
                }
                put(key, value);
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache1 = new LFUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1));
        cache1.put(3, 3);
        System.out.println(cache1.get(2));
        System.out.println(cache1.get(3));
        cache1.put(4, 4);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));
        System.out.println(cache1.get(4));

        System.out.println("----------------------");

        LFUCache cache2 = new LFUCache(0);
        cache2.put(0, 0);
        System.out.println(cache2.get(0));

        System.out.println("----------------------");

        LFUCache cache3 = new LFUCache(2);
        cache3.put(2, 1);
        cache3.put(1, 1);
        cache3.put(2, 3);
        cache3.put(4, 1);
        System.out.println(cache3.get(1));
        System.out.println(cache3.get(2));

        System.out.println("----------------------");

        LFUCache cache4 = new LFUCache(10);
        cache4.put(10, 13);
        cache4.put(3, 17);
        cache4.put(6, 11);
        cache4.put(10, 5);
        cache4.put(9, 10);
        System.out.println(cache4.get(13));
        cache4.put(2, 19);
        System.out.println(cache4.get(2));
        System.out.println(cache4.get(3));
        cache4.put(5, 25);
        System.out.println(cache4.get(8));
        cache4.put(9, 22);
        cache4.put(5, 5);
        cache4.put(1, 30);
        System.out.println(cache4.get(11));
        cache4.put(9, 12);
        System.out.println(cache4.get(7));
        System.out.println(cache4.get(5));
        System.out.println(cache4.get(8));
        System.out.println(cache4.get(9));
        cache4.put(4, 30);
        cache4.put(9, 3);
        System.out.println(cache4.get(9));
        System.out.println(cache4.get(10));
        System.out.println(cache4.get(10));
        cache4.put(6, 14);
        cache4.put(3, 1);
        System.out.println(cache4.get(3));
        cache4.put(10, 11);
        System.out.println(cache4.get(8));
        cache4.put(2, 14);
        System.out.println(cache4.get(1));
        System.out.println(cache4.get(5));
        System.out.println(cache4.get(4));
        cache4.put(11, 4);
        cache4.put(12, 24);
        cache4.put(5, 18);
        System.out.println(cache4.get(13));
        cache4.put(7, 23);
        System.out.println(cache4.get(8));
        System.out.println(cache4.get(12));
        cache4.put(3, 27);
        cache4.put(2, 12);
        System.out.println(cache4.get(5));
        cache4.put(2, 9);
        cache4.put(13, 4);
        cache4.put(8, 18);
        cache4.put(1, 7);
        System.out.println(cache4.get(6));
        cache4.put(9, 29);
        cache4.put(8, 21);
        System.out.println(cache4.get(5));
        cache4.put(6, 30);
        cache4.put(1, 12);
        System.out.println(cache4.get(10));
        cache4.put(4, 15);
        cache4.put(7, 22);
        cache4.put(11, 26);
        cache4.put(8, 17);
        cache4.put(9, 29);
        System.out.println(cache4.get(5));
        cache4.put(3, 4);
        cache4.put(11, 30);
        System.out.println(cache4.get(12));
        cache4.put(4, 29);
        System.out.println(cache4.get(3));
        System.out.println(cache4.get(9));
        System.out.println(cache4.get(6));
        cache4.put(3, 4);
        System.out.println(cache4.get(1));
        System.out.println(cache4.get(10));
        cache4.put(3, 29);
        cache4.put(10, 28);
        cache4.put(1, 20);
        cache4.put(11, 13);
        System.out.println(cache4.get(3));
        cache4.put(3, 12);
        cache4.put(3, 8);
        cache4.put(10, 9);
        cache4.put(3, 26);
        System.out.println(cache4.get(8));
        System.out.println(cache4.get(7));
        System.out.println(cache4.get(5));
        cache4.put(13, 17);
        cache4.put(2, 27);
        cache4.put(11, 15);
        System.out.println(cache4.get(12));
        cache4.put(9, 19);
        cache4.put(2, 15);
        cache4.put(3, 16);
        System.out.println(cache4.get(1));
        cache4.put(12, 17);
        cache4.put(9, 1);
        cache4.put(6, 19);
        System.out.println(cache4.get(4));
        System.out.println(cache4.get(5));
        System.out.println(cache4.get(5));
        cache4.put(8, 1);
        cache4.put(11, 7);
        cache4.put(5, 2);
        cache4.put(9, 28);
        System.out.println(cache4.get(1));
        cache4.put(2, 2);
        cache4.put(7, 4);
        cache4.put(4, 22);
        cache4.put(7, 24);
        cache4.put(9, 26);
        cache4.put(13, 28);
        cache4.put(11, 26);

        System.out.println("----------------------");

        LFUCache cache5 = new LFUCache(2);
        cache5.put(2, 1);
        cache5.put(2, 3);
        cache5.put(1, 1);
        cache5.put(4, 1);
        System.out.println(cache5.get(1));
        System.out.println(cache5.get(2));
    }
}
