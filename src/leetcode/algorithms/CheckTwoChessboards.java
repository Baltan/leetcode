package leetcode.algorithms;

/**
 * Description: 3274. Check if Two Chessboard Squares Have the Same Color
 *
 * @author Baltan
 * @date 2024/9/7 18:26
 */
public class CheckTwoChessboards {
    public static void main(String[] args) {
        System.out.println(checkTwoChessboards("a1", "c3"));
        System.out.println(checkTwoChessboards("a1", "h3"));
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        /**
         * 棋盘中，白色单元格的横纵坐标之和都为奇数，黑色单元格的横纵坐标之和都为偶数，只需比较两个字符串表示的单元格的横竖坐标之和的奇偶性是
         * 否一致即可
         */
        return (coordinate1.charAt(0) + coordinate1.charAt(1)) % 2 == (coordinate2.charAt(0) + coordinate2.charAt(1)) % 2;
    }
}
