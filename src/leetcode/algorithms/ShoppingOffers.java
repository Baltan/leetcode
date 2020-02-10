package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 638. Shopping Offers
 *
 * @author Baltan
 * @date 2020-02-10 12:32
 */
public class ShoppingOffers {
    private static int result;

    public static void main(String[] args) {
        List<Integer> price1 = Arrays.asList(2, 5);
        List<List<Integer>> special1 = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs1 = Arrays.asList(3, 2);
        System.out.println(shoppingOffers(price1, special1, needs1));

        List<Integer> price2 = Arrays.asList(2, 3, 4);
        List<List<Integer>> special2 = Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9));
        List<Integer> needs2 = Arrays.asList(1, 2, 1);
        System.out.println(shoppingOffers(price2, special2, needs2));

        List<Integer> price3 = Arrays.asList(4, 3, 2, 9, 8, 8);
        List<List<Integer>> special3 =
                Arrays.asList(Arrays.asList(1, 5, 5, 1, 4, 0, 18), Arrays.asList(3, 3, 6, 6, 4, 2, 32));
        List<Integer> needs3 = Arrays.asList(6, 5, 5, 6, 4, 1);
        System.out.println(shoppingOffers(price3, special3, needs3));
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        result = Integer.MAX_VALUE;
        int itemCount = needs.size();
        /**
         * 记录每件物品当前的数量
         */
        List<Integer> currentAmount = new ArrayList<>(itemCount);
        List<List<Integer>> consists = new ArrayList<>(special);

        for (int i = 0; i < itemCount; i++) {
            /**
             * 初始状态下，每件物品的数量都为0
             */
            currentAmount.add(0);
            /**
             * 将单个物品也看做大礼包的形式，例如：price=[2,3,4]时，可以看做三个大礼包[1,0,0,2]、
             * [0,1,0,3]、[0,0,1,4]
             */
            List<Integer> consist = new ArrayList<>(itemCount + 1);

            for (int j = 0; j <= itemCount; j++) {
                if (j == i) {
                    consist.add(1);
                } else if (j == itemCount) {
                    consist.add(price.get(i));
                } else {
                    consist.add(0);
                }
            }
            consists.add(consist);
        }

        dfs(consists, needs, 0, currentAmount, 0);
        return result;
    }

    /**
     * @param consists
     * @param needs
     * @param totalPrice    当前总价
     * @param currentAmount 每件物品当前的数量
     * @param consistIndex  当前考虑购买第consistIndex（0-based）个大礼包
     */
    public static void dfs(List<List<Integer>> consists, List<Integer> needs,
                           int totalPrice, List<Integer> currentAmount, int consistIndex) {
        /**
         * 如果每件物品当前的数量都和待购清单一致，则已经完成购物，更新购物花费
         */
        if (needs.equals(currentAmount)) {
            result = Math.min(result, totalPrice);
            return;
        }
        /**
         * 如果某件物品当前的数量大于待购清单数量，需要将最近添加的大礼包除去
         */
        if (!checkAmount(currentAmount, needs)) {
            return;
        }
        /**
         * 物品种类数
         */
        int itemCount = needs.size();
        /**
         * 大礼包种类数
         */
        int consistCount = consists.size();

        for (int i = consistIndex; i < consistCount; i++) {
            /**
             * 当前考虑购买的大礼包
             */
            List<Integer> consist = consists.get(i);
            /**
             * 添加当前考虑购买的大礼包，更新每件物品当前的数量和当前总价
             */
            addAmount(currentAmount, consist);
            totalPrice += consist.get(itemCount);
            /**
             * 深度优先搜索，不再考虑索引i之前的大礼包，因为之前已经计算过肯定会超过待购清单的数量
             */
            dfs(consists, needs, totalPrice, currentAmount, i);
            /**
             * 除去当前考虑购买的大礼包，更新每件物品当前的数量和当前总价
             */
            totalPrice -= consist.get(itemCount);
            removeAmount(currentAmount, consist);
        }
    }

    /**
     * 添加大礼包，更新每件物品当前的数量
     *
     * @param currentAmount
     * @param consist
     */
    public static void addAmount(List<Integer> currentAmount, List<Integer> consist) {
        /**
         * 物品种类数
         */
        int itemCount = currentAmount.size();

        for (int i = 0; i < itemCount; i++) {
            currentAmount.set(i, currentAmount.get(i) + consist.get(i));
        }
    }

    /**
     * 除去大礼包，更新每件物品当前的数量
     *
     * @param currentAmount
     * @param consist
     */
    public static void removeAmount(List<Integer> currentAmount, List<Integer> consist) {
        /**
         * 物品种类数
         */
        int itemCount = currentAmount.size();

        for (int i = 0; i < itemCount; i++) {
            currentAmount.set(i, currentAmount.get(i) - consist.get(i));
        }
    }

    /**
     * 检查是否存在某件物品当前的数量都超过待购清单数量
     *
     * @param currentAmount
     * @param needs
     * @return
     */
    public static boolean checkAmount(List<Integer> currentAmount, List<Integer> needs) {
        /**
         * 物品种类数
         */
        int size = needs.size();

        for (int i = 0; i < size; i++) {
            if (currentAmount.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }
}
