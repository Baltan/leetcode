package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2018/8/7 09:39
 */
public class IslandCoordinate {
    private int x;
    private int y;

    public IslandCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "IslandCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
