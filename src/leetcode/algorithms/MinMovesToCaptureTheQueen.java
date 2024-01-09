package leetcode.algorithms;

/**
 * Description: 3001. Minimum Moves to Capture The Queen
 *
 * @author baltan
 * @date 2024/1/8 15:36
 */
public class MinMovesToCaptureTheQueen {
    public static void main(String[] args) {
        System.out.println(minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3));
        System.out.println(minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2));
        System.out.println(minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
    }

    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int result = Integer.MAX_VALUE;
        /**
         * 白车捕获黑后需要的移动次数。有三种情况：
         * 1、白车和黑后同在一行或一列，且两个棋子之间没有白象阻挡，只需要移动1次
         * 2、白车和黑后同在一行或一列，但是两个棋子之间有白象阻挡，移除白象后得到情况1，至少需要移动2次
         * 3、白车和黑后不在同在一行且不在一列，以两个棋子作为对角线顶点构成矩形，总能从其中找到一个直角的两条边是不被白象阻挡的，因此至少需要
         * 移动2次
         */
        if (a == e) {
            result = Math.min(result, a == c && (b - d) * (f - d) < 0 ? 2 : 1);
        } else if (b == f) {
            result = Math.min(result, b == d && (a - c) * (e - c) < 0 ? 2 : 1);
        } else {
            result = Math.min(result, 2);
        }
        /**
         * 白象捕获黑后只需考虑移动1次的情况，否则就不会优于白车捕获黑后的移动次数。有两种情况：
         * 1、白象和黑后同在一条左上右下方向的对角线上，且对角线上两个棋子之间没有白车阻挡
         * 2、白象和黑后同在一条右上左下方向的对角线上，且对角线上两个棋子之间没有白车阻挡
         */
        if (c - d == e - f && (c - d != a - b || (a - c) * (a - e) > 0)) {
            result = Math.min(result, 1);
        }

        if (c + d == e + f && (c + d != a + b || (a - c) * (a - e) > 0)) {
            result = Math.min(result, 1);
        }
        return result;
    }
}
