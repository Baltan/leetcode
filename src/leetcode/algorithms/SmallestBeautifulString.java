package leetcode.algorithms;

/**
 * Description: 2663. Lexicographically Smallest Beautiful String
 *
 * @author Baltan
 * @date 2023/5/7 21:39
 */
public class SmallestBeautifulString {
    public static void main(String[] args) {
        System.out.println(smallestBeautifulString("abdc", 4));
        System.out.println(smallestBeautifulString("abcz", 26));
        System.out.println(smallestBeautifulString("dc", 4));
    }

    public static String smallestBeautifulString(String s, int k) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * 可选的字母范围为['a',max]
         */
        char max = (char) ('a' + k - 1);
        /**
         * 从后向前遍历字符串s，找到第一个能放大的字母，然后再将该字母之后的所有字母尽可能缩小
         */
        for (int i = length - 1; i >= 0; i--) {
            /**
             * charArray[i]可以放大的字母范围为[charArray[i]+1,max]
             */
            for (char j = (char) (charArray[i] + 1); j <= max; j++) {
                /**
                 * 因为目标字符串中同样不存在长度大于等于2的回文子串，所以相邻的两个字母和间隔一位的两个字母都不可能相同，否则会构成"aa"和
                 * "aba"形式的回文子串
                 */
                if ((i - 1 < 0 || j != charArray[i - 1]) && (i - 2 < 0 || j != charArray[i - 2])) {
                    charArray[i] = j;
                    /**
                     * 将charArray[i]之后的字母都尽可能缩小，对于每一个字母charArray[l]而言，只要将其替换为['a',max]中不等于
                     * charArray[l-1]和charArray[l-2]的最小字母即可
                     */
                    for (int l = i + 1; l < length; l++) {
                        for (char m = 'a'; m <= max; m++) {
                            if (m != charArray[l - 1] && (l - 2 < 0 || m != charArray[l - 2])) {
                                charArray[l] = m;
                                break;
                            }
                        }
                    }
                    return new String(charArray);
                }
            }
        }
        return "";
    }
}
