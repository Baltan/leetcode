package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-10-28 09:14
 */
public interface CustomFunction {
    /**
     * Returns f(x, y) for any given positive integers x and y.
     * Note that f(x, y) is increasing with respect to both x and y.
     * i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *
     * @param x
     * @param y
     * @return
     */
    int f(int x, int y);
}
