package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 914. X of a Kind in a Deck of Cards
 *
 * @author Baltan
 * @date 2019-03-17 08:58
 * @see HasGroupsSizeX1
 */
public class HasGroupsSizeX {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        /**
         * i -> deck中i出现的次数
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /**
         * deck中出现次数最少的那个元素的出现次数
         */
        int minNum = Integer.MAX_VALUE;

        for (int value : map.values()) {
            minNum = Math.min(minNum, value);
        }

        if (minNum == 1) {
            return false;
        }
        /**
         * 从最小可能值2开始逐一判断是否是deck中所有出现过的元素的出现次数的最大公约数
         */
        for (int i = 2; i <= minNum; i++) {
            /**
             * 标记i是否是deck中所有出现过的元素的出现次数的最大公约数
             */
            boolean flag = true;

            for (int value : map.values()) {
                if (value % i != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }
        return false;
    }
}
