package leetcode.algorithms;

/**
 * Description: 1518. Water Bottles
 *
 * @author Baltan
 * @date 2020-07-21 22:13
 */
public class NumWaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(5, 5));
        System.out.println(numWaterBottles(2, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        /**
         * 满瓶的个数
         */
        int fullCount = numBottles;
        /**
         * 空瓶的个数
         */
        int emptyCount = 0;

        while (fullCount > 0) {
            result += fullCount;
            emptyCount += fullCount;
            /**
             * 用空瓶换满瓶的个数
             */
            fullCount = emptyCount / numExchange;
            /**
             * 剩余的空瓶的个数
             */
            emptyCount -= fullCount * numExchange;
        }
        return result;
    }
}
