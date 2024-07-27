package leetcode.algorithms;

/**
 * Description: 3227. Vowels Game in a String
 *
 * @author Baltan
 * @date 2024/7/27 14:54
 */
public class DoesAliceWin {
    public static void main(String[] args) {
        System.out.println(doesAliceWin("leetcoder"));
        System.out.println(doesAliceWin("bbcd"));
    }

    public static boolean doesAliceWin(String s) {
        /**
         * 字符串s中元音字母的个数
         */
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        /**
         * 如果字符串s中元音字母的个数为奇数，则Alice直接将整个字符串移除即可获胜；如果字符串s中元音字母的个数大于0且为偶数，则不论Alice第
         * 一回合移除的子串中有多少元音字母，下一回合轮到她时剩余的子串中元音字母的个数一定为奇数，她直接将剩下的子串都移除即可获胜。Bob唯一
         * 可能获胜的情况就是字符串s中没有元音字母。
         */
        return count != 0;
    }
}
