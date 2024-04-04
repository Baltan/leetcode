package leetcode.algorithms;

/**
 * Description: 3100. Water Bottles II
 *
 * @author Baltan
 * @date 2024/4/4 13:31
 */
public class MaxBottlesDrunk {
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(13, 6));
        System.out.println(maxBottlesDrunk(10, 3));
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = 0;
        /**
         * 空瓶数量
         */
        int emptyBottles = 0;

        while (numBottles > 0) {
            /**
             * 将所有水喝光后，如果空瓶数量足够，就用numExchange个空瓶换一瓶水继续喝
             */
            result += numBottles;
            emptyBottles += numBottles;
            numBottles = emptyBottles >= numExchange ? 1 : 0;
            /**
             * 更新剩余空瓶数量
             */
            emptyBottles -= numBottles * numExchange;
            numExchange++;
        }
        return result;
    }
}
