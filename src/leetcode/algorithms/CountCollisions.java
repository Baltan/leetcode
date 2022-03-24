package leetcode.algorithms;

/**
 * Description: 2211. Count Collisions on a Road
 *
 * @author Baltan
 * @date 2022/3/23 20:54
 */
public class CountCollisions {
    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
        System.out.println(countCollisions("LLRR"));
    }

    /**
     * <a href="https://leetcode-cn.com/problems/count-collisions-on-a-road/solution/da-an-hui-bei-zhuang-ting-de-che-liang-s-yyfl/"></a>
     *
     * @param directions
     * @return
     */
    public static int countCollisions(String directions) {
        int result = 0;
        char[] charArray = directions.toCharArray();
        int leftmost = 0;
        int rightmost = directions.length() - 1;
        /**
         * 所有左边没有方向不向左的其他车的车都不会发生碰撞
         */
        while (leftmost < directions.length() && charArray[leftmost] == 'L') {
            leftmost++;
        }
        /**
         * 所有右边没有方向不向右的其他车的车都不会发生碰撞
         */
        while (rightmost >= 0 && charArray[rightmost] == 'R') {
            rightmost--;
        }
        /**
         * 剩余的其他车只要不是静止的，都会运动着撞向其他车一次
         */
        for (int i = leftmost; i <= rightmost; i++) {
            if (charArray[i] != 'S') {
                result++;
            }
        }
        return result;
    }
}
