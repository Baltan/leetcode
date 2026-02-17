package leetcode.algorithms;

/**
 * Description: 3800. Minimum Cost to Make Two Binary Strings Equal
 *
 * @author baltan
 * @date 2026/2/13 08:52
 */
public class MinimumCost10 {
    public static void main(String[] args) {
        System.out.println(minimumCost("01000", "10111", 10, 2, 2));
        System.out.println(minimumCost("001", "110", 2, 100, 100));
        System.out.println(minimumCost("1010", "1010", 5, 5, 5));
    }

    public static long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        long result = 0L;
        /**
         * counts[i][j]表示同一索引位置上字符串s的数字为i，字符为j的数字为j出现的次数
         */
        int[][] counts = new int[2][2];

        for (int i = 0; i < t.length(); i++) {
            counts[s.charAt(i) - '0'][t.charAt(i) - '0']++;
        }
        /**
         * s[x]为0，t[x]为1，并且s[y]为1，t[y]为0，这样四个数的组合的个数
         */
        int pairs1 = Math.min(counts[0][1], counts[1][0]);
        /**
         * 如果s[x]为0，t[x]为1，并且s[y]为1，t[y]为0，则可以通过一次字符串内交换或者两次字符翻转使得s[x]和t[x]相等，并且s[y]和t[y]相
         * 等，前者成本为swapCost，后者成本为flipCost*2，两者取较小值
         */
        result += (long) pairs1 * Math.min(swapCost, flipCost * 2);
        /**
         * 剩余s[x]为0，t[x]为1（或者s[x]为1，t[x]为0），这样两个数的组合的个数
         */
        int pairs2 = Math.max(counts[0][1], counts[1][0]) - pairs1;
        /**
         * 如果s[x]为0，t[x]为1，并且s[y]为0，t[y]为1（或者s[x]为1，t[x]为0，并且s[y]为1，t[y]为0），这样四个数的组合的个数
         */
        int pairs3 = pairs2 / 2;
        /**
         * 如果s[x]为0，t[x]为1，并且s[y]为1，t[y]为0（或者s[x]为1，t[x]为0，并且s[y]为1，t[y]为0），则可以通过一次字符串间交换加一次
         * 字符串内交换或者两次字符翻转使得s[x]和t[x]相等，并且s[y]和t[y]相等，前者成本为crossCost+swapCost，后者成本为flipCost*2，两
         * 者取较小值
         */
        result += (long) pairs3 * Math.min(crossCost + swapCost, flipCost * 2);
        /**
         * 剩余s[x]为0，t[x]为1（或者s[x]为1，t[x]为0），这样两个数的组合的个数
         */
        int pairs4 = pairs2 - pairs3 * 2;
        /**
         * 如果s[x]为0，t[x]为1（或者s[x]为1，t[x]为0），则只能通过一次字符翻转使得s[x]和t[x]相等，成本为flipCost
         */
        return result + (long) pairs4 * flipCost;
    }
}
