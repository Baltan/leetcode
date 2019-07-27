package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 853. Car Fleet
 *
 * @author Baltan
 * @date 2019-07-27 12:33
 */
public class CarFleet {
    public static void main(String[] args) {
        int target1 = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target1, position1, speed1));

        int target2 = 10;
        int[] position2 = {};
        int[] speed2 = {};
        System.out.println(carFleet(target2, position2, speed2));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }

        int result = 1;
        int count = position.length;
        int[][] arr = new int[count][2];
        /**
         * 将每一辆车的初始位置和速度放在一个数组里，构成一个二维数组
         */
        for (int i = 0; i < count; i++) {
            arr[i] = new int[]{position[i], speed[i]};
        }
        /**
         * 对二维数组排序，优先按照初始位置降序排列，如果初始位置相同按照速度升序排列
         * （按照题意两车不会处于同一位置，所以其实只要按照初始位置降序排列即可：Arrays.sort(arr, (m, n) -> n[0] - m[0]);）
         */
        Arrays.sort(arr, (m, n) -> {
            if (m[0] == n[0]) {
                return m[1] - n[1];
            } else {
                return n[0] - m[0];
            }
        });
        /**
         * 第一辆车到达目的地需要花费的时间
         */
        double time = (target - arr[0][0]) * 1.0 / arr[0][1];
        /**
         * 对于每一辆车，如果该车按照自己的速度到达目的地的时间少于前面最慢的那辆车，则可以和前面的慢车组成一个车队，
         * 如果前面多于前面最慢的那辆车，则自己会形成一个新的车队，后面的车比较的时间应当以该车为准
         */
        for (int i = 1; i < count; i++) {
            double currentTime = (target - arr[i][0]) * 1.0 / arr[i][1];

            if (currentTime > time) {
                result++;
                time = currentTime;
            }
        }
        return result;
    }
}
