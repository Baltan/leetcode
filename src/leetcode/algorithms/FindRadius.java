package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 475. Heaters
 *
 * @author Baltan
 * @date 2018/1/8 20:40
 */
public class FindRadius {
    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30}));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minRadius = 0;
        int currentRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            int currentHouse = houses[i];
            int heaterLeftIndex = heaters.length - 1;
            while (heaterLeftIndex >= 0 && heaters[heaterLeftIndex] > currentHouse) {
                heaterLeftIndex--;
            }
            if (heaterLeftIndex == -1) {
                currentRadius = heaters[0] - currentHouse;
            } else {
                if (heaterLeftIndex < heaters.length - 1) {
                    currentRadius =
                            Math.min(currentHouse - heaters[heaterLeftIndex], heaters[heaterLeftIndex + 1] - currentHouse);
                } else {
                    currentRadius = currentHouse - heaters[heaterLeftIndex];
                }
            }
            if (currentRadius > minRadius) {
                minRadius = currentRadius;
            }
        }
        return minRadius;
    }
}
