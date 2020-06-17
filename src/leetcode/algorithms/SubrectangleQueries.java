package leetcode.algorithms;

/**
 * Description: 1476. Subrectangle Queries
 *
 * @author Baltan
 * @date 2020-06-17 12:58
 */
public class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle1 = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
        SubrectangleQueries queries1 = new SubrectangleQueries(rectangle1);
        System.out.println(queries1.getValue(0, 2));
        queries1.updateSubrectangle(0, 0, 3, 2, 5);
        System.out.println(queries1.getValue(0, 2));
        System.out.println(queries1.getValue(3, 1));
        queries1.updateSubrectangle(3, 0, 3, 2, 10);
        System.out.println(queries1.getValue(3, 1));
        System.out.println(queries1.getValue(0, 2));
    }
}
