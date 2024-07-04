package leetcode.algorithms;

/**
 * Description: 3200. Maximum Height of a Triangle
 *
 * @author Baltan
 * @date 2024/7/4 23:29
 */
public class MaxHeightOfTriangle {
    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(2, 4));
        System.out.println(maxHeightOfTriangle(2, 1));
        System.out.println(maxHeightOfTriangle(1, 1));
        System.out.println(maxHeightOfTriangle(10, 1));
    }

    public static int maxHeightOfTriangle(int red, int blue) {
        int result = 0;
        /**
         * 奇数行球的总个数
         */
        int oddRows = 0;
        /**
         * 偶数行球的总个数
         */
        int evenRows = 0;

        for (int i = 1; ; i++) {
            if (i % 2 == 0) {
                evenRows += i;
            } else {
                oddRows += i;
            }
            /**
             * 只要红球和蓝球各自多余所在行球的总个数即可
             */
            if ((red >= oddRows && blue >= evenRows) || (red >= evenRows && blue >= oddRows)) {
                result++;
                continue;
            }
            break;
        }
        return result;
    }
}
