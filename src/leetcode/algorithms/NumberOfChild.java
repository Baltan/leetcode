package leetcode.algorithms;

/**
 * Description: 3178. Find the Child Who Has the Ball After K Seconds
 *
 * @author Baltan
 * @date 2024/6/15 23:50
 */
public class NumberOfChild {
    public static void main(String[] args) {
        System.out.println(numberOfChild(3, 5));
        System.out.println(numberOfChild(5, 6));
        System.out.println(numberOfChild(4, 2));
    }

    public static int numberOfChild(int n, int k) {
        int result = 0;
        /**
         * 球传递的方向，向右传递为+1，向左传递为-1
         */
        int direction = 1;

        for (int i = 0; i < k; i++) {
            result += direction;
            /**
             * 如果球传到第一个人或最后一个人，掉转传递方向
             */
            if (result == 0 || result == n - 1) {
                direction = -direction;
            }
        }
        return result;
    }
}
