package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2018/8/28 12:04
 */
public class Point {
    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
