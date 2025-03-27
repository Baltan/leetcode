package leetcode.algorithms;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Description: 3479. Fruits Into Baskets III
 *
 * @author Baltan
 * @date 2025/3/12 23:48
 * @see NumOfUnplacedFruits
 */
public class NumOfUnplacedFruits1 {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{2, 16, 53, 100, 61}, new int[]{46, 7, 78, 30, 30}));
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
        System.out.println(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/fruits-into-baskets-iii/solutions/3603232/3479-jiang-shui-guo-zhuang-ru-lan-zi-iii-y2nb/"></a>
     *
     * @param fruits
     * @param baskets
     * @return
     */
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = fruits.length;
        /**
         * isVisited[i]表示篮子baskets[i]是否已被放入水果
         */
        boolean[] isVisited = new boolean[baskets.length];
        /**
         * 将baskets数组按顺序分割成parts个连续的子数组，每个子数组的长度为length（最后一个子数组的长度可能不足length）
         */
        int length = (int) Math.sqrt(baskets.length);
        int parts = (int) Math.ceil((double) baskets.length / length);
        /**
         * treeMaps[i]保存第i个子数组中不同容量的篮子的个数，并且按照篮子容量升序排列
         */
        TreeMap<Integer, Integer>[] treeMaps = new TreeMap[parts];
        Arrays.setAll(treeMaps, x -> new TreeMap<>());

        for (int i = 0; i < parts; i++) {
            for (int j = 0; j < length; j++) {
                /**
                 * 第i个子数组中的第j个篮子在数组baskets中的索引值
                 */
                int index = i * length + j;

                if (index < baskets.length) {
                    treeMaps[i].merge(baskets[index], 1, Integer::sum);
                }
            }
        }
        outer:
        for (int fruit : fruits) {
            for (int i = 0; i < treeMaps.length; i++) {
                TreeMap<Integer, Integer> treeMap = treeMaps[i];
                /**
                 * 如果当前子数组中剩余篮子的最大容量不小于fruit，则水果一定可以被放入某个篮子中
                 */
                if (!treeMap.isEmpty() && treeMap.lastKey() >= fruit) {
                    /**
                     * 按序在第i个子数组中找到第一个容量不小于fruit的篮子即可
                     */
                    for (int j = i * length; j < Math.min((i + 1) * length, baskets.length); j++) {
                        if (!isVisited[j] && baskets[j] >= fruit) {
                            if (treeMap.get(baskets[j]) == 1) {
                                treeMap.remove(baskets[j]);
                            } else {
                                treeMap.merge(baskets[j], -1, Integer::sum);
                            }
                            isVisited[j] = true;
                            result--;
                            continue outer;
                        }
                    }
                }
            }
        }
        return result;
    }
}
