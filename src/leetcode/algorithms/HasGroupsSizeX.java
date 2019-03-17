package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: X of a Kind in a Deck of Cards
 *
 * @author Baltan
 * @date 2019-03-17 08:58
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
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minNum = Integer.MAX_VALUE;

        for (int value : map.values()) {
            minNum = Math.min(minNum, value);
        }

        if (minNum == 1) {
            return false;
        }

        for (int i = 2; i <= minNum; i++) {
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
