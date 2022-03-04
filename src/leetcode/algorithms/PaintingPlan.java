package leetcode.algorithms;

/**
 * Description: LCP 22. 黑白方格画
 *
 * @author Baltan
 * @date 2022/3/4 16:13
 */
public class PaintingPlan {
    public static void main(String[] args) {
        System.out.println(paintingPlan(2, 2));
        System.out.println(paintingPlan(2, 1));
        System.out.println(paintingPlan(2, 4));
        System.out.println(paintingPlan(1, 0));
    }

    public static int paintingPlan(int n, int k) {
        /**
         * 要不全涂黑，要不全不涂黑
         */
        if (n * n == k || k == 0) {
            return 1;
        }
        /**
         * 任意涂一行或者一列，涂黑的格子数量就会大于k
         */
        if (k < n) {
            return 0;
        }

        int result = 0;
        /**
         * 枚举涂黑i行和j列的所有情况
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 涂黑的格子数量
                 */
                int total = i * n + j * n - i * j;

                if (total == k) {
                    result += chooseXFromY(i, n) * chooseXFromY(j, n);
                }
            }
        }
        return result;
    }

    /**
     * 从y个中选出x个的组合数：Cyx=[y*(y-1)*(y-2)*……*(y-x+1)]/[1*2*3*……*x]
     *
     * @param x
     * @param y
     * @return
     */
    public static int chooseXFromY(int x, int y) {
        int total = 1;
        int count = x;
        /**
         * 计算y*(y-1)*(y-2)*……*(y-x+1)
         */
        while (count > 0) {
            total *= y;
            y--;
            count--;
        }
        /**
         * 计算[y*(y-1)*(y-2)*……*(y-x+1)]/[1*2*3*……*x]
         */
        for (int i = 1; i <= x; i++) {
            total /= i;
        }
        return total;
    }
}
