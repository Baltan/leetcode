package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 2176. Count Equal and Divisible Pairs in an Array
 *
 * @author Baltan
 * @date 2022/2/24 09:14
 */
public class CountPairs {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
        System.out.println(countPairs(new int[]{1, 2, 3, 4}, 1));
    }

    public static int countPairs(int[] nums, int k) {
        int result = 0;
        /**
         * 元素x -> 元素x在数组nums中出现的所有索引位置
         */
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> indexList = indexMap.computeIfAbsent(num, x -> new ArrayList<>());
            indexList.add(i);
        }

        for (List<Integer> indexList : indexMap.values()) {
            for (int i = 0; i < indexList.size(); i++) {
                for (int j = i + 1; j < indexList.size(); j++) {
                    if ((indexList.get(i) * indexList.get(j)) % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
