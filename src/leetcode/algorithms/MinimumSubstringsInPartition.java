package leetcode.algorithms;

/**
 * Description: 3144. Minimum Substring Partition of Equal Character Frequency
 *
 * @author Baltan
 * @date 2024/5/15 22:09
 */
public class MinimumSubstringsInPartition {
    public static void main(String[] args) {
        System.out.println(minimumSubstringsInPartition("hhqmqzavccbsjkfpijrpdjkmgcpyomborudbbfyeokkelzznstufyppndilajgxxhusslzvnwhfitqtsstjqclxqvkykovhzyyqfksmnhhtpdabfjrfflmqoakaackcchgzhrppmvpnunuzhoouftiqwdbxbemtzwkrqqkspwypxwzavvgelkxsgkipoottveturyicswfdemvpfegdclnjccqkgouzcdfvpstnjxzdukwctysagimjissinxkohfyapuuavvnssqzcynoixegzkuvphadbaedwkgpxaoohgmfoqmvfbbywinngwctrighefrnbllggbjfeslbfwzuktwvocbmokicwvpotpvbytlxajtidumtocerdqrrtvjawgikwkqnnfgbsczshswuvvnnmmjssrulcxattfgklzklfrahvbcdetxohipslfbifkmiljvbvpffeiymidgsaxkjvynjaaqkymyyejjyyxucuyehrnzzqwolgylytlviedicxxavsmytdyscdczhmpydzvwaeziczvolrzossqazqtccygbyunsxxwzxnsfboazgfcefmqggcgwhlaatfgatfkffgywldlmoubqlcstwwkepecxxrsgawwxpxmdvifiecopozvooomhbqmrsdraajwybdhnmrzfgnemzqnxvaedhvhexjlvkllzrtgcgnkkopnytjktjffndpqlpepqqxyjikcyfwaocbjcjlzybxemollniwuucqpshkkqwawyyuqligbzanssbsfwnckkkjfurvpxqcdauvrykrqlnpwacgxivlgppdqqkijjvyycwlxzxcgxudboopuehittsiknnlssspefgcvvctzhajjmkyyykkqlpynaconuuumzycvlrkgukuuwpleedpwtmsjfkbdmyubjuhoajcymrzeytmnkkoqgnsltpczzofvivpuogrunnnxkmyhbuuwvvvgnbvnvvlggnug"));
        System.out.println(minimumSubstringsInPartition("fabccddg"));
        System.out.println(minimumSubstringsInPartition("abababaccddb"));
    }

    public static int minimumSubstringsInPartition(String s) {
        int length = s.length();
        int[][] prefixCounts = new int[length + 1][26];
        int[][] dp = new int[length + 1][length + 1];
        boolean[][] isBalanced = new boolean[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 26; j++) {
                prefixCounts[i + 1][j] = prefixCounts[i][j];
            }
            prefixCounts[i + 1][s.charAt(i) - 'a']++;
            dp[i][i + 1] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                isBalanced[i][j] = isBalanced(prefixCounts, i, j);
            }
        }

        for (int i = 2; i <= length; i++) {
            for (int j = 0; j + i <= length; j++) {
                if (isBalanced[j][j + i]) {
                    dp[j][j + i] = 1;
                    continue;
                }
                dp[j][j + i] = Integer.MAX_VALUE;

                for (int k = j + 1; k <= j + i; k++) {
                    if (dp[j][k] != Integer.MAX_VALUE && dp[k][j + i] != Integer.MAX_VALUE) {
                        dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k][j + i]);
                    }
                }
            }
        }
        return dp[0][length];
    }

    public static boolean isBalanced(int[][] prefixCounts, int start, int end) {
        int count = -1;

        for (int i = 0; i < 26; i++) {
            if (prefixCounts[end][i] - prefixCounts[start][i] != 0) {
                if (count == -1) {
                    count = prefixCounts[end][i] - prefixCounts[start][i];
                } else if (prefixCounts[end][i] - prefixCounts[start][i] != count) {
                    return false;
                }
            }
        }
        return true;
    }
}
