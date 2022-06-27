package leetcode.algorithms;

/**
 * Description: 1812. Determine Color of a Chessboard Square
 *
 * @author Baltan
 * @date 2022/6/23 16:33
 */
public class SquareIsWhite {
    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1"));
        System.out.println(squareIsWhite("h3"));
        System.out.println(squareIsWhite("c7"));
    }

    public static boolean squareIsWhite(String coordinates) {
        /**
         * 将横坐标的a-h依次替换为0-7，则白格子的横坐标数字和纵坐标数字之和为偶数，黑格子为奇数
         */
        return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '0')) % 2 == 0;
    }
}
