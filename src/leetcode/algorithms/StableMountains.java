package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3285. Find Indices of Stable Mountains
 *
 * @author Baltan
 * @date 2024/9/15 23:21
 */
public class StableMountains {
    public static void main(String[] args) {
        System.out.println(stableMountains(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(stableMountains(new int[]{10, 1, 10, 1, 10}, 3));
        System.out.println(stableMountains(new int[]{10, 1, 10, 1, 10}, 10));
    }

    public static List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;
    }
}
