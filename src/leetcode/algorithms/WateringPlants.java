package leetcode.algorithms;

/**
 * Description: 2079. Watering Plants
 *
 * @author Baltan
 * @date 2021/11/21 21:51
 */
public class WateringPlants {
    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{2, 2, 3, 3}, 5));
        System.out.println(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        System.out.println(wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int result = 0;
        int length = plants.length;
        /**
         * 到当前位置为止可以浇灌的植物数量
         */
        int plantNum = 0;

        for (int i = 0; i < length; i++) {
            plantNum += plants[i];
            /**
             * 如果到当前位置需要浇灌的植物数量大于capacity，说明到前一个位置为止浇灌完成后必须折返河边补水，
             * 一个来回需要移动2*i步
             */
            if (plantNum > capacity) {
                result += 2 * i;
                plantNum = plants[i];
            }
        }
        /**
         * 最后这部分植物只需从河边走到最远的length步即可完成，不需要返回河边
         */
        return result + length;
    }
}
