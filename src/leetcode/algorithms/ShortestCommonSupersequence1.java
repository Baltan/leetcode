package leetcode.algorithms;

/**
 * Description: 1092. Shortest Common Supersequence
 *
 * @author Baltan
 * @date 2023/9/24 14:23
 * @see ShortestCommonSupersequence
 */
public class ShortestCommonSupersequence1 {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("bcacaaab", "bbabaccc"));
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
        System.out.println(shortestCommonSupersequence("accabcba", "aacbbbbbaa"));
        System.out.println(shortestCommonSupersequence("bcaaacbbbcbdcaddadcacbdddcdcccdadadcbabaccbccdcdcbcaccacbbdcbabb", "dddbbdcbccaccbababaacbcbacdddcdabadcacddbacadabdabcdbaaabaccbdaa"));
        System.out.println(shortestCommonSupersequence("atdznrqfwlfbcqkezrltzyeqvqemikzgghxkzenhtapwrmrovwtpzzsyiwongllqmvptwammerobtgmkpowndejvbuwbporfyroknrjoekdgqqlgzxiisweeegxajqlradgcciavbpgqjzwtdetmtallzyukdztoxysggrqkliixnagwzmassthjecvfzmyonglocmvjnxkcwqqvgrzpsswnigjthtkuawirecfuzrbifgwolpnhcapzxwmfhvpfmqapdxgmddsdlhteugqoyepbztspgojbrmpjmwmhnldunskpvwprzrudbmtwdvgyghgprqcdgqjjbyfsujnnssfqvjhnvcotynidziswpzhkdszbblustoxwtlhkowpatbypvkmajumsxqqunlxxvfezayrolwezfzfyzmmneepwshpemynwzyunsxgjflnqmfghsvwpknqhclhrlmnrljwabwpxomwhuhffpfinhnairblcayygghzqmotwrywqayvvgohmujneqlzurxcpnwdipldofyvfdurbsoxdurlofkqnrjomszjimrxbqzyazakkizojwkuzcacnbdifesoiesmkbyffcxhqgqyhwyubtsrqarqagogrnaxuzyggknksrfdrmnoxrctntngdxxechxrsbyhtlbmzgmcqopyixdomhnmvnsafphpkdgndcscbwyhueytaeodlhlzczmpqqmnilliydwtxtpedbncvsqauopbvygqdtcwehffagxmyoalogetacehnbfxlqhklvxfzmrjqofaesvuzfczeuqegwpcmahhpzodsmpvrvkzxxtsdsxwixiraphjlqawxinlwfspdlscdswtgjpoiixbvmpzilxrnpdvigpccnngxmlzoentslzyjjpkxemyiemoluhqifyonbnizcjrlmuylezdkkztcphlmwhnkdguhelqzjgvjtrzofmtpuhifoqnokonhqtzxmimp", "xjtuwbmvsdeogmnzorndhmjoqnqjnhmfueifqwleggctttilmfokpgotfykyzdhfafiervrsyuiseumzmymtvsdsowmovagekhevyqhifwevpepgmyhnagjtsciaecswebcuvxoavfgejqrxuvnhvkmolclecqsnsrjmxyokbkesaugbydfsupuqanetgunlqmundxvduqmzidatemaqmzzzfjpgmhyoktbdgpgbmjkhmfjtsxjqbfspedhzrxavhngtnuykpapwluameeqlutkyzyeffmqdsjyklmrxtioawcrvmsthbebdqqrpphncthosljfaeidboyekxezqtzlizqcvvxehrcskstshupglzgmbretpyehtavxegmbtznhpbczdjlzibnouxlxkeiedzoohoxhnhzqqaxdwetyudhyqvdhrggrszqeqkqqnunxqyyagyoptfkolieayokryidtctemtesuhbzczzvhlbbhnufjjocporuzuevofbuevuxhgexmckifntngaohfwqdakyobcooubdvypxjjxeugzdmapyamuwqtnqspsznyszhwqdqjxsmhdlkwkvlkdbjngvdmhvbllqqlcemkqxxdlldcfthjdqkyjrrjqqqpnmmelrwhtyugieuppqqtwychtpjmloxsckhzyitomjzypisxzztdwxhddvtvpleqdwamfnhhkszsfgfcdvakyqmmusdvihobdktesudmgmuaoovskvcapucntotdqxkrovzrtrrfvoczkfexwxujizcfiqflpbuuoyfuoovypstrtrxjuuecpjimbutnvqtiqvesaxrvzyxcwslttrgknbdcvvtkfqfzwudspeposxrfkkeqmdvlpazzjnywxjyaquirqpinaennweuobqvxnomuejansapnsrqivcateqngychblywxtdwntancarldwnloqyywrxrganyehkglbdeyshpodpmdchbcc"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/shortest-common-supersequence/solutions/2194615/cong-di-gui-dao-di-tui-jiao-ni-yi-bu-bu-auy8z/"></a>
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        /**
         * dp[i][j]表示str1.substring(0,i)和str2.substring(0,j)的最短公共超序列的长度
         */
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * str1.substring(0,i)和一个空字符串的最短公共超序列就是其本身，即str1.substring(0,i)
         */
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }
        /**
         * 一个空字符串和str2.substring(0,j)的最短公共超序列就是其本身，即str2.substring(0,j)
         */
        for (int j = 1; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                /**
                 * 对于str1.substring(0,i)和str2.substring(0,j)，如果这两个子串的最后一个字符相同，则它们的最短公共超序列就是
                 * str1.substring(0,i-1)和str2.substring(0,j-1)的最短公共超序列尾部追加这个相同的字符；否则这个公共超序列可以由
                 * str1.substring(0,i-1)和str2.substring(0,j)的最短公共超序列尾部追加str1.substring(0,i-1)的最后一个字符得到，
                 * 也可以由str1.substring(0,i)和str2.substring(0,j-1)的最短公共超序列尾部追加str2.substring(0,j)的最后一个字符得
                 * 到，两种情况选择长度更短的公共超序列即为str1.substring(0,i)和str2.substring(0,j)的最短公共超序列
                 */
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] + 1 : dp[i][j - 1] + 1;
                }
            }
        }
        StringBuilder builder = new StringBuilder(dp[length1][length2]);
        int x = length1;
        int y = length2;
        int length = dp[x][y];
        /**
         * 从最后一个字符开始向前还原str1和str2的最短公共超序列，还原逻辑同上
         */
        while (builder.length() < length) {
            if (x == 0) {
                builder.append(str2.charAt(y - 1));
                y--;
            } else if (y == 0) {
                builder.append(str1.charAt(x - 1));
                x--;
            } else if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
                builder.append(str1.charAt(x - 1));
                x--;
                y--;
            } else {
                if (dp[x - 1][y] <= dp[x][y - 1]) {
                    builder.append(str1.charAt(x - 1));
                    x--;
                } else {
                    builder.append(str2.charAt(y - 1));
                    y--;
                }
            }
        }
        return builder.reverse().toString();
    }
}
