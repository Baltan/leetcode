package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 735. Asteroid Collision
 *
 * @author Baltan
 * @date 2019-08-15 09:54
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids1 = {5, 10, -5};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids1));

        int[] asteroids2 = {8, -8};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids2));

        int[] asteroids3 = {10, 2, -5};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids3));

        int[] asteroids4 = {-2, -1, 1, 2};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids4));

        int[] asteroids5 = {1, 4, 2, 5, -4, -1, 7, 3, -4, 7, -9, 3, 6, -2, 2, 1, -3, -1, 2, 5, 8, -6, 3};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids5));

        int[] asteroids6 = {-2, 1, -1, -2};
        OutputUtils.print1DIntegerArray(asteroidCollision(asteroids6));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        /**
         * 记录剩余行星的总数
         */
        int count = length;
        /**
         * stack保存向右飞的行星，每颗行星以[行星初始索引位置，行星大小]的数组形式保存
         */
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int currentAsteroid = asteroids[i];
            /**
             * 如果当前行星是向右飞的，就先加入stack中
             */
            if (currentAsteroid > 0) {
                stack.push(new int[]{i, currentAsteroid});
            } else if (currentAsteroid < 0) {
                /**
                 * 对于当前向左飞的行星，如果stack为空，说明当前行星左侧没有向右飞的行星，则该行星不会和其他行星相撞
                 */
                if (stack.isEmpty()) {
                    continue;
                }
                /**
                 * 获取当前向左飞的行星其左侧最近的一颗向右飞的行星（即stack栈顶位置的行星）
                 */
                int[] rightArray = stack.peek();
                int rightwardAsteroid = rightArray[1];
                int rightwardAsteroidIndex = rightArray[0];
                /**
                 * 如果向左飞的行星比向右飞的行星小，向左飞的行星爆炸，行星总数减1，将当前位置的行星大小标记为0；
                 *
                 * 如果向左飞的行星和向右飞的行星一样大，两颗行星都爆炸，行星总数减2，将两个位置的行星大小都标记为0，
                 * 向右飞的行星要出栈；
                 *
                 * 如果向左飞的行星比向右飞的行星大，向右飞的行星爆炸，行星总数减1，将向右飞的行星初始位置标记为0；
                 * 向右飞的行星要出栈，如果stack内还有其他向右飞的行星，就循环获得下一颗向右飞的行星和当前的向左飞
                 * 的行星比较，知道当前向左飞的行星爆炸或者没有向右飞的行星了。
                 */
                if (-currentAsteroid < rightwardAsteroid) {
                    asteroids[i] = 0;
                    count--;
                } else if (-currentAsteroid == rightwardAsteroid) {
                    stack.pop();
                    asteroids[rightwardAsteroidIndex] = 0;
                    asteroids[i] = 0;
                    count -= 2;
                } else {
                    while (!stack.isEmpty() && rightwardAsteroid < -currentAsteroid) {
                        stack.pop();
                        asteroids[rightwardAsteroidIndex] = 0;
                        count--;
                        /**
                         * 如果stack为空，说明当前行星左侧没有向右飞的行星，则该行星不会和其他行星相撞
                         */
                        if (stack.isEmpty()) {
                            break;
                        }

                        rightArray = stack.peek();
                        rightwardAsteroid = rightArray[1];
                        rightwardAsteroidIndex = rightArray[0];
                    }
                    /**
                     * 上面退出循环时，当前向左飞的行星左侧紧挨着的向右飞且质量更小的行星都爆炸了，可能还存在向右飞且
                     * 质量更大的行星会与当前行星相撞，将i减1，下一轮循环仍旧处理当前向左飞的行星，例如：[10, 2, -5]
                     */
                    i--;
                }
            }
        }
        /**
         * 将剩下的行星复制到新数组中
         */
        int[] result = new int[count];
        int index = 0;

        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                result[index++] = asteroid;
            }
        }
        return result;
    }
}
