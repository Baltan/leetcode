package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 904. Fruit Into Baskets
 *
 * @author Baltan
 * @date 2019-05-07 09:27
 */
public class TotalFruit {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(totalFruit(
                new int[]{2, 3, 4, 2, 3, 4, 2, 2, 3, 4, 3, 2, 3, 4, 3, 2, 2, 2, 4, 3, 2, 3, 4, 3, 2, 2, 3, 4,
                        2, 3, 3, 3, 4, 3, 2, 2, 2, 3, 4, 3, 2, 3, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 3, 2, 3, 3,
                        2, 2, 3, 3, 4, 3, 2, 4, 3, 2, 2, 3, 4, 2}));
    }

    public static int totalFruit(int[] tree) {
        int result = 0;
        int num = 0;
        int length = tree.length;
        int index = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            int beforeSize = set.size();
            set.add(tree[i]);
            int afterSize = set.size();

            if (beforeSize == 1 && afterSize == 2) {
                index = i;
            }

            if (set.size() < 3) {
                num++;
            } else {
                set = new HashSet<>();
                num = 0;
                i = index - 1;
            }
            result = Math.max(result, num);
        }
        return result;
    }
}
