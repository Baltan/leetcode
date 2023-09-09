package leetcode.algorithms;

/**
 * Description: 920. Number of Music Playlists
 *
 * @author Baltan
 * @date 2023/9/2 16:07
 */
public class NumMusicPlaylists {
    public static void main(String[] args) {
        System.out.println(numMusicPlaylists(3, 3, 1));
        System.out.println(numMusicPlaylists(2, 3, 0));
        System.out.println(numMusicPlaylists(2, 3, 1));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-music-playlists/solutions/24767/bo-fang-lie-biao-de-shu-liang-by-leetcode/"></a>
     *
     * @param n
     * @param goal
     * @param k
     * @return
     */
    public static int numMusicPlaylists(int n, int goal, int k) {
        int mod = 1000000007;
        /**
         * dp[i][j]表示在播放列表的前i首歌中包含j首不同歌曲的方案数，所求即为dp[goal][n]
         */
        long[][] dp = new long[goal + 1][n + 1];
        /**
         * 如果播放列表中只有一首歌，则可以选择n首歌中的任意一首，都满足dp[1][1]的情况
         */
        dp[1][1] = n;

        for (int i = 2; i <= goal; i++) {
            for (int j = 1; j <= Math.min(n, i); j++) {
                if (j > k) {
                    /**
                     * 如果播放列表的前i-1首歌中包含j首不同歌曲，则第i首歌只能在这j首歌中选择，同时又不能和第[i-k,i-1]首歌相同，所以第i
                     * 首歌有j-k种选择（根据题意，第[i-k,i-1]首歌一定是不同的）
                     */
                    dp[i][j] = (dp[i - 1][j] * (j - k)) % mod;
                }

                if (n > j - 1) {
                    /**
                     * 如果播放列表的前i-1首歌中包含j-1首不同歌曲，则第i首歌只能是除这j-1首歌以外的任意一首，所以第i首歌有n-j+1中选择
                     */
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (n - j + 1)) % mod;
                }
            }
        }
        return (int) dp[goal][n];
    }
}
