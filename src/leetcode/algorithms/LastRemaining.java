package leetcode.algorithms;

/**
 * Description: 390. Elimination Game
 *
 * @author Baltan
 * @date 2019-07-04 09:29
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(100000000));
    }

    public static int lastRemaining(int n) {
        int start = 1;
        int end = n;
        int oldEnd;
        int length = n;
        int step = 1;
        boolean leftToRight = true;

        while (length > 1) {
            /**
             * 如果是从左向右删除
             */
            if (leftToRight) {
                /**
                 * 如果共有奇数个数字
                 */
                if ((length & 1) == 1) {
                    oldEnd = end;
                    /**
                     * 对于下一轮从右向左删除来说，下一轮的最后一个数就是这轮的第二个数(start + step)，
                     * 下一轮的第一个数就是这轮的倒数第二个数(oldEnd - step)
                     */
                    end = start + step;
                    start = oldEnd - step;
                } else {
                    oldEnd = end;
                    /**
                     * 对于下一轮从右向左删除来说，下一轮的最后一个数就是这轮的第二个数(start + step)，
                     * 下一轮的第一个数就是这轮的最后一个数(oldEnd)
                     */
                    end = start + step;
                    start = oldEnd;
                }
            } else {
                /**
                 * 如果共有奇数个数字
                 */
                if ((length & 1) == 1) {
                    oldEnd = end;
                    /**
                     * 对于下一轮从左向右删除来说，下一轮的最后一个数就是这轮的第二个数(start - step)，
                     * 下一轮的第一个数就是这轮的倒数第二个数(oldEnd + step)
                     */
                    end = start - step;
                    start = oldEnd + step;
                } else {
                    oldEnd = end;
                    /**
                     * 对于下一轮从左向右删除来说，下一轮的最后一个数就是这轮的第二个数(start - step)，
                     * 下一轮的第一个数就是这轮的最后一个数(oldEnd)
                     */
                    end = start - step;
                    start = oldEnd;
                }
            }
            /**
             * 数列长度减半
             */
            length >>= 1;
            /**
             * 删除的步长加倍
             */
            step <<= 1;
            /**
             * 操作方向取反
             */
            leftToRight = !leftToRight;
        }
        return start;
    }
}
