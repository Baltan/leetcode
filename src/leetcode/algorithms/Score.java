package leetcode.algorithms;

/**
 * Description: 3664. Two-Letter Card Game
 *
 * @author baltan
 * @date 2025/9/29 10:20
 */
public class Score {
    public static void main(String[] args) {
        System.out.println(score(new String[]{"ab", "aa", "ab", "bc", "cc", "bc", "bb", "ac", "bc", "bc", "aa", "aa", "ba", "bc", "cb", "ba", "ac", "bb", "cb", "ac", "cb", "cb", "ba", "bc", "ca", "ba", "bb", "cc", "cc", "ca", "ab", "bb", "bc", "ba", "ac", "bc", "ac", "ac", "bc", "bb", "bc", "ac", "bc", "aa", "ba", "cc", "ac", "bb", "ba", "bb"}, 'b'));
        System.out.println(score(new String[]{"aa", "ab", "ba", "ac"}, 'a'));
        System.out.println(score(new String[]{"aa", "ab", "ba"}, 'a'));
        System.out.println(score(new String[]{"aa", "ab", "ba", "ac"}, 'b'));
    }

    /**
     * 参考: <a href="https://leetcode.cn/problems/two-letter-card-game/solutions/3768070/mei-ju-jie-lun-pythonjavacgo-by-endlessc-zbnv/"></a>
     *
     * @param cards
     * @param x
     * @return
     */
    public static int score(String[] cards, char x) {
        int result = 0;
        /**
         * 字符串"x_"（第二个字符不为"x"）组中，出现频次最高的字符串的个数
         */
        int maxCount1 = 0;
        /**
         * 字符串"_x"（第一个字符不为"x"）组中，出现频次最高的字符串的个数
         */
        int maxCount2 = 0;
        /**
         * 字符串"x_"（第二个字符不为"x"）组中，字符串的总个数
         */
        int totalCount1 = 0;
        /**
         * 字符串"_x"（第一个字符不为"x"）组中，字符串的总个数
         */
        int totalCount2 = 0;
        /**
         * 字符串"xx"的个数
         */
        int xxCount = 0;
        /**
         * counts1[0]-counts1[25]依次表示字符串"xa"-"xz"（第二个字符不为"x"）的个数
         */
        int[] counts1 = new int[26];
        /**
         * counts2[0]-counts2[25]依次表示字符串"ax"-"zx"（第一个字符不为"x"）的个数
         */
        int[] counts2 = new int[26];
        /**
         * 统计包含字符"x"的不同字符串的个数
         */
        for (String card : cards) {
            if (card.charAt(0) == x && card.charAt(1) == x) {
                xxCount++;
            } else if (card.charAt(0) == x) {
                counts1[card.charAt(1) - 'a']++;
            } else if (card.charAt(1) == x) {
                counts2[card.charAt(0) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            maxCount1 = Math.max(maxCount1, counts1[i]);
            totalCount1 += counts1[i];
            maxCount2 = Math.max(maxCount2, counts2[i]);
            totalCount2 += counts2[i];
        }
        /**
         * 将其中i个字符串"xx"分配到"x_"（第二个字符不为"x"）组中，其余xxCount-i个字符串"xx"分配到"_x"（第一个字符不为"x"）组中，并分别
         * 计算两组中兼容卡牌的得分
         */
        for (int i = 0; i <= xxCount; i++) {
            result = Math.max(result, help(totalCount1, maxCount1, i) + help(totalCount2, maxCount2, xxCount - i));
        }
        return result;
    }

    /**
     * 计算兼容卡牌的得分
     *
     * @param totalCount
     * @param maxCount
     * @param xxCount
     * @return
     */
    public static int help(int totalCount, int maxCount, int xxCount) {
        totalCount += xxCount;
        maxCount = Math.max(maxCount, xxCount);
        int otherCount = totalCount - maxCount;
        /**
         * @see NumberOfWeeks
         * 插空法，将otherCount张牌插入maxCount-1个空位中，计算兼容卡牌的得分
         */
        return otherCount >= maxCount - 1 ? totalCount / 2 : otherCount;
    }
}
