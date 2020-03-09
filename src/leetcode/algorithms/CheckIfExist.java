package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1346. Check If N and Its Double Exist
 *
 * @author Baltan
 * @date 2020-03-09 18:11
 */
public class CheckIfExist {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

    public static boolean checkIfExist(int[] arr) {
        /**
         * 数组中0的个数
         */
        int zeroCount = 0;
        /**
         * 保存数组中除0以外的其余数字
         */
        Set<Integer> set = new HashSet<>();

        for (int value : arr) {
            if (value == 0) {
                zeroCount++;
                continue;
            }
            set.add(value);
        }

        if (zeroCount > 1) {
            return true;
        }

        for (int value : set) {
            if (set.contains(value * 2)) {
                return true;
            }
        }
        return false;
    }
}
