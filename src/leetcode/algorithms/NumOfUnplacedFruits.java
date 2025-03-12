package leetcode.algorithms;

/**
 * Description: 3477. Fruits Into Baskets II
 *
 * @author Baltan
 * @date 2025/3/12 23:48
 */
public class NumOfUnplacedFruits {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
        System.out.println(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = fruits.length;
        /**
         * isVisited[i]表示篮子baskets[i]已被放入水果
         */
        boolean[] isVisited = new boolean[baskets.length];

        for (int fruit : fruits) {
            /**
             * 从左到右找到第一个可以放下水果fruit的篮子
             */
            for (int j = 0; j < baskets.length; j++) {
                if (!isVisited[j] && baskets[j] >= fruit) {
                    result--;
                    isVisited[j] = true;
                    break;
                }
            }
        }
        return result;
    }
}
