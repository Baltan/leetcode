package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1092. Shortest Common Supersequence
 *
 * @author Baltan
 * @date 2023/9/24 14:23
 */
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
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
         * dp[i][j]表示str1.substring(0,i)和str2.substring(0,j)的最短公共超序列的构造方式
         */
        Constructor[][] dp = new Constructor[length1 + 1][length2 + 1];
        /**
         * 保存构造str1和str2的最短公共超序列的路径
         */
        Deque<Grid> deque = new ArrayDeque<>();
        /**
         * 两个空字符串的最短公共超序列也是一个空字符串
         */
        dp[0][0] = new Constructor(-1, -1, 0);
        /**
         * str1.substring(0,i)和一个空字符串的最短公共超序列就是其本身，即str1.substring(0,i)
         */
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = new Constructor(-1, -1, i);
        }
        /**
         * 一个空字符串和str2.substring(0,j)的最短公共超序列就是其本身，即str2.substring(0,j)
         */
        for (int j = 1; j <= length2; j++) {
            dp[0][j] = new Constructor(-1, -1, j);
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
                    dp[i][j] = new Constructor(i - 1, j - 1, dp[i - 1][j - 1].length + 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length < dp[i][j - 1].length ?
                            new Constructor(i - 1, j, dp[i - 1][j].length + 1) :
                            new Constructor(i, j - 1, dp[i][j - 1].length + 1);
                }
            }
        }
        int x = length1;
        int y = length2;
        /**
         * 将计算str1和str2的最短公共超序列路径上的每个状态入栈
         */
        while (x >= 0 && y >= 0) {
            deque.offerLast(new Grid(x, y));
            int tempX = dp[x][y].x;
            int tempY = dp[x][y].y;
            x = tempX;
            y = tempY;
        }
        /**
         * 构造str1和str2的最短公共超序列的初始状态：如果是空字符串和str2.substring(0,y)的最短公共超序列，则为str2.substring(0,y)；
         * 如果是str1.substring(0,x)和空字符串的最短公共超序列，则为str1.substring(0,x)
         */
        Grid curr = deque.pollLast();
        StringBuilder builder = new StringBuilder(curr.x == 0 ? str2.substring(0, curr.y) : str1.substring(0, curr.x));
        Grid prev = curr;

        while (!deque.isEmpty()) {
            curr = deque.pollLast();
            /**
             * 如果当前状态和前一个状态str1的前缀子串相同，则需要在前一个最短公共超序列后追加字符str2[curr.y-1]，否则在前一个最短公共超序
             * 列后追加字符str1[curr.x-1]
             */
            builder.append(curr.x == prev.x ? str2.charAt(curr.y - 1) : str1.charAt(curr.x - 1));
            prev = curr;
        }
        return builder.toString();
    }

    /**
     * 当前需要计算的两个子串的最短公共超序列sequence的构造方式，由str1.substring(0,x)和str2.substring(0,y)的最短公共超序列衍生而来，
     * 并且得到的sequence的长度为length
     */
    public static class Constructor {
        private int x;
        private int y;
        private int length;

        public Constructor(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    /**
     * 动态规划计算str1和str2的最短公共超序列路径上的每个状态，即先必须得到str1.substring(0,x)和str2.substring(0,y)的最短公共超序列
     */
    public static class Grid {
        private int x;
        private int y;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
