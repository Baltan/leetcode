package leetcode.algorithms;

/**
 * Description: 1232. Check If It Is a Straight Line
 *
 * @author Baltan
 * @date 2019-10-21 08:50
 */
public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates1));

        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(checkStraightLine(coordinates2));

        int[][] coordinates3 = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {7, 0}};
        System.out.println(checkStraightLine(coordinates3));

        int[][] coordinates4 = {{0, 1}, {0, 2}, {0, 4}, {0, 5}, {0, 6}, {0, 7}};
        System.out.println(checkStraightLine(coordinates4));

        int[][] coordinates5 = {{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}};
        System.out.println(checkStraightLine(coordinates5));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        /**
         * 计算头两个坐标的斜率，作为比较参考斜率
         */
        double criterion = coordinates[0][0] == coordinates[1][0] ? Double.POSITIVE_INFINITY :
                1.0 * (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        /**
         * 依次计算相邻两个坐标的斜率，和参考斜率比较，如果不相等说明所有点不共线
         */
        for (int i = 2; i < length; i++) {
            double gradient = coordinates[i - 1][0] == coordinates[i][0] ? Double.POSITIVE_INFINITY :
                    1.0 * (coordinates[i][1] - coordinates[i - 1][1]) /
                            (coordinates[i][0] - coordinates[i - 1][0]);
            if (gradient != criterion) {
                return false;
            }
        }
        return true;
    }
}
