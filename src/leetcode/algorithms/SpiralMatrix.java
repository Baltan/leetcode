package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2326. Spiral Matrix IV
 *
 * @author Baltan
 * @date 2023/1/18 15:33
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        OutputUtils.print2DIntegerArray(spiralMatrix(3, 5, head1));

        System.out.println("-------------------------------------------");

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{0, 1, 2});
        OutputUtils.print2DIntegerArray(spiralMatrix(1, 4, head2));

        System.out.println("-------------------------------------------");

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{8, 24, 5, 21, 10, 11, 11, 12, 6, 17});
        OutputUtils.print2DIntegerArray(spiralMatrix(10, 1, head3));
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        /**
         * 按照顺时针方向依次为向右、向下、向左、向上前进时坐标的变化
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        /**
         * 表示当前前进方向为directions[index]
         */
        int index = 0;
        /**
         * 当前位置行坐标
         */
        int x = 0;
        /**
         * 当前位置列坐标
         */
        int y = 0;

        for (int[] row : result) {
            Arrays.fill(row, -1);
        }

        while (head != null) {
            result[x][y] = head.val;
            head = head.next;
            /**
             * 查找下一个坐标的位置
             */
            while (head != null) {
                int nextX = x + directions[index][0];
                int nextY = y + directions[index][1];
                /**
                 * 坐标(nextX,nextY)超出了矩阵范围或者已经被占用，根据题意node.val∈[0,1000]，所以当空格内的值为-1时，肯定未被占用
                 */
                if (nextX < m && nextY < n && nextX >= 0 && nextY >= 0 && result[nextX][nextY] == -1) {
                    x = nextX;
                    y = nextY;
                    break;
                } else {
                    /**
                     * 顺时针方向调转前进方向
                     */
                    index = (index + 1) % directions.length;
                }
            }
        }
        return result;
    }
}
