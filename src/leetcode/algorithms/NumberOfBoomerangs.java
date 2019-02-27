package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:Number of Boomerangs
 *
 * @author Baltan
 * @date 2018/1/3 17:03
 */
public class NumberOfBoomerangs {
    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}}));
        System.out.println(numberOfBoomerangs(
                new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}}));
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int boomerangNum = 0;
        for (int i = 0; i < points.length; i++) {
            int[] iPoint = points[i];
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int[] jPoint = points[j];
                    double IJDistance = Math.pow(iPoint[0] - jPoint[0], 2) + Math.pow(iPoint[1] - jPoint[1], 2);
                    if (map.get(IJDistance) != null) {
                        boomerangNum += map.get(IJDistance) * 2;
                        map.put(IJDistance, map.get(IJDistance) + 1);
                    } else {
                        map.put(IJDistance, 1);
                    }
                }
            }
        }
        return boomerangNum;
    }
}
