package leetcode.algorithms;

/**
 * Description: 1375. Bulb Switcher III
 *
 * @author Baltan
 * @date 2020-03-20 13:35
 * @see BulbSwitch
 * @see BulbSwitch1
 * @see FlipLights
 * @see MinFlips1
 */
public class NumTimesAllBlue {
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(numTimesAllBlue(new int[]{4, 1, 2, 3}));
        System.out.println(numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
        System.out.println(numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int numTimesAllBlue(int[] light) {
        int result = 0;
        /**
         * 当前点亮的灯的最大编号
         */
        int maxLighting = 0;
        /**
         * 当前点亮的灯的数量
         */
        int lightCount = 0;

        for (int i : light) {
            maxLighting = Math.max(maxLighting, i);
            lightCount++;
            /**
             * 如果当前点亮的灯的数量和点亮的所有灯的最大编号相同，说明最大编号的灯及其左边的所有灯都被点
             * 亮了，此时这盏最大编号的灯会变蓝
             */
            if (maxLighting == lightCount) {
                result++;
            }
        }
        return result;
    }
}
