package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2126. Destroying Asteroids
 *
 * @author Baltan
 * @date 2022/1/5 09:11
 */
public class AsteroidsDestroyed {
    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21}));
        System.out.println(asteroidsDestroyed(5, new int[]{4, 9, 23, 4}));
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long total = mass;
        Arrays.sort(asteroids);
        /**
         * 按质量从小到大尝试摧毁所有小行星，直到行星被摧毁或者多有小行星都被摧毁
         */
        for (int asteroid : asteroids) {
            if (asteroid > total) {
                return false;
            }
            total += asteroid;
        }
        return true;
    }
}
