package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 347. Top K Frequent Elements
 *
 * @author Baltan
 * @date 2018/8/21 11:42
 */
public class TopKFrequent {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        OutputUtils.print1DIntegerArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3));
        OutputUtils.print1DIntegerArray(topKFrequent(new int[]{1}, 1));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        /**
         * frequencyList[i]保存nums出现中出现i次所有数字
         */
        List<Integer>[] frequencyList = new List[nums.length + 1];
        /**
         * 数字i -> 数字i在nums中出现的次数
         */
        Map<Integer, Integer> frequencyMap = new HashMap();
        /**
         * 统计nums中各个数字出现的次数
         */
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequencyList[frequency] == null) {
                frequencyList[frequency] = new ArrayList<>();
            }
            frequencyList[frequency].add(num);
        }


        for (int i = frequencyList.length - 1; i > 0; i--) {
            if (frequencyList[i] == null) {
                continue;
            }

            if (k > 0) {
                /**
                 * 因为题意说明答案唯一，所以直接将frequencyList[i]中的所有数字加入result即可
                 */
                for (int value : frequencyList[i]) {
                    result[index++] = value;
                    k--;
                }
                /**
                 * 找到了出现次数最多的k个数字，直接返回result
                 */
                if (k == 0) {
                    return result;
                }
            }
        }
        return result;
    }
}
