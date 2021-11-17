package leetcode.algorithms;

/**
 * Description: 2064. Minimized Maximum of Products Distributed to Any Store
 *
 * @author Baltan
 * @date 2021/11/17 10:26
 */
public class MinimizedMaximum {
    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6, new int[]{11, 6}));
        System.out.println(minimizedMaximum(7, new int[]{15, 10, 10}));
        System.out.println(minimizedMaximum(1, new int[]{100000}));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int result = 0;
        int max = 1;
        int min = 1;
        /**
         * 商店的商品数目的最大值
         */
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        /**
         * 二分查找符合条件的商店的商品数目的最大值
         */
        while (min <= max) {
            result = (min + max) / 2;
            /**
             * 如果每个商店的商品数目为result，需要的商店数量
             */
            int total = 0;

            for (int quantity : quantities) {
                total += Math.ceil(1.0 * quantity / result);
            }

            if (total > n) {
                min = result + 1;
            } else {
                /**
                 * 退出循环，否则可能会死循环
                 */
                if (min == max) {
                    break;
                }

                max = result;
            }
        }
        return result;
    }
}
