package leetcode.algorithms;

/**
 * Description: 2320. Count Number of Ways to Place Houses
 *
 * @author Baltan
 * @date 2023/1/19 09:33
 */
public class CountHousePlacements {
    public static void main(String[] args) {
        System.out.println(countHousePlacements(1));
        System.out.println(countHousePlacements(2));
    }

    public static int countHousePlacements(int n) {
        int mod = 1000000007;
        /**
         * emptyCounts[i]表示某一侧的第i+1号地块如果空着，这一侧前i+1个地块放置房屋的方式数目
         */
        long[] emptyCounts = new long[n];
        /**
         * occupiedCounts[i]表示某一侧的第i+1号地块如果放置房屋，这一侧前i+1个地块放置房屋的方式数目
         */
        long[] occupiedCounts = new long[n];
        emptyCounts[0] = 1L;
        occupiedCounts[0] = 1L;

        for (int i = 1; i < n; i++) {
            /**
             * 如果第i+1号地块空着，则第i号地块可以空着也可以放置房屋
             */
            emptyCounts[i] = (emptyCounts[i - 1] + occupiedCounts[i - 1]) % mod;
            /**
             * 如果第i+1号地块放置房屋，则第i号地块可以必须空着
             */
            occupiedCounts[i] = emptyCounts[i - 1];
        }
        /**
         * 某一侧放置房屋的方式数目
         */
        long oneSideCount = (emptyCounts[n - 1] + occupiedCounts[n - 1]) % mod;
        return (int) ((oneSideCount * oneSideCount) % mod);
    }
}
