package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 781. Rabbits in Forest
 *
 * @author Baltan
 * @date 2018/8/21 16:38
 */
public class NumRabbits {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits(new int[]{10, 10, 10}));
        System.out.println(numRabbits(new int[]{}));
        System.out.println(numRabbits(new int[]{1, 0, 1, 0, 0}));
        System.out.println(numRabbits(new int[]{0, 0, 1, 1, 1}));
        System.out.println(numRabbits(new int[]{2, 1, 2, 2, 2, 2, 2, 2, 1, 1}));
        System.out.println(numRabbits(new int[]{0, 1, 0, 2, 0, 1, 0, 2, 1, 1}));
    }

    public static int numRabbits(int[] answers) {
        int totalNum = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (key == 0) {
                totalNum += val;
            } else if (val - key > 1) {
                int groups = val / (key + 1);
                totalNum += groups * (key + 1);
                if (val - groups * (key + 1) != 0) {
                    totalNum += (key + 1);
                }
            } else {
                totalNum += (key + 1);
            }
        }
        return totalNum;
    }
}
