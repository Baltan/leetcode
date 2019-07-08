package leetcode.algorithms;

/**
 * Description: 1105. Filling Bookcase Shelves
 *
 * @author Baltan
 * @date 2019-07-08 10:38
 */
public class MinHeightShelves {
    public static void main(String[] args) {
        int[][] books1 = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        System.out.println(minHeightShelves(books1, 4));
    }

    public static int minHeightShelves(int[][] books, int shelf_width) {
        int length = books.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;

        /**
         * 把books[i]单独放在书架最下面一层，将book[i-1]、book[i-2]等等依次向后挪跟book[i]放到同一层
         */
        for (int i = 0; i < length; i++) {
            /**
             * 把books[i]单独放在书架最下面一层时的总高度
             */
            dp[i + 1] = dp[i] + books[i][1];
            /**
             * 最下面一层的剩余宽度
             */
            int leftWidth = shelf_width - books[i][0];
            int j = i - 1;
            /**
             * 记录最下面一层的高度
             */
            int maxHeight = books[i][1];
            /**
             * 将book[i-1]、book[i-2]等等依次向后挪跟book[i]放到同一层
             */
            while (j >= 0 && leftWidth >= books[j][0]) {
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], maxHeight + dp[j]);
                leftWidth -= books[j][0];
                j--;
            }
        }
        return dp[length];
    }
}
